package dongduk.cs.ssd.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.service.UserService;
import dongduk.cs.ssd.validator.UserFormValidator;

/**
 * @author Yejin Lee | Seonmi Hwang
 * @since 2020.05.07 | 2020.06.21
 */

@Controller
@RequestMapping("/user/update.do")
public class UpdateUserFormController {

	@Value("user/user_update")
	private String formViewName;
	@Value("user/user_detail")
	private String successViewName;
	
	@Autowired
	private UserService userService;
	
	
	@ModelAttribute("userForm")
	public UserForm formBackingObject(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		return new UserForm(userService.getUserByEmail(userSession.getUser().getEmail()));
	}
	
	@ModelAttribute("cardBanks")
	public List<String> cardBanksData() {
		ArrayList<String> cardBanks = new ArrayList<String>();
		cardBanks.add("신한");
		cardBanks.add("하나");
		cardBanks.add("우리");
		cardBanks.add("농협");
		cardBanks.add("국민"); 
		// add more
		return cardBanks;			
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("userForm") UserForm userForm, BindingResult result) throws Exception {
		new UserFormValidator().validate(userForm, result);
		
		// 검증 오류 발생 시 다시 form view로 이동
		if (result.hasErrors()) { return formViewName; }
		
		try {
			userService.updateUser(userForm.getUser());
		} catch (DataIntegrityViolationException ex) {
			result.rejectValue("user.userName", "USER_ID_ALREADY_EXISTS", "User ID already exists: choose a different ID.");
			return formViewName;
		}
		
		UserSession userSession = new UserSession(userService.getUserByEmail(userForm.getUser().getEmail()));
		session.setAttribute("userSession", userSession);
		return successViewName;
	}
}

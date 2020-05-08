package dongduk.cs.ssd.controller.user;

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

/**
 * @author Yejin Lee
 * @since 2020.05.07
 */
@Controller
@RequestMapping("/user/update.do")
public class UpdateUserFormController {

	@Value("user_update")
	private String formViewName;
	@Value("user_detail")
	private String successViewName;
	
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	private UserFormValidator validator;
	public void setValidator(UserFormValidator validator) {
		this.validator = validator;
	}
	
	@ModelAttribute("userForm")
	public UserForm formBackingObject(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		return new UserForm(userService.getUserByEmailId(userSession.getUser().getEmailId()));
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("userForm") UserForm userForm, BindingResult result) throws Exception {
		validator.validate(userForm, result);
		
		if (result.hasErrors()) return formViewName;
		try {
			userService.updateUser(userForm.getUser());
		} catch (DataIntegrityViolationException ex) {
			result.rejectValue("user.username", "USER_ID_ALREADY_EXISTS", "User ID already exists: choose a different ID.");
			return formViewName;
		}
		
		UserSession userSession = new UserSession(userService.getUserByEmailId(userForm.getUser().getEmailId()));
		session.setAttribute("userSession", userSession);
		return successViewName;
	}
	
}

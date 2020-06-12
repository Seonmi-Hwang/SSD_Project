package dongduk.cs.ssd.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.UserService;

/**
 * @author kimdahyee
 * @since 2020.06.12
 */

@Controller
//@SessionAttributes("userSession")
public class LoginController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) { //setter method를 통한 DI
		this.userService = userService;
	}
	
	//forward : 주소 변경 X, 화면 전환, 대량의 데이터 전달
	//redirect : 주소 변경 O, 화면 전환, 소량의 데이터 전달 (get 방식만 가능)
	@RequestMapping("/user/login.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpSession session,
			@RequestParam("emailId") String email,
			@RequestParam("password") String password,
			Model model) throws Exception {
		
		User user = userService.getUser(email, password);// 로그인 시도
		
		if (user == null) { // 해당 email과 password를 갖는 사용자가 존재하지 않을 시
			return new ModelAndView("/user/login", "message", "Invalid email or password. Login failed.");
		} else { // 로그인 성공 시
			UserSession userSession = new UserSession(user);
			session.setAttribute("userSession", userSession);
			model.addAttribute("userSession", userSession);
			return new ModelAndView("home");
		}
	}
	
	/*
	@Value("login")
	private String formViewName;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpSession session,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) throws Exception {
		User user = userService.getUser(email, password); // 로그인 시도
		if (user == null) { // 해당 email과 password를 갖는 사용자가 존재하지 않을 시
			return new ModelAndView("login", "message", "Invalid email or password. Login failed.");
		} else { // 로그인 성공 시
			UserSession userSession = new UserSession(user);
			session.setAttribute("userSession", userSession);
			return new ModelAndView("home");
		}
	}
	*/
}

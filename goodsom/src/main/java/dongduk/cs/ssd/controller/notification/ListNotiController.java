package dongduk.cs.ssd.controller.notification;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.Notification;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.BidService;
import dongduk.cs.ssd.service.NotiService;

/**
 * @author Yejin Lee 	| HK
 * @since 2020.05.07	| 2020.6.29
 */
@Controller
public class ListNotiController {
	
	@Value("user/noti_list")
	private String formViewName;
	
	@Autowired
	private NotiService notiService;
	
	@Autowired
	private BidService bidService;
	
	public void setNotiService(NotiService notiService) {
		this.notiService = notiService;
	}
	
	/* 세션에서 로그인한 사용자 정보를 받아와 해당 사용자의 notification list들을 보여주면 된다. */
//	user_detail -> noti_list
	@RequestMapping("/noti/list.do")  // ex) /user/detail.do?userId=2
	public ModelAndView handleRequest(HttpSession session) throws Exception {
		UserSession user  = (UserSession)session.getAttribute("userSession");
		List<Bid> userBidList = null;
		
		// user가 배팅한 경매 && 마감된 경매 && 최고금액인 경매
//		해당 유저가 배팅한 모든 Bid 정보
		userBidList = bidService.getBidByUserId(user.getUser().getUserId());	// bidService에 추가
		
		for(int i=0; i<userBidList.size(); i++) {
			System.out.println("Is Bidded: " + userBidList.get(i).getIsBidded());
			if(userBidList.get(i).getIsBidded()) {
				notiService.createNoti_a(userBidList.get(i).getAuctionId());
			}
		}
		
		ModelAndView mov = new ModelAndView();
//		mov.addObject(attributeName, attributeValue);
		mov.setViewName(formViewName);
		
		return mov;
//		List<Notification> notiList = notiService.getNotiListByEmailId(user.getEmailId());
//		return new ModelAndView("noti_list", "notiList", notiList);
	}
	
	
	
}

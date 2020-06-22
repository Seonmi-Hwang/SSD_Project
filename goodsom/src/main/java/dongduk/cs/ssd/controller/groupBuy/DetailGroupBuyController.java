package dongduk.cs.ssd.controller.groupBuy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.service.GroupBuyService;
import dongduk.cs.ssd.service.UserService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.04
 */
/**
 * @author HK
 * @since 2020.06.22
 */

@Controller
//@SessionAttributes("groupBuySession")
public class DetailGroupBuyController {
	private static final String GROUPBUY_LIST = "groupBuy/groupBuy_list";
	private static final String GROUPBUY_DETAIL = "groupBuy/groupBuy_detail";
	
	@Autowired
	GroupBuyService groupBuyService;
	@Autowired
	UserService userService;
	
	// home -> list
	@RequestMapping("/groupBuy/list.do")
	public ModelAndView groupBuyDetail(){
		ModelAndView mav = new ModelAndView(GROUPBUY_LIST);
		List<GroupBuy> groupBuyList = null;
		
		// db
		groupBuyList = groupBuyService.getGroupBuyList();
		
		if (groupBuyList == null) {
			System.out.println("[DetailGroupBuyController] groupBuyList가 null");
		} else {
			mav.addObject("groupBuyList", groupBuyList);		
		}
		return mav;
	}
	
	// list -> detail
	@RequestMapping("/groupBuy/detail.do")
	public ModelAndView groupBuyDetail(HttpServletRequest request,
										@RequestParam("groupBuyId") int groupBuyId)	{
		ModelAndView mav = new ModelAndView(GROUPBUY_DETAIL);
		
		// db
		GroupBuy groupBuy = groupBuyService.getGroupBuy(groupBuyId);
		groupBuy.setOptions(groupBuyService.getOptions(groupBuyId));
		
		mav.addObject("groupBuy", groupBuy);
		mav.addObject("writer", userService.getUserByUserId(groupBuy.getUserId()).getNickname());
		return mav;
	}
	
}

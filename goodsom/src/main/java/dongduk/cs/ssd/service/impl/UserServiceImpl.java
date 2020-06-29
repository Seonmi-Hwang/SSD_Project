package dongduk.cs.ssd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dongduk.cs.ssd.dao.UserDao;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.UserService;

/**
 * @author Yejin Lee | kimdahyee  | Seonmi-Hwang
 * @since 2020.05.03 | 2020.06.12 | 2020.06.13
 */

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User getUser(String email, String password) {
		return userDao.getUser(email, password);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public User getUserByUserId(int userId) throws DataAccessException {
		return userDao.getUserByUserId(userId);
	}

	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public int deleteUser(int userId) {
		try {
			userDao.deleteUser(userId);
		} catch (DataAccessException ex) {
			return 0;
		}
		return 1;
	}

	@Override
	public List<Order> getAuctionOrderList(int userId) { // 마이페이지 결제 목록 보기
		return userDao.getAuctionOrderList(userId);
	}
	
	@Override
	public List<Order> getGroupBuyOrderList(int userId) { // 마이페이지 결제 목록 보기
		return userDao.getGroupBuyOrderList(userId);
	}
	
	@Override	
	public List<GroupBuy> getGroupBuyList(int userId) { // 마이페이지 공동구매 등록 목록 보기
		return userDao.getGroupBuyList(userId);
	}
	
	@Override	
	public List<Auction> getAuctionList(int userId) { // 마이페이지 경매 등록 목록 보기
		return userDao.getAuctionList(userId);
	}
	
	public boolean isUnClosedExist(int userId) {
		List<GroupBuy> groupBuys = userDao.getGroupBuyList(userId);
		List<Auction> auctions = userDao.getAuctionList(userId);
		
		System.out.println("[GROUPBUY EXIST?]" + groupBuys.get(0).getState());
		System.out.println("[AUCTION EXIST?]" + auctions.get(0).getState());
		for (GroupBuy groupBuy : groupBuys) {
			if (!groupBuy.getState().equals("closed")) {
				return true;
			}
		}
		
		for (Auction auction : auctions) {
			if (!auction.getState().equals("closed")) {
				return true;
			}
		}
		return false;
	}

}

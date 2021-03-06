package dongduk.cs.ssd.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Order;
import dongduk.cs.ssd.domain.User;

/**
 * @author Yejin Lee | kimdahyee  | Seonmi Hwang
 * @since 2020.05.06 | 2020.06.12 | 2020.06.21
 */

public interface UserDao {

	User getUser(String emailId, String password) throws DataAccessException; // login시 필요
	
	User getUserByEmail(String email) throws DataAccessException; // email로 user객체 얻어옴
	
	User getUserByUserId(int userId) throws DataAccessException; // userId로 user객체 얻어옴
	
	void createUser(User user) throws DataAccessException;

	int updateUser(User user) throws DataAccessException;

	int deleteUser(User user) throws DataAccessException;
	
	List<Order> getAuctionOrderList(int userId);
	
	List<Order> getGroupBuyOrderList(int userId);
	
	List<GroupBuy> getGroupBuyList(int userId); // 마이페이지 공동구매 등록 목록 보기
	
	List<Auction> getAuctionList(int userId); // 마이페이지 경매 등록 목록 보기
	
}

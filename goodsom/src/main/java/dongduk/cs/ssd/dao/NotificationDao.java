package dongduk.cs.ssd.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.Notification;

public interface NotificationDao {
	
//	List<Notification> getNotiListByEmailId(String emailId) throws DataAccessException; //Do sql operations twice.
//	
//	Notification getNoti(int notiId) throws DataAccessException; // Two tables share one noti_sequence.
//	
//	void createNoti_g(int groupBuyId) throws DataAccessException; // lineGroupBuys table
	
	void createNoti_a(int auctionId) throws DataAccessException; // successBidders table
	
//	void deleteNoti(int notiId) throws DataAccessException;
//
	List<Bid> getBidByUserId(int userId) throws DataAccessException;
}

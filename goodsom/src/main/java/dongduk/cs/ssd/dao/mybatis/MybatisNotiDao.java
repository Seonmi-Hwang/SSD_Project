package dongduk.cs.ssd.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.NotificationDao;
import dongduk.cs.ssd.dao.mybatis.mapper.NotiMapper;
import dongduk.cs.ssd.domain.Bid;
import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Notification;

/**
 * @author HK
 * @since  2020.06.29
 */

@Repository
public class MybatisNotiDao implements NotificationDao {
	
	@Autowired
	private NotiMapper notiMapper;
	
	public void createNoti_a(Bid bid) throws DataAccessException{
		notiMapper.createNoti_a(bid);
	}
	
	public Notification getAuctionNoti(int notiId) throws DataAccessException{
		return notiMapper.getAuctionNoti(notiId);
	}
	
	public Notification getGroupBuyNoti(int notiId) throws DataAccessException{
		return notiMapper.getGroupBuyNoti(notiId);
	}
	
//	public List<Bid> getBidByUserId(int userId)throws DataAccessException{
//		return notiMapper.getBidByUserId(userId);
//	}
	
	public List<Notification> getAuctionNotiByUserId(int userId) throws DataAccessException{
		return notiMapper.getAuctionNotiByUserId(userId);
	}
	
	public List<Notification> getGroupBuyNotiByUserId(int userId) throws DataAccessException{
		return notiMapper.getGroupBuyNotiByUserId(userId);
	}
	
	public void createNoti_g(GroupBuy groupBuy) throws DataAccessException{
		notiMapper.createNoti_g(groupBuy);
	}
	
	public void deleteAuctionNoti(int notiId) throws DataAccessException{
		notiMapper.deleteAuctionNoti(notiId);
	}
	
	public void deleteGroupBuyNoti(int notiId) throws DataAccessException{
		notiMapper.deleteGroupBuyNoti(notiId);
	}

	@Override
	public void notiUserUpdate(int groupBuyId) throws DataAccessException {
		notiMapper.notiUserUpdate(groupBuyId);
	}
}
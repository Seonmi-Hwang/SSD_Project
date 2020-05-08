package dongduk.cs.ssd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dongduk.cs.ssd.dao.NotificationDao;
import dongduk.cs.ssd.domain.Notification;

public class NotiServiceImpl implements NotiService {

	@Autowired
	private NotificationDao notiDao;
	
	@Override
	public List<Notification> getNotiListByEmailId(String emailId) {
		return notiDao.getNotiListByEmailId(emailId);
	}

	@Override
	public Notification getNoti(int notiId) {
		return notiDao.getNoti(notiId);
	}

	@Override
	public void createNoti_g(int groupBuyId) {
		notiDao.createNoti_g(groupBuyId);
	}

	@Override
	public void createNoti_a(int auctionId) {
		notiDao.createNoti_a(auctionId);
	}

	@Override
	public void deleteNoti(int notiId) {
		notiDao.deleteNoti(notiId);
	}


}

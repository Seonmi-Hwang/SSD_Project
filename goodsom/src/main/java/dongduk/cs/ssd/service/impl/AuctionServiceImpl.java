package dongduk.cs.ssd.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.AuctionDao;
import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.SuccessBidder;
import dongduk.cs.ssd.service.AuctionService;


/**
 * @author Hyekyung Kim | Yejin Lee  | kimdahyee  | Seonmi Hwang
 * @since 2020.05.05	| 2020.06.13 | 2020.06.25 | 2020.06.29
 */

@Service
public class AuctionServiceImpl implements AuctionService {
	
	@Autowired
	private AuctionDao auctionDao;
	
//	스케줄러
	@Autowired
	private ThreadPoolTaskScheduler scheduler;
	
	public Auction getAuction(int auctionId) throws DataAccessException {
		return auctionDao.getAuction(auctionId);
	}
	
	public List<Auction> getAuctionList() {
		return auctionDao.getAuctionList();
	}
	
	public List<Auction> getAuctionListByKeyword(String keyword) {
		return auctionDao.getAuctionListByKeyword(keyword);
	}

	public int createAuction(Auction auction) {
		return auctionDao.createAuction(auction);
	}

	public int updateAuction(Auction auction) {
		return auctionDao.updateAuction(auction);
	}
	
	public void updateAuctionMaxPrice(int maxPrice, int auctionId) {
		auctionDao.updateAuctionMaxPrice(maxPrice, auctionId);
	}

	public List<Auction> deleteAuction(int auctionId) {
		auctionDao.deleteAuction(auctionId);			
		return auctionDao.getAuctionList();
	}

//	public List<Bid> getBidByAuctionId(int auctionId) {
//		return auctionDao.getBidByAuctionId(auctionId);
//	}
//
	public boolean isAuctionClosed(int auctionId, Date endDate) {
		return auctionDao.isAuctionClosed(auctionId, endDate);
	}

	public void increaseCount(Auction auction) {
		auctionDao.increaseCount(auction);
	}
	
	public List<Auction> getRecentAuctionList() {
		return auctionDao.getRecentAuctionList();
	}
	
//	스케줄러
	public void deadLineScheduler(Date endDate) {
		Runnable updateTableRunner = new Runnable() {	
			// anonymous class 정의
			@Override
			public void run() {   // 스케쥴러에 의해 미래의 특정 시점에 실행될 작업을 정의				
				Date curTime = new Date();
				// 실행 시점의 시각을 전달하여 그 시각 이전의 closing time 값을 갖는 event의 상태를 변경 
				auctionDao.closeEvent(curTime);	// EVENTS 테이블의 레코드 갱신	
				System.out.println("Auction updateTableRunner is executed at " + curTime);
			}
		};
		
		// 스케줄 생성: closingTime에 updateTableRunner.run() 메소드 실행
		scheduler.schedule(updateTableRunner, endDate);  
		
		System.out.println("Auction updateTableRunner has been scheduled to execute at " + endDate);

	}
	
	public int getSuccessBidderUserId(int auctionId) {
		return auctionDao.getSuccessBidderUserId(auctionId);
	}
	
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId) {
		return auctionDao.getSuccessBidderByAuctionId(auctionId);
	}
	
}

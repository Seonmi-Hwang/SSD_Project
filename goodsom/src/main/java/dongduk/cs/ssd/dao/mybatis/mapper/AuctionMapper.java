package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Auction;

/**
 * @author Yejin Lee | kimdahyee  | Seonmi Hwang
 * @since 2020.06.12 | 2020.06.25 | 2020.06.29
 */

public interface AuctionMapper { // AuctionMapper.xml에서 구현한 method 이름과 일치해야함!
	
	Auction getAuction(int auctionId) throws DataAccessException;
	
	Auction getAuctionWithBids(int auctionId) throws DataAccessException;
	
	int createAuction(Auction auction) throws DataAccessException;
	
	int updateAuction(Auction auction) throws DataAccessException;
	
	void updateAuctionMaxPrice(int maxPrice, int auctionId) throws DataAccessException;
	
	void deleteAuction(int auctionId) throws DataAccessException;
	
	int deleteAuctionByUserId(int userId) throws DataAccessException;
	
	List<Auction> getAuctionList() throws DataAccessException;
	
	List<Auction> getAuctionListByKeyword(String keyword) throws DataAccessException;
	
	List<Auction> getRecentAuctionList() throws DataAccessException;
	
	void increaseCount(Auction auction) throws DataAccessException;
	
	void closeEvent(Date curTime);
	
	Integer getSuccessBidderUserId(int auctionId);
	
	List<Auction> auctionListByKeyword(String keyword);

}

package dongduk.cs.ssd.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.GroupBuy;

public interface GroupBuyDao {
	
	GroupBuy getGroupBuy(int groupBuyId) throws DataAccessException;

	List<GroupBuy> getGroupBuyList(int menuId) throws DataAccessException;
	
	List<GroupBuy> getGroupBuyListByKeyword(String keyword) throws DataAccessException;

	void createGroupBuy(GroupBuy groupBuy) throws DataAccessException;

	void updateGroupBuy(GroupBuy groupBuy) throws DataAccessException;
	
	void deleteGroupBuy(int groupBuyId) throws DataAccessException;

}
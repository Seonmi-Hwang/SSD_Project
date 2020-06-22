package dongduk.cs.ssd.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.GroupBuy;
import dongduk.cs.ssd.domain.Option;

public interface GroupBuyDao {
	
	GroupBuy getGroupBuy(int groupBuyId) throws DataAccessException;

	void createGroupBuy(GroupBuy groupBuy) throws DataAccessException;

	void updateGroupBuy(GroupBuy groupBuy) throws DataAccessException;
	
	void deleteOptions(int groupBuyId) throws DataAccessException;
	
	void deleteGroupBuy(int groupBuyId) throws DataAccessException;

	void createOptions(GroupBuy groupBuy) throws DataAccessException;
	
	List<GroupBuy> getGroupBuyList() throws DataAccessException;
	
	List<Option> getOptions(int groupBuyId) throws DataAccessException;
	
//	List<GroupBuy> getGroupBuyListByKeyword(String keyword) throws DataAccessException;
}

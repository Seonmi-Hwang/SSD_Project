package dongduk.cs.ssd.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.Menu;

public interface MenuDao {
	List<Menu> getMenuList() throws DataAccessException;

	List<Menu> getCategoryList() throws DataAccessException;

	Menu getMenu(String menuId) throws DataAccessException;
}

package dongduk.cs.ssd.service;

import org.springframework.beans.factory.annotation.Autowired;

import dongduk.cs.ssd.dao.UserDao;
import dongduk.cs.ssd.domain.User;

/**
 * @author Yejin Lee
 * @since 2020.05.02
 */

public class UserServiceImpl implements UserService {
	
	@Override
	public User getUser(String email, String passwd) {
		return userDao.getUser(email, passwd);
	}

	@Autowired
	private UserDao userDao;

	@Override
	public User getUserByEmailId(String emailId) {
		return userDao.getUserByEmailId(emailId);
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
	public void deleteUser(String emailId) {
		userDao.deleteUser(emailId);
	}

}

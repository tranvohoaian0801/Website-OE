package Service.impl;

import java.util.List;

import DAO.AbstractDAO;
import DAO.UserDAO;
import DAO.impl.UserDaoimpl;
import Entity.User;
import Service.UserService;

public class UserServiceimpl  implements UserService {
	
		UserDAO dao;
	
	public UserServiceimpl() {
		dao = new UserDaoimpl();
	}


	@Override
	public User findByEmail(String email) {
		return dao.findbyEmail(email);
	}

	@Override
	public User login(String id, String password) {
		return dao.findbyIdAndPass(id, password);
	}

	@Override
	public User resetPassword(String email) {
		User existUser = findByEmail(email);
		if(existUser != null) {
			String newPass = String.valueOf(123);
			existUser.setPassword(newPass);
			return dao.update(existUser);
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return dao.findAll( pageNumber, pageSize);
	}

	@Override
	public User register(String id, String password, String email,String fullname) {
		User newUser = new User();
		newUser.setId(id);
		newUser.setPassword(password);
		newUser.setEmail(email);
		newUser.setFullname(fullname);
		newUser.setAdmin(Boolean.FALSE);
		return dao.create(newUser);
	}

	@Override
	public User update(User entity) {
		return dao.update(entity);
	}

	@Override
	public User delete(String id) {
		User user = dao.findbyID(id);
		return dao.delete(user);
	}
	
	@Override
	public User findById(String id) {
		return dao.findbyID(id);
	}

}

package DAO.impl;

import java.util.List;

import DAO.AbstractDAO;
import DAO.UserDAO;
import Entity.User;

public class UserDaoimpl extends AbstractDAO<User> implements UserDAO {

	@Override
	public User findbyID(String id) {
		// TODO Auto-generated method stub
		return super.findbyID(User.class, id);
	}

	@Override
	public User findbyEmail(String email) {
		// TODO Auto-generated method stub
		String sql="Select o from User o where o.Email=?0";
		return super.findOne(User.class,sql,email);
	}

	@Override
	public User findbyIdAndPass(String id, String password) {
		String sql="Select o from User o where o.Id=?0 and o.Password=?1";
		return super.findOne(User.class, sql, id,password);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(User.class);
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return super.findAll(User.class, true, pageNumber, pageSize);
	}

}

package DAO;

import java.util.List;

import Entity.User;

public interface UserDAO {
	User findbyID (String id);
	User findbyEmail(String email);
	User findbyIdAndPass(String id,String password);
	List<User> findAll();
	List<User> findAll(int pageNumber,int pageSize);
	User create(User entity);
	User update(User entity);
	User delete(User entity);
	
	
	

}

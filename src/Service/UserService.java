package Service;

import java.util.List;

import Entity.User;

public interface UserService {
	User findByEmail(String email);
	User findById(String username);
	User login(String username, String password);
	User resetPassword(String email);
	List<User> findAll();
	List<User> findAll(int pageNumber, int pageSize);
	User register(String username, String password, String email,String fullname);
	User update(User entity);
	User delete(String username);
}

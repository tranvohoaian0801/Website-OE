package DAO;

import java.util.List;

import Entity.Share;

public interface ShareDAO {
	 Share findbyEmail(String email);
	 List<Share> findByUserId(String UserId);
	 List<Share> findByVideoId(Integer VideoId);
	 Share findByUserIdAndVideoID(String UserId,Integer VideoId);
	 Share create(Share entity);
	 Share update(Share entity);
	 Share delete(Share entity);

}

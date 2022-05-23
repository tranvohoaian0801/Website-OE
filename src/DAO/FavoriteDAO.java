package DAO;

import java.util.List;

import Entity.Favorite;


public interface FavoriteDAO {
	List<Favorite> findByUserId(String UserId);
	 List<Favorite> findbyUserAndlike(String UserId);
	 List<Favorite> findByVideoId(String videoId);
	 Favorite create(Favorite entity);
	 Favorite update(Favorite entity);
	 Favorite delete(Favorite entity);
	Favorite findByUserIdAndVideoID(String userId, String videoId);
	 

}

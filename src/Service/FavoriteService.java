package Service;

import java.util.List;

import Entity.Favorite;
import Entity.User;
import Entity.Video;


public interface FavoriteService {
	List<Favorite> findByUserId(String UserId);
	 List<Favorite> findbyUserAndlike(String UserId);
	 List<Favorite> findByVideoId(String VideoId);
	 Favorite findByUserIdAndVideoID(String UserId,String VideoId);
	 Favorite create(User user,Video video);
	 Favorite update(Favorite entity);
	 Favorite delete(Favorite entity);
	 boolean updateLikeOrUnlike(User user,String link);
	
	 

}

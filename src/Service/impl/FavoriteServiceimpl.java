package Service.impl;


import java.security.Timestamp;
import java.util.List;

import DAO.AbstractDAO;
import DAO.FavoriteDAO;
import DAO.impl.FavoriteDaoimpl;
import Entity.Favorite;
import Entity.User;
import Entity.Video;
import Service.FavoriteService;
import Service.VideoService;

public  class FavoriteServiceimpl  implements FavoriteService {
		
	private FavoriteDAO dao;
	private VideoService videoservice;
	
	public FavoriteServiceimpl() {
		dao =new FavoriteDaoimpl();
	}
	

	@Override
	public List<Favorite> findByUserId(String UserId) {		
		return dao.findByUserId(UserId);
	}

	@Override
	public List<Favorite> findByVideoId(String VideoId) {
		// TODO Auto-generated method stub
		return dao.findByVideoId(VideoId);
	}

	@Override
	public Favorite findByUserIdAndVideoID(String UserId, String videoId) {
		// TODO Auto-generated method stub
		return dao.findByUserIdAndVideoID(UserId,videoId);
	}


	@Override
	public Favorite update(Favorite entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}


	@Override
	public Favorite delete(Favorite entity) {
		// TODO Auto-generated method stub
		return dao.delete(entity);
	}

	@Override
	public Favorite create(User user, Video video) {
		// TODO Auto-generated method stub
		Favorite favorite= new Favorite();
		favorite.setUser(user);
		favorite.setVideo(video);
		favorite.setIsLike(false);
		return dao.create(favorite);
	}

	@Override
	public boolean updateLikeOrUnlike(User user, String link) {
		// TODO Auto-generated method stub
		Video video= videoservice.findbyhref(link);
		Favorite favorite =findByUserIdAndVideoID(user.getId(), video.getId());
		if(favorite.getIsLike()==Boolean.FALSE) {
			favorite.setIsLike(true);	
		}
		else {
			favorite.setIsLike(false);
			favorite.setLikeDate(null);
		}
		Favorite updatefavorite=dao.update(favorite);
		return updatefavorite != null ? true :false;
	}
	@Override
	public List<Favorite> findbyUserAndlike(String UserId) {
		// TODO Auto-generated method stub
		return dao.findbyUserAndlike(UserId);
	}

}

package DAO.impl;

import java.util.List;

import DAO.AbstractDAO;
import DAO.FavoriteDAO;
import Entity.Favorite;
import Entity.Share;

public class FavoriteDaoimpl extends AbstractDAO<Favorite> implements FavoriteDAO {


	@Override
	public List<Favorite> findByUserId(String UserId) {
		String sql="select o from Favorite o where o.UserId = 0? and o.video.active= 1"+"Order by o.views desc";
		return super.findMany(Favorite.class, sql, UserId);
	}

	@Override
	public List<Favorite> findByVideoId(String VideoId) {
		// TODO Auto-generated method stub
		String sql="select o from Favorite o where o.VideoId = 0? and o.video.active= 1"+"Order by o.views desc";
		return super.findMany(Favorite.class, sql, VideoId);
	}

	@Override
	public Favorite findByUserIdAndVideoID(String UserId, String VideoId) {
		// TODO Auto-generated method stub
		String sql ="select o from Favorite o where o.userid=?0 and o.videoid=?1" 
				+ "and o.video.active= 1";
		return super.findOne(Favorite.class, sql,UserId, VideoId);
	}

	@Override
	public List<Favorite> findbyUserAndlike(String UserId) {
		// TODO Auto-generated method stub
		String sql ="select o from Favorite o where  o.UserId = 0? and o.isLike=1 and o.video.Active= 1";
		return super.findMany(Favorite.class, sql, UserId);
	}

}

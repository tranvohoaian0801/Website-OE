package DAO.impl;

import java.util.List;

import DAO.AbstractDAO;
import DAO.ShareDAO;
import Entity.Share;
import Entity.User;
import Entity.Video;

public class ShareDaoimpl extends AbstractDAO<Share> implements ShareDAO{

	@Override
	public Share findbyEmail(String email) {
		// TODO Auto-generated method stub
		String sql="Select o from Share o where o.email=?0";
		return super.findOne(Share.class,sql,email);
	}

	@Override
	public List<Share> findByUserId(String UserId) {
		// TODO Auto-generated method stub
		String sql="select o from Share o where o.UserId = 0? and o.video.active= 1"+"Order by o.views desc";
		return super.findMany(Share.class, sql, UserId);
	}

	@Override
	public List<Share> findByVideoId(Integer VideoId) {
		// TODO Auto-generated method stub
		String sql="select o from Share o where o.VideoId = 0? and o.video.active= 1"+"Order by o.views desc";
		return super.findMany(Share.class, sql, VideoId);
	}

	@Override
	public Share findByUserIdAndVideoID(String UserId, Integer VideoId) {
		// TODO Auto-generated method stub
		String sql ="select o from share o where o.userid=?0 and o.videoid=?1" 
				+ "and o.video.active= 1";
		return super.findOne(Share.class, sql,UserId, VideoId);
	}

}

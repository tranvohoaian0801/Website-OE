package DAO.impl;

import java.util.List;

import DAO.AbstractDAO;
import DAO.VideoDAO;
import Entity.Video;

public class VideoDaoimpl extends AbstractDAO<Video> implements VideoDAO {

	@Override
	public Video findID(String id) {
		// TODO Auto-generated method stub
		return super.findbyID(Video.class, id);
	}

	@Override
	public Video findbyhref(String link) {
		// TODO Auto-generated method stub
		String sql="select o from Video o where o.link= ?0";
		return super.findOne(Video.class, sql, link);
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(Video.class);
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return super.findAll(Video.class, true, pageNumber, pageSize);
	}

	@Override
	public List<Video> findAll(boolean active) {
		// TODO Auto-generated method stub
		return super.findAll(Video.class,true);
	}
	

}

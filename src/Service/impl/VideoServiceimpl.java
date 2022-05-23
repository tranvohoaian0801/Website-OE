package Service.impl;

import java.util.List;

import DAO.AbstractDAO;
import DAO.VideoDAO;
import DAO.impl.VideoDaoimpl;
import Entity.Video;
import Service.VideoService;

public class VideoServiceimpl implements VideoService {
	
	 private VideoDAO dao;
	 public VideoServiceimpl() {
		 dao= new VideoDaoimpl();
	 }
	

	@Override
	public Video findID(String id) {
		// TODO Auto-generated method stub
		return dao.findID(id);
	}

	@Override
	public Video findbyhref(String href) {
		// TODO Auto-generated method stub
		return dao.findbyhref(href);
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public Video create(Video entity) {
		// TODO Auto-generated method stub
		entity.setActive(true);
		entity.setViews(0);
		return dao.create(entity);
	}

	@Override
	public Video update(Video entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	
	@Override
	public Video delete(String href) {
		// TODO Auto-generated method stub
		Video entity=findID(href);
		entity.setActive(false);
		return dao.delete(entity);
	}

	
	

}

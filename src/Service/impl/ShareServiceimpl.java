package Service.impl;

import java.util.List;

import DAO.AbstractDAO;
import DAO.ShareDAO;
import DAO.impl.ShareDaoimpl;
import Entity.Share;
import Entity.User;
import Entity.Video;
import Service.ShareService;

public class ShareServiceimpl  implements ShareService{
	
	 private ShareDAO dao;
	 public ShareServiceimpl() {
		 dao = new ShareDaoimpl();
	 }

	@Override
	public Share findbyEmail(String email) {
		// TODO Auto-generated method stub		
		return dao.findbyEmail(email);
	}

	@Override
	public List<Share> findByUserId(String UserId) {
		// TODO Auto-generated method stub
		return dao.findByUserId(UserId);
	}

	@Override
	public List<Share> findByVideoId(Integer VideoId) {
		// TODO Auto-generated method stub
		return dao.findByVideoId(VideoId);
	}

	@Override
	public Share findByUserIdAndVideoID(String UserId, Integer VideoId) {
		// TODO Auto-generated method stub
		return dao.findByUserIdAndVideoID(UserId, VideoId);
	}

	@Override
	public Share create(Share entity) {
		// TODO Auto-generated method stub
		return dao.create(entity);
	}

	@Override
	public Share update(Share entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public Share delete(Share entity) {
		// TODO Auto-generated method stub
		return dao.delete(entity);
	}

}

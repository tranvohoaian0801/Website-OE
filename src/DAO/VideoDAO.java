package DAO;

import java.util.List;

import Entity.Video;

public interface VideoDAO {
	Video findID(String id);
	Video findbyhref(String link);
	List<Video> findAll(boolean active);
	List<Video> findAll(int pageNumber,int pageSize);
	Video create(Video entity);
	Video update(Video entity);
	Video delete(Video entity);
	List<Video> findAll();

}

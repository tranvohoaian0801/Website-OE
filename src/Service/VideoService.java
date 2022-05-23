package Service;

import java.util.List;

import Entity.Video;

public interface VideoService {
	Video findID(String id);
	Video findbyhref(String link);
	List<Video> findAll();
	List<Video> findAll(int pageNumber,int pageSize);
	Video create(Video entity);
	Video update(Video entity);
	Video delete(String link);

}

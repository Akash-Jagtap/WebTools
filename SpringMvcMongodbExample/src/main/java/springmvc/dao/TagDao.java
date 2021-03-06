package springmvc.dao;

import java.util.List;

import springmvc.model.Tag;

public interface TagDao {
	
	public List<Tag> findTagByUserId(String id);
	
	public List<Tag> findTagByMovieId(String id);
	
	public List<Tag> findTagByTag(String tag);
	
	public List<Tag> findTagByTimeStamp(String timest);
	
	void add(Tag tag);
	
}

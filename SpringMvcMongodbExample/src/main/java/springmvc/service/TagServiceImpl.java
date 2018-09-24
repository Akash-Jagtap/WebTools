package springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.TagDao;
import springmvc.model.Tag;
@Service
public class TagServiceImpl implements TagService{

	@Autowired
	TagDao tagDao;
	@Override
	public List<Tag> findTagByUserId(String id) {
		// TODO Auto-generated method stub
		return tagDao.findTagByUserId(id);
	}

	@Override
	public List<Tag> findTagByMovieId(String id) {
		// TODO Auto-generated method stub
		return tagDao.findTagByMovieId(id);
	}

	@Override
	public List<Tag> findTagByTag(String tag) {
		// TODO Auto-generated method stub
		return tagDao.findTagByTag(tag);
	}

	@Override
	public List<Tag> findTagByTimeStamp(String timest) {
		// TODO Auto-generated method stub
		return tagDao.findTagByTimeStamp(timest);
	}

	@Override
	public void add(Tag tag) {
		// TODO Auto-generated method stub
		tagDao.add(tag);
	}

}

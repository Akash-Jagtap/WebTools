package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import springmvc.model.Tag;

@Repository
public class TagImpl implements TagDao {

	@Autowired
	MongoTemplate mongoTemplate;

	private static final String COLLECTION_NAME = "tag";

	@Override
	public void add(Tag tag) {
		if (!mongoTemplate.collectionExists(Tag.class)) {
			mongoTemplate.createCollection(Tag.class);
		}
		mongoTemplate.insert(tag, COLLECTION_NAME);
	}

	@Override
	public List<Tag> findTagByUserId(String id) {
		Query q= new Query();
		q.addCriteria(Criteria.where("userID").is(id));
		return mongoTemplate.find(q, Tag.class);
	}

	@Override
	public List<Tag> findTagByMovieId(String id) {
		Query q= new Query();
		q.addCriteria(Criteria.where("movieID").is(id));
		return mongoTemplate.find(q, Tag.class);
	}

	@Override
	public List<Tag> findTagByTag(String tag) {
		Query q= new Query();
		q.addCriteria(Criteria.where("tag").regex(tag));
		return mongoTemplate.find(q, Tag.class);
	}

	@Override
	public List<Tag> findTagByTimeStamp(String timest) {
		Query q= new Query();
		q.addCriteria(Criteria.where("timeStamp").is(timest));
		return mongoTemplate.find(q, Tag.class);
	}

}

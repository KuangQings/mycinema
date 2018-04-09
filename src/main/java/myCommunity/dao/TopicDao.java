package myCommunity.dao;

import java.util.List;


import myCommunity.entity.Topic;

public interface TopicDao {
	List<Topic> findAll();
}

package myCommunity.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import myCommunity.dao.ForumDao;
import myCommunity.dao.TopicDao;
import myCommunity.entity.Forum;
import myCommunity.entity.Topic;

@Component
@Scope("prototype")
public class ForumAction extends ActionSupport {
	
	@Autowired
	private ForumDao fdao;
	@Autowired
	private TopicDao topicDao;
	
	private List<Topic> topics;
	
	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	private List<Forum> forums;
	public List<Forum> getForums() {
		return forums;
	}
	
	public String index() {
		 this.forums=fdao.findAll();
		 this.topics = topicDao.findAll();
		 return "index";
	}

}

package myCommunity.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myCommunity.dao.TopicDao;

import myCommunity.entity.Topic;
@Repository
public class TopicDaoImpl implements TopicDao {
	@Autowired
	private HibernateTemplate  db;
	
	@Override
	public List<Topic> findAll() {
		return db.execute(new HibernateCallback<List<Topic>>() {

			@Override
			public List<Topic> doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Topic.class);
				criteria.addOrder(Order.desc("updateTime"));
				criteria.setFirstResult(0);
				criteria.setMaxResults(6); 
				try {
					return criteria.list();
				} catch (Exception e) {
					throw e;
				}
			}
		});

		}
	
	public static void main(String[] args) {
 
		 ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-beans.xml");
		 TopicDao dao=ctx.getBean(TopicDao.class);
			
			System.out.println(dao.findAll().size());
		}
	}
	


package com.canteen.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canteen.pojo.Orderitem;
import com.canteen.pojo.OrderitemId;

/**
 	* A data access object (DAO) providing persistence and search support for Orderitem entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.canteen.pojo.Orderitem
  * @author MyEclipse Persistence Tools 
 */
public class OrderitemDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(OrderitemDAO.class);
		//property constants
	public static final String NUM = "num";


	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

    
    public void save(Orderitem transientInstance) {
        log.debug("saving Orderitem instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Orderitem persistentInstance) {
        log.debug("deleting Orderitem instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Orderitem findById( com.canteen.pojo.OrderitemId id) {
        log.debug("getting Orderitem instance with id: " + id);
        try {
            Orderitem instance = (Orderitem) getSession()
                    .get("com.canteen.pojo.Orderitem", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Orderitem> findByExample(Orderitem instance) {
        log.debug("finding Orderitem instance by example");
        try {
            List<Orderitem> results = (List<Orderitem>) getSession()
                    .createCriteria("com.canteen.pojo.Orderitem")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Orderitem instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Orderitem as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Orderitem> findByNum(Object num
	) {
		return findByProperty(NUM, num
		);
	}
	

	public List findAll() {
		log.debug("finding all Orderitem instances");
		try {
			String queryString = "from Orderitem";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Orderitem merge(Orderitem detachedInstance) {
        log.debug("merging Orderitem instance");
        try {
            Orderitem result = (Orderitem) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Orderitem instance) {
        log.debug("attaching dirty Orderitem instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Orderitem instance) {
        log.debug("attaching clean Orderitem instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
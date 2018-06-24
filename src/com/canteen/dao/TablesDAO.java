package com.canteen.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canteen.pojo.Tables;

/**
 	* A data access object (DAO) providing persistence and search support for Tables entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.canteen.pojo.Tables
  * @author MyEclipse Persistence Tools 
 */
public class TablesDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TablesDAO.class);
		//property constants
	public static final String TABLES_STATE = "tablesState";


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

    
    public void save(Tables transientInstance) {
        log.debug("saving Tables instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Tables persistentInstance) {
        log.debug("deleting Tables instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Tables findById( java.lang.Integer id) {
        log.debug("getting Tables instance with id: " + id);
        try {
            Tables instance = (Tables) getSession()
                    .get("com.canteen.pojo.Tables", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Tables> findByExample(Tables instance) {
        log.debug("finding Tables instance by example");
        try {
            List<Tables> results = (List<Tables>) getSession()
                    .createCriteria("com.canteen.pojo.Tables")
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
      log.debug("finding Tables instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Tables as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Tables> findByTablesState(Object tablesState
	) {
		return findByProperty(TABLES_STATE, tablesState
		);
	}
	

	public List findAll() {
		log.debug("finding all Tables instances");
		try {
			String queryString = "from Tables";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Tables merge(Tables detachedInstance) {
        log.debug("merging Tables instance");
        try {
            Tables result = (Tables) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Tables instance) {
        log.debug("attaching dirty Tables instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Tables instance) {
        log.debug("attaching clean Tables instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    @SuppressWarnings("unchecked")
	public List<Tables> findAvailableTable(){
    	String hql = "from Tables t where t.tablesState=0 ";
    	Query queryObject = getSession().createQuery(hql);
		 return queryObject.list();    	
    }
}
package com.canteen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canteen.pojo.Category;
import com.canteen.pojo.Menu;

/**
 	* A data access object (DAO) providing persistence and search support for Menu entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.canteen.pojo.Menu
  * @author MyEclipse Persistence Tools 
 */
public class MenuDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MenuDAO.class);
		//property constants
	public static final String MENU_NAME = "menuName";
	public static final String PRICE = "price";
	public static final String SUMMARY = "summary";
	public static final String IMG = "img";

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


    
    public void save(Menu transientInstance) {
        log.debug("saving Menu instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Menu persistentInstance) {
        log.debug("deleting Menu instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Menu findById( java.lang.Integer id) {
        log.debug("getting Menu instance with id: " + id);
        try {
            Menu instance = (Menu) getSession()
                    .get("com.canteen.pojo.Menu", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Menu> findByExample(Menu instance) {
        log.debug("finding Menu instance by example");
        try {
            List<Menu> results = (List<Menu>) getSession()
                    .createCriteria("com.canteen.pojo.Menu")
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
      log.debug("finding Menu instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Menu as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Menu> findByMenuName(Object menuName
	) {
		return findByProperty(MENU_NAME, menuName
		);
	}
	
	public List<Menu> findByPrice(Object price
	) {
		return findByProperty(PRICE, price
		);
	}
	
	public List<Menu> findBySummary(Object summary
	) {
		return findByProperty(SUMMARY, summary
		);
	}
	
	public List<Menu> findByImg(Object img
	) {
		return findByProperty(IMG, img
		);
	}
	

	public List findAll() {
		log.debug("finding all Menu instances");
		try {
			String queryString = "from Menu";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Menu merge(Menu detachedInstance) {
        log.debug("merging Menu instance");
        try {
            Menu result = (Menu) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Menu instance) {
        log.debug("attaching dirty Menu instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Menu instance) {
        log.debug("attaching clean Menu instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /*
	 * 设置图片的路径
	 */
	public void setImgPath(String fileName ,Integer menuId) {
		Menu menu = this.findById(menuId);
		menu.setImg("img-menu\\"+fileName);
		getSession().update(menu);
	}
		
	/*
	 * 获取图片头像的路径
	 */
	public String getImgPath(Integer menuId){
		String hql = "from Menu m where m.menuId=?";
		Query queryObject = getSession().createQuery(hql);
		queryObject.setParameter(0, menuId);
		return null;		
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findAllMenuList(){
		String hql = "from Menu m , Category c  where m.category=c.categoryId";
		Query queryObject = getSession().createQuery(hql);
		List<Object[]> list = new ArrayList<Object[]>();
		list = queryObject.list();
		return list;
		
	}
}
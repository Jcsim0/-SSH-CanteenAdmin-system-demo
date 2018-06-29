package com.canteen.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;
import java.util.Map;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.canteen.pojo.Admin;
import com.opensymphony.xwork2.ActionContext;

/**
 * A data access object (DAO) providing persistence and search support for Admin
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.canteen.pojo.Admin
 * @author MyEclipse Persistence Tools
 */
public class AdminDAO extends BaseHibernateDAO
{
	private static final Logger log = LoggerFactory.getLogger(AdminDAO.class);
	// property constants
	public static final String ADMIN_NAME = "adminName";
	public static final String JOB = "job";
	public static final String SEX = "sex";
	public static final String PASSWORD = "password";
	public static final String PHONE = "phone";
	public static final String ACCOUNT = "account";

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

	public void save(Admin transientInstance)
	{
		log.debug("saving Admin instance");
		try
		{
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Admin persistentInstance)
	{
		log.debug("deleting Admin instance");
		try
		{
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public Admin findById(java.lang.Integer id)
	{
		log.debug("getting Admin instance with id: " + id);
		try
		{
			Admin instance = (Admin) getSession().get("com.canteen.pojo.Admin",
					id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Admin> findByExample(Admin instance)
	{
		log.debug("finding Admin instance by example");
		try
		{
			List<Admin> results = (List<Admin>) getSession()
					.createCriteria("com.canteen.pojo.Admin")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding Admin instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Admin as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Admin> findByAdminName(Object adminName)
	{
		return findByProperty(ADMIN_NAME, adminName);
	}

	public List<Admin> findByJob(Object job)
	{
		return findByProperty(JOB, job);
	}

	public List<Admin> findBySex(Object sex)
	{
		return findByProperty(SEX, sex);
	}

	public List<Admin> findByPassword(Object password)
	{
		return findByProperty(PASSWORD, password);
	}

	public List<Admin> findByPhone(Object phone)
	{
		return findByProperty(PHONE, phone);
	}

	public List<Admin> findByAccount(Object account)
	{
		return findByProperty(ACCOUNT, account);
	}

	public List findAll()
	{
		log.debug("finding all Admin instances");
		try
		{
			String queryString = "from Admin";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Admin merge(Admin detachedInstance)
	{
		log.debug("merging Admin instance");
		try
		{
			Admin result = (Admin) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Admin instance)
	{
		log.debug("attaching dirty Admin instance");
		try
		{
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Admin instance)
	{
		log.debug("attaching clean Admin instance");
		try
		{
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * 登录判断--return 0:用户名密码均正确，1，为用户名不存在，2为密码不正确；-1为异常
	 */
	@SuppressWarnings("unchecked")
	public String judgeAdminAccount(Admin admin)
	{
		List<Admin> rs = this.findByAccount(admin.getAccount());
		if (!rs.isEmpty())
		{
			for (Admin use : rs)
			{
				String pwd = use.getPassword();
				if (pwd.equals(admin.getPassword()))
				{
					((Map<String, Object>) ActionContext.getContext().get("session")).put("admin", use);
					return use.getAdminName(); // 密码正确，登录成功 返回用户名字
				} else
					return "passwordError";// 密码错误
			}
			return "unknowError";// 异常
		} else
			return "accountError";// 登录名错误
	}
}
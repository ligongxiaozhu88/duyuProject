package com.duyu.dao.impl;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.duyu.dao.CommonDao;
import com.duyu.utils.BlankUtil;

@Repository("commonDao")
public class CommonDaoImpl extends HibernateDaoSupport implements CommonDao {

	@Resource
	public void setMysessionFactory(SessionFactory mySessionFactory) {
		super.setSessionFactory(mySessionFactory);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findObjectsByQuery(String query, Object o[],
			int maxResultNum) throws RuntimeException {
		HibernateTemplate ht = getHibernateTemplate();
		if (maxResultNum > 0) {
			ht.setMaxResults(maxResultNum);
		} else {
			ht.setMaxResults(Integer.MAX_VALUE);
		}
		if (!BlankUtil.isBlank(o)) {
			return ht.find(query, o);
		} else {
			return ht.find(query);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findObjectsByQueryNamesParam(final String hql,
			final Map<String, Object> params, final int maxResultNum)
			throws RuntimeException {
		return (List<T>) getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setProperties(params);
						if (maxResultNum > 0) {
							query.setMaxResults(maxResultNum);
						} else {
							query.setMaxResults(Integer.MAX_VALUE);
						}
						return query.list();
					}
				});
	}
	public Object uniqueResultHQL(final String hql, final Object... params)
			throws RuntimeException {
		return getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (!BlankUtil.isBlank(params)) {
					for (int index = 0; index < params.length; index++) {
						query.setParameter(index, params[index]);
					}
				}
				return query.uniqueResult();
			}
		});
	}
	/**
	 * 调用存储过程
	 * 
	 * @param name
	 *            存储过程名
	 * @param params
	 *            参数列表
	 * 
	 * @return
	 * @throws RuntimeException
	 */
	public void callProcedure(final String sql, final Object[] params)
			throws RuntimeException {
		getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				String callname = "{call " + sql + "}";
				CallableStatement cs = session.connection().prepareCall(
						callname);
				if (!BlankUtil.isBlank(params)) {
					for (int i = 0; i < params.length; i++) {
						cs.setObject(i + 1, params[i]);
					}
				}
				cs.execute();
				cs.close();
				return null;
			}
		});

	}
	@SuppressWarnings("unchecked")
	public <T> T getObject(Serializable id, Class<T> className)
			throws RuntimeException {
		return (T) getHibernateTemplate().get(className, id);
	}

	public <T> Serializable saveObject(T entity) throws RuntimeException {
		return getHibernateTemplate().save(entity);
	}

	public <T> void deleteObject(T entity) throws RuntimeException {
		getHibernateTemplate().delete(entity);
	}
	public <T> void updateObject(T entity) throws RuntimeException {
		getHibernateTemplate().update(entity);
	}
}


package be.odisee.lucychang.dao;

import org.hibernate.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

class HibernateDao {

	SessionFactory sessionFactory;

    protected HibernateDao() {}

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected void sessionSaveObject(Object o){
        try{
            sessionFactory.getCurrentSession().save(o);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected Object sessionGetObjectById(String classname, int id){
        Object result = null;
        try{
            result = sessionFactory.getCurrentSession().createQuery("from "+classname+" where id="+id).uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    protected Object getLastObjectOfQuery(String qstr){
        Object result = null;
        try{
            @SuppressWarnings("rawtypes")
			List list = sessionFactory.getCurrentSession().createQuery(qstr).list();
            if (!list.isEmpty()) result = list.get(list.size()-1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    protected Object sessionGetObjectBy1StringParameterNamedQuery(String qstr, String parameter, String value){
    	Query query = null;
        Object result = null;
        try{
            query = sessionFactory.getCurrentSession().createQuery(qstr);
            query.setString(parameter, value);
            result = query.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    protected Object sessionGetObjectByQuery(String qstr){
    	Object result = null;
        try{
            Query query = sessionFactory.getCurrentSession().createQuery(qstr);
            result = query.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
	protected List sessionGetAllObjects(String classname) {
        Query query = null;
 		List result = null;
        try{
            query = sessionFactory.getCurrentSession().createQuery("from "+classname);
            result = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    protected void sessionUpdateObject(Object o){
        try{
        	sessionFactory.getCurrentSession().update(o);
            sessionFactory.getCurrentSession().flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    protected void sessionDeleteObject(Object o){
        try{
        	sessionFactory.getCurrentSession().delete(o);
        	sessionFactory.getCurrentSession().flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}

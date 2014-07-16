package lyh.base;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;

public class BaseDao {
	protected Session session;
	protected Transaction transaction;
	protected ThreadLocal<Session> local = new ThreadLocal<Session>();
	
	public BaseDao(){
		if(this.session == null){
			this.local.set(HibernateSessionFactory.getSession());
		}
		this.session = this.local.get();
	}
}
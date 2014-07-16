package lyh.dao.user;

import org.hibernate.HibernateException;

import util.HibernateSessionFactory;

import lyh.base.BaseDao;
import lyh.po.user.MemberInfo;

public class MemberInfoDao extends BaseDao{
	
	/**
	 * 插入用户信息
	 */
	public int saveMemberInfo(MemberInfo info){
		int i = 0;
		super.transaction = super.session.beginTransaction();
		try {
			super.session.save(info);
			super.transaction.commit();
			i = info.getId();
		} catch (HibernateException e) {
			super.transaction.rollback();
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.getSession().close();
		}
		
		return i;
	}
}


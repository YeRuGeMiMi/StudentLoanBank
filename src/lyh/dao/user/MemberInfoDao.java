package lyh.dao.user;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

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
	
	public List<MemberInfo> getByType(int type){
		String hql = "from MemberInfo as i where i.member.type=:type";
		Query query = super.session.createQuery(hql);
		query.setInteger("type", type);
		List<MemberInfo> list = query.list();
		
		return list;
	}
}


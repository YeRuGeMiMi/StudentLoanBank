 package lyh.dao.user;

import java.util.List;

import lyh.base.BaseDao;
import lyh.po.user.Member;

import org.hibernate.CacheMode;
import org.hibernate.Query;


import util.HibernateSessionFactory;

public class MemberDao extends BaseDao {
	
	public MemberDao(){
		
	}
	
	/**
	 *保存一个Member
	 * @param Member
	 * @return int
	 */
	public int saveMember(Member member){
		int i = 0;
		super.transaction = super.session.beginTransaction();
		
		try {
			super.session.save(member);
			super.transaction.commit();
			i = member.getUid();
		} catch (Exception e) {
			super.transaction.rollback();
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.getSession().close();
		}
		
		return i;
	}
	
	/**
	 * 根据用户名取得用户
	 * @param String
	 * @return Member
	 */
	public Member getPasswordByUsername(String username){
		Member member = null;
		
		String hql = "from Member as m where m.username=:name";
		Query query = super.session.createQuery(hql);
		query.setString("name", username);
		
		List<Member> list = query.list();
		
		if(list.size() > 0){
			member = list.get(0);	
		}
		return member;
		
	}
	
	/**
	 * 根据ID取得用户
	 * @param int
	 * @return Member 
	 */
	public Member getById(int uid){
		Member member = null;
		String hql = "from Member as m where m.uid=:uid";
		Query query = super.session.createQuery(hql);
		query.setInteger("uid", uid);
		query.setCacheMode(CacheMode.IGNORE);
		
		List<Member> list = query.list();
		if(list.size() > 0){
			member = list.get(0);
		}
		
		return member;
	}
	
	/**
	 * 修改
	 * @param member
	 * @return
	 */
	public boolean update(Member member){
		super.transaction = super.session.beginTransaction();
		try {
			super.session.save(member);
			super.transaction.commit();
		} catch (Exception e) {
			super.transaction.rollback();
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}


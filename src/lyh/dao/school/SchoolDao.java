package lyh.dao.school;

import java.util.List;

import org.hibernate.Query;

import util.HibernateSessionFactory;
import lyh.base.BaseDao;
import lyh.po.school.School;

public class SchoolDao extends BaseDao{
	
	/**
	 *保存一个school
	 * @param school
	 * @return 保存school的ID
	 */
	public int saveSchool(School school){
		int i = 0;
		super.transaction = super.session.beginTransaction();
		
		try {
			super.session.save(school);
			super.transaction.commit();
			i = school.getScid();
		} catch (Exception e) {
			super.transaction.rollback();
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.getSession().close();
		}
		return i;
	}
	
	/**
	 * 根据uid取得一个school
	 * @param uid
	 * @return
	 */
	public School getByUid(int uid){
		School school = null;
		
		String hql = "from School as s where s.member.uid=:uid";
		Query query = super.session.createQuery(hql);
		query.setInteger("uid", uid);
		
		List<School> list = query.list();
		if(list.size()>0){
			school = list.get(0);
		}
		
		return school;
	}
	
	/**
	 * 获取所有学校
	 * @return
	 */
	public List<School> getAllSchool(){
		List<School> list = null;
		
		String hql = "from School";
		Query query = super.session.createQuery(hql);
		list = query.list();
		
		return list;
	}

}

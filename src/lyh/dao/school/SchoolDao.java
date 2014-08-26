package lyh.dao.school;

import java.util.List;

import org.hibernate.CacheMode;
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
		
		String hql = "select s.scid,s.name from School as s";
		Query query = super.session.createQuery(hql);
		list = query.list();
		
		return list;
	}
	
	/**
	 * ID查询
	 * @param scid
	 * @return
	 */
	public School getSchool(int scid){
		String hql = "from School as s where s.scid=:scid";
		Query query = super.session.createQuery(hql);
		query.setInteger("scid", scid);
		
		List<School> list = query.list();
		
		School school = list.get(0);
		
		return school;
	}
	
	/**
	 * 查询学校（带查询条件）
	 * @param scid
	 * @param start
	 * @param size
	 * @param textword
	 * @return
	 */
	public List<School> getByFy(int start,int size,String textword){
		StringBuilder hql = new StringBuilder("from School as s");
		Query query = null;
		
		//查询条件
		if(!"null".equals(textword)&&textword != null){
			hql.append(" where s.name like :name");
			hql.append(" or s.scode like :code");
			hql.append(" order by s.scid DESC");
			query = super.session.createQuery(hql.toString());
			query.setString("name", "%"+textword+"%");
			query.setString("code", "%"+textword+"%");
		}else{
			query = super.session.createQuery(hql.toString());
		}
		
		query.setCacheMode(CacheMode.IGNORE);
		List<School> schools = query.list();
		
		if(schools.size()>0){
			return schools;
		}
		
		return null;
	}
	
	/**
	 * 根据条件获得学校总数
	 * @param scid
	 * @param textword
	 * @return
	 */
	public int countSchool(String textword){
		StringBuilder hql = new StringBuilder("select count(*) from School as s");
		Query query = null;
		
		if(!"null".equals(textword)&&textword != null){
			hql.append(" where s.name like :name");
			hql.append(" or s.scode like :code");
			hql.append(" order by s.scid DESC");
			query = super.session.createQuery(hql.toString());
			query.setString("name", "%"+textword+"%");
			query.setString("code", "%"+textword+"%");
		}else{
			query = super.session.createQuery(hql.toString());
		}
		
		query.setCacheMode(CacheMode.IGNORE);
		long count = (Long)query.uniqueResult();
		
		return (int)count;
		
	}

}

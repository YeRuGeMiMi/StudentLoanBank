package lyh.dao.student;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import lyh.base.BaseDao;
import lyh.po.student.Student;

public class StudentDao extends BaseDao{
	
	/**
	 * 保存studnet
	 * @param student
	 * @return
	 */
	public Student save(Student student){
		int i = 0;
		super.transaction = super.session.beginTransaction();
		
		try {
			super.session.save(student);
			super.transaction.commit();
			i = student.getStid();
			
		} catch (HibernateException e) {
			super.transaction.rollback();
			e.printStackTrace();
		}
		
		if(i>0){
			return student;
		}
		
		return null;
	}
	
	/**
	 *取得这个用户关联的学生 
	 * @param uid
	 * @return
	 */
	public Student getByUid(int uid){
		String hql = "from Student as su where su.member.uid=:uid";
		Query query = super.session.createQuery(hql);
		
		query.setInteger("uid", uid);
		
		List<Student> list = query.list();
		
		if(list.size()>0){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Id获取一个student
	 * @param stid
	 * @return
	 */
	public Student getByStid(int stid){
		String hql = "from Student as su where su.stid=:stid";
		Query query = super.session.createQuery(hql);
		
		query.setInteger("stid", stid);
		
		List<Student> list = query.list();
		
		if(list.size()>0){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * 取得一个学校的所有学生
	 * @param scid
	 * @return
	 */
	public List<Student> getAllbySchool(int scid){
		String hql = "from Student as stu where stu.school.scid=:scid";
		Query query = super.session.createQuery(hql);
		
		query.setInteger("scid", scid);
		
		List<Student> list = query.list();
		
		if(list.size()>0){
			return list;
		}
		
		return null;
	}
	
	/**
	 * 按学校查询学生（分页查询）
	 * @param scid
	 * @param start
	 * @param size
	 * @param textword
	 * @return
	 */
	public List<Student> getBySchool(int scid,int start,int size,String textword){
		StringBuilder hql = new StringBuilder("from Student as stu where stu.school.scid=:scid");
		
		Query query = null;
		
		//查询条件
		if(!"null".equals(textword)&&textword != null){
			hql.append(" and stu.name like :name");
			hql.append(" or stu.schoolcode like :code");
			hql.append(" order by stu.stid DESC");
			query = super.session.createQuery(hql.toString());
			query.setString("name", "%"+textword+"%");
			query.setString("code", "%"+textword+"%");
		}else{
			hql.append(" order by stu.stid DESC");
			query = super.session.createQuery(hql.toString());
		}
		query.setInteger("scid", scid);
		
		//设置分页
		query.setFirstResult(start);
		query.setMaxResults(size);
		
		//查询结果
		query.setCacheMode(CacheMode.IGNORE);
		List<Student> list = query.list();
		
		return list;
	}
	
	/**
	 * 获得一个学校学生总数（带查询条件）
	 * @param scid
	 * @param textword
	 * @return
	 */
	public int getCountSchool(int scid,String textword){
		StringBuilder hql = new StringBuilder("select count(*) from Student as stu where stu.school.scid=:scid");
		Query query = null;
		
		//查询条件
		if(!"null".equals(textword)&&textword != null){
			hql.append(" and stu.name like :name");
			hql.append(" or stu.schoolcode like :code");
			query = super.session.createQuery(hql.toString());
			query.setString("name", "%"+textword+"%");
			query.setString("code", "%"+textword+"%");
		}else{
			query = super.session.createQuery(hql.toString());
		}
		query.setInteger("scid", scid);
		
		//查询结果
		query.setCacheMode(CacheMode.IGNORE);
		long count = (Long)query.uniqueResult();
		
		return (int)count;
		
	}
	
	/**
	 * 获取总数
	 * @param textword
	 * @return
	 */
	public int getCount(String textword){
		StringBuilder hql = new StringBuilder("select count(*) from Student as stu");
		Query query = null;
		
		//查询条件
		if(!"null".equals(textword)&&textword != null){
			hql.append(" and stu.name like :name");
			hql.append(" or stu.schoolcode like :code");
			query = super.session.createQuery(hql.toString());
			query.setString("name", "%"+textword+"%");
			query.setString("code", "%"+textword+"%");
		}else{
			query = super.session.createQuery(hql.toString());
		}
		
		//查询结果
		query.setCacheMode(CacheMode.IGNORE);
		long count = (Long)query.uniqueResult();
		
		return (int)count;
	}
	
	/**
	 * 查询学生（分页查询）
	 * @param scid
	 * @param start
	 * @param size
	 * @param textword
	 * @return
	 */
	public List<Student> getAll(int start,int size,String textword){
		StringBuilder hql = new StringBuilder("from Student as stu");
		
		Query query = null;
		
		//查询条件
		if(!"null".equals(textword)&&textword != null){
			hql.append(" and stu.name like :name");
			hql.append(" or stu.schoolcode like :code");
			hql.append(" order by stu.stid DESC");
			query = super.session.createQuery(hql.toString());
			query.setString("name", "%"+textword+"%");
			query.setString("code", "%"+textword+"%");
		}else{
			hql.append(" order by stu.stid DESC");
			query = super.session.createQuery(hql.toString());
		}
		
		//设置分页
		query.setFirstResult(start);
		query.setMaxResults(size);
		
		//查询结果
		query.setCacheMode(CacheMode.IGNORE);
		List<Student> list = query.list();
		
		return list;
	}
}

package lyh.dao.student;

import java.util.List;

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
}

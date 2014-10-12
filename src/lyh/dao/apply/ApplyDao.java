package lyh.dao.apply;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import lyh.base.BaseDao;
import lyh.po.apply.Apply;

public class ApplyDao extends BaseDao{
	
	/**
	 * 新增一个申请
	 */
	public Apply create(Apply apply){
		int i = 0;
		super.transaction = super.session.beginTransaction();
		
		try {
			super.session.save(apply);
			super.transaction.commit();
			i=apply.getApid();
		} catch (HibernateException e) {
			super.transaction.rollback();
			e.printStackTrace();
		}
		if(i>0){
			return apply;
		}
		
		return null;
	}
	
	/**
	 * 学生id取得申请单
	 * @param stid
	 * @return
	 */
	public  Apply getByStid(int stid){
		String hql = "from Apply a where a.student.stid=:stid";
		
		Query query = super.session.createQuery(hql);
		query.setInteger("stid", stid);
		
		query.setCacheMode(CacheMode.IGNORE);
		List<Apply> list = query.list();
		
		if(list.size()==1){
			return list.get(0);
		}
		
		return null;
	}
}

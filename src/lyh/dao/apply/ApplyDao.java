package lyh.dao.apply;

import org.hibernate.HibernateException;

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
}

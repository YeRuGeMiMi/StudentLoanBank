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
	
	/**
	 * 取得学校的全部的申请单(按参数分页)
	 * @param start
	 * @param size
	 * @param textword
	 * @return
	 */
	public List<Apply> getAll(int start,int size,String textword,int scid){
		StringBuilder hql = new StringBuilder("from Apply as a");
		Query query = null;
		
		//查询条件
		if(!"".equals(textword) && textword != null){
			hql.append(" where a.student.school.scid=:scid");
			hql.append(" AND (a.student.schoolcode like :schoolcode");
			hql.append(" or a.student.name like :name");
			hql.append(" or a.bank.bname like :bname)");
			hql.append(" order by a.apid DESC");
			query = super.session.createQuery(hql.toString());
			
			//设置条件
			query.setInteger("scid", scid);
			query.setString("schoolcode", "%"+textword+"%");
			query.setString("name", "%"+textword+"%");
			query.setString("bname", "%"+textword+"%");
			
			//设置范围
			query.setFirstResult(start);
			query.setMaxResults(size);
		}else{
			hql.append(" where a.student.school.scid=:scid");
			hql.append(" order by a.apid DESC");
			query = super.session.createQuery(hql.toString());
			
			//设置条件
			query.setInteger("scid", scid);
			
			//设置范围
			query.setFirstResult(start);
			query.setMaxResults(size);
		}
		
		query.setCacheMode(CacheMode.IGNORE);
		List<Apply> list = query.list();
		
		if(list.size()>0){
			return list;
		}
		
		return null;
	}
	
	/**
	 * 取得学校的申请单总数
	 * @return
	 */
	public int count(String textword,int scid){
		StringBuilder hql = new StringBuilder("select count(*) from Apply as a");
		Query query = null;
		
		//查询条件
		if(!"".equals(textword) && textword != null){
			hql.append(" where a.student.school.scid=:scid");
			hql.append(" AND (a.student.schoolcode like :schoolcode");
			hql.append(" or a.student.name like :name");
			hql.append(" or a.bank.bname like :bname)");
			query = super.session.createQuery(hql.toString());
			
			//设置条件
			query.setInteger("scid", scid);
			query.setString("schoolcode", "%"+textword+"%");
			query.setString("name", "%"+textword+"%");
			query.setString("bname", "%"+textword+"%");
		}else{
			hql.append(" where a.student.school.scid=:scid");
			query = super.session.createQuery(hql.toString());
			
			//设置条件
			query.setInteger("scid", scid);
		}
		
		query.setCacheMode(CacheMode.IGNORE);
		long count = (Long)query.uniqueResult();
		
		return (int)count;
	}
	
	/**
	 * 取得一条申请单（apid）
	 * @param apid
	 * @return
	 */
	public Apply getApply(int apid){
		String hql = "from Apply where apid=:apid";
		Query query = super.session.createQuery(hql);
		query.setInteger("apid", apid);
		
		List<Apply> list = query.list();
		if(list.size() == 1){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * 修改申请单状态
	 * @param apply
	 * @return
	 */
	public boolean updateStatus(Apply apply){
		super.transaction = super.session.beginTransaction();
		try {
			super.session.update(apply);
			super.transaction.commit();
		} catch (Exception e) {
			super.transaction.rollback();
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 取得学校的申请单总数
	 * @return
	 */
	public int countBnak(String textword,int bid){
		StringBuilder hql = new StringBuilder("select count(*) from Apply as a");
		Query query = null;
		
		//查询条件
		if(!"".equals(textword) && textword != null){
			hql.append(" where a.bank.bid=:bid");
			hql.append(" AND (a.student.schoolcode like :schoolcode");
			hql.append(" or a.student.name like :name");
			hql.append(" or a.bank.bname like :bname)");
			query = super.session.createQuery(hql.toString());
			
			//设置条件
			query.setInteger("bid", bid);
			query.setString("schoolcode", "%"+textword+"%");
			query.setString("name", "%"+textword+"%");
			query.setString("bname", "%"+textword+"%");
		}else{
			hql.append(" where a.bank.bid=:bid");
			query = super.session.createQuery(hql.toString());
			
			//设置条件
			query.setInteger("bid", bid);
		}
		
		query.setCacheMode(CacheMode.IGNORE);
		long count = (Long)query.uniqueResult();
		
		return (int)count;
	}
	/**
	 * 取得银行的全部的申请单(按参数分页)
	 * @param start
	 * @param size
	 * @param textword
	 * @return
	 */
	public List<Apply> getBankAll(int start,int size,String textword,int bid){
		StringBuilder hql = new StringBuilder("from Apply as a");
		Query query = null;
		
		//查询条件
		if(!"".equals(textword) && textword != null){
			hql.append(" where a.bank.bid=:bid");
			hql.append(" AND (a.student.schoolcode like :schoolcode");
			hql.append(" or a.student.name like :name");
			hql.append(" or a.bank.bname like :bname)");
			hql.append(" order by a.apid DESC");
			query = super.session.createQuery(hql.toString());
			
			//设置条件
			query.setInteger("bid", bid);
			query.setString("schoolcode", "%"+textword+"%");
			query.setString("name", "%"+textword+"%");
			query.setString("bname", "%"+textword+"%");
			
			//设置范围
			query.setFirstResult(start);
			query.setMaxResults(size);
		}else{
			hql.append(" where a.bank.bid=:bid");
			hql.append(" order by a.apid DESC");
			query = super.session.createQuery(hql.toString());
			
			//设置条件
			query.setInteger("bid", bid);
			
			//设置范围
			query.setFirstResult(start);
			query.setMaxResults(size);
		}
		
		query.setCacheMode(CacheMode.IGNORE);
		List<Apply> list = query.list();
		
		if(list.size()>0){
			return list;
		}
		
		return null;
	}
}

package lyh.dao.bank;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import lyh.base.BaseDao;
import lyh.po.bank.Bank;

public class BankDao extends BaseDao{
	
	/**
	 * 新增银行
	 * @param bank
	 * @return
	 */
	public int save(Bank bank){
		super.transaction = super.session.beginTransaction();
		int i =0;
		try {
			super.session.save(bank);
			super.transaction.commit();
			i = bank.getBid();
		} catch (HibernateException e) {
			e.printStackTrace();
			super.transaction.rollback();
		}
		
		return i;
	}
	
	/**
	 * 取得用户管理的银行信息
	 * @param uid
	 * @return
	 */
	public Bank getOne(int uid){
		String hql = "from Bank as b where b.member.uid=:uid";
		
		Query query = super.session.createQuery(hql);
		query.setInteger("uid", uid);
		
		List<Bank> list = query.list();
		
		if(list.size() == 1){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * 取得一跳银行（按bid）
	 * @return
	 */
	public Bank getOneByBid(int bid){
		String hql = "from Bank as b where b.bid=:bid";
		
		Query query = super.session.createQuery(hql);
		query.setInteger("bid", bid);
		
		List<Bank> list = query.list();
		
		if(list.size() == 1){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * 取得全部(按参数)
	 * @return
	 */
	public List<Bank> getAll(int start,int size,String textword){
		StringBuilder hql = new StringBuilder("from Bank as b");
		Query query = null;
		
		//查询条件
		if(!"null".equals(textword)&&textword != null){
			hql.append(" where b.bname like :name");
			hql.append(" or b.bcode like :code");
			hql.append(" order by b.bid DESC");
			query = super.session.createQuery(hql.toString());
			query.setString("name", "%"+textword+"%");
			query.setString("code", "%"+textword+"%");
		}else{
			query = super.session.createQuery(hql.toString());
		}
		
		query.setCacheMode(CacheMode.IGNORE);
		List<Bank> list = query.list();
		
		if(list.size()>0){
			return list;
		}
		
		return null;
	}
	
	/**
	 * 取得全部(无参数)
	 * @return
	 */
	public List<Bank> getAll(){
		String hql = "from Bank";
		Query query = super.session.createQuery(hql);
		query.setCacheMode(CacheMode.IGNORE);
		List<Bank> list = query.list();
		if(list.size()>0){
			return list;
		}
		
		return null;
	}
	
	/**
	 * 按条件取得总数
	 * @param textword
	 * @return
	 */
	public int count(String textword){
		StringBuilder hql = new StringBuilder("select count(*) from Bank as b");
		Query query = null;
		
		if(!"null".equals(textword)&&textword != null){
			hql.append(" where b.bname like :name");
			hql.append(" or b.bcode like :code");
			hql.append(" order by b.bid DESC");
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

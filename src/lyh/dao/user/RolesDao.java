package lyh.dao.user;

import java.util.List;

import org.hibernate.Query;

import lyh.base.BaseDao;
import lyh.po.user.Roles;

public class RolesDao extends BaseDao{
	
	/**
	 * 取得全部角色
	 * @return
	 */
	public List<Roles> getAll(){
		String hql = "from Roles";
		Query query = super.session.createQuery(hql);
		List<Roles> list = query.list();
		return list;
	}
	
	/**
	 * 取得一个角色
	 * @param roid
	 * @return
	 */
	public Roles get(int roid){
		String hql = "from Roles where roid=:roid";
		Query query = super.session.createQuery(hql);
		query.setInteger("roid", roid);
		List<Roles> list = query.list();
		if(list.size() == 1){
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * 保存角色
	 * @param roles
	 * @return
	 */
	public boolean save(Roles roles){
		
		super.transaction = super.session.beginTransaction();
		try {
			super.session.save(roles);
			super.transaction.commit();
		} catch (Exception e) {
			super.transaction.rollback();
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}

package lyh.dao.school;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;

import lyh.base.BaseDao;
import lyh.po.school.Collage;

public class CollageDao extends BaseDao{
	
	/**
	 * 保存一个Collage
	 * @param collage
	 * @return
	 */
	public int saveCollage(Collage collage){
		int i = 0;
		super.transaction = super.session.beginTransaction();
		
		try {
			super.session.save(collage);
			super.transaction.commit();
			i = collage.getCoid();
		} catch (Exception e) {
			super.transaction.rollback();
			e.printStackTrace();
		}finally{
			super.session.close();
		}
		return i;
	}
	
	/**
	 * 根据学校查找所有学院(分页查询)
	 * @param scid
	 * @return
	 */
	public List<Collage> getBySchool(int scid,int start,int size,String textword){
		
		StringBuilder hql = new StringBuilder("from Collage as c where c.school.scid=:scid");
		Query query = null;
		
		//查询条件
		if(!"null".equals(textword)&&textword != null){
			hql.append(" and c.coname like :name");
			hql.append(" order by c.coid desc");
			query = super.session.createQuery(hql.toString());
			query.setInteger("scid", scid);
			query.setFirstResult(start);
			query.setMaxResults(size);
			query.setString("name", "%"+textword+"%");
		}else{
			hql.append(" order by c.coid desc");
			query = super.session.createQuery(hql.toString());
			query.setInteger("scid", scid);
			query.setFirstResult(start);
			query.setMaxResults(size);
		}
		
		
		query.setCacheMode(CacheMode.IGNORE);
		List<Collage> list = query.list();
		
		return list;
	}
	
	/**
	 * 根据学院ID查找学院
	 * @param coid
	 * @return
	 */
	public Collage getByCoid(int coid){
		String hql = "from Collage as c where c.coid=:coid";
		Query query = super.session.createQuery(hql);
		query.setInteger("coid", coid);
		
		List<Collage> list = query.list();
		
		return list.get(0);
	}
	
	/**
	 * 根据条件获取总数
	 * @param keys
	 * @return
	 */
	public int countCollage(int scid,String textword){
		StringBuilder hql = new StringBuilder("select count(*) from Collage as c where c.school.scid=:scid");
		Query query = null;
		
		//查询条件
		if(textword != null){
			hql.append(" and c.coname like :name");
			query = super.session.createQuery(hql.toString());
			query.setInteger("scid", scid);
			query.setString("name", "%"+textword+"%");
		}else{
			query = super.session.createQuery(hql.toString());
			query.setInteger("scid", scid);
		}
		
		
		//Integer count = (Integer)query.uniqueResult();
		query.setCacheMode(CacheMode.IGNORE);
		long count = (Long)query.uniqueResult();
		
		return (int)count;
	}
	
	/**
	 * 取得学院名和学院ID的对
	 * @param scid
	 * @return
	 */
	public List<Collage> getQueueCollage(int scid){
		String hql = "from Collage as c where c.school.scid=:scid";
		Query query = super.session.createQuery(hql);
		query.setInteger("scid", scid);
		
		List<Collage> list = query.list();
		
		return list;
	}
}

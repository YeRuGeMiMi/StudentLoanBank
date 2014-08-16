package lyh.dao.school;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;

import util.HibernateSessionFactory;
import lyh.base.BaseDao;
import lyh.po.school.Collage;
import lyh.po.school.School;

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
	public List<Collage> getBySchool(int scid,int start,int size){
		
		String hql = "from Collage as c where c.school.scid=:scid order by c.coid desc";
		Query query = super.session.createQuery(hql);
		query.setInteger("scid", scid);
//		query.setFirstResult(1);
//		query.setMaxResults(3);
		
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
	
	

}

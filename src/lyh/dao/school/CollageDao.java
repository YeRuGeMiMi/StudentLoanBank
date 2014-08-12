package lyh.dao.school;

import util.HibernateSessionFactory;
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
		super.session.beginTransaction();
		
		try {
			super.session.save(collage);
			super.transaction.commit();
			i = collage.getCoid();
		} catch (Exception e) {
			super.transaction.rollback();
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.getSession().close();
		}
		return i;
	}
	
	

}

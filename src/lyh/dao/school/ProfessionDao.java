package lyh.dao.school;

import java.util.List;

import org.hibernate.Query;

import lyh.base.BaseDao;
import lyh.po.school.Profession;

public class ProfessionDao extends BaseDao{
	
	/**
	 * 保存一个Profession
	 * @param profession
	 * @return
	 */
	public int saveProfession(Profession profession){
		int i = 0;
		
		super.transaction = super.session.beginTransaction();
		
		try {
			super.session.save(profession);
			super.transaction.commit();
			i = profession.getProid();
		} catch (Exception e) {
			super.transaction.rollback();
			e.printStackTrace();
		}finally{
			super.session.close();
		}
		
		return i;
	}
	
	/**
	 * 根据学院ID取得专业
	 * @param coid
	 * @return
	 */
	public List<Profession> getByCollage(int coid){
		String hql = "from Profession as p where p.collage.coid=:coid";
		
		Query query = super.session.createQuery(hql);
		query.setInteger("coid", coid);
		
		List<Profession> pros = (List<Profession>)query.list();
		
		return pros;
	}
}

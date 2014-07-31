package lyh.dao.index;

import java.util.List;

import org.hibernate.Query;

import lyh.base.BaseDao;
import lyh.po.index.Menu;

public class MenuDao extends BaseDao{
	
	/**
	 * 根据Id取得指定的菜单
	 */
	public Menu getMenu(){
		
		return null;
	}
	
	/**
	 * 取得所有的Menu结构
	 */
	public List getMenus(){
		//取得所有root菜单
		String getroot = "from Menu as m where m.plid=:plid";
		Query rootquery = super.session.createQuery(getroot);
		rootquery.setInteger("plid", 0);
		List<Menu> roots = rootquery.list();
		return roots;
	}
	
	/**
	 * 取得一个菜单的子菜单
	 */
	public List getChildMeuns(){
		return null;
	}
}

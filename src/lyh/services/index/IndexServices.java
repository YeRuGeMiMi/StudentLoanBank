package lyh.services.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lyh.base.BaseServices;
import lyh.dao.index.MenuDao;
import lyh.po.index.Menu;


public class IndexServices extends BaseServices{
	
	/**
	 * 取得所有的菜单
	 * @return
	 */
	public static Map<String,List<Menu>> getMunes(){
		Map<String,List<Menu>> result = new HashMap<String, List<Menu>>();
		
		MenuDao dao = new MenuDao();
		
		List<Menu> roots = dao.getMenus(0);
		result.put("0", roots);
		for(Menu m:roots){
			if(m.getHas_submenu() == 0){
				continue;
			}
			List<Menu> list = dao.getMenus(m.getMlid());
			result.put(m.getTitle(), list);
		}
		return result;
	}

}

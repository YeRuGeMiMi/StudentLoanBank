package lyh.web.index;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;


import lyh.base.BaseAction;
import lyh.po.index.Menu;
import lyh.services.index.IndexServices;

/**
 * 首页
 * @author lyh
 *
 */
public class IndexAction extends BaseAction{

	@Override
	public String execute() throws Exception {

		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		String today = df.format(System.currentTimeMillis());
		Map<String,List<Menu>> result = IndexServices.getMunes();
		super.request.put("menus", result);
		super.session.put("today", today);
 		return "In";
	}
	
}

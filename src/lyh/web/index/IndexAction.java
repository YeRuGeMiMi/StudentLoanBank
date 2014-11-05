package lyh.web.index;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import util.Common;


import lyh.base.BaseAction;
import lyh.po.index.Menu;
import lyh.po.user.Member;
import lyh.po.user.Roles;
import lyh.services.index.IndexServices;

/**
 * 首页
 * @author lyh
 *
 */
public class IndexAction extends BaseAction{

	@Override
	public String execute() throws Exception {
		Member member = (Member)super.session.get("member");
		Roles roles = member.getRoles();
		List<Integer> power = Common.array2Int(roles.getRopower().split(","));
		
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		String today = df.format(System.currentTimeMillis());
		Map<String,List<Menu>> result = IndexServices.getMunes(power);
		super.request.put("menus", result);
		super.session.put("today", today);
 		return "In";
	}
	
}

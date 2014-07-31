package lyh.web.index;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import lyh.base.BaseAction;

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
		super.session.put("today", today);
		return "In";
	}
	
}

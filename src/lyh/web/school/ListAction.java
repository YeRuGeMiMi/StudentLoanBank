package lyh.web.school;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import util.PageUtil;

import lyh.base.BaseAction;
import lyh.po.school.School;
import lyh.services.school.SchoolServices;

public class ListAction extends BaseAction{
	private String textword;
	private String p;
	
	

	public String getTextword() {
		return textword;
	}



	public void setTextword(String textword) {
		this.textword = textword;
	}



	public String getP() {
		return p;
	}



	public void setP(String p) {
		this.p = p;
	}



	@Override
	public String execute() throws Exception {
		String method = ServletActionContext.getRequest().getMethod();
		Map<String,Object> keys = new HashMap<String,Object>();
		keys.put("size", 6);
		
		if("POST".equals(method)){
			keys.put("p", 1);
		}else{
			if(p == null){
				keys.put("p", 1);
			}else{
				keys.put("p", Integer.parseInt(p));
			}
		}
		keys.put("textword", textword);
		
		List<School> schools = SchoolServices.schoolList(keys);
		
		//分页
		int total = (Integer)keys.get("total");
		int element = (Integer)keys.get("size");
		String url = "list";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("textword", keys.get("textword"));
		int p = (Integer)keys.get("p");
		PageUtil util = new PageUtil(total, element, url, map, p);
		String pagepaper = util.showPage();
		
		super.request.put("pagepaper", pagepaper);
		super.request.put("schools", schools);
		super.request.put("keys", keys);
		
		return "In";
	}
	

}

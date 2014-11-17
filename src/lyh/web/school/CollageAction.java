package lyh.web.school;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import util.PageUtil;

import lyh.base.BaseAction;
import lyh.po.school.Collage;
import lyh.po.user.Member;
import lyh.services.school.SchoolServices;

public class CollageAction extends BaseAction{
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
		Member member = (Member)super.session.get("member");
		if(SchoolServices.getOneByUid(member.getUid()) == null){
			super.request.put("message", "学校信息尚未完善，请到[学校管理]->[学校信息]填写学校信息");
			return "fail";
		}
		Map<String,Object> keys = new HashMap<String,Object>();
		keys.put("scid", SchoolServices.getOneByUid(member.getUid()).getScid());
		keys.put("size", 6);
		
		String method = ServletActionContext.getRequest().getMethod();
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
		
		List<Collage> collages = SchoolServices.collageList(keys);
		
		//分页
		int total = (Integer)keys.get("total");
		int element = (Integer)keys.get("size");
		String url = "collage";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("textword", keys.get("textword"));
		int p = (Integer)keys.get("p");
		PageUtil util = new PageUtil(total, element, url, map, p);
		String pagepaper = util.showPage();
		
		super.request.put("pagepaper", pagepaper);
		super.request.put("collages", collages);
		super.request.put("keys", keys);
		
		return "In";
	}
	
	

}

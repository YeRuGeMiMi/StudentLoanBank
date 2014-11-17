package lyh.web.studnet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import util.PageUtil;

import lyh.base.BaseAction;
import lyh.po.school.School;
import lyh.po.student.Student;
import lyh.po.user.Member;
import lyh.services.school.SchoolServices;
import lyh.services.student.StudentServices;

public class InfoAction extends BaseAction {
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
		if(member.getType() == 2){
			keys.put("scid", SchoolServices.getOneByUid(member.getUid()).getScid());
		}
		keys.put("size", 6);
		
		String method = ServletActionContext.getRequest().getMethod();
		if(method.equals("POST")){
			keys.put("p", 1);
		}else{
			if(p == null){
				keys.put("p", 1);
			}else{
				keys.put("p", Integer.parseInt(p));
			}
			
		}
		keys.put("textword", textword);
		
		StudentServices services = new StudentServices();
		List<Student> students = services.getSetudentsByFy(keys);
		
		//分页
		int total = (Integer)keys.get("total");
		int element = (Integer)keys.get("size");
		String url = "info";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("textword", keys.get("textword"));
		int p = (Integer)keys.get("p");
		PageUtil util = new PageUtil(total, element, url, map, p);
		String pagepaper = util.showPage();
		
		super.request.put("pagepaper", pagepaper);
		super.request.put("students", students);
		super.request.put("keys", keys);
		
		return "In";
	}
	
	

}

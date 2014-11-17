package lyh.web.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import util.PageUtil;
import lyh.base.BaseAction;
import lyh.po.apply.Apply;
import lyh.po.bank.Bank;
import lyh.po.school.School;
import lyh.po.user.Member;
import lyh.services.apply.ApplyServices;
import lyh.services.bank.BankServices;
import lyh.services.school.SchoolServices;
/**
 * 银行审核申请单
 * @author lyh
 *
 */
public class BankVerAction extends BaseAction{
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
		Member member = (Member) super.session.get("member");
		String method = ServletActionContext.getRequest().getMethod();
		
		//取得学校信息
		BankServices bankSer = new BankServices();
		Bank bank = bankSer.getOneBank(member.getUid());
		if(bank == null){
			super.request.put("message", "银行信息尚未完善，请到[银行管理]->[银行信息]填写银行信息");
			return "fail";
		}
		
		//取得申请的services
		ApplyServices applySer = new ApplyServices();
		
		Map<String,Object> keys = new HashMap<String,Object>();
		keys.put("size", 6);
		keys.put("bid", bank.getBid());
		
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
		
		//取得学校的申请单列表
		List<Apply> applys = applySer.getBankApplyList(keys);
		
		//分页
		int total = (Integer)keys.get("total");
		int element = (Integer)keys.get("size");
		String url = "schoolVer";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("textword", keys.get("textword"));
		int p = (Integer)keys.get("p");
		PageUtil util = new PageUtil(total, element, url, map, p);
		String pagepaper = util.showPage();
		
		Map<Integer,String> order_status = new HashMap<Integer,String>();
		order_status.put(1, "待学校审核");
		order_status.put(2, "待银行审核");
		order_status.put(3, "通过");
		order_status.put(4, "拒绝");
		
		super.request.put("order_status", order_status);
		super.request.put("applys", applys);
		super.request.put("pagepaper", pagepaper);
		super.request.put("keys", keys);
		return "In";
	}

	
}

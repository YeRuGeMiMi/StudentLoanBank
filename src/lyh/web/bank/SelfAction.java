package lyh.web.bank;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import lyh.base.BaseAction;
import lyh.po.bank.Bank;
import lyh.po.user.Member;
import lyh.services.bank.BankServices;

public class SelfAction extends BaseAction{
	private String bname;
	private String bcode;
	private String officetel;
	private String email;

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String execute() throws Exception {
		String method = ServletActionContext.getRequest().getMethod();
		Member member = (Member) super.session.get("member");
		Map<String, Object> keys = new HashMap<String, Object>();
		BankServices services = new BankServices();
		
		//获取用户的bank
		Bank bank = services.getOneBank(member.getUid());
		
		if("POST".equals(method)){
			keys.put("bname", bname.trim());
			keys.put("bcode", bcode.trim());
			keys.put("officetel", officetel.trim());
			keys.put("email", email.trim());
			keys.put("member", member);
			
			bank = services.saveBak(keys);
			
		}
		
		if(bank != null){
			super.request.put("bank", bank);
			return "sucess";
		}
		
		return "In";
	}
	
	

}

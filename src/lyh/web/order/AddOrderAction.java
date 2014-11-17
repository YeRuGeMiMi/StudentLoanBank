package lyh.web.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import lyh.base.BaseAction;
import lyh.po.apply.Apply;
import lyh.po.bank.Bank;
import lyh.po.student.Student;
import lyh.po.user.Member;
import lyh.services.apply.ApplyServices;
import lyh.services.bank.BankServices;
import lyh.services.student.StudentServices;

public class AddOrderAction extends BaseAction{
	private String money;
	private String bankcode;
	private String bank;

	

	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}


	public String getMoney() {
		return money;
	}


	public void setMoney(String money) {
		this.money = money;
	}


	@Override
	public String execute() throws Exception {
		Member member = (Member) super.session.get("member");
		String method = ServletActionContext.getRequest().getMethod();
		ApplyServices applySer = new ApplyServices();
		
		//取得学生信息
		StudentServices studentSer = new StudentServices();
		Student student = studentSer.getByUid(member.getUid());
		if(student == null){
			super.request.put("message", "学生信息没有完善，请到[学生管理]->[学生信息]填写信息");
			return "fail";
		}
		
		//获取一个学生的申请单
		Apply apply = applySer.getApply(student);
		if(apply != null){
			Map<Integer,String> order_status = new HashMap<Integer,String>();
			order_status.put(1, "已提交学校审核");
			order_status.put(2, "已提交银行审核");
			order_status.put(3, "申请已经审核通过");
			order_status.put(4, "申请被拒绝");
			
			super.request.put("status", order_status.get(apply.getStatus()));
			return "Su";
		}
		
		if(method.equals("POST")){
			
			boolean bool = applySer.createApply(student, Integer.parseInt(bank), bankcode, Float.valueOf(money));
			
			if(bool){
				super.request.put("status","已提交学校审核");
				return "Su";
			}
		}
		
		//取得银行列表
		BankServices bankSer = new BankServices();
		List<Bank> banks = bankSer.getAllBank();
		
		super.request.put("student", student);
		super.request.put("banks", banks);
		return "In";
	}

	
}

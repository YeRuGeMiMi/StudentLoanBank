package lyh.services.apply;

import java.util.List;
import java.util.Map;

import util.Common;
import lyh.base.BaseServices;
import lyh.dao.apply.ApplyDao;
import lyh.dao.bank.BankDao;
import lyh.po.apply.Apply;
import lyh.po.bank.Bank;
import lyh.po.student.Student;

public class ApplyServices extends BaseServices{
	
	/**
	 * 创建申请单
	 * @param student
	 * @param bid
	 * @param bankcode
	 * @param money
	 * @return
	 */
	public boolean createApply(Student student,int bid,String bankcode,float money){
		Apply apply = new Apply();
		
		//取得银行
		BankDao bankdao = new BankDao();
		Bank bank = bankdao.getOneByBid(bid);
		
		//为属性赋值
		apply.setStudent(student);
		apply.setBank(bank);
		apply.setBankcode(bankcode);
		apply.setMoney(money);
		apply.setCreated(Common.getDate());
		apply.setLast_update(Common.getDate());
		apply.setStatus(1);                   //设置状态为学生提交订单，学校未审核
		apply.setApsn(Common.getApplySN());  //设置申请单的编号
		//创建申请单
		ApplyDao dao = new ApplyDao();
		Apply result = dao.create(apply);
		if(result != null){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 获取一个学生的申请单
	 * @param student
	 * @return
	 */
	public Apply getApply(Student student){
		ApplyDao dao = new ApplyDao();
		Apply apply = dao.getByStid(student.getStid());
		
		return apply;
	}
	
	/**
	 * 取得学校的申请单列表
	 * @return
	 */
	public List<Apply> getSchoolApplyList(Map<String,Object> keys){
		int size=(Integer)keys.get("size");   //每页显示数
		int p=(Integer)keys.get("p");
		int start;
		if(p==1 || p==0){
			start = 0;
		}else{
			start = (p-1)*size;
		}
		
		ApplyDao dao = new ApplyDao();
		
		//取得总数
		int total = dao.count((String)keys.get("textword"), (Integer)keys.get("scid"));
		keys.put("total", total);
		//取得申请单
		List<Apply> list = dao.getAll(start, size, (String)keys.get("textword"), (Integer)keys.get("scid"));
		
		return list;
	}
	
	/**
	 * 取得一条申请单
	 * @param apid
	 * @return
	 */
	public Apply getApply(int apid){
		ApplyDao dao = new ApplyDao();
		Apply apply = dao.getApply(apid);
		return apply;
	}
	
	/**
	 * 修改申请单
	 * @param id
	 * @param status
	 * @return
	 */
	public boolean updateApplyStatus(int id,int status){
		ApplyDao dao = new ApplyDao();
		Apply apply = this.getApply(id);
		apply.setStatus(status);
		
		boolean bool = dao.updateStatus(apply);
		return bool;
	}
}

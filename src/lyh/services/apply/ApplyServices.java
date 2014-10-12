package lyh.services.apply;

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
}

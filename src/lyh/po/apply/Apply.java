package lyh.po.apply;

import lyh.po.bank.Bank;
import lyh.po.student.Student;

/**
 * 申请单
 * @author lyh
 *
 */
public class Apply {
	/**属性**/
	private int apid;          //申请单id
	private Student student;   //发起申请单的学生
	private Bank bank;    	    //申请单对应的银行
	private int created;     	//创建申请单的时间
	private int last_update;   //申请单的最后修改时间
	private String bankcode;   //学生的银行卡号
	private int status;       //申请单的状态
	private float money;
	
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public int getCreated() {
		return created;
	}
	public void setCreated(int created) {
		this.created = created;
	}
	public int getLast_update() {
		return last_update;
	}
	public void setLast_update(int lastUpdate) {
		last_update = lastUpdate;
	}
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getApid() {
		return apid;
	}
	public void setApid(int apid) {
		this.apid = apid;
	}
	
	
	

}

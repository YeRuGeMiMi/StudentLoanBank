package lyh.services.bank;

import java.util.List;
import java.util.Map;

import lyh.base.BaseServices;
import lyh.dao.bank.BankDao;
import lyh.po.bank.Bank;
import lyh.po.user.Member;

public class BankServices extends BaseServices{
	
	/**
	 * 新增一个银行
	 * @param keys
	 * @return
	 */
	public Bank saveBak(Map<String,Object> keys){
		Bank bank = new Bank();
		bank.setBcode((String)keys.get("bcode"));
		bank.setBname((String)keys.get("bname"));
		bank.setOfficetel((String)keys.get("officetel"));
		bank.setEmail((String)keys.get("email"));
		bank.setMember((Member)keys.get("member"));
		
		BankDao dao = new BankDao();
		int i = dao.save(bank);
		
		if(i>0){
			return bank;
		}
		return null;
	}
	
	/**
	 * 获得用户绑定的银行
	 * @param uid
	 * @return
	 */
	public Bank getOneBank(int uid){
		BankDao dao = new BankDao();
		Bank bank = dao.getOne(uid);
		return bank;
	}
	
	/**
	 * 获取所有的银行信息(分页)
	 * @return
	 */
	public List<Bank> getAllBank(Map<String,Object> keys){
		int size=(Integer)keys.get("size");   //每页显示数
		int p=(Integer)keys.get("p");
		int start;
		if(p==1 || p==0){
			start = 0;
		}else{
			start = (p-1)*size;
		}
		
		BankDao dao = new BankDao();
		
		//取得总数
		int total = dao.count((String)keys.get("textword"));
		
		List<Bank> list = dao.getAll(start,size,(String)keys.get("textword"));
		keys.put("total", total);
		
		if(list != null){
			return list;
		}
		
		return null;
	}
	
	/**
	 * 获取所有的银行信息(无分页)
	 * @return
	 */
	public List<Bank> getAllBank(){
		BankDao dao = new BankDao();
		List<Bank> list = dao.getAll();
		return list;
	}
}

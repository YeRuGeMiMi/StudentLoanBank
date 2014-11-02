package lyh.web.order;

import java.util.HashMap;
import java.util.Map;

import lyh.base.BaseAction;
import lyh.po.apply.Apply;
import lyh.services.apply.ApplyServices;

public class OrderItemAction extends BaseAction{
	private int apid;
	

	public int getApid() {
		return apid;
	}


	public void setApid(int apid) {
		this.apid = apid;
	}


	@Override
	public String execute() throws Exception {
		ApplyServices applySer = new ApplyServices();
		Apply apply = applySer.getApply(apid);
		
		Map<Integer,String> order_status = new HashMap<Integer,String>();
		order_status.put(1, "待学校审核");
		order_status.put(2, "待银行审核");
		order_status.put(3, "通过");
		order_status.put(4, "拒绝");
		
		super.request.put("order_status", order_status);
		super.request.put("apply", apply);
		return "In";
	}

}

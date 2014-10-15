package lyh.web.order;

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
		super.request.put("apply", apply);
		return "In";
	}

}

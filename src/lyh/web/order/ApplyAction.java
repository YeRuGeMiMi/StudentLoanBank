package lyh.web.order;

import lyh.base.BaseAction;
import lyh.services.apply.ApplyServices;

public class ApplyAction extends BaseAction{
	private int id;
	private int status;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String execute() throws Exception {
		ApplyServices applySer = new ApplyServices();
		applySer.updateApplyStatus(this.id, this.status);
		return "school";
	}
	
}

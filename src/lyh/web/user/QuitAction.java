package lyh.web.user;


import lyh.base.BaseAction;

/**
 * 退出
 * @author lyh
 *
 */
public class QuitAction extends BaseAction {

	@Override
	public String execute() throws Exception {
		super.session.remove("member");
		
		return "sucess";
	}
	
	

}

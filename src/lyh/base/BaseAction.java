package lyh.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	/**
	 * 序列化ID
	 */
	protected static final long serialVersionUID = 1L;
	
	/**
	 * session
	 */
	protected Map<String,Object> session = ActionContext.getContext().getSession();
	
	/**
	 * request
	 */
	protected HttpServletRequest request;
	
	/**
	 * 注入request
	 * @param request
	 */
	public void setServletRequest(HttpServletRequest request){
	      this.request = request;
    }
}

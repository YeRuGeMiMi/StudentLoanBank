package lyh.base;


import lyh.po.user.Member;
import lyh.web.user.LoginAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 全局拦截器
 * @author lyh
 *
 */
public class SessionNullInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction();
		if(action instanceof LoginAction){
			return invocation.invoke();
		}
		
		Member member = (Member) ActionContext.getContext().getSession().get("member");
		if(member!=null){
			return invocation.invoke();
		}
		return "sessionnull";
	}

}

package util;

import java.util.Map;

/**
 * 分页工具类
 * @author lyh
 *
 */
public class PageUtil {
	private int total;    //总数
	private int element;  //每夜显示数
	private String url;   //访问的url
	private Map<String,Object> keys;	  //记忆参数
	private int p;       //当前页数
	private int page;   //总页数

	/**
	 * 构造传参数
	 * @param total
	 * @param element
	 * @param url
	 * @param keys
	 * @param p
	 */
	public PageUtil(int total,int element,String url,Map<String,Object> keys,int p){
		this.total = total;
		this.element = element;
		this.url = url;
		this.keys = keys;
		this.p = p;
		if(this.total != 0 && this.total%this.element == 0){
			this.page = this.total/this.element;
		}else{
			this.page = this.total/this.element+1;
		}
	}
	
	/**
	 * 拼接分页访问的url
	 * @param p
	 * @param keys
	 * @return 拼接好的带参数url
	 */
	private String createFullUrl(int p,Map<String,Object> keys){
		StringBuffer buf = new StringBuffer(this.url);
		buf.append("?p="+p);
		
		if(keys != null){
			buf.append(this.createParamUrl(keys));
		}
		return buf.toString();
	}
	
	private String createParamUrl(Map<String,Object> keys){
		StringBuffer buf = new StringBuffer();
		
		if(keys != null){
			for(String key : keys.keySet()){
				buf.append("&"+key+"="+keys.get(key));
			}
			return buf.toString();
		}else{
			return "";
		}
		
	}
	
	/**
	 * 生成分页代码
	 * @return
	 */
	public String showPage(){
		StringBuffer buf = new StringBuffer("<div class=\"footpage\">");
		
		if(this.page<=5){
			//5页显示
			for(int i=1;i<=this.page;i++){
				if(i==this.p){
					buf.append("<a href=\""+this.createFullUrl(i, this.keys)+"\" class=\"hidepage\">"+i+"</a>");
				}else{
					buf.append("<a href=\""+this.createFullUrl(i, this.keys)+"\" class=\"viewpage\">"+i+"</a>");
				}
			}
		}else{
			//超出5页显示
			if(this.p==1){
				//如果当前页是第一页的情况
				for(int i=1;i<=5;i++){
					if(i==this.p){
						buf.append("<a href=\""+this.createFullUrl(i, this.keys)+"\" class=\"hidepage\">"+i+"</a>");
					}else{
						buf.append("<a href=\""+this.createFullUrl(i, this.keys)+"\" class=\"viewpage\">"+i+"</a>");
					}
				}
				//超过5页部分省略
				buf.append("<span>...</span>");
			}else{
				//当前页不是第一页
				//显示首页
				buf.append("<a href=\""+this.createFullUrl(1, this.keys)+"\" class=\"viewpage\">首页</a>");
				buf.append("<span>...</span>");
				int cou =0;
				
				//判断五页是否超出范围
				if((this.p+5)>this.page){
					cou = this.page;
				}else{
					cou = this.p+5;
				}
				
				for(int j =this.p;j<cou;j++){
					if(j==this.p){
						buf.append("<a href=\""+this.createFullUrl(j, this.keys)+"\" class=\"hidepage\">"+j+"</a>");
					}else{
						buf.append("<a href=\""+this.createFullUrl(j, this.keys)+"\" class=\"viewpage\">"+j+"</a>");
					}
				}
				
				//判断是否还有页需要省略
				if(cou != this.page){
					buf.append("<span>...</span>");
				}
			}
			//显示尾页
			buf.append("<a href=\""+this.createFullUrl(this.page, this.keys)+"\" class=\"viewpage\">尾页</a>");
			 
		}
		
		buf.append("到<input type=\"text\" id=\"go\"/>页<button onclick=\"javascript:if(document.getElementById('go').value.match(/^([0-9])*$/)) {window.location='"+this.url+"?p=__PAGE__"+this.createParamUrl(this.keys)+"'.replace('__PAGE__',document.getElementById('go').value);} else {return false;}\">确定</button>");
		buf.append("共"+this.page+"页");
		buf.append("</div>");
		return buf.toString();
	}
}

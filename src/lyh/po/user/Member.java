package lyh.po.user;

import java.io.Serializable;

/**
 * 用户
 * @author lyh
 *
 */
public class Member implements Serializable {
	
	//属性
	private int uid;
	private String username;
	private String password;
	private String email;
	private int type;
	private int created;
	private Roles roles;
	
	
	/**
	 * 全构造
	 */
	public Member(String username,String password,String email,int type,int created){
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
		this.created = created;
	}
	
	/**
	 *空构造
	 */
	public Member(){
		
	}
	
	
	/**geter and seter**/
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public int getCreated() {
		return created;
	}

	public void setCreated(int created) {
		this.created = created;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	
}

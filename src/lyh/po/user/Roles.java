package lyh.po.user;

import java.io.Serializable;
import java.util.Set;

public class Roles implements Serializable{
	
	//属性
	private int roid;
	private String roname;
	private String rodec;
	private String ropower;
	private Set<Member> members;
	
	public int getRoid() {
		return roid;
	}
	public void setRoid(int roid) {
		this.roid = roid;
	}
	public String getRoname() {
		return roname;
	}
	public void setRoname(String roname) {
		this.roname = roname;
	}
	public String getRodec() {
		return rodec;
	}
	public void setRodec(String rodec) {
		this.rodec = rodec;
	}
	public String getRopower() {
		return ropower;
	}
	public void setRopower(String ropower) {
		this.ropower = ropower;
	}
	public Set<Member> getMembers() {
		return members;
	}
	public void setMembers(Set<Member> members) {
		this.members = members;
	}
	
}

package lyh.po.school;

import java.io.Serializable;
import java.util.Set;

import lyh.po.user.Member;

public class School implements Serializable{
	
	//属性
	private int scid;
	private String name;
	private String scode;
	private String email;
	private String address;
	private String officetel;
	private String fax;
	private Member member;
	private Set<Collage> collages;
	
	
	
	public Set<Collage> getCollages() {
		return collages;
	}

	public void setCollages(Set<Collage> collages) {
		this.collages = collages;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	//构造
	public School(){
		
	}
	
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOfficetel() {
		return officetel;
	}
	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	

}

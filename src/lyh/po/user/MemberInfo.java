package lyh.po.user;

import java.io.Serializable;

/**
 * 用户信息
 * @author lyh
 *
 */
public class MemberInfo implements Serializable {
	//属性
	private int id;
	private Member member;
	private String name;
	private String selfcode;
	private String address;
	private String school;
	private String collage;
	private int years;
	
	/**
	 * 空构造
	 */
	public MemberInfo(){
		
	}
	
	/**
	 * 全构造
	 */
	public MemberInfo(Member member,String name,String selfcode,String address,String school,String collage,int years){
		this.member = member;
		this.name = name;
		this.selfcode = selfcode;
		this.address = address;
		this.school = school;
		this.collage = collage;
		this.years = years;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSelfcode() {
		return selfcode;
	}
	public void setSelfcode(String selfcode) {
		this.selfcode = selfcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCollage() {
		return collage;
	}
	public void setCollage(String collage) {
		this.collage = collage;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	
	
}


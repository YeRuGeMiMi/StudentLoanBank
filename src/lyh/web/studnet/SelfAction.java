package lyh.web.studnet;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import lyh.base.BaseAction;
import lyh.po.school.School;
import lyh.po.student.Student;
import lyh.po.user.Member;
import lyh.services.school.SchoolServices;
import lyh.services.student.StudentServices;

public class SelfAction extends BaseAction{
	private String name;
	private String born;
	private String selfcode;
	private String school;
	private String collage;
	private String profession;
	private String schoolcode;
	private String address;
	private String email;
	private String phone;
	private File photo;
	private String bank;
	private String bankcode;
	private String photoContentType;
	private String photoFileName; 
	
	

	public String getPhotoContentType() {
		return photoContentType;
	}



	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}



	public String getPhotoFileName() {
		return photoFileName;
	}



	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBorn() {
		return born;
	}



	public void setBorn(String born) {
		this.born = born;
	}



	public String getSelfcode() {
		return selfcode;
	}



	public void setSelfcode(String selfcode) {
		this.selfcode = selfcode;
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



	public String getProfession() {
		return profession;
	}



	public void setProfession(String profession) {
		this.profession = profession;
	}



	public String getSchoolcode() {
		return schoolcode;
	}



	public void setSchoolcode(String schoolcode) {
		this.schoolcode = schoolcode;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public File getPhoto() {
		return photo;
	}



	public void setPhoto(File photo) {
		this.photo = photo;
	}



	public String getBank() {
		return bank;
	}



	public void setBank(String bank) {
		this.bank = bank;
	}



	public String getBankcode() {
		return bankcode;
	}



	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}



	@Override
	public String execute() throws Exception {
		Member member = (Member)super.session.get("member");
		String method = ServletActionContext.getRequest().getMethod();
		
		StudentServices services = new StudentServices();
		Student student = services.getByUid(member.getUid());
		
		if(student != null){
			super.request.put("student", student);
			return "sucess";
		}
		
		
		Map<String,Object> keys = new HashMap<String,Object>();
		if("POST".equals(method)){
			//保存上传文件
			String totype = this.photoFileName.substring(this.photoFileName.lastIndexOf("."));
			String tofile = member.getUsername()+System.currentTimeMillis()+totype;
			
			
			String photoString = services.savePhoto(photo, tofile);
			
			keys.put("member", member);
			keys.put("name",name.trim());
			keys.put("born", born.trim());
			keys.put("selfcode", selfcode.trim());
			keys.put("school", school.trim());
			keys.put("collage", collage.trim());
			keys.put("profession", profession.trim());
			keys.put("schoolcode", schoolcode.trim());
			keys.put("address", address.trim());
			keys.put("email", email.trim());
			keys.put("phone", phone.trim());
			keys.put("photo", photoString.trim());
			keys.put("bank", bank.trim());
			keys.put("bankcode", bankcode.trim());
			
			Student stu = services.saveStudent(keys);
			
			if(stu != null){
				super.request.put("student", stu);
				return "sucess";
			}
			
		}
		
		List<School> schools = SchoolServices.getAllSchools();
		
		super.request.put("schools", schools);
		return "In";
	}
	
	

}

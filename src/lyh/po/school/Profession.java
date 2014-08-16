package lyh.po.school;

import java.io.Serializable;

public class Profession implements Serializable{
	
	private int proid;
	private Collage collage;
	private School school;
	private String proname;
	private int year;
	private String procode;
	
	public Profession(){}
	
	public Profession(Collage collage,School school,String proname,int year,String procode){
		this.collage = collage;
		this.school = school;
		this.proname = proname;
		this.year = year;
		this.procode = procode;
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public Collage getCollage() {
		return collage;
	}
	public void setCollage(Collage collage) {
		this.collage = collage;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getProcode() {
		return procode;
	}
	public void setProcode(String procode) {
		this.procode = procode;
	}
	
	
}

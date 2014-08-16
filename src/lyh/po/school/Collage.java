package lyh.po.school;

import java.io.Serializable;
import java.util.Set;

public class Collage implements Serializable {
	
	private int coid;
	private School school;
	private String coname;
	private String cocode;
	private Set<Profession> professions;
	
	
	
	public Set<Profession> getProfessions() {
		return professions;
	}
	public void setProfessions(Set<Profession> professions) {
		this.professions = professions;
	}
	public String getCocode() {
		return cocode;
	}
	public void setCocode(String cocode) {
		this.cocode = cocode;
	}
	public int getCoid() {
		return coid;
	}
	public void setCoid(int coid) {
		this.coid = coid;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public String getConame() {
		return coname;
	}
	public void setConame(String coname) {
		this.coname = coname;
	}
	
	
	

}

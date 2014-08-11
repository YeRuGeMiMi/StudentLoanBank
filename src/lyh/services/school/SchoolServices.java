package lyh.services.school;

import java.util.List;
import java.util.Map;

import lyh.base.BaseServices;
import lyh.dao.school.SchoolDao;
import lyh.po.school.School;
import lyh.po.user.Member;

public class SchoolServices extends BaseServices{
	
	/**
	 * 保存一个school对象
	 * @param keys
	 * @return
	 */
	public static int saveOneSchool(Map<String,Object> keys){
		int i = 0;
		
		School school = new School();
		school.setAddress((String)keys.get("address"));
		school.setName((String)keys.get("name"));
		school.setScode((String)keys.get("scode"));
		school.setOfficetel((String)keys.get("officetel"));
		school.setEmail((String)keys.get("email"));
		school.setFax((String)keys.get("fax"));
		school.setMember((Member)keys.get("member"));
		
		SchoolDao dao = new SchoolDao();
		i = dao.saveSchool(school);
		
		return i;
	}
	
	/**
	 * 取得一个School
	 * @param uid
	 * @return
	 */
	public static School getOneByUid(int uid){
		School school = null;
		
		SchoolDao dao = new SchoolDao();
		school = dao.getByUid(uid);
		
		return school;
	}
	
	/**
	 * 取得所有的schools
	 * @return
	 */
	public static List<School> getAllSchools(){
		
		SchoolDao dao = new SchoolDao();
		List<School> schools = dao.getAllSchool();
		
		return schools;
	}
}

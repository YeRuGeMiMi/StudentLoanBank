package lyh.services.school;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lyh.base.BaseServices;
import lyh.dao.school.CollageDao;
import lyh.dao.school.ProfessionDao;
import lyh.dao.school.SchoolDao;
import lyh.po.school.Collage;
import lyh.po.school.Profession;
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
	
	/**
	 *增加学院 
	 * @param map
	 * @return
	 */
	public static int saveCollage(Map<String,String> map){
		Collage collage = new Collage();
		collage.setCocode(map.get("cocode"));
		collage.setConame(map.get("coname"));
		collage.setSchool(getOneByUid(Integer.parseInt(map.get("uid"))));
		
		CollageDao dao = new CollageDao();
		int i = dao.saveCollage(collage);
		
		return i;
	}
	
	/**
	 * 增加专业
	 * @param keys
	 * @return
	 */
	public static int saveProfession(Map<String,Object> keys){
		Profession pro = new Profession();
		pro.setProname((String)keys.get("proname"));
		pro.setProcode((String)keys.get("procode"));
		pro.setYear((Integer)keys.get("year"));
		
		CollageDao codao = new CollageDao();
		Collage collage = codao.getByCoid((Integer)keys.get("collage"));
		
		pro.setCollage(collage);
		pro.setSchool(collage.getSchool());
		
		ProfessionDao dao = new ProfessionDao();
		int i = dao.saveProfession(pro);
		
		return i;
		
	}
	
	/**
	 * 取得学院列表
	 * @param keys
	 * @return
	 */
	public static List<Collage> collageList(Map<String,Object> keys){
		int size=(Integer)keys.get("size");   //每页显示数
		int p=(Integer)keys.get("p");
		int start;
		if(p==1 || p==0){
			start = 0;
		}else{
			start = (p-1)*size;
		}
		
		
		CollageDao dao = new CollageDao();
		
		//取得总数
		int total = dao.countCollage((Integer)keys.get("scid"), (String)keys.get("textword"));
		
		List<Collage> collages = dao.getBySchool((Integer)keys.get("scid"),start,size,(String)keys.get("textword"));
		keys.put("total", total);
		
		
		return collages;
	}
	
	/**
	 * 根据学校ID取得学院ID和学院名的键值对
	 * @param scid
	 * @return
	 */
	public static Map<String,String> ajaxCollages(int scid){
		Map<String,String> map = new HashMap<String,String>();
		
		CollageDao dao = new CollageDao();
		List<Collage> list = dao.getQueueCollage(scid);
		
		for(Collage co : list){
			map.put(String.valueOf(co.getCoid()), co.getConame());
		}
		
		return map;
	}
	
	/**
	 * 根据学院ID取得专业ID和专业名的键值对
	 * @param coid
	 * @return
	 */
	public static Map<String,String> ajaxProfessions(int coid){
		Map<String,String> map = new HashMap<String,String>();
		
		ProfessionDao dao = new ProfessionDao();
		List<Profession> list = dao.getByCollage(coid);
		
		for(Profession pro : list){
			map.put(String.valueOf(pro.getProid()), pro.getProname());
		}
		
		return map;
	}
	
	/**
	 * 
	 * @param keys
	 * @return
	 */
	public static List<School> schoolList(Map<String,Object> keys){
		int size=(Integer)keys.get("size");   //每页显示数
		int p=(Integer)keys.get("p");
		int start;
		if(p==1 || p==0){
			start = 0;
		}else{
			start = (p-1)*size;
		}
		
		SchoolDao dao = new SchoolDao();
		
		//取得总数
		int total = dao.countSchool( (String)keys.get("textword"));
		
		List<School> schools = dao.getByFy(start,size,(String)keys.get("textword"));
		keys.put("total", total);
		
		return schools;
	}
}

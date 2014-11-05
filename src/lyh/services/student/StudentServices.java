package lyh.services.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import lyh.base.BaseServices;
import lyh.dao.school.CollageDao;
import lyh.dao.school.ProfessionDao;
import lyh.dao.school.SchoolDao;
import lyh.dao.student.StudentDao;
import lyh.po.school.Collage;
import lyh.po.school.Profession;
import lyh.po.school.School;
import lyh.po.student.Student;
import lyh.po.user.Member;

/**
 * 学生服务
 * @author Administrator
 *
 */
public class StudentServices extends BaseServices{
	
	/**
	 * 保存头像
	 * @param myfile
	 * @param tofileName
	 * @return
	 */
	public String savePhoto(File myfile,String tofileName){
		//设置目标文件
		String uploadpath = ServletActionContext.getServletContext().getRealPath("/upload");
		File tofile = new File(uploadpath,tofileName);
		
		//建立输入输出流
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(myfile);
			out = new FileOutputStream(tofile.getPath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//设置缓存
		byte[] buffer = new byte[1024];
		
		//读取文件
		int length = 0;
		try {
			while((length = in.read(buffer)) > 0 ){
				out.write(buffer,0,length);
			}
			
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tofile.getName();
	}
	
	/**
	 * 保存student信息
	 * @param keys
	 * @return
	 */
	public Student saveStudent(Map<String,Object> keys){
		//取得学校
		SchoolDao scdao = new SchoolDao();
		School school = scdao.getSchool(Integer.parseInt((String)keys.get("school")));
		
		//取得学院
		CollageDao codao = new CollageDao();
		Collage collage = codao.getByCoid(Integer.parseInt((String)keys.get("collage")));
		
		//取得专业
		ProfessionDao prodao = new ProfessionDao();
		Profession profession = prodao.getProfession(Integer.parseInt((String)keys.get("profession")));
		
		//格式化born成时间戳
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date d = null;
		String born = "";
		try {
			 d = sdf.parse((String)keys.get("born"));
			 Long l = d.getTime()/1000L;
			 born = String.valueOf(l);
			 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//生成一个studnet
		Student student = new Student();
		student.setMember((Member)keys.get("member"));
		student.setName((String)keys.get("name"));
		student.setBorn(born);
		student.setSelfcode((String)keys.get("selfcode"));
		student.setSchool(school);
		student.setCollage(collage);
		student.setProfession(profession);
		student.setSchoolcode((String)keys.get("schoolcode"));
		student.setAddress((String)keys.get("address"));
		student.setEmail((String)keys.get("email"));
		student.setPhone((String)keys.get("phone"));
		student.setPhoto((String)keys.get("photo"));
		student.setBank((String)keys.get("bank"));
		student.setBankcode((String)keys.get("bankcode"));
		
		//保存student
		StudentDao dao = new StudentDao();
		Student stu = dao.save(student);
		
		return stu;
	}
	
	/**
	 * 取得用户关联的studnet
	 * @param uid
	 * @return
	 */
	public Student getByUid(int uid){
		StudentDao dao = new StudentDao();
		Student student = dao.getByUid(uid);
		
		return student;
	}
	
	/**
	 * Id取得Student
	 * @param stid
	 * @return
	 */
	public Student getByStid(int stid){
		StudentDao dao = new StudentDao();
		Student student = dao.getByStid(stid);
		
		return student;
	}
	
	/**
	 * 取得一个学校的所有学生
	 * @param scid
	 * @return
	 */
	public List<Student> getStudentsBySchool(int scid){
		StudentDao dao = new StudentDao();
		List<Student> list = dao.getAllbySchool(scid);
		
		return list;
	}
	
	/**
	 * 分页查询学校的学生
	 * @param keys
	 * @return
	 */
	public List<Student> getSetudentsByFy(Map<String,Object> keys){
		int size=(Integer)keys.get("size");   //每页显示数
		int p=(Integer)keys.get("p");
		int start;
		if(p==1 || p==0){
			start = 0;
		}else{
			start = (p-1)*size;
		}
		
		StudentDao dao = new StudentDao();
		List<Student> students = null;
		if(keys.get("scid") != null){
			int totoal = dao.getCountSchool((Integer)keys.get("scid"), (String)keys.get("textword"));
			students = dao.getBySchool((Integer)keys.get("scid"),start,size,(String)keys.get("textword"));
			keys.put("total", totoal);
		}else{
			int totoal = dao.getCount((String)keys.get("textword"));
			students = dao.getAll(start,size,(String)keys.get("textword"));
			keys.put("total", totoal);
		}
		
		return students;
	}
}

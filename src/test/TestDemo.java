package test;

import lyh.dao.school.CollageDao;
import lyh.po.school.Collage;
import lyh.po.school.School;
import lyh.services.school.SchoolServices;


public class TestDemo {
	public static void main(String[] args) {
		Collage collage = new Collage();
		collage.setCocode("xxx343234");
		collage.setConame("软件学院");
		
		School school = SchoolServices.getOneByUid(17);
		collage.setSchool(school);
		
		CollageDao dao = new CollageDao();
		dao.saveCollage(collage);
		
	}
}

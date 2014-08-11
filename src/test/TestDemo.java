package test;

import lyh.dao.school.SchoolDao;
import lyh.dao.user.MemberDao;
import lyh.po.school.School;
import lyh.po.user.Member;
import lyh.services.school.SchoolServices;



public class TestDemo {
	public static void main(String[] args) {
		School school = SchoolServices.getOneByUid(22);
		System.out.println(school.getName());
	}
}

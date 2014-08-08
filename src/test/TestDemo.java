package test;

import java.util.List;

import lyh.dao.user.MemberInfoDao;
import lyh.po.user.MemberInfo;


public class TestDemo {
	public static void main(String[] args) {
		MemberInfoDao dao = new MemberInfoDao();
		List<MemberInfo> list= dao.getByType(1);
		System.out.println(list.get(0).getAddress());
	}
}

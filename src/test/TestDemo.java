package test;

import java.util.List;
import java.util.Map;

import lyh.dao.index.MenuDao;
import lyh.po.index.Menu;
import lyh.services.index.IndexServices;

public class TestDemo {
	public static void main(String[] args) {
		Map<String,List<Menu>> list = IndexServices.getMunes();
		
		System.out.println(list.get(0).get(1).getTitle());
	}
}

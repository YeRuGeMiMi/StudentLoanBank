package test;

import java.util.List;

import lyh.dao.index.MenuDao;
import lyh.po.index.Menu;

public class TestDemo {
	public static void main(String[] args) {
		MenuDao dao = new MenuDao();
	    List<Menu> list= dao.getMenus();
	    
	    System.out.println(list.get(1).getTitle());
	}
}

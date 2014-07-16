package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.io.File;

/**
 * 系统配置文件类
 * 使用properties作为配置文件（单例模式）
 * @author Administrator
 *
 */
public class Conf {
	private static  Conf instance = null;
	private static Properties prop = null;
	
	/**
	 * 私有化构造方法
	 */
	private Conf(){
		prop = new Properties();
		InputStream in = null;
		try {
			in = new FileInputStream(new File(this.getClass().getClassLoader().getResource("/").getPath()+File.separator+"conf.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			prop.load(in);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 返回单例对象
	 */
	public static Conf getInstance(){
		if(instance == null){
			instance = new Conf();
		}
		return instance;
	}
	
	/**
	 * 根据Key取得配置的配置值
	 */
	public String getValue(String key){
		return prop.getProperty(key);
	}
	
	
}


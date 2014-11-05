package util;

import java.util.ArrayList;
import java.util.List;

public class Common {
	
	/**
	 * 获取当前时间
	 */
	public static int getDate(){
		return (int)(System.currentTimeMillis()/1000);
	}
	
	/**
	 * 生成申请单编号
	 */
	public static int getApplySN(){
		return (int)((System.currentTimeMillis()+20)*1.1/1000);
	}
	
	/**
	 * 字符串数组转整形数组
	 */
	public static List<Integer> array2Int(String[] str){
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0 ; i<str.length; i++ ){
			numbers.add(Integer.parseInt(str[i]));
		}
		return numbers;
	}
}

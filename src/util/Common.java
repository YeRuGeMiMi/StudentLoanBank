package util;

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
}

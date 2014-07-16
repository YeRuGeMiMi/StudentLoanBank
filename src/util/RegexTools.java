package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTools {
	
	
	/**
	 * 验证用户名或密码
	 * 验证规则：英文与数字组成，且开头必须是英文字母
	 */
	public static boolean regUserName(String input){
		
		String reg = "^[a-zA-Z]{1,}\\w*$";
		Pattern pattern = Pattern.compile(reg);
		Matcher m = pattern.matcher(input);
		
		return m.matches();
	}
	
	/**
	 * 验证邮箱
	 * 验证规则：常用邮箱格式，如：ye124224@gmail.com
	 */
	public static boolean regEmail(String input){
		String reg = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern pattern = Pattern.compile(reg);
		Matcher m = pattern.matcher(input);
		
		return m.matches();
	}
	
	/**
	 * 验证身份证号
	 * 验证规则：中国大陆身份证号15位或者18位
	 */
	public static boolean regSelfCode(String input){
		String reg = "\\d{15}(\\d\\d[0-9xX])?";
		Pattern pattern = Pattern.compile(reg);
		Matcher m = pattern.matcher(input);
		
		return m.matches();
	}
	

}


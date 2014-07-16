package lyh.services.user;

import java.util.Map;

import util.Conf;
import util.DesUtils;

import lyh.base.BaseServices;
import lyh.dao.user.MemberDao;
import lyh.dao.user.MemberInfoDao;
import lyh.po.user.Member;
import lyh.po.user.MemberInfo;

public class UserServices  extends BaseServices{
	
	/**
	 * 用户注册
	 * @param Map<String,String>
	 * @return boolean
	 */
	public boolean regSave(Map<String,String> keys){
		Member member = new Member();
		member.setUsername(keys.get("username"));
		DesUtils des = null;
		try {
			des = new DesUtils(Conf.getInstance().getValue("DES_KEY"));
			//des = new DesUtils("@yfl@llb%");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			member.setPassword(des.encrypt(keys.get("password")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		member.setEmail(keys.get("email"));
		member.setType(Integer.parseInt(keys.get("type")));
		member.setCreated((int)(System.currentTimeMillis()/1000));
		
		MemberDao dao = new MemberDao();
		int i= dao.saveMember(member);
		if(i>0){
			MemberInfo info = new MemberInfo();
			info.setMember(member);
			info.setName(keys.get("name"));
			info.setSelfcode(keys.get("selfcode"));
			info.setAddress(keys.get("address"));
			info.setSchool(keys.get("school"));
			info.setCollage(keys.get("collage"));
			info.setYears(Integer.parseInt(keys.get("years")));
			
			MemberInfoDao infoDao = new MemberInfoDao();
			int s = infoDao.saveMemberInfo(info);
			if(s>0){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 用户登录
	 * @param String,String (用户名，密码)
	 * @return int (状态,0 用户不存在，-1用户名或密码错误，大于0的用户ID登录成功)
	 */
	public int  userLogin(String username,String password){
		MemberDao dao = new MemberDao();
		Member member = dao.getPasswordByUsername(username);
		
		DesUtils des = null;
		try {
			
			des = new DesUtils(Conf.getInstance().getValue("DES_KEY"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(member != null){
			try {
				if(des.decrypt(member.getPassword()).equals(password)){
					return member.getUid();
				}else{
					return -1;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
	/**
	 * 根据用户信息取得用户
	 * @param int 
	 * @return Member
	 */
	public Member getById(int uid){
		MemberDao dao = new MemberDao();
		Member member = dao.getById(uid);
		if( member != null){
			return member;
		}
		return member;
		}
}


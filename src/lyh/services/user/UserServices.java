package lyh.services.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Common;
import util.Conf;
import util.DesUtils;

import lyh.base.BaseServices;
import lyh.dao.index.MenuDao;
import lyh.dao.user.MemberDao;
import lyh.dao.user.MemberInfoDao;
import lyh.dao.user.RolesDao;
import lyh.po.index.Menu;
import lyh.po.user.Member;
import lyh.po.user.MemberInfo;
import lyh.po.user.Roles;

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
		member.setRoles(this.getRolesById(Integer.parseInt(keys.get("type"))));
		
		MemberDao dao = new MemberDao();
		int i= dao.saveMember(member);
		if(i>0){
			return true;
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
	
	/**
	 * 获取所有的用户角色
	 * @return
	 */
	public List<Roles> getAllRoles(){
		RolesDao dao = new RolesDao();
		List<Roles> roles = dao.getAll();
		return roles;
	}
	
	/**
	 * 获取用户组的权限
	 */
	public Map<String,List<Menu>> getPowerByRole(int roid){
		Map<String,List<Menu>> result = new HashMap<String, List<Menu>>();
		RolesDao rodao = new RolesDao();
		Roles role = rodao.get(roid);
		List<Integer> powers = Common.array2Int(role.getRopower().split(","));
		
		MenuDao dao = new MenuDao();
		List<Menu> roots = dao.getMenus(0);
		for(Menu m:roots){
			if(m.getHas_submenu() == 0){
				continue;
			}
			int flag = powers.indexOf(m.getMlid());
			if(flag != -1){
				m.setIsCheck(1);
			}else{
				m.setIsCheck(0);
			}
			List<Menu> list = dao.getMenus(m.getMlid());
			for(Menu c:list){
				int cflag = powers.indexOf(c.getMlid());
				if(cflag != -1){
					c.setIsCheck(1);
				}else{
					c.setIsCheck(0);
				}
			}
			result.put(m.getTitle(), list);
		}
		result.put("0", roots);
		
		return result;
	}
	
	/**
	 * 保存一个角色的权限
	 * @param roid
	 * @param powers
	 */
	public void save(int roid,String powers){
		RolesDao dao = new RolesDao();
		Roles roles = dao.get(roid);
		roles.setRopower(powers);
		
		boolean bool = dao.save(roles);
	}
	
	/**
	 * 修改账户密码
	 * @param uid
	 * @param newpasswd
	 * @return
	 */
	public boolean updatePassword(int uid,String newpasswd){
		DesUtils des = null;
		try {
			des = new DesUtils(Conf.getInstance().getValue("DES_KEY"));
			//des = new DesUtils("@yfl@llb%");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Member member = this.getById(uid);
		try {
			member.setPassword(des.encrypt(newpasswd));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemberDao dao = new MemberDao();
		boolean bool = dao.update(member);
		return bool;
	}
	
	/**
	 * 获取一个角色
	 * @param roid
	 * @return
	 */
	public Roles getRolesById(int roid){
		RolesDao dao = new RolesDao();
		Roles roles = dao.get(roid);
		return roles;
	}
}


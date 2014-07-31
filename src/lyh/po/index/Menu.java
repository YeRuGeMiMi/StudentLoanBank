package lyh.po.index;

import java.io.Serializable;

/**
 * 菜单
 * @author lyh
 *
 */
public class Menu implements Serializable{
	
	//属性
	private int mlid;
	private int plid;
	private String title;
	private String path;
	private int has_submenu;
	private int depth;
	private int weight;
	private int status;
	
	/**
	 * 空构造
	 * @return
	 */
	public Menu(){
		
	}
	
	//geter&&seter
	public int getMlid() {
		return mlid;
	}
	public void setMlid(int mlid) {
		this.mlid = mlid;
	}
	public int getPlid() {
		return plid;
	}
	public void setPlid(int plid) {
		this.plid = plid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getHas_submenu() {
		return has_submenu;
	}
	public void setHas_submenu(int hasSubmenu) {
		has_submenu = hasSubmenu;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}

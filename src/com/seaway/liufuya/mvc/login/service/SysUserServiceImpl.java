package com.seaway.liufuya.mvc.login.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.mvc.login.dao.MenusDaoImpl;
import com.seaway.liufuya.mvc.login.dao.SysUserDaoImpl;
import com.seaway.liufuya.mvc.login.model.Menus;
import com.seaway.liufuya.mvc.login.model.SysUser;

/**
 * SysUser业务类
 * @author CarryCheng
 */
@IocBean
public class SysUserServiceImpl{
	

	private static final Log log = Logs.get();
	
	//ioc 注入
	//系统用户数据库操作类
	@Inject("refer:sysUserDaoImpl")
	private SysUserDaoImpl sysUserDao;
	
	@Inject("refer:menusDaoImpl")
	private  MenusDaoImpl menusDao;
	
//	@Inject
//	private SysUserDaoImpl userRoleDao;

	/**
	 * 根据id删除用户
	 * @param sysUser
	 * @return
	 */
//	public void deleteSysUserById(String sysUserId ) throws Exception{
//		String[] delUserId = sysUserId.split(",");
//		for(String userId:delUserId){//删除系统用户表,用户角色中间关系表数据
//			sysUserDao.deleteSysUserById(userId);
//			userRoleDao.deleteUserRoleByUserCode(userId);
//		}
//	}

	/**
	 * 根据登陆名和密码查当前用户
	 * @param map
	 * @return
	 */
	public SysUser findSysUser(Map<String, Object> map) {
		return sysUserDao.findSysUser(map);
	}
	
	/**
	 * 添加登陆日记 ，目前没有这个表
	 * @param map
	 * @return
	 */
//	public int insertLoginLog(SysUser sysUser,String ip,String type) throws Exception{
//		Map<String,Object> map = new HashMap<String,Object>();
//		String uuid = new RandomGUID().valueAfterMD5;
//		map.put("id", uuid);
//		map.put("userCode", sysUser.getUserCode());
//		map.put("loginIp", ip);
//		map.put("loginTime", "");
//		map.put("userPhone", sysUser.getUserPhone()==null?"":sysUser.getUserPhone());
//		map.put("userEmail", sysUser.getEmail()==null?"":sysUser.getEmail());
//		map.put("loginType", type);
//		map.put("createOpid", "");
//		map.put("createDate", "");
//		map.put("status", "1");
//		return sysUserDao.insertLoginLog(map);
//	}
	
	/**
	 * 根据usercode修改用户登陆密码
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public boolean updateLoginPwd(SysUser sysUser) throws Exception{
		return sysUserDao.updateLoginPwd(sysUser);
	}

	/**
	 * 查询所有系统用户
	 * @return
	 */
	public List<SysUser> getAllSysUserList(int startNum, int rows){
		return sysUserDao.getAllSysUserList(startNum,rows);
	}

	
	/**
	 *新增系统用户
	 * @param sysUser
	 */
//	public void saveSysUser(SysUser sysUser,String relativedRoles) throws Exception{
//		String[] relativedRolesCodesArray = relativedRoles.split(",");
//		sysUser.setLogPwd(new MD5().getMD5ofStr(sysUser.getLogPwd()));//利用MD5给登陆密码加密
//		sysUserDao.saveSysUser(sysUser);
//		for(String code:relativedRolesCodesArray){
//			UserRole userRole = new UserRole();
//			userRole.setUserCode(sysUser.getUserCode());
//			userRole.setRoleCode(code);
//			userRole.setStatus("1");
//			this.saveUserRole(userRole);//插入用户角色关系表
//		}
//		return ;
//	}
	
	/**
	 * 新增用户角色关系
	 * @param userRole
	 */
//	public void saveUserRole(UserRole userRole) throws Exception{
//		userRoleDao.saveUserRole(userRole);
//	}

	/**
	 * 根据id修改用户
	 * @param sysUser
	 * @return
	 */
//	public void updateSysUserById(SysUser sysUser,String relativedRoles) throws Exception{
//		String[] relativedRolesCodesArray = relativedRoles.split(",");
//		List<SysUser> userList = this.getSysUserById(sysUser.getUserCode());
//		SysUser userOriginal = userList.get(0);
//		if(userOriginal.getLogPwd().equals(sysUser.getLogPwd())){//未修改登陆密码
//			sysUser.setLogPwd(userOriginal.getLogPwd());
//		}else{//修改登录密码，重新设置密码，并加密保存
//			sysUser.setLogPwd(new MD5().getMD5ofStr(sysUser.getLogPwd()));
//		}
//		sysUserDao.updateSysUserById(sysUser);//更改系统用户表
//		userRoleDao.deleteUserRoleByUserCode(userOriginal.getUserCode());//删除用户角色中间表关系
//		for(String code:relativedRolesCodesArray){//插入用户角色关系表
//			UserRole userRole = new UserRole();
//			userRole.setUserCode(userOriginal.getUserCode());
//			userRole.setRoleCode(code);
//			userRole.setStatus("1");
//			this.saveUserRole(userRole);
//		}
//	}
	
	
	/**
	 * 根据id查询用户
	 * @param sysUserId
	 * @return
	 */
	public List<SysUser> getSysUserById(String userCode){
		return sysUserDao.getSysUserById(userCode);
	}

	/**
	 * 获取系统用户总记录数
	 * @return
	 */
	public int getTotalCount(){
		return sysUserDao.getTotalCount();
	}
	
	/**
	 * 加载当前用户的菜单
	 */
	public String loadMenus(SysUser sysUser) {
		//获取当前用户的菜单
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("userCode", sysUser.getUserCode());
		List<Menus> menusList = menusDao.findUserMenus(userMap);
		StringBuffer menuSBuffer=new StringBuffer();
		menuSBuffer.append("{");
		//处理json格式的menu数据
		//processMenus(menusList,Constants.FIRST_MENU_FLAG,menuSBuffer);
		menuSBuffer.append("}");
		
		return menuSBuffer.toString();
	}
	
	/**
	 * 处理当前用户 获取的菜单 数据。
	 * @param allMenusList
	 * @param fMenuCode
	 * @param menuSBuffer
	 * @return
	 */
	private StringBuffer processMenus(List<Menus> allMenusList,String fMenuCode,StringBuffer menuSBuffer){
		if(null!=allMenusList&&allMenusList.size()>0&&!allMenusList.isEmpty()){
			List<Menus> fMenuCodemenuList=new ArrayList<Menus>();//当前节点的子节点 
			List<Menus> otherMenuList=new ArrayList<Menus>(); //非当前节点的子节点 
			for(Menus menu:allMenusList){
				if(StringUtils.equals(fMenuCode, menu.getFmenuCode())){
					fMenuCodemenuList.add(menu);
				}else{
					otherMenuList.add(menu);
				}
			}
			if(null!=fMenuCodemenuList&&fMenuCodemenuList.size()>0&&!fMenuCodemenuList.isEmpty()){
				boolean isLeaf=false;
				boolean levelGTtwo=false;
				for(int i=0;i<fMenuCodemenuList.size();i++){
					Menus menu= fMenuCodemenuList.get(i);
					if(StringUtils.isNotBlank(menu.getMenuUrl())){
						isLeaf=true;
					}
					if(StringUtils.length(menu.getLevelId())>2){
						levelGTtwo=true;
					}
				}
				if(isLeaf&&levelGTtwo)
					menuSBuffer.append("\"child\":["); 
				else
					menuSBuffer.append("\"menus\":[");
				for(int i=0;i<fMenuCodemenuList.size();i++){
					menuSBuffer.append("{");
					Menus menu= fMenuCodemenuList.get(i);
					menuSBuffer.append("\"menuid\": \""+menu.getEngName()+"\",");
					if(!isLeaf)
						menuSBuffer.append("\"icon\": \"icon-sys\",");
					menuSBuffer.append("\"menuname\": \""+menu.getMenuName()+"\",");
					if(StringUtils.isNotBlank(menu.getMenuUrl())){
						menuSBuffer.append("\"url\": \""+menu.getMenuUrl()+"\"");
					}else{
						processMenus(otherMenuList,menu.getMenuCode(),menuSBuffer);
					}
					menuSBuffer.append("}");
					if(i<fMenuCodemenuList.size()-1){
						menuSBuffer.append(",");
					}
				}
				menuSBuffer.append("]");
			}else{
				menuSBuffer.append("\"menus\":[]");
			}
		}
		return menuSBuffer;
	}
	
	/**
	 *根据loginName查询系统用户 
	 */
	public List<SysUser> findSysUserByLoginName(Map<String, Object> map) {
		//String a = (String) map.get("loginName");
		return sysUserDao.findSysUserByLoginName(map);
	}

	/**
	 *根据loginName查询系统用户的总数量 
	 */
	public int findSysUserByLoginNameCount(Map<String, Object> map) {
		return sysUserDao.findSysUserByLoginNameCount(map);
	}

	/**
	 * 根据loginName验证登录名是否唯一
	 */
	public List<SysUser> checkLoginName(Map<String, Object> map) {
		return sysUserDao.checkLoginName(map);
	}
	
	
	
	
	
	
	

}

package com.seaway.liufuya.mvc.login.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.login.dao.MenusDaoImpl;
import com.seaway.liufuya.mvc.login.dao.RoleDaoImpl;
import com.seaway.liufuya.mvc.login.model.Role;
import com.seaway.liufuya.mvc.login.model.SysUser;



/**
 * 角色模块service实现层
 * 
 * @author 刘立立
 * 
 */
@IocBean
public class RoleServiceImpl {
	private static final Log log = Logs.get();

	@Inject("refer:roleDaoImpl")
	private RoleDaoImpl roleDao;
	
	@Inject("refer:menusDaoImpl")
	private MenusDaoImpl menusDao;
	
	
	/**
	 * 查询角色列表(分页查询)
	 * 
	 * @return
	 */
	public List<Role> quryAllRoleList(int startNum, int rp) {
		return roleDao.queryAllRoleList(startNum, rp);
	}

	/**
	 * 统计所有角色数量
	 * @return
	 */
	public int queryRoleTotalCount() {
		return roleDao.getRoleTotalCount();
	}
	/**
	 * 通过角色名称获取角色
	 */
	public List<Role> getRoleByRoleName(String roleName,int startNum, int rp){			
			Map<String,Object> roleNameMap = new HashMap<String, Object>();
			roleNameMap.put("roleName", roleName);
			return roleDao.getRoleByRoleName(roleNameMap,startNum,rp);			
	}
	/**
	 * 根据角色名称统计角色数量
	 */
	public int getRolesTotalCountByRoleName(String roleName){
		Map<String,Object> roleNameMap = new HashMap<String, Object>();
		roleNameMap.put("roleName", roleName);
		return roleDao.getRolesTotalCountByRoleName(roleNameMap);
	}
	/**
	 * 新增角色
	 * @param map
	 * @return
	 */
	public void saveRole(HttpServletRequest request,Role role,String selectAuthIds){
		String[] checkedAuthIds = selectAuthIds.split(",");
		HttpSession session = request.getSession();
        SysUser user =(SysUser)session.getAttribute(Constants.CURRENT_LOGIN_USER); // 获取当前登陆的系统用户对象	
        if(!role.getRoleCode().equals(Constants.ADMIN_ROLE_CODE)){ // 系统管理员角色不能修改
		if (StringUtils.isEmpty(role.getRoleCode())) {
			role.setIsSystem("0");
			String id = UUID.randomUUID().toString();
			role.setRoleCode(id);
			roleDao.insertRole(role); // 插入角色
		} else {			
				Map<String,Object> roleCodeMap = new HashMap<String, Object>();
				roleCodeMap.put("roleCode", role.getRoleCode());
				roleDao.deleteRoleAuthByRoleCode(roleCodeMap);// 根据角色编码 roleCode 删除角色权限		
				roleDao.updateRole(role); // 更新角色
			}
					
		if (checkedAuthIds != null  && checkedAuthIds[0]!="") {
			for (String authId : checkedAuthIds) {
				Map<String,Object> roleAuthMap = new HashMap<String, Object>();// 存放角色权限属性的map 	
				roleAuthMap.put("roleCode", role.getRoleCode());
				roleAuthMap.put("createOpid",user.getId());
				roleAuthMap.put("authCode", authId);
				menusDao.insertRoleAuth(roleAuthMap);	// 插入角色权限			
			}
		}
      }
	}

	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}
	

	/**
	 * 根据用户id查询用户关联的角色名称信息
	 */
	public String getRoleNamesByUserId(String sysUserId) {
		List<Role> roles = roleDao.getRolesByUserId(sysUserId);
		String userRoles ="";
		for(Role role:roles){
			userRoles+=role.getRoleName()+",";
		}
		return userRoles;
	}
	
	/**
	 * 根据用户id查询用户关联的角色id信息
	 */
	public String getRoleIdByUserId(String sysUserId) {
		List<Role> roles = roleDao.getRolesByUserId(sysUserId);
		String userRoles ="";
		for(Role role:roles){
			userRoles+=role.getRoleCode()+",";
		}
		return userRoles;
	}

	/**
	 * 根据用户id查询用户关联的角色id信息
	 */
	public List<Role> getRoleByUserId(String userId) {
		return roleDao.getRolesByUserId(userId);
	}
    /**
     * 根据id获取角色对象
     */
	public Role getRoleById(String id) {		
		return roleDao.getRoleById(id);
	}
    /**
     * 删除角色
     */
	public void deleteRoles(String ids) throws Exception {
	  String [] idArr = ids.split(",");
	  for(String id : idArr){
		  Map<String,Object> roleCodeMap = new HashMap<String, Object>();
		  if(!id.equals(Constants.ADMIN_ROLE_CODE)){ // 系统管理员角色不能删除
			  roleCodeMap.put("roleCode", id);
			  roleDao.deleteRole(id); // 删除角色
			  roleDao.deleteRoleAuthByRoleCode(roleCodeMap); // 删除角色权限	 
		  }
			  
	  }
		
	}
   

	public int valiedateRoleName(String roleName) {
		if(roleName!="" && roleName!=null){	
			Map<String,Object> roleNameMap = new HashMap<String, Object>();
			roleNameMap.put("roleName", roleName);
			return roleDao.validateRoleName(roleNameMap);
		}
		return 0;
	}
	
	public List<Role> getRoleByRoleIds(String roleIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(roleIds)){
			String roleIdArray []=StringUtils.split(roleIds, ",");
			List<String> codes=new ArrayList<String>();
			if(roleIdArray.length>0){
				for(int i=0;i<roleIdArray.length;i++) {
					codes.add(roleIdArray[i]);
				}
			}
			map.put("list", codes);
		}
		return roleDao.getRoleByRoleIds(map);
	}

}

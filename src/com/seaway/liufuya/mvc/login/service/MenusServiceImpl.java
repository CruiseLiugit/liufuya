package com.seaway.liufuya.mvc.login.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.mvc.login.dao.MenusDaoImpl;
import com.seaway.liufuya.mvc.login.model.Authority;
import com.seaway.liufuya.mvc.login.model.Button;
import com.seaway.liufuya.mvc.login.model.Menus;
import com.seaway.liufuya.mvc.login.model.SysUser;


/**
 * 菜单service实现层
 * 
 * @author 刘立立
 * 
 */
@IocBean
public class MenusServiceImpl {
	private static final Log log = Logs.get();

	@Inject("refer:menusDaoImpl")
	private MenusDaoImpl menusDao;

	/**
	 * 插入菜单
	 */
	public void insertMenus(Menus menus) throws Exception {
		menusDao.insertMenus(menus);
	}

	/**
	 * 更新菜单
	 */
	public boolean updateMenus(Menus menus) throws Exception {
		return menusDao.updateMenus(menus);
	}

	/**
	 * 删除菜单
	 */
	public boolean deleteMenusById(String id) throws Exception {
		return menusDao.deleteMenusById(id);
	}

	/**
	 * 通过菜单Code获取菜单
	 */
	public Menus getMenusByCode(String menusCode) {
		return menusDao.getMenusByCode(menusCode);
	}
	
	/**
	 * 通过菜单 id 获取菜单
	 */
	public Menus getMenusById(String menusId) {
		return menusDao.getMenusById(menusId);
	}

	/**
	 * 查询所有菜单列表
	 */
	public List<Menus> getMenusList(int startNum, int rp) {
		return menusDao.getMenusList(startNum, rp);
	}

	/**
	 * 统计所有菜单数量
	 */
	public int getMenusCount() {
		return menusDao.getMenusCount();
	}

	/**
	 * 通过菜单levelId获取菜单
	 */
	public Menus getMenusByLevelId(String levelId) {
		return menusDao.getMenusByLevelId(levelId);
	}

	/**
	 * 获取所有的按钮
	 */
	public List<Button> getAllButtons() {
		return menusDao.getAllButtons();
	}
	
	

	/**
	 * 保存菜单
	 */
	public void saveMenus(HttpServletRequest request, Menus menus,
			String selectButtonIds) throws Exception {
		String[] checkedButtonIds = selectButtonIds.split(","); // 将获取选中的按钮id放入
		HttpSession session = request.getSession();
		SysUser user = (SysUser) session
				.getAttribute(Constants.CURRENT_LOGIN_USER); // 获取当前登陆的系统用户对象
		if (StringUtils.isEmpty(menus.getMenuCode())) {
			log.info("-------增加菜单--------");
			String uuid = UUID.randomUUID().toString();
			menus.setMenuCode(uuid);
			menus.setCreateDate(new Date());
			menus.setStatus("1");
			menus.setSortValue(1);   //排序字段
			menusDao.insertMenus(menus);
		} else {
			log.info("-------修改菜单--------");
			menusDao.updateMenus(menus);
			
			///////2014-04-22 这里有问题///
			List<Authority> authoritys = menusDao
					.getAuthorityCodeByMenuCode(menus.getMenuCode()); // 获取权限编码
			log.info("根据菜单 code 查询 AuthorityCode list ="+authoritys.size());
			if (authoritys != null) {
				for (Authority authority : authoritys) {
					menusDao.deleteRoleAuthByauthCode(authority.getAuthCode().toString());// 删除角色权限
				}
			}
			
			menusDao.deleteAuthByMenuCode(menus.getMenuCode());// 删除权限表
		}

		if (checkedButtonIds != null) {

			for (String buttonId : checkedButtonIds) {
				// -----插入权限开始----
				Map<String, Object> inAuthMap = new HashMap<String, Object>();
				String authorityId = UUID.randomUUID().toString();
				inAuthMap.put("authCode", authorityId);
				inAuthMap.put("menuCode", menus.getMenuCode());
				inAuthMap.put("modelCode", buttonId);
				if (buttonId.equals(Constants.RUN_BUTTON_CODE)) { // 运行按钮code
					inAuthMap.put("isMenu", "1");
				} else {
					inAuthMap.put("isMenu", "0");
				}
				menusDao.insertAuthority(inAuthMap); // 插入权限表

				// 插入权限结束
				// 插入角色权限开始
				Map<String, Object> roleAuthMap = new HashMap<String, Object>();// 存放角色权限属性的map
				
				String roleCode = menusDao.getRoleCodeByUserCode(user.getUserCode());// 查询角色code
				roleAuthMap.put("roleCode", roleCode);
				roleAuthMap.put("authCode", authorityId);
				menusDao.insertRoleAuth(roleAuthMap);
				// 插入角色权限结束
			}
		}

	}

	/**
	 * 获取菜单已经拥有的按钮
	 * 
	 * @param menuCode
	 * @return
	 */
	public List<Button> getCheckedButtonByMenuCode(String menucode) {
		if (menucode != null && menucode != "") {
			return menusDao.getCheckedButtonMenuId(menucode);
		}
		return null;
	}

	
	/**
	 * 获取菜单已经拥有的按钮
	 * 
	 * @param menuId
	 * @return
	 */
	public List<Button> getCheckedButtonByMenuId(String menuId) {
		if (menuId != null && menuId != "") {
			return menusDao.getCheckedButtonMenuId(menuId);
		}
		return null;
	}
	
	/**
	 * 删除菜单
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void deleteMenus(String ids) throws Exception {
		//log.info("deleteMenus(String ids)  ids ="+ids);
		String[] idArr = ids.split(",");
		//log.info("ids.split(\",\")  idarr ="+idArr);
		for (String id : idArr) {
			//log.info("删除菜单时的单个 id ="+id);
			String menuCode = menusDao.getMenusById(id).getMenuCode(); //根据菜单 主键 id 查询 menuCode
			menusDao.deleteMenusById(id); // 删除菜单
			List<Authority> authoritys = menusDao
					.getAuthorityCodeByMenuCode(menuCode); // 获取权限编码
			if (authoritys != null && !authoritys.isEmpty()) {
				for (Authority authMap : authoritys) {
					String authCode = authMap.getAuthCode() == null ? ""
							: authMap.getAuthCode().toString();
					menusDao.deleteRoleAuthByauthCode(authCode);// 删除角色权限
				}
			}
			menusDao.deleteAuthByMenuCode(menuCode);// 删除权限表
			//log.info("删除菜单成功.....................");
		}

	}

	/**
	 * 同过菜单名称获取菜单
	 */
	public List<Menus> getMenusByMenusName(String menuName, int startNum, int rp) {
		Map<String, Object> menuNameMap = new HashMap<String, Object>();
		menuNameMap.put("menuName", menuName);
		return menusDao.getMenusByMenusName(menuNameMap, startNum, rp);
	}

	/**
	 * 通过菜单名称统计菜单数量
	 */
	public int getMenusCountByMenusName(String menuName) {
		Map<String, Object> menuNameMap = new HashMap<String, Object>();
		menuNameMap.put("menuName", menuName);
		return menusDao.getMenusCountByMenusName(menuNameMap);
	}

	

	/**
	 * 获取用户拥有的菜单
	 */
	public String getUserToolbar(HttpServletRequest request,
			HttpServletResponse response, String menusCode) {
		HttpSession session = request.getSession();
		SysUser user = (SysUser) session
				.getAttribute(Constants.CURRENT_LOGIN_USER); // 获取当前登陆的系统用户对象

		StringBuffer toolbarSBuffer = new StringBuffer();
		toolbarSBuffer.append("[");

		if (user != null && menusCode != "") {
			String userCode = user.getUserCode();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userCode", userCode);
			map.put("menuCode", menusCode);
			List<Map<String, Object>> butonList = menusDao.getUserButtons(map); // 获取当前用户和菜单拥有的按钮
			for (int i = 0; i < butonList.size(); i++) {
				Map<String, Object> buttonMap = butonList.get(i);
				String text = (String) buttonMap.get("MODEL_NAME");
				String iconCls = (String) buttonMap.get("IMGNAME");
				String handler = (String) buttonMap.get("MODEL_TITLE");
				if (i < butonList.size() - 1) {
					toolbarSBuffer.append("{");
					toolbarSBuffer.append("text: '" + text + "',");
					toolbarSBuffer.append("iconCls: '" + iconCls + "',");
					toolbarSBuffer.append("handler: " + handler);
					toolbarSBuffer.append("},'-',");
				} else {
					toolbarSBuffer.append("{");
					toolbarSBuffer.append("text: '" + text + "',");
					toolbarSBuffer.append("iconCls: '" + iconCls + "',");
					toolbarSBuffer.append("handler: " + handler);
					toolbarSBuffer.append("}");
					toolbarSBuffer.append("]");
				}
			}

			try {
				PrintWriter out = response.getWriter();
				out.print(toolbarSBuffer.toString());
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return toolbarSBuffer.toString();

		}
		return null;
	}

	

}

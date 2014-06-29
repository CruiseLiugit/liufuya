package com.seaway.liufuya.mvc.login.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.mvc.login.model.Authority;
import com.seaway.liufuya.mvc.login.model.Button;
import com.seaway.liufuya.mvc.login.model.Menus;
import com.seaway.liufuya.mvc.login.model.UserRole;

/**
 * 菜单dao类
 * 
 * @author caryCheng
 * 
 */
@IocBean
public class MenusDaoImpl extends BasicDao {
	private static final Log log = Logs.get();
	
	/**
	 * 获取当前用户拥有的菜单
	 */
	public List<Menus> findUserMenus(Map<String, Object> map) {
		Sql sql = Sqls
				.create("select b.* from "
						+ "(select distinct a.Id,m.MENU_CODE,m.ENGNAME,m.MENU_NAME,m.FMENU_CODE,m.MENU_URL,m.LEVELID,m.SORTVALUE "
						+ "from sys_user_role ur,sys_roles_authorities ra,sys_authorities a,sys_menus m "
						+ "WHERE ur.USER_CODE = @userName "
						+ "AND ur.ROLE_CODE = ra.ROLE_CODE  "
						+ "AND ra.AUTH_CODE = a.AUTH_CODE "
						+ "AND a.IS_MENU = '1' "
						+ "AND a.MENU_CODE = m.MENU_CODE) b ORDER  BY b.SORTVALUE ");
		sql.params().set("userName", (String)map.get("userCode"));

		// dao.execute(sql) 执行前，编写回调函数，解析 查询结果
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<Menus> list = new LinkedList<Menus>();
				while (rs.next()) {
					// m.FMENU_CODE,m.MENU_URL,m.LEVELID,m.SORTVALUE
					Menus menu = new Menus();
					menu.setId(rs.getInt("Id"));
					menu.setMenuCode(rs.getString("MENU_CODE"));
					menu.setEngName(rs.getString("ENGNAME"));
					menu.setMenuName(rs.getString("MENU_NAME"));
					menu.setFmenuCode(rs.getString("FMENU_CODE"));
					menu.setMenuUrl(rs.getString("MENU_URL"));
					menu.setLevelId(rs.getString("LEVELID"));
					menu.setSortValue(rs.getInt("SORTVALUE"));
					
					log.info("---->menuName = "+menu.getMenuName());
					
					list.add(menu);
				}

				return list;
			}
		});

		dao.execute(sql);
		return sql.getList(Menus.class);
		// Nutz内置了大量回调, 请查看Sqls.callback的属性
	}

	/**
	 * 插入菜单
	 */
	public void insertMenus(Menus menus) {
		this.save(menus);
	}

	/**
	 * 更新菜单
	 */
	public boolean updateMenus(Menus menus) {
		return this.update(menus);

	}

	/**
	 * 删除菜单
	 */
	public boolean deleteMenusById(String id) {
		return super.delById(new Integer(id.trim()).intValue(),Menus.class);
	}

	/**
	 * 通过菜单Code 获取菜单
	 */
	public Menus getMenusByCode(String menusCode) {
		//select * from SYS_MENUS where id = #{id} and status='1'
		Cnd condition = Cnd.where("menuCode", "=", menusCode)
				.and("status", "=", "1");
		return findByCondition(Menus.class, condition);
	}
	
	/**
	 * 查询所有菜单列表 -实现分页
	 */
	public List<Menus> getMenusList(int startNum, int rp) {
		Pager pager = dao.createPager(startNum, rp);
		// 设置一共可以查询的条数
		pager.setRecordCount(dao.count(Menus.class,Cnd.where("status", "=", 1)));
		List<Menus> meuns = dao.query(Menus.class,Cnd.where("status", "=", 1), pager);

		return meuns;
	}

	/**
	 * 统计菜单数量
	 */
	public int getMenusCount() {
		//select count(1) from SYS_MENUS where status='1'	
		Cnd condition = Cnd.where("status", "=", 1);
		return this.searchCount(Menus.class, condition);
	}

	/**
	 * 通过菜单levelId获取菜单
	 */
	public Menus getMenusByLevelId(String levelId) {
		//select * from SYS_MENUS where levelid = #{levelId} and status='1'
		Cnd condition = Cnd.where("levelId", "=", levelId).and("status", "=", "1");
		return findByCondition(Menus.class, condition);
	}

	/**
	 * 通过菜单 Id获取菜单
	 */
	public Menus getMenusById(String id) {
		Cnd condition = Cnd.where("id", "=", id).and("status", "=", "1");
		return findByCondition(Menus.class, condition);
	}

	
	/**
	 * 获取所有的按钮
	 */
	public List<Button> getAllButtons() {
		//select * from SYS_MODEL where status ='1'
		Cnd condition = Cnd.where("status", "=", "1");
		return search(Button.class, condition);
	}

	/**
	 * 获取权限编码
	 */
	public List<Authority> getAuthorityCodeByMenuCode(String menuCode) {
		//select auth_code from SYS_AUTHORITIES where menu_code=#{menuCode}
		Cnd condition = Cnd.where("menuCode", "=", menuCode);
		return search(Authority.class, condition);
	}

	/**
	 * 删除角色权限表
	 */
	public void deleteRoleAuthByauthCode(String authCode) {
		//delete from SYS_ROLES_AUTHORITIES where auth_code = #{authCode} 
		
		Sql sql = Sqls.create("delete from SYS_ROLES_AUTHORITIES where auth_code = @authCode ");
		sql.params().set("authCode", authCode);
		dao.execute(sql);
	}

	/**
	 * 删除权限表
	 */
	public void deleteAuthByMenuCode(String menuCode) {
		//delete from sys_authorities  where menu_code = #{menuCode} 
		
		Sql sql = Sqls.create("delete from sys_authorities  where menu_code = @menuCode");
		sql.params().set("menuCode", menuCode);
		log.info("删除权限表 ="+sql.toString());
		
		dao.execute(sql);
	}

	/**
	 * 插入权限表
	 */
	public void insertAuthority(Map<String, Object> map) {
		/*
		 insert into sys_authorities (AUTH_CODE,IS_MENU,MENU_CODE,MODEL_CODE,CREATE_DATE,STATUS)  
			values(#{authCode,jdbcType=VARCHAR},#{isMenu,jdbcType=VARCHAR},
			#{menuCode,jdbcType=VARCHAR},#{modelCode,jdbcType=VARCHAR},sysdate(),'1'
			)
		 * */
		Sql sql = Sqls
				.create("insert into sys_authorities (AUTH_CODE,IS_MENU,MENU_CODE,MODEL_CODE,CREATE_DATE,STATUS)  " +
						"values(@authCode,@isMenu,@menuCode,@modelCode,@createDate,'1')");
		sql.params().set("authCode", (String)map.get("authCode"));
		sql.params().set("isMenu", (String)map.get("isMenu"));
		sql.params().set("menuCode", (String)map.get("menuCode"));
		sql.params().set("modelCode", (String)map.get("modelCode"));
		sql.params().set("createDate", new Date());
		log.info("插入sys_authorities:"+sql.toString());
		
		dao.execute(sql);
	}

	/**
	 * 通过用户编码回去角色编码
	 */
	public String getRoleCodeByUserCode(String userCode) {
		//select role_code from sys_user_role  where user_code =#{userCode}
		
		Cnd condition = Cnd.where("userCode", "=", userCode).and("status", "=", "1");
		UserRole urole =  findByCondition(UserRole.class, condition);
		return urole.getRoleCode();
	}

	/**
	 * 插入角色权限表
	 */
	public void insertRoleAuth(Map<String, Object> map) {
		//insert into SYS_ROLES_AUTHORITIES (ROLE_CODE, AUTH_CODE,CREATE_DATE,STATUS) values (#{roleCode}, #{authCode},sysdate(),'1')
		Sql sql = Sqls.create("insert into SYS_ROLES_AUTHORITIES (ROLE_CODE, AUTH_CODE,CREATE_DATE,STATUS) " +
				"values (@roleCode, @authCode,@createDate,'1')");
		sql.params().set("roleCode", (String)map.get("roleCode"));
		sql.params().set("authCode", (String)map.get("authCode"));
		sql.params().set("createDate", new Date());
		
		log.info("插入角色权限表"+sql.toString());
		
		dao.execute(sql);
	}

	/**
	 * 获取已经拥有的按钮
	 */
	public List<Button> getCheckedButtonMenuCode(String menucode) {
		/*
		 select md.id as btid,md.model_code as btcode,md.model_name as btname,md.imgname as btimg,md.model_title as bttitle,md.create_date as btdate,md.status as btsts,md.sortValue as btsort  
      from SYS_MENUS m,
      SYS_AUTHORITIES a,
      sys_model md 
      where  m.menu_code = a.menu_code 
      and a.model_code = md.model_code 
      and m.menu_code =
      and a.status='1'
      and m.status='1'
		 * */
		

		Sql sql = Sqls.create("select md.id as btid,md.model_code as btcode,md.model_name as btname,md.imgname as btimg,md.model_title as bttitle,md.create_date as btdate,md.status as btsts,md.sortValue as btsort  from SYS_MENUS m,SYS_AUTHORITIES a,sys_model md where  m.menu_code = a.menu_code and a.model_code = md.model_code and m.menu_code =@menuCode  and a.status='1' and m.status='1'");
		sql.params().set("menuCode", menucode);
		log.info("sql  ="+sql.toPreparedStatement());

		// dao.execute(sql) 执行前，编写回调函数，解析 查询结果
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<Button> list = new LinkedList<Button>();
				while (rs.next()) {
					// m.FMENU_CODE,m.MENU_URL,m.LEVELID,m.SORTVALUE
					Button bt = new Button();
					bt.setId(rs.getInt("btid"));
					bt.setModelCode(rs.getString("btcode"));
					bt.setModelName(rs.getString("btname"));
					bt.setImgName(rs.getString("btimg")==null?"":rs.getString("btimg"));
					bt.setModelTitle(rs.getString("bttitle")==null?"":rs.getString("bttitle"));
					bt.setCreateDate(rs.getString("btdate"));
					bt.setStatus(rs.getString("btsts"));
					bt.setSortValue(rs.getInt("btsort"));
			
					list.add(bt);
				}

				return list;
			}
		});

		dao.execute(sql);
		return sql.getList(Button.class);
		// Nutz内置了大量回调, 请查看Sqls.callback的属性
	}
	
	/**
	 * 获取已经拥有的按钮
	 */
	public List<Button> getCheckedButtonMenuId(String menuid) {
		Sql sql = Sqls.create("select md.id as btid,md.model_code as btcode,md.model_name as btname,md.imgname as btimg,md.model_title as bttitle,md.create_date as btdate,md.status as btsts,md.sortValue as btsort  from SYS_MENUS m,SYS_AUTHORITIES a,sys_model md where  m.menu_code = a.menu_code and a.model_code = md.model_code and m.id =@menuId  and a.status='1' and m.status='1'");
		sql.params().set("menuId", menuid);

		// dao.execute(sql) 执行前，编写回调函数，解析 查询结果
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<Button> list = new LinkedList<Button>();
				while (rs.next()) {
					// m.FMENU_CODE,m.MENU_URL,m.LEVELID,m.SORTVALUE
					Button bt = new Button();
					bt.setId(rs.getInt("btid"));
					bt.setModelCode(rs.getString("btcode"));
					bt.setModelName(rs.getString("btname"));
					bt.setImgName(rs.getString("btimg")==null?"":rs.getString("btimg"));
					bt.setModelTitle(rs.getString("bttitle")==null?"":rs.getString("bttitle"));
					bt.setCreateDate(rs.getString("btdate"));
					bt.setStatus(rs.getString("btsts"));
					bt.setSortValue(rs.getInt("btsort"));
			
					list.add(bt);
				}

				return list;
			}
		});

		dao.execute(sql);
		return sql.getList(Button.class);
		// Nutz内置了大量回调, 请查看Sqls.callback的属性
	}
	

	/**
	 * 通过菜单名称查找菜单
	 */
	public List<Menus> getMenusByMenusName(Map<String, Object> map,
			int startNum, int rp) {
		 //select * from SYS_MENUS where MENU_NAME  like '%${menuName}%' and status='1'
		Cnd condition = Cnd.where("status", "=", 1).and("menuName", "like", map.get("menuName"));
		Pager pager = dao.createPager(startNum, rp);
		// 设置一共可以查询的条数
		pager.setRecordCount(dao.count(Menus.class,condition));
		List<Menus> menus = dao.query(Menus.class,condition, pager);

		return menus;
	}

	/**
	 * 通过菜单名称统计菜单数量
	 */
	public int getMenusCountByMenusName(Map<String, Object> map) {
		//select count(1) from SYS_MENUS  where MENU_NAME like '%${menuName}%' and status='1'	
		Cnd condition = Cnd.where("status", "=", 1).and("menuName", "like", map.get("menuName"));
		return this.searchCount(Menus.class, condition);
	}

	/**
	 * 获取所有Auth menu（用于菜单按钮树）
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getAllAuthMenus() {
		/*
		 select m.MENU_CODE,m.MENU_NAME,m.FMENU_CODE,au.auth_code 
   	from SYS_MENUS m left join sys_authorities au on m.menu_code=au.menu_code 
   	where m.STATUS='1' and au.is_menu='1' and au.status='1' ORDER BY m.LEVELID
		 * */

		Sql sql = Sqls
				.create("select m.MENU_CODE,m.MENU_NAME,m.FMENU_CODE,au.auth_code from SYS_MENUS m left join sys_authorities au on m.menu_code=au.menu_code where m.STATUS='1' and au.is_menu='1' and au.status='1' ORDER BY m.LEVELID"); 
		
		// dao.execute(sql) 执行前，编写回调函数，解析 查询结果
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
				while (rs.next()) {
					// m.FMENU_CODE,m.MENU_URL,m.LEVELID,m.SORTVALUE
					Menus menu = new Menus();
					menu.setMenuCode(rs.getString("MENU_CODE"));
					menu.setMenuName(rs.getString("MENU_NAME"));
					menu.setFmenuCode(rs.getString("FMENU_CODE"));
					menu.setMenuUrl(rs.getString("auth_code"));
					
					Map<String, Object> map =  new HashMap<String, Object>();
					
					
					list.add(map);
				}

				return list;
			}
		});

		dao.execute(sql);
		//return sql.getList(Map<String,Object>);
		return null;
	}

	/**
	 * 获取所有Auth Button（用于菜单按钮树）
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getAllAuthButtons() {
		/*select pov_m.model_code,pov_m.model_name,au.MENU_CODE,au.auth_code
		from sys_authorities au  left join sys_model pov_m on pov_m.model_code=au.model_code 
				where pov_m.status='1' and au.is_menu='0' and au.status='1'
		*/		
		Sql sql = Sqls.create("select pov_m.model_code,pov_m.model_name,au.MENU_CODE,au.auth_code from sys_authorities au  left join sys_model pov_m on pov_m.model_code=au.model_code  where pov_m.status='1' and au.is_menu='0' and au.status='1'"); 
		
		// dao.execute(sql) 执行前，编写回调函数，解析 查询结果
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
				while (rs.next()) {
					// m.FMENU_CODE,m.MENU_URL,m.LEVELID,m.SORTVALUE
					Menus menu = new Menus();
					menu.setMenuCode(rs.getString("MENU_CODE"));
					menu.setMenuName(rs.getString("MENU_NAME"));
					menu.setFmenuCode(rs.getString("FMENU_CODE"));
					menu.setMenuUrl(rs.getString("auth_code"));
					
					Map<String, Object> map =  new HashMap<String, Object>();
					
					
					list.add(map);
				}

				return list;
			}
		});

		dao.execute(sql);
		//return sql.getList(Map<String,Object>);
		return null;
	}

	/**
	 * 获取用户拥有的菜单toolbar
	 */
	public List<Map<String, Object>> getUserButtons(Map<String, Object> map) {
		/*
		 select distinct a.ID, m.MODEL_NAME, m.MODEL_TITLE, m.IMGNAME, m.CREATE_DATE
          from sys_user_role         ur,
               sys_roles_authorities ra,
               sys_authorities       a,
               sys_model             m
         WHERE ur.USER_CODE = #{userCode}
         AND ur.ROLE_CODE = ra.ROLE_CODE
         AND ra.AUTH_CODE = a.AUTH_CODE
         AND a.IS_MENU = '0'
         AND a.Model_CODE = m.MODEL_CODE
         AND a.MENU_CODE = #{menuCode}
         order by m.SORTVALUE 
		 * */
		//return this.getSqlSessionTemplate().getMapper(MenusMapper.class).getUserButtons(map);
		return null;
	}

}

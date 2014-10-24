package com.seaway.liufuya.mvc.login.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
import com.seaway.liufuya.mvc.login.model.Role;
import com.seaway.liufuya.mvc.system.storeaddress.data.StoreAddress;

/**
 * 角色dao类
 * 
 * @author caryCheng
 * 
 */
@IocBean
public class RoleDaoImpl extends BasicDao {
	private static final Log log = Logs.get();

	/**
	 * 插入角色
	 */
	public void insertRole(Role role) {
		this.save(role);
	}

	/**
	 * 更新角色，按照 id 更新
	 */
	public void updateRole(Role role) {
		this.update(role);
	}

	/**
	 * 删除角色
	 */
	public boolean deleteRole(String id) {
		return super.delById(new Integer(id.trim()).intValue(), Role.class);
	}

	/**
	 * 统计角色数量
	 */
	public int getRoleTotalCount() {
		// select count(*) from SYS_ROLE where status ='1'
		Cnd condition = Cnd.where("status", "=", 1);
		return this.searchCount(Role.class, condition);
	}
	
	/**
	 * 新增 角色数据，前，判断角色是否已经存在 不存在，返回 true
	 * 
	 * @param memberlevel
	 */
	public boolean checkRoleByName(String role_name) {
		boolean flag = false;
		Cnd condition = Cnd.where("role_name", "=", role_name);
		Role store = findByCondition(Role.class, condition);
		if (store == null) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 查询所有角色列表
	 * 分页
	 */
	public List<Role> queryAllRoleList(int startNum, int rp) {
		Pager pager = dao.createPager(startNum, rp);
		// 设置一共可以查询的条数
		pager.setRecordCount(dao.count(Role.class, Cnd.where("status", "=", 1)));
		List<Role> roles = dao.query(Role.class, Cnd.where("status", "=", 1),
				pager);

		return roles;
	}
	
	/**
	 * 根据 角色 编码，查询角色对象
	 * @param role_code
	 * @return
	 */
	public Role findRoleByCode(String role_code) {
		Cnd condition = Cnd.where("role_code", "=", role_code);
		Role role = findByCondition(Role.class, condition);
		
		return role;
	}
	
	
	
	/**
	 * 查询所有角色列表
	 * 不分页
	 */
	public List<Role> queryAllRoleList() {
		List<Role> roles = dao.query(Role.class, Cnd.where("status", "=", 1));
		return roles;
	}

	/**
	 * 通过角色名称获取角色
	 */
	public List<Role> getRoleByRoleName(Map<String, Object> map, int startNum,
			int rp) {
		// select * from sys_role where ROLE_NAME like '%${roleName}%' and
		// status ='1'
		Pager pager = dao.createPager(startNum, rp);
		Cnd condition = Cnd.where("status", "=", 1).and("roleName", "LIKE",
				"%" + map.get("roleName") + "%");
		// 设置一共可以查询的条数
		pager.setRecordCount(dao.count(Role.class, condition));
		List<Role> roles = dao.query(Role.class, condition, pager);
		return roles;

	}

	/**
	 * 根据角色名称统计角色数量
	 */
	public int getRolesTotalCountByRoleName(Map<String, Object> map) {
		// select count(*) from SYS_ROLE where ROLE_NAME like '%${roleName}%'
		// and status ='1'
		Cnd condition = Cnd.where("status", "=", 1).and("roleName", "LIKE",
				"%" + map.get("roleName") + "%");
		return this.searchCount(Role.class, condition);
	}

	/**
	 * 根据id查询角色
	 */
	public Role getRoleById(String roleId) {
		return this.find(Integer.parseInt(roleId.trim()), Role.class);
	}

	/**
	 * 查询所有角色
	 */
	public List<Role> getAllRoles() {
		Cnd condition = Cnd.where("status", "=", "1");
		return search(Role.class, condition);
	}

	/**
	 * 根据用户id查询用户关联的角色信息
	 */
	public List<Role> getRolesByUserId(String sysUserId) {
		/*
		 * select * from sys_role r,SYS_USER_ROLE ur,SYS_USER u where r.
		 * ROLE_CODE = ur.ROLE_CODE and ur.USER_CODE = u.USER_CODE and
		 * u.USER_CODE = #{sysUserId}
		 */
		// @userName
		Sql sql = Sqls
				.create("select * from sys_role r,SYS_USER_ROLE ur,SYS_USER u where r. ROLE_CODE = ur.ROLE_CODE and ur.USER_CODE = u.USER_CODE and u.USER_CODE = @sysUserId");
		sql.params().set("sysUserId", sysUserId.trim().intern());

		// dao.execute(sql) 执行前，编写回调函数，解析 查询结果
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<Role> list = new LinkedList<Role>();
				while (rs.next()) {
					Role role = new Role();
					role.setId(rs.getInt("id"));
					role.setRoleCode(rs.getString("role_code"));
					role.setRoleName(rs.getString("role_name"));
					role.setDescription(rs.getString("description"));
					role.setIsSystem(rs.getString("is_system"));
					role.setType(rs.getString("type"));
					role.setCreateDate(rs.getDate("create_date"));
					role.setStatus(rs.getString("status"));

					list.add(role);
				}

				return list;
			}
		});

		dao.execute(sql);
		return sql.getList(Role.class);
	}

	/**
	 * 删除角色权限
	 */
	public void deleteRoleAuthByRoleCode(Map<String, Object> map) {
		// delete from SYS_ROLES_AUTHORITIES where role_code = #{roleCode}
		Sql sql = Sqls
				.create("delete from SYS_ROLES_AUTHORITIES where role_code = @roleCode");
		sql.params().set("roleCode", (String) map.get("roleCode"));
		dao.execute(sql);
	}

	/**
	 * 根据角色code查询角色拥有的权限
	 */
	public List<Authority> getCheckedAuthIds(Map<String, Object> map) {
		/*
		 * select auth_code from sys_authorities t where t.auth_code in (select
		 * ba.auth_code from sys_roles_authorities ba,sys_authorities bm where
		 * role_code = 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc')
		 */
		Sql sql = Sqls
				.create("select auth_code from sys_authorities t where t.auth_code in (select ba.auth_code from sys_roles_authorities ba,sys_authorities bm where  role_code = @roleCode");
		sql.params().set("roleCode", (String) map.get("roleCode"));

		// dao.execute(sql) 执行前，编写回调函数，解析 查询结果
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<Authority> list = new LinkedList<Authority>();
				while (rs.next()) {
					Authority auth = new Authority();
					auth.setAuthCode(rs.getString("auth_code"));

					list.add(auth);
				}

				return list;
			}
		});

		dao.execute(sql);
		return sql.getList(Authority.class);
	}

	/**
	 * 验证用户名是否存在
	 */
	public int validateRoleName(Map<String, Object> map) {
		// select count(*) from SYS_ROLE where ROLE_NAME = #{roleName} and
		// status ='1'
		Cnd condition = Cnd.where("status", "=", 1).and("roleName", "LIKE",
				"%" + map.get("roleName") + "%");
		return this.searchCount(Role.class, condition);
	}

	public List<Role> getRoleByRoleIds(Map<String, Object> map) {
		/*
		 * SELECT * FROM SYS_ROLE r WHERE r.ROLE_CODE in <foreach
		 * collection="list" index="index" item="i" separator="," open="("
		 * close=")" > #{i} </foreach>
		 */
		// @userName
		if (map == null) {
			return null;
		}
		
		Collection list= map.values();
		StringBuffer sb = new StringBuffer("(");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			sb.append("'"+it.next()+"',");
		}
		sb.append(")");
		
		String row = sb.toString();
		log.info(" 范围为  :"+row);
		
		Sql sql = Sqls
				.create("SELECT * FROM SYS_ROLE r WHERE r.ROLE_CODE in "+row);
		
		// dao.execute(sql) 执行前，编写回调函数，解析 查询结果
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<Role> list = new LinkedList<Role>();
				while (rs.next()) {
					Role role = new Role();
					role.setId(rs.getInt("id"));
					role.setRoleCode(rs.getString("role_code"));
					role.setRoleName(rs.getString("role_name"));
					role.setDescription(rs.getString("description"));
					role.setIsSystem(rs.getString("is_system"));
					role.setType(rs.getString("type"));
					role.setCreateDate(rs.getDate("create_date"));
					role.setStatus(rs.getString("status"));

					list.add(role);
				}

				return list;
			}
		});

		dao.execute(sql);
		return sql.getList(Role.class);
	}

}

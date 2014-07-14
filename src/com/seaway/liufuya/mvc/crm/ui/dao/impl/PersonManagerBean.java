package com.seaway.liufuya.mvc.crm.ui.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.mvc.crm.ui.dao.PersonManager;
import com.seaway.liufuya.mvc.crm.ui.data.Person;
import com.seaway.liufuya.mvc.crm.ui.data.PersonReference;
import com.seaway.liufuya.mvc.crm.ui.data.QueryMetaData;


@IocBean
public class PersonManagerBean extends BasicDao implements PersonManager {
	private static final Log log = Logs.get();

	private Dao dao = null;
	
	public PersonManagerBean() {
	}

	public PersonManagerBean(Dao dao) {
		this.dao = dao;
		super.dao = dao;
	}
	
	/**
	 * 被 PersonReferenceContainer.java 容器调用的方法。 容器能被 Table Form
	 * 公用，所以有可能每次查询字段不同，那么需要动态变化的字段，组合不同的 SQL 语句
	 * 
	 * @param queryMetaData
	 *            查询的参数 where 后使用
	 * @param propertyNames
	 *            要查询的列名 from 前使用
	 * 
	 */
	public List<PersonReference> getPersonReferences(
			QueryMetaData queryMetaData, String... propertyNames) {
		// Construct the query
		StringBuffer pqlBuf = new StringBuffer();
		pqlBuf.append("SELECT p.id");
		for (int i = 0; i < propertyNames.length; i++) {
			pqlBuf.append(",");
			pqlBuf.append("p.");
			pqlBuf.append(propertyNames[i]);
		}
		pqlBuf.append(" FROM Person p");

		
		if (queryMetaData.getPropertyName() != null) {
			pqlBuf.append(" WHERE p.");
			pqlBuf.append(queryMetaData.getPropertyName());
			if (queryMetaData.getSearchTerm() == null) {
				pqlBuf.append(" IS NULL");
			} else {
				pqlBuf.append(" = :searchTerm");
			}
		}

		if (queryMetaData != null && queryMetaData.getAscending().length > 0) {
			assert queryMetaData.getAscending().length == queryMetaData
					.getOrderBy().length : "orderBy and ascending arrays must be equal in length";
			pqlBuf.append(" ORDER BY ");
			for (int i = 0; i < queryMetaData.getAscending().length; i++) {
				if (i > 0) {
					pqlBuf.append(",");
				}
				pqlBuf.append("p.");
				pqlBuf.append(queryMetaData.getOrderBy()[i]);
				if (!queryMetaData.getAscending()[i]) {
					pqlBuf.append(" DESC");
				}
			}
		}

		String pql = pqlBuf.toString();

		// Nutz Dao 复杂 SQL 查询
		Sql sql = Sqls.create(pql);

		// dao.execute(sql) 执行前，编写回调函数，解析 查询结果
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<Person> list = new LinkedList<Person>();
				while (rs.next()) {
					//SELECT p.id,p.firstName,p.lastName,p.email,p.phoneNumber,p.streetAddress,
					//p.postalCode,p.city FROM Person p ORDER BY p.firstName,p.lastName
					Person menu = new Person();
					menu.setId(rs.getInt("id"));
					//menu.setVersion(rs.getInt("version")); //sql 语句里面没有这个字段
					menu.setFirstName(rs.getString("firstName"));
					menu.setLastName(rs.getString("lastName"));
					menu.setEmail(rs.getString("email"));
					menu.setPhoneNumber(rs.getString("phoneNumber"));
					menu.setStreetAddress(rs.getString("streetAddress"));
					menu.setPostalCode(rs.getString("postalCode"));
					menu.setCity(rs.getString("city"));

					log.info("---->city = " + menu.getCity());

					list.add(menu);
				}

				return list;
			}
		});

		System.out.println("---------baseDao  dao = "+dao);
		this.dao.execute(sql);
		List<Person> rslist =sql.getList(Person.class);
		
		//把结果取出，封装到 PersonReference 对象中
		List<PersonReference> referenceList = new ArrayList<PersonReference>(rslist.size());

        HashMap<String, Object> valueMap;
        for (Person row : rslist) {
            //assert row.length == propertyNames.length + 1 : "invalid number of returned values";
            valueMap = new HashMap<String, Object>();
//            new String[]{
//                    "firstName", "lastName", "email", "phoneNumber", "streetAddress",
//                    "postalCode", "city"};
            
            valueMap.put(propertyNames[0], row.getFirstName());
            valueMap.put(propertyNames[1], row.getLastName());
            valueMap.put(propertyNames[2], row.getEmail());
            valueMap.put(propertyNames[3], row.getPhoneNumber());
            valueMap.put(propertyNames[4], row.getStreetAddress());
            valueMap.put(propertyNames[5], row.getPostalCode());
            valueMap.put(propertyNames[6], row.getCity());
            
            
            referenceList.add(new PersonReference(row.getId(), valueMap));
        }

        return referenceList;
	}

	/**
	 * 根据 id 查询人 的数据
	 */
	public Person getPerson(int id) {
		
		System.out.println("---------baseDao  dao = "+dao);
		
		Cnd condition = Cnd.where("id", "=", id);
		return findByCondition(Person.class, condition);
	}

	/**
	 * 新增一个人的数据
	 */
	public Person savePerson(Person person) {
		if (person.getId() == 0) {
			this.save(person);
		}else{
			this.update(person);
		}
		
		return person;
	}

}

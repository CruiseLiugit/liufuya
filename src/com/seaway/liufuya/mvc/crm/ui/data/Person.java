package com.seaway.liufuya.mvc.crm.ui.data;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.seaway.liufuya.common.NotNull;
import com.seaway.liufuya.common.SelectBox;
import com.vaadin.data.fieldgroup.Caption;

@Table("person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column("version")
	private int version;
	
	@NotNull
	@Caption("姓氏")
	@Column("firstName")
	private String firstName = "";
	
	@NotNull
	@Caption("名称")
	@Column("lastName")
	private String lastName = "";
	
	@NotNull
	@Caption("邮箱")
	@Column("email")
	private String email = "";
	
	@NotNull
	@Caption("电话")
	@Column("phoneNumber")
	private String phoneNumber = "";
	
	@NotNull
	@Caption("地址")
	@Column("streetAddress")
	private String streetAddress = "";
	
	@Caption("邮编")
	@Column("postalCode")
	private String postalCode = "";
	
	@Caption("城市")
	@Column("city")
	@SelectBox
	private String city = "";

	public Person(){}
	
	public Person(String firstName, String lastName, String email,
			String phoneNumber, String streetAddress, String postalCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}

package com.jlj.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Bigtype entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "admin", catalog = "wcg")
public class Admin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private Integer limits;
	private Date createdate;
	private String phone;
	private String qq;
	private String email;
	private Integer ison;

	// Constructors
	/** full constructor */
	public Admin(String username, String password, Integer limits,
			Date createdate, String phone, String qq, String email, Integer ison) {
		super();
		this.username = username;
		this.password = password;
		this.limits = limits;
		this.createdate = createdate;
		this.phone = phone;
		this.qq = qq;
		this.email = email;
		this.ison = ison;
	}

	/** default constructor */
	public Admin() {
	}

	
	

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", length = 30)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "limits")
	public Integer getLimits() {
		return limits;
	}

	public void setLimits(Integer limits) {
		this.limits = limits;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createdate")
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "qq", length = 20)
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ison")
	public Integer getIson() {
		return ison;
	}

	public void setIson(Integer ison) {
		this.ison = ison;
	}

	
	
	
	

}
package com.jlj.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Member entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "member", catalog = "wcg")
public class Member implements java.io.Serializable {

	// Fields

	private Integer id;
	private String realname;
	private String username;
	private String password;
	private Integer sex;
	private Integer age;
	private String phone;
	private String address;
	private Integer credit;
	private Integer currentcredit;
	private Integer consumecredit;
	private Integer level;
	private Date recentlogin;
	private String email;
	private Date createdate;
	private String openid;
	private String publicaccount;
	private String preopenid;
	private String nextopenids;
	private String recordnote;

	// Constructors

	/** default constructor */
	public Member() {
	}

	/** full constructor */
	public Member(String realname, String username, String password,
			Integer sex, Integer age, String phone, String address,
			Integer credit,Integer currentcredit,Integer consumecredit, 
			Integer level, Date recentlogin, String email,
			Date createdate, String openid, String publicaccount, String preopenid, String nextopenids, String recordnote) {
		this.realname = realname;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.credit = credit;
		this.currentcredit = currentcredit;
		this.consumecredit = consumecredit;
		this.level = level;
		this.recentlogin = recentlogin;
		this.email = email;
		this.createdate = createdate;
		this.openid = openid;
		this.publicaccount = publicaccount;
		this.preopenid = preopenid;
		this.nextopenids = nextopenids;
		this.recordnote = recordnote;
		
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

	@Column(name = "realname", length = 50)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "username", length = 30)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "sex")
	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "credit")
	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "recentlogin", length = 19)
	public Date getRecentlogin() {
		return this.recentlogin;
	}

	public void setRecentlogin(Date recentlogin) {
		this.recentlogin = recentlogin;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createdate", length = 10)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(name = "openid", length = 50)
	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}
	@Column(name = "currentcredit")
	public Integer getCurrentcredit() {
		return currentcredit;
	}

	public void setCurrentcredit(Integer currentcredit) {
		this.currentcredit = currentcredit;
	}
	@Column(name = "consumecredit")
	public Integer getConsumecredit() {
		return consumecredit;
	}

	public void setConsumecredit(Integer consumecredit) {
		this.consumecredit = consumecredit;
	}

	@Column(name = "preopenid")
	public String getPreopenid() {
		return preopenid;
	}

	public void setPreopenid(String preopenid) {
		this.preopenid = preopenid;
	}

	@Column(name = "nextopenids")
	public String getNextopenids() {
		return nextopenids;
	}

	public void setNextopenids(String nextopenids) {
		this.nextopenids = nextopenids;
	}

	@Column(name = "recordnote")
	public String getRecordnote() {
		return recordnote;
	}

	public void setRecordnote(String recordnote) {
		this.recordnote = recordnote;
	}

	
	
}
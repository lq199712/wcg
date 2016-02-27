package com.jlj.model;

// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Prizer entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "prizer", catalog = "wcg")
public class Prizer implements java.io.Serializable {

	// Fields

	private Integer id;
	private Bigwheel bigwheel;
	private Integer mid;
	private String name;
	private String wxname;
	private String tel;
	private String prize;
	private Date time;
	private String remark;
	private Integer awardstate;
	private Integer isprizer;
	private String openid;
	private Integer totimes;

	// Constructors

	/** default constructor */
	public Prizer() {
	}

	/** full constructor */
	public Prizer(Bigwheel bigwheel, Integer mid, String name, String wxname,
			String tel, String prize, Date time, String remark,
			Integer awardstate, Integer isprizer, String openid, Integer totimes) {
		this.bigwheel = bigwheel;
		this.mid = mid;
		this.name = name;
		this.wxname = wxname;
		this.tel = tel;
		this.prize = prize;
		this.time = time;
		this.remark = remark;
		this.awardstate = awardstate;
		this.isprizer = isprizer;
		this.openid = openid;
		this.totimes = totimes;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bid")
	public Bigwheel getBigwheel() {
		return this.bigwheel;
	}

	public void setBigwheel(Bigwheel bigwheel) {
		this.bigwheel = bigwheel;
	}

	@Column(name = "mid")
	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "wxname", length = 50)
	public String getWxname() {
		return this.wxname;
	}

	public void setWxname(String wxname) {
		this.wxname = wxname;
	}

	@Column(name = "tel")
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "prize")
	public String getPrize() {
		return this.prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "time", length = 19)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "awardstate")
	public Integer getAwardstate() {
		return this.awardstate;
	}

	public void setAwardstate(Integer awardstate) {
		this.awardstate = awardstate;
	}

	@Column(name = "isprizer")
	public Integer getIsprizer() {
		return this.isprizer;
	}

	public void setIsprizer(Integer isprizer) {
		this.isprizer = isprizer;
	}

	@Column(name = "openid", length = 50)
	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Column(name = "totimes")
	public Integer getTotimes() {
		return this.totimes;
	}

	public void setTotimes(Integer totimes) {
		this.totimes = totimes;
	}

}
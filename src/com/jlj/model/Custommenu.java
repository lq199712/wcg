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
 * Custommenu entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "custommenu", catalog = "wcg")
public class Custommenu implements java.io.Serializable {

	// Fields

	private Integer id;
	private String menu1;
	private String menu2;
	private String menu3;
	private Integer isend1;
	private Integer isend2;
	private Integer isend3;
	private String menu1type;
	private String menu1key;
	private String menu1url;
	private String menu2type;
	private String menu2key;
	private String menu2url;
	private String menu3type;
	private String menu3key;
	private String menu3url;
	private String menu1son1;
	private String menu1son2;
	private String menu1son3;
	private String menu1son4;
	private String menu1son5;
	private String menu2son1;
	private String menu2son2;
	private String menu2son3;
	private String menu2son4;
	private String menu2son5;
	private String menu3son1;
	private String menu3son2;
	private String menu3son3;
	private String menu3son4;
	private String menu3son5;
	private String menu1son1type;
	private String menu1son1key;
	private String menu1son1url;
	private String menu1son2type;
	private String menu1son2key;
	private String menu1son2url;
	private String menu1son3type;
	private String menu1son3key;
	private String menu1son3url;
	private String menu1son4type;
	private String menu1son4key;
	private String menu1son4url;
	private String menu1son5type;
	private String menu1son5key;
	private String menu1son5url;
	private String menu2son1type;
	private String menu2son1key;
	private String menu2son1url;
	private String menu2son2type;
	private String menu2son2key;
	private String menu2son2url;
	private String menu2son3type;
	private String menu2son3key;
	private String menu2son3url;
	private String menu2son4type;
	private String menu2son4key;
	private String menu2son4url;
	private String menu2son5type;
	private String menu2son5key;
	private String menu2son5url;
	private String menu3son1type;
	private String menu3son1key;
	private String menu3son1url;
	private String menu3son2type;
	private String menu3son2key;
	private String menu3son2url;
	private String menu3son3type;
	private String menu3son3key;
	private String menu3son3url;
	private String menu3son4type;
	private String menu3son4key;
	private String menu3son4url;
	private String menu3son5type;
	private String menu3son5key;
	private String menu3son5url;
	private Integer menu1resid;
	private Integer menu2resid;
	private Integer menu3resid;
	private Integer menu1son1resid;
	private Integer menu1son2resid;
	private Integer menu1son3resid;
	private Integer menu1son4resid;
	private Integer menu1son5resid;
	private Integer menu2son1resid;
	private Integer menu2son2resid;
	private Integer menu2son3resid;
	private Integer menu2son4resid;
	private Integer menu2son5resid;
	private Integer menu3son1resid;
	private Integer menu3son2resid;
	private Integer menu3son3resid;
	private Integer menu3son4resid;
	private Integer menu3son5resid;
	private Date createdate;
	private String publicaccount;

	// Constructors

	/** default constructor */
	public Custommenu() {
	}

	/** full constructor */
	public Custommenu(String menu1, String menu2, String menu3, Integer isend1,
			Integer isend2, Integer isend3, String menu1type, String menu1key,
			String menu1url, String menu2type, String menu2key,
			String menu2url, String menu3type, String menu3key,
			String menu3url, String menu1son1, String menu1son2,
			String menu1son3, String menu1son4, String menu1son5,
			String menu2son1, String menu2son2, String menu2son3,
			String menu2son4, String menu2son5, String menu3son1,
			String menu3son2, String menu3son3, String menu3son4,
			String menu3son5, String menu1son1type, String menu1son1key,
			String menu1son1url, String menu1son2type, String menu1son2key,
			String menu1son2url, String menu1son3type, String menu1son3key,
			String menu1son3url, String menu1son4type, String menu1son4key,
			String menu1son4url, String menu1son5type, String menu1son5key,
			String menu1son5url, String menu2son1type, String menu2son1key,
			String menu2son1url, String menu2son2type, String menu2son2key,
			String menu2son2url, String menu2son3type, String menu2son3key,
			String menu2son3url, String menu2son4type, String menu2son4key,
			String menu2son4url, String menu2son5type, String menu2son5key,
			String menu2son5url, String menu3son1type, String menu3son1key,
			String menu3son1url, String menu3son2type, String menu3son2key,
			String menu3son2url, String menu3son3type, String menu3son3key,
			String menu3son3url, String menu3son4type, String menu3son4key,
			String menu3son4url, String menu3son5type, String menu3son5key,
			String menu3son5url, Integer menu1resid, Integer menu2resid,
			Integer menu3resid, Integer menu1son1resid, Integer menu1son2resid,
			Integer menu1son3resid, Integer menu1son4resid,
			Integer menu1son5resid, Integer menu2son1resid,
			Integer menu2son2resid, Integer menu2son3resid,
			Integer menu2son4resid, Integer menu2son5resid,
			Integer menu3son1resid, Integer menu3son2resid,
			Integer menu3son3resid, Integer menu3son4resid,
			Integer menu3son5resid, Date createdate, String publicaccount) {
		this.menu1 = menu1;
		this.menu2 = menu2;
		this.menu3 = menu3;
		this.isend1 = isend1;
		this.isend2 = isend2;
		this.isend3 = isend3;
		this.menu1type = menu1type;
		this.menu1key = menu1key;
		this.menu1url = menu1url;
		this.menu2type = menu2type;
		this.menu2key = menu2key;
		this.menu2url = menu2url;
		this.menu3type = menu3type;
		this.menu3key = menu3key;
		this.menu3url = menu3url;
		this.menu1son1 = menu1son1;
		this.menu1son2 = menu1son2;
		this.menu1son3 = menu1son3;
		this.menu1son4 = menu1son4;
		this.menu1son5 = menu1son5;
		this.menu2son1 = menu2son1;
		this.menu2son2 = menu2son2;
		this.menu2son3 = menu2son3;
		this.menu2son4 = menu2son4;
		this.menu2son5 = menu2son5;
		this.menu3son1 = menu3son1;
		this.menu3son2 = menu3son2;
		this.menu3son3 = menu3son3;
		this.menu3son4 = menu3son4;
		this.menu3son5 = menu3son5;
		this.menu1son1type = menu1son1type;
		this.menu1son1key = menu1son1key;
		this.menu1son1url = menu1son1url;
		this.menu1son2type = menu1son2type;
		this.menu1son2key = menu1son2key;
		this.menu1son2url = menu1son2url;
		this.menu1son3type = menu1son3type;
		this.menu1son3key = menu1son3key;
		this.menu1son3url = menu1son3url;
		this.menu1son4type = menu1son4type;
		this.menu1son4key = menu1son4key;
		this.menu1son4url = menu1son4url;
		this.menu1son5type = menu1son5type;
		this.menu1son5key = menu1son5key;
		this.menu1son5url = menu1son5url;
		this.menu2son1type = menu2son1type;
		this.menu2son1key = menu2son1key;
		this.menu2son1url = menu2son1url;
		this.menu2son2type = menu2son2type;
		this.menu2son2key = menu2son2key;
		this.menu2son2url = menu2son2url;
		this.menu2son3type = menu2son3type;
		this.menu2son3key = menu2son3key;
		this.menu2son3url = menu2son3url;
		this.menu2son4type = menu2son4type;
		this.menu2son4key = menu2son4key;
		this.menu2son4url = menu2son4url;
		this.menu2son5type = menu2son5type;
		this.menu2son5key = menu2son5key;
		this.menu2son5url = menu2son5url;
		this.menu3son1type = menu3son1type;
		this.menu3son1key = menu3son1key;
		this.menu3son1url = menu3son1url;
		this.menu3son2type = menu3son2type;
		this.menu3son2key = menu3son2key;
		this.menu3son2url = menu3son2url;
		this.menu3son3type = menu3son3type;
		this.menu3son3key = menu3son3key;
		this.menu3son3url = menu3son3url;
		this.menu3son4type = menu3son4type;
		this.menu3son4key = menu3son4key;
		this.menu3son4url = menu3son4url;
		this.menu3son5type = menu3son5type;
		this.menu3son5key = menu3son5key;
		this.menu3son5url = menu3son5url;
		this.menu1resid = menu1resid;
		this.menu2resid = menu2resid;
		this.menu3resid = menu3resid;
		this.menu1son1resid = menu1son1resid;
		this.menu1son2resid = menu1son2resid;
		this.menu1son3resid = menu1son3resid;
		this.menu1son4resid = menu1son4resid;
		this.menu1son5resid = menu1son5resid;
		this.menu2son1resid = menu2son1resid;
		this.menu2son2resid = menu2son2resid;
		this.menu2son3resid = menu2son3resid;
		this.menu2son4resid = menu2son4resid;
		this.menu2son5resid = menu2son5resid;
		this.menu3son1resid = menu3son1resid;
		this.menu3son2resid = menu3son2resid;
		this.menu3son3resid = menu3son3resid;
		this.menu3son4resid = menu3son4resid;
		this.menu3son5resid = menu3son5resid;
		this.createdate = createdate;
		this.publicaccount = publicaccount;
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

	@Column(name = "menu1", length = 8)
	public String getMenu1() {
		return this.menu1;
	}

	public void setMenu1(String menu1) {
		this.menu1 = menu1;
	}

	@Column(name = "menu2", length = 8)
	public String getMenu2() {
		return this.menu2;
	}

	public void setMenu2(String menu2) {
		this.menu2 = menu2;
	}

	@Column(name = "menu3", length = 8)
	public String getMenu3() {
		return this.menu3;
	}

	public void setMenu3(String menu3) {
		this.menu3 = menu3;
	}

	@Column(name = "isend1")
	public Integer getIsend1() {
		return this.isend1;
	}

	public void setIsend1(Integer isend1) {
		this.isend1 = isend1;
	}

	@Column(name = "isend2")
	public Integer getIsend2() {
		return this.isend2;
	}

	public void setIsend2(Integer isend2) {
		this.isend2 = isend2;
	}

	@Column(name = "isend3")
	public Integer getIsend3() {
		return this.isend3;
	}

	public void setIsend3(Integer isend3) {
		this.isend3 = isend3;
	}

	@Column(name = "menu1type", length = 10)
	public String getMenu1type() {
		return this.menu1type;
	}

	public void setMenu1type(String menu1type) {
		this.menu1type = menu1type;
	}

	@Column(name = "menu1key", length = 20)
	public String getMenu1key() {
		return this.menu1key;
	}

	public void setMenu1key(String menu1key) {
		this.menu1key = menu1key;
	}

	@Column(name = "menu1url", length = 50)
	public String getMenu1url() {
		return this.menu1url;
	}

	public void setMenu1url(String menu1url) {
		this.menu1url = menu1url;
	}

	@Column(name = "menu2type", length = 10)
	public String getMenu2type() {
		return this.menu2type;
	}

	public void setMenu2type(String menu2type) {
		this.menu2type = menu2type;
	}

	@Column(name = "menu2key", length = 20)
	public String getMenu2key() {
		return this.menu2key;
	}

	public void setMenu2key(String menu2key) {
		this.menu2key = menu2key;
	}

	@Column(name = "menu2url", length = 50)
	public String getMenu2url() {
		return this.menu2url;
	}

	public void setMenu2url(String menu2url) {
		this.menu2url = menu2url;
	}

	@Column(name = "menu3type", length = 10)
	public String getMenu3type() {
		return this.menu3type;
	}

	public void setMenu3type(String menu3type) {
		this.menu3type = menu3type;
	}

	@Column(name = "menu3key", length = 20)
	public String getMenu3key() {
		return this.menu3key;
	}

	public void setMenu3key(String menu3key) {
		this.menu3key = menu3key;
	}

	@Column(name = "menu3url", length = 50)
	public String getMenu3url() {
		return this.menu3url;
	}

	public void setMenu3url(String menu3url) {
		this.menu3url = menu3url;
	}

	@Column(name = "menu1son1", length = 16)
	public String getMenu1son1() {
		return this.menu1son1;
	}

	public void setMenu1son1(String menu1son1) {
		this.menu1son1 = menu1son1;
	}

	@Column(name = "menu1son2", length = 16)
	public String getMenu1son2() {
		return this.menu1son2;
	}

	public void setMenu1son2(String menu1son2) {
		this.menu1son2 = menu1son2;
	}

	@Column(name = "menu1son3", length = 16)
	public String getMenu1son3() {
		return this.menu1son3;
	}

	public void setMenu1son3(String menu1son3) {
		this.menu1son3 = menu1son3;
	}

	@Column(name = "menu1son4", length = 16)
	public String getMenu1son4() {
		return this.menu1son4;
	}

	public void setMenu1son4(String menu1son4) {
		this.menu1son4 = menu1son4;
	}

	@Column(name = "menu1son5", length = 16)
	public String getMenu1son5() {
		return this.menu1son5;
	}

	public void setMenu1son5(String menu1son5) {
		this.menu1son5 = menu1son5;
	}

	@Column(name = "menu2son1", length = 16)
	public String getMenu2son1() {
		return this.menu2son1;
	}

	public void setMenu2son1(String menu2son1) {
		this.menu2son1 = menu2son1;
	}

	@Column(name = "menu2son2", length = 16)
	public String getMenu2son2() {
		return this.menu2son2;
	}

	public void setMenu2son2(String menu2son2) {
		this.menu2son2 = menu2son2;
	}

	@Column(name = "menu2son3", length = 16)
	public String getMenu2son3() {
		return this.menu2son3;
	}

	public void setMenu2son3(String menu2son3) {
		this.menu2son3 = menu2son3;
	}

	@Column(name = "menu2son4", length = 16)
	public String getMenu2son4() {
		return this.menu2son4;
	}

	public void setMenu2son4(String menu2son4) {
		this.menu2son4 = menu2son4;
	}

	@Column(name = "menu2son5", length = 16)
	public String getMenu2son5() {
		return this.menu2son5;
	}

	public void setMenu2son5(String menu2son5) {
		this.menu2son5 = menu2son5;
	}

	@Column(name = "menu3son1", length = 16)
	public String getMenu3son1() {
		return this.menu3son1;
	}

	public void setMenu3son1(String menu3son1) {
		this.menu3son1 = menu3son1;
	}

	@Column(name = "menu3son2", length = 16)
	public String getMenu3son2() {
		return this.menu3son2;
	}

	public void setMenu3son2(String menu3son2) {
		this.menu3son2 = menu3son2;
	}

	@Column(name = "menu3son3", length = 16)
	public String getMenu3son3() {
		return this.menu3son3;
	}

	public void setMenu3son3(String menu3son3) {
		this.menu3son3 = menu3son3;
	}

	@Column(name = "menu3son4", length = 16)
	public String getMenu3son4() {
		return this.menu3son4;
	}

	public void setMenu3son4(String menu3son4) {
		this.menu3son4 = menu3son4;
	}

	@Column(name = "menu3son5", length = 16)
	public String getMenu3son5() {
		return this.menu3son5;
	}

	public void setMenu3son5(String menu3son5) {
		this.menu3son5 = menu3son5;
	}

	@Column(name = "menu1son1type", length = 10)
	public String getMenu1son1type() {
		return this.menu1son1type;
	}

	public void setMenu1son1type(String menu1son1type) {
		this.menu1son1type = menu1son1type;
	}

	@Column(name = "menu1son1key", length = 20)
	public String getMenu1son1key() {
		return this.menu1son1key;
	}

	public void setMenu1son1key(String menu1son1key) {
		this.menu1son1key = menu1son1key;
	}

	@Column(name = "menu1son1url", length = 50)
	public String getMenu1son1url() {
		return this.menu1son1url;
	}

	public void setMenu1son1url(String menu1son1url) {
		this.menu1son1url = menu1son1url;
	}

	@Column(name = "menu1son2type", length = 10)
	public String getMenu1son2type() {
		return this.menu1son2type;
	}

	public void setMenu1son2type(String menu1son2type) {
		this.menu1son2type = menu1son2type;
	}

	@Column(name = "menu1son2key", length = 20)
	public String getMenu1son2key() {
		return this.menu1son2key;
	}

	public void setMenu1son2key(String menu1son2key) {
		this.menu1son2key = menu1son2key;
	}

	@Column(name = "menu1son2url", length = 50)
	public String getMenu1son2url() {
		return this.menu1son2url;
	}

	public void setMenu1son2url(String menu1son2url) {
		this.menu1son2url = menu1son2url;
	}

	@Column(name = "menu1son3type", length = 10)
	public String getMenu1son3type() {
		return this.menu1son3type;
	}

	public void setMenu1son3type(String menu1son3type) {
		this.menu1son3type = menu1son3type;
	}

	@Column(name = "menu1son3key", length = 20)
	public String getMenu1son3key() {
		return this.menu1son3key;
	}

	public void setMenu1son3key(String menu1son3key) {
		this.menu1son3key = menu1son3key;
	}

	@Column(name = "menu1son3url", length = 50)
	public String getMenu1son3url() {
		return this.menu1son3url;
	}

	public void setMenu1son3url(String menu1son3url) {
		this.menu1son3url = menu1son3url;
	}

	@Column(name = "menu1son4type", length = 10)
	public String getMenu1son4type() {
		return this.menu1son4type;
	}

	public void setMenu1son4type(String menu1son4type) {
		this.menu1son4type = menu1son4type;
	}

	@Column(name = "menu1son4key", length = 20)
	public String getMenu1son4key() {
		return this.menu1son4key;
	}

	public void setMenu1son4key(String menu1son4key) {
		this.menu1son4key = menu1son4key;
	}

	@Column(name = "menu1son4url", length = 50)
	public String getMenu1son4url() {
		return this.menu1son4url;
	}

	public void setMenu1son4url(String menu1son4url) {
		this.menu1son4url = menu1son4url;
	}

	@Column(name = "menu1son5type", length = 10)
	public String getMenu1son5type() {
		return this.menu1son5type;
	}

	public void setMenu1son5type(String menu1son5type) {
		this.menu1son5type = menu1son5type;
	}

	@Column(name = "menu1son5key", length = 20)
	public String getMenu1son5key() {
		return this.menu1son5key;
	}

	public void setMenu1son5key(String menu1son5key) {
		this.menu1son5key = menu1son5key;
	}

	@Column(name = "menu1son5url", length = 50)
	public String getMenu1son5url() {
		return this.menu1son5url;
	}

	public void setMenu1son5url(String menu1son5url) {
		this.menu1son5url = menu1son5url;
	}

	@Column(name = "menu2son1type", length = 10)
	public String getMenu2son1type() {
		return this.menu2son1type;
	}

	public void setMenu2son1type(String menu2son1type) {
		this.menu2son1type = menu2son1type;
	}

	@Column(name = "menu2son1key", length = 20)
	public String getMenu2son1key() {
		return this.menu2son1key;
	}

	public void setMenu2son1key(String menu2son1key) {
		this.menu2son1key = menu2son1key;
	}

	@Column(name = "menu2son1url", length = 50)
	public String getMenu2son1url() {
		return this.menu2son1url;
	}

	public void setMenu2son1url(String menu2son1url) {
		this.menu2son1url = menu2son1url;
	}

	@Column(name = "menu2son2type", length = 10)
	public String getMenu2son2type() {
		return this.menu2son2type;
	}

	public void setMenu2son2type(String menu2son2type) {
		this.menu2son2type = menu2son2type;
	}

	@Column(name = "menu2son2key", length = 20)
	public String getMenu2son2key() {
		return this.menu2son2key;
	}

	public void setMenu2son2key(String menu2son2key) {
		this.menu2son2key = menu2son2key;
	}

	@Column(name = "menu2son2url", length = 50)
	public String getMenu2son2url() {
		return this.menu2son2url;
	}

	public void setMenu2son2url(String menu2son2url) {
		this.menu2son2url = menu2son2url;
	}

	@Column(name = "menu2son3type", length = 10)
	public String getMenu2son3type() {
		return this.menu2son3type;
	}

	public void setMenu2son3type(String menu2son3type) {
		this.menu2son3type = menu2son3type;
	}

	@Column(name = "menu2son3key", length = 20)
	public String getMenu2son3key() {
		return this.menu2son3key;
	}

	public void setMenu2son3key(String menu2son3key) {
		this.menu2son3key = menu2son3key;
	}

	@Column(name = "menu2son3url", length = 50)
	public String getMenu2son3url() {
		return this.menu2son3url;
	}

	public void setMenu2son3url(String menu2son3url) {
		this.menu2son3url = menu2son3url;
	}

	@Column(name = "menu2son4type", length = 10)
	public String getMenu2son4type() {
		return this.menu2son4type;
	}

	public void setMenu2son4type(String menu2son4type) {
		this.menu2son4type = menu2son4type;
	}

	@Column(name = "menu2son4key", length = 20)
	public String getMenu2son4key() {
		return this.menu2son4key;
	}

	public void setMenu2son4key(String menu2son4key) {
		this.menu2son4key = menu2son4key;
	}

	@Column(name = "menu2son4url", length = 50)
	public String getMenu2son4url() {
		return this.menu2son4url;
	}

	public void setMenu2son4url(String menu2son4url) {
		this.menu2son4url = menu2son4url;
	}

	@Column(name = "menu2son5type", length = 10)
	public String getMenu2son5type() {
		return this.menu2son5type;
	}

	public void setMenu2son5type(String menu2son5type) {
		this.menu2son5type = menu2son5type;
	}

	@Column(name = "menu2son5key", length = 20)
	public String getMenu2son5key() {
		return this.menu2son5key;
	}

	public void setMenu2son5key(String menu2son5key) {
		this.menu2son5key = menu2son5key;
	}

	@Column(name = "menu2son5url", length = 50)
	public String getMenu2son5url() {
		return this.menu2son5url;
	}

	public void setMenu2son5url(String menu2son5url) {
		this.menu2son5url = menu2son5url;
	}

	@Column(name = "menu3son1type", length = 10)
	public String getMenu3son1type() {
		return this.menu3son1type;
	}

	public void setMenu3son1type(String menu3son1type) {
		this.menu3son1type = menu3son1type;
	}

	@Column(name = "menu3son1key", length = 20)
	public String getMenu3son1key() {
		return this.menu3son1key;
	}

	public void setMenu3son1key(String menu3son1key) {
		this.menu3son1key = menu3son1key;
	}

	@Column(name = "menu3son1url", length = 50)
	public String getMenu3son1url() {
		return this.menu3son1url;
	}

	public void setMenu3son1url(String menu3son1url) {
		this.menu3son1url = menu3son1url;
	}

	@Column(name = "menu3son2type", length = 10)
	public String getMenu3son2type() {
		return this.menu3son2type;
	}

	public void setMenu3son2type(String menu3son2type) {
		this.menu3son2type = menu3son2type;
	}

	@Column(name = "menu3son2key", length = 20)
	public String getMenu3son2key() {
		return this.menu3son2key;
	}

	public void setMenu3son2key(String menu3son2key) {
		this.menu3son2key = menu3son2key;
	}

	@Column(name = "menu3son2url", length = 50)
	public String getMenu3son2url() {
		return this.menu3son2url;
	}

	public void setMenu3son2url(String menu3son2url) {
		this.menu3son2url = menu3son2url;
	}

	@Column(name = "menu3son3type", length = 10)
	public String getMenu3son3type() {
		return this.menu3son3type;
	}

	public void setMenu3son3type(String menu3son3type) {
		this.menu3son3type = menu3son3type;
	}

	@Column(name = "menu3son3key", length = 20)
	public String getMenu3son3key() {
		return this.menu3son3key;
	}

	public void setMenu3son3key(String menu3son3key) {
		this.menu3son3key = menu3son3key;
	}

	@Column(name = "menu3son3url", length = 50)
	public String getMenu3son3url() {
		return this.menu3son3url;
	}

	public void setMenu3son3url(String menu3son3url) {
		this.menu3son3url = menu3son3url;
	}

	@Column(name = "menu3son4type", length = 10)
	public String getMenu3son4type() {
		return this.menu3son4type;
	}

	public void setMenu3son4type(String menu3son4type) {
		this.menu3son4type = menu3son4type;
	}

	@Column(name = "menu3son4key", length = 20)
	public String getMenu3son4key() {
		return this.menu3son4key;
	}

	public void setMenu3son4key(String menu3son4key) {
		this.menu3son4key = menu3son4key;
	}

	@Column(name = "menu3son4url", length = 50)
	public String getMenu3son4url() {
		return this.menu3son4url;
	}

	public void setMenu3son4url(String menu3son4url) {
		this.menu3son4url = menu3son4url;
	}

	@Column(name = "menu3son5type", length = 10)
	public String getMenu3son5type() {
		return this.menu3son5type;
	}

	public void setMenu3son5type(String menu3son5type) {
		this.menu3son5type = menu3son5type;
	}

	@Column(name = "menu3son5key", length = 20)
	public String getMenu3son5key() {
		return this.menu3son5key;
	}

	public void setMenu3son5key(String menu3son5key) {
		this.menu3son5key = menu3son5key;
	}

	@Column(name = "menu3son5url", length = 50)
	public String getMenu3son5url() {
		return this.menu3son5url;
	}

	public void setMenu3son5url(String menu3son5url) {
		this.menu3son5url = menu3son5url;
	}

	@Column(name = "menu1resid")
	public Integer getMenu1resid() {
		return this.menu1resid;
	}

	public void setMenu1resid(Integer menu1resid) {
		this.menu1resid = menu1resid;
	}

	@Column(name = "menu2resid")
	public Integer getMenu2resid() {
		return this.menu2resid;
	}

	public void setMenu2resid(Integer menu2resid) {
		this.menu2resid = menu2resid;
	}

	@Column(name = "menu3resid")
	public Integer getMenu3resid() {
		return this.menu3resid;
	}

	public void setMenu3resid(Integer menu3resid) {
		this.menu3resid = menu3resid;
	}

	@Column(name = "menu1son1resid")
	public Integer getMenu1son1resid() {
		return this.menu1son1resid;
	}

	public void setMenu1son1resid(Integer menu1son1resid) {
		this.menu1son1resid = menu1son1resid;
	}

	@Column(name = "menu1son2resid")
	public Integer getMenu1son2resid() {
		return this.menu1son2resid;
	}

	public void setMenu1son2resid(Integer menu1son2resid) {
		this.menu1son2resid = menu1son2resid;
	}

	@Column(name = "menu1son3resid")
	public Integer getMenu1son3resid() {
		return this.menu1son3resid;
	}

	public void setMenu1son3resid(Integer menu1son3resid) {
		this.menu1son3resid = menu1son3resid;
	}

	@Column(name = "menu1son4resid")
	public Integer getMenu1son4resid() {
		return this.menu1son4resid;
	}

	public void setMenu1son4resid(Integer menu1son4resid) {
		this.menu1son4resid = menu1son4resid;
	}

	@Column(name = "menu1son5resid")
	public Integer getMenu1son5resid() {
		return this.menu1son5resid;
	}

	public void setMenu1son5resid(Integer menu1son5resid) {
		this.menu1son5resid = menu1son5resid;
	}

	@Column(name = "menu2son1resid")
	public Integer getMenu2son1resid() {
		return this.menu2son1resid;
	}

	public void setMenu2son1resid(Integer menu2son1resid) {
		this.menu2son1resid = menu2son1resid;
	}

	@Column(name = "menu2son2resid")
	public Integer getMenu2son2resid() {
		return this.menu2son2resid;
	}

	public void setMenu2son2resid(Integer menu2son2resid) {
		this.menu2son2resid = menu2son2resid;
	}

	@Column(name = "menu2son3resid")
	public Integer getMenu2son3resid() {
		return this.menu2son3resid;
	}

	public void setMenu2son3resid(Integer menu2son3resid) {
		this.menu2son3resid = menu2son3resid;
	}

	@Column(name = "menu2son4resid")
	public Integer getMenu2son4resid() {
		return this.menu2son4resid;
	}

	public void setMenu2son4resid(Integer menu2son4resid) {
		this.menu2son4resid = menu2son4resid;
	}

	@Column(name = "menu2son5resid")
	public Integer getMenu2son5resid() {
		return this.menu2son5resid;
	}

	public void setMenu2son5resid(Integer menu2son5resid) {
		this.menu2son5resid = menu2son5resid;
	}

	@Column(name = "menu3son1resid")
	public Integer getMenu3son1resid() {
		return this.menu3son1resid;
	}

	public void setMenu3son1resid(Integer menu3son1resid) {
		this.menu3son1resid = menu3son1resid;
	}

	@Column(name = "menu3son2resid")
	public Integer getMenu3son2resid() {
		return this.menu3son2resid;
	}

	public void setMenu3son2resid(Integer menu3son2resid) {
		this.menu3son2resid = menu3son2resid;
	}

	@Column(name = "menu3son3resid")
	public Integer getMenu3son3resid() {
		return this.menu3son3resid;
	}

	public void setMenu3son3resid(Integer menu3son3resid) {
		this.menu3son3resid = menu3son3resid;
	}

	@Column(name = "menu3son4resid")
	public Integer getMenu3son4resid() {
		return this.menu3son4resid;
	}

	public void setMenu3son4resid(Integer menu3son4resid) {
		this.menu3son4resid = menu3son4resid;
	}

	@Column(name = "menu3son5resid")
	public Integer getMenu3son5resid() {
		return this.menu3son5resid;
	}

	public void setMenu3son5resid(Integer menu3son5resid) {
		this.menu3son5resid = menu3son5resid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createdate", length = 10)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

}
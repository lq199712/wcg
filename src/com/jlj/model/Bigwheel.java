package com.jlj.model;

// default package

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
 * Bigwheel entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bigwheel", catalog = "wcg")
public class Bigwheel implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String ikey;
	private Date timestart;
	private Date timeend;
	private String image;
	private String resume;
	private String publicaccount;
	private Integer currentstate;
	private Integer totimes;
	private Integer isshownum;
	private String prize1;
	private String prizename1;
	private Integer prizenumber1;
	private Float prizeprob1;
	private String prize2;
	private String prizename2;
	private Integer prizenumber2;
	private Float prizeprob2;
	private String prize3;
	private String prizename3;
	private Integer prizenumber3;
	private Float prizeprob3;
	private Integer maxnumofprizes;
	private String remark;
	private Set<Prizer> prizers = new HashSet<Prizer>(0);

	// Constructors

	/** default constructor */
	public Bigwheel() {
	}

	/** full constructor */
	public Bigwheel(String name, String ikey, Date timestart, Date timeend,
			String image, String resume, String publicaccount,
			Integer currentstate, Integer totimes, Integer isshownum,
			String prize1, String prizename1, Integer prizenumber1,
			Float prizeprob1, String prize2, String prizename2,
			Integer prizenumber2, Float prizeprob2, String prize3,
			String prizename3, Integer prizenumber3, Float prizeprob3,
			Integer maxnumofprizes, String remark, Set<Prizer> prizers) {
		this.name = name;
		this.ikey = ikey;
		this.timestart = timestart;
		this.timeend = timeend;
		this.image = image;
		this.resume = resume;
		this.publicaccount = publicaccount;
		this.currentstate = currentstate;
		this.totimes = totimes;
		this.isshownum = isshownum;
		this.prize1 = prize1;
		this.prizename1 = prizename1;
		this.prizenumber1 = prizenumber1;
		this.prizeprob1 = prizeprob1;
		this.prize2 = prize2;
		this.prizename2 = prizename2;
		this.prizenumber2 = prizenumber2;
		this.prizeprob2 = prizeprob2;
		this.prize3 = prize3;
		this.prizename3 = prizename3;
		this.prizenumber3 = prizenumber3;
		this.prizeprob3 = prizeprob3;
		this.maxnumofprizes = maxnumofprizes;
		this.remark = remark;
		this.prizers = prizers;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ikey", length = 50)
	public String getIkey() {
		return this.ikey;
	}

	public void setIkey(String ikey) {
		this.ikey = ikey;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "timestart", length = 19)
	public Date getTimestart() {
		return this.timestart;
	}

	public void setTimestart(Date timestart) {
		this.timestart = timestart;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "timeend", length = 19)
	public Date getTimeend() {
		return this.timeend;
	}

	public void setTimeend(Date timeend) {
		this.timeend = timeend;
	}

	@Column(name = "image", length = 100)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "resume", length = 65535)
	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	@Column(name = "publicaccount")
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@Column(name = "currentstate")
	public Integer getCurrentstate() {
		return this.currentstate;
	}

	public void setCurrentstate(Integer currentstate) {
		this.currentstate = currentstate;
	}

	@Column(name = "totimes")
	public Integer getTotimes() {
		return this.totimes;
	}

	public void setTotimes(Integer totimes) {
		this.totimes = totimes;
	}

	@Column(name = "isshownum")
	public Integer getIsshownum() {
		return this.isshownum;
	}

	public void setIsshownum(Integer isshownum) {
		this.isshownum = isshownum;
	}

	@Column(name = "prize1", length = 50)
	public String getPrize1() {
		return this.prize1;
	}

	public void setPrize1(String prize1) {
		this.prize1 = prize1;
	}

	@Column(name = "prizename1", length = 50)
	public String getPrizename1() {
		return this.prizename1;
	}

	public void setPrizename1(String prizename1) {
		this.prizename1 = prizename1;
	}

	@Column(name = "prizenumber1")
	public Integer getPrizenumber1() {
		return this.prizenumber1;
	}

	public void setPrizenumber1(Integer prizenumber1) {
		this.prizenumber1 = prizenumber1;
	}

	@Column(name = "prizeprob1", precision = 12, scale = 0)
	public Float getPrizeprob1() {
		return this.prizeprob1;
	}

	public void setPrizeprob1(Float prizeprob1) {
		this.prizeprob1 = prizeprob1;
	}

	@Column(name = "prize2", length = 50)
	public String getPrize2() {
		return this.prize2;
	}

	public void setPrize2(String prize2) {
		this.prize2 = prize2;
	}

	@Column(name = "prizename2", length = 50)
	public String getPrizename2() {
		return this.prizename2;
	}

	public void setPrizename2(String prizename2) {
		this.prizename2 = prizename2;
	}

	@Column(name = "prizenumber2")
	public Integer getPrizenumber2() {
		return this.prizenumber2;
	}

	public void setPrizenumber2(Integer prizenumber2) {
		this.prizenumber2 = prizenumber2;
	}

	@Column(name = "prizeprob2", precision = 12, scale = 0)
	public Float getPrizeprob2() {
		return this.prizeprob2;
	}

	public void setPrizeprob2(Float prizeprob2) {
		this.prizeprob2 = prizeprob2;
	}

	@Column(name = "prize3", length = 50)
	public String getPrize3() {
		return this.prize3;
	}

	public void setPrize3(String prize3) {
		this.prize3 = prize3;
	}

	@Column(name = "prizename3", length = 50)
	public String getPrizename3() {
		return this.prizename3;
	}

	public void setPrizename3(String prizename3) {
		this.prizename3 = prizename3;
	}

	@Column(name = "prizenumber3")
	public Integer getPrizenumber3() {
		return this.prizenumber3;
	}

	public void setPrizenumber3(Integer prizenumber3) {
		this.prizenumber3 = prizenumber3;
	}

	@Column(name = "prizeprob3", precision = 12, scale = 0)
	public Float getPrizeprob3() {
		return this.prizeprob3;
	}

	public void setPrizeprob3(Float prizeprob3) {
		this.prizeprob3 = prizeprob3;
	}

	@Column(name = "maxnumofprizes")
	public Integer getMaxnumofprizes() {
		return this.maxnumofprizes;
	}

	public void setMaxnumofprizes(Integer maxnumofprizes) {
		this.maxnumofprizes = maxnumofprizes;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bigwheel")
	public Set<Prizer> getPrizers() {
		return this.prizers;
	}

	public void setPrizers(Set<Prizer> prizers) {
		this.prizers = prizers;
	}

}
package com.jlj.bean;
//INF_APPLY
public class InfApply {
	private String internalNo;//INTERNAL_NO
	private String content;//CONTENT
	private String transactAffairName;//TRANSACT_AFFAIR_NAME
	
	public String getInternalNo() {
		return internalNo;
	}
	public void setInternalNo(String internalNo) {
		this.internalNo = internalNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTransactAffairName() {
		return transactAffairName;
	}
	public void setTransactAffairName(String transactAffairName) {
		this.transactAffairName = transactAffairName;
	}
	@Override
	public String toString() {
		return this.internalNo+","+this.transactAffairName+","+this.content;
	}
	
}

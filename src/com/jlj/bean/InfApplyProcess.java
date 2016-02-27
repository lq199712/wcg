package com.jlj.bean;

//INF_APPLY_PROCESS
public class InfApplyProcess {
	private String internalNo;//INTERNAL_NO
	private String note;//NOTE
	
	public String getInternalNo() {
		return internalNo;
	}
	public void setInternalNo(String internalNo) {
		this.internalNo = internalNo;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return this.internalNo+","+this.note;
	}
	
}

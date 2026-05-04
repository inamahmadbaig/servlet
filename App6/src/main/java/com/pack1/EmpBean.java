package com.pack1;

import java.io.Serializable;

public class EmpBean implements Serializable {
	
	private String eId;
	private String eFName;
	private String eLName;
	private int eSal;
	private String eAdd;
	
	public EmpBean() {
		
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String geteFName() {
		return eFName;
	}
	public void seteFName(String eFName) {
		this.eFName = eFName;
	}
	public String geteLName() {
		return eLName;
	}
	public void seteLName(String eLName) {
		this.eLName = eLName;
	}
	public int geteSal() {
		return eSal;
	}
	public void seteSal(int eSal) {
		this.eSal = eSal;
	}
	public String geteAdd() {
		return eAdd;
	}
	public void seteAdd(String eAdd) {
		this.eAdd = eAdd;
	}
	
	
}

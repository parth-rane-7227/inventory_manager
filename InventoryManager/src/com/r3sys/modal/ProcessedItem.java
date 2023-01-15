package com.r3sys.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="processeditemdetails")
@Component
public class ProcessedItem {
	
	@Id
	private int pid;
	private int pquantity;
	private int pcost;
    private String pname;
    private String punit;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPunit() {
		return punit;
	}
	public void setPunit(String punit) {
		this.punit = punit;
	}
	public ProcessedItem(int pid, int pquantity, int pcost, String pname, String punit) {
		super();
		this.pid = pid;
		this.pquantity = pquantity;
		this.pcost = pcost;
		this.pname = pname;
		this.punit = punit;
	}
	public ProcessedItem() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}

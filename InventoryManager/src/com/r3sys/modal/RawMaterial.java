package com.r3sys.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="rawmaterialdetails")
@Component
public class RawMaterial {
	
	   @Id
       private int rid;
	   private int rquantity;
	   private int rcost;
       private String rname;
       private String runit;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getRquantity() {
		return rquantity;
	}
	public void setRquantity(int rquantity) {
		this.rquantity = rquantity;
	}
	public int getRcost() {
		return rcost;
	}
	public void setRcost(int rcost) {
		this.rcost = rcost;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRunit() {
		return runit;
	}
	public void setRunit(String runit) {
		this.runit = runit;
	}
	public RawMaterial(int rid, int rquantity, int rcost, String rname, String runit) {
		super();
		this.rid = rid;
		this.rquantity = rquantity;
		this.rcost = rcost;
		this.rname = rname;
		this.runit = runit;
	}
	public RawMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
       
	
}

package com.r3sys.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="logsraw")
@Component
public class IssueRawMaterial 
{
	 @Id
      private int iid;
      private int iquantity;
      private String idate;
      private String iname;
      private int irid;
      private String imaterialname;
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public int getIquantity() {
		return iquantity;
	}
	public void setIquantity(int iquantity) {
		this.iquantity = iquantity;
	}
	public String getIdate() {
		return idate;
	}
	public void setIdate(String idate) {
		this.idate = idate;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public int getIrid() {
		return irid;
	}
	public void setIrid(int irid) {
		this.irid = irid;
	}
	public String getImaterialname() {
		return imaterialname;
	}
	public void setImaterialname(String imaterialname) {
		this.imaterialname = imaterialname;
	}
	public IssueRawMaterial(int iid, int iquantity, String idate, String iname, int irid, String imaterialname) {
		super();
		this.iid = iid;
		this.iquantity = iquantity;
		this.idate = idate;
		this.iname = iname;
		this.irid = irid;
		this.imaterialname = imaterialname;
	}
	public IssueRawMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "IssueRawMaterial [iid=" + iid + ", iquantity=" + iquantity + ", idate=" + idate + ", iname=" + iname
				+ ", irid=" + irid + ", imaterialname=" + imaterialname + "]";
	}
     
}

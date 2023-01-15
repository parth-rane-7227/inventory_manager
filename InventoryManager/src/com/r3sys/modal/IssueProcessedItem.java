package com.r3sys.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="logprocessed")
@Component
public class IssueProcessedItem 
{
	@Id
    private int ipid;
    private String pname;
    private String ipname;
    private int ipquantity;
    private String ipdate;
    private int pid;
	public int getIpid() {
		return ipid;
	}
	public void setIpid(int ipid) {
		this.ipid = ipid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getIpname() {
		return ipname;
	}
	public void setIpname(String ipname) {
		this.ipname = ipname;
	}
	public int getIpquantity() {
		return ipquantity;
	}
	public void setIpquantity(int ipquantity) {
		this.ipquantity = ipquantity;
	}
	public String getIpdate() {
		return ipdate;
	}
	public void setIpdate(String ipdate) {
		this.ipdate = ipdate;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public IssueProcessedItem(int ipid, String pname, String ipname, int ipquantity, String ipdate, int pid) {
		super();
		this.ipid = ipid;
		this.pname = pname;
		this.ipname = ipname;
		this.ipquantity = ipquantity;
		this.ipdate = ipdate;
		this.pid = pid;
	}
	public IssueProcessedItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "IssueProcessedItem [ipid=" + ipid + ", ipitemname=" + pname + ", ipname=" + ipname
				+ ", ipquantity=" + ipquantity + ", ipdate=" + ipdate + ", pid=" + pid + "]";
	}
	
    
}

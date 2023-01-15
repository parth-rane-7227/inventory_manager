package com.r3sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.r3sys.Dao.IssueRawMaterialDao;
import com.r3sys.Dao.RawMaterialDao;
import com.r3sys.modal.IssueRawMaterial;
import com.r3sys.modal.RawMaterial;

@Controller
public class IssueRawMaterialController 
{
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	IssueRawMaterialDao issueRawMaterialDao = (IssueRawMaterialDao) context.getBean("issueRawMaterialDao");
	
	ApplicationContext context1=new ClassPathXmlApplicationContext("config.xml");
	RawMaterialDao rawMaterialDao = (RawMaterialDao) context1.getBean("rawMaterialDao");
	
	
	@RequestMapping("/issuedashboard")
	public String issuedashboard()
	{
	return "issuedashboard";
	}
	@RequestMapping("/issuematerial")
	public String issuematerial()                      
	{
	return "issuematerial";
	}
	@RequestMapping("/issueMaterial")
	public RedirectView insertIssueRawMaterial(HttpServletRequest request)
	{
		int new_quantity=Integer.parseInt(request.getParameter("iquantity"));
		System.out.println(new_quantity);
		int irid=Integer.parseInt(request.getParameter("iid"));
		System.out.println(irid);
		String iname=request.getParameter("iname");
		String idate=request.getParameter("idate");
		
		RawMaterial up=rawMaterialDao.getRawMaterial(irid);
		int p=(up.getRquantity()-new_quantity);
		rawMaterialDao.updateRawMaterial(up);
		
		if(new_quantity<=up.getRquantity()){
			up.setRquantity(up.getRquantity()-new_quantity);
			rawMaterialDao.updateRawMaterial(up);
			
			IssueRawMaterial issueRawMaterial= (IssueRawMaterial) context.getBean("issueRawMaterial");
			issueRawMaterial.setIid(0);
			issueRawMaterial.setIrid(irid);
			issueRawMaterial.setImaterialname(up.getRname());
			issueRawMaterial.setIquantity(new_quantity);
			issueRawMaterial.setIname(iname);
			issueRawMaterial.setIdate(idate);
			
			issueRawMaterialDao.insert(issueRawMaterial);
			
			System.out.println(up.getRquantity());
			
			RedirectView redirectView=new RedirectView();
			redirectView.setUrl(request.getContextPath()+"/issueview");
			return redirectView;
		}
		else
		{
			RedirectView redirectView=new RedirectView();
			redirectView.setUrl(request.getContextPath()+"/notsufficient");
			return redirectView;			
		}	
    }
	@RequestMapping("/issueview")
	public String viewprocessedItem(Model m)
	{
		List<IssueRawMaterial> issueRawMaterial = issueRawMaterialDao.getAllIssueRawMaterial();
		m.addAttribute("issueRawMaterial",issueRawMaterial);
		return "issueview";
		
	}
	@RequestMapping("/notsufficient")
	public String notsufficient()
	{
	return "notsufficient";		
	}
}	
	

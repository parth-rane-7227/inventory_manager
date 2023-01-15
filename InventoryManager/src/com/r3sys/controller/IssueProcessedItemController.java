package com.r3sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.r3sys.Dao.IssueProcessedItemDao;        
import com.r3sys.Dao.ProcessedItemDao;
import com.r3sys.modal.IssueProcessedItem;
import com.r3sys.modal.ProcessedItem;

@Controller
public class IssueProcessedItemController 
{
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	IssueProcessedItemDao issueProcessedItemDao = (IssueProcessedItemDao) context.getBean("issueProcessedItemDao");
	
	ApplicationContext context1=new ClassPathXmlApplicationContext("config.xml");
	ProcessedItemDao processedItemDao = (ProcessedItemDao) context1.getBean("processedItemDao");
	
	@RequestMapping("/issueprocesseddashboard")
	public String issueprocesseddashboard()                      
	{
	return "issueprocesseddashboard";
	}
	
	@RequestMapping("/issueprocesseditem")
	public String issueprocesseditem()                      
	{
	return "issueprocesseditem";
	}
	@RequestMapping("/issueProcessedItem")
	public RedirectView insertIssueProcessedItem(HttpServletRequest request)
	{
		int new_quantity=Integer.parseInt(request.getParameter("ipquantity"));
		System.out.println(new_quantity);
		int pid=Integer.parseInt(request.getParameter("ipid"));
		System.out.println(pid);
		String ipname=request.getParameter("ipname");
		String ipdate=request.getParameter("ipdate");
		
		ProcessedItem up=processedItemDao.getProcessedItem(pid);
		int p=(up.getPquantity()-new_quantity);
		processedItemDao.updateProcessedItem(up);
		
		if(new_quantity<=up.getPquantity()){
			up.setPquantity(up.getPquantity()-new_quantity);
			processedItemDao.updateProcessedItem(up);
			
			IssueProcessedItem issueProcessedItem= (IssueProcessedItem) context.getBean("issueProcessedItem");
			issueProcessedItem.setIpid(0);
			issueProcessedItem.setPid(pid);
			issueProcessedItem.setPname(up.getPname());
			issueProcessedItem.setIpquantity(new_quantity);
			issueProcessedItem.setIpname(ipname);
			issueProcessedItem.setIpdate(ipdate);
			
			issueProcessedItemDao.insert(issueProcessedItem);
			
			System.out.println(up.getPquantity());
			
			RedirectView redirectView=new RedirectView();
			redirectView.setUrl(request.getContextPath()+"/issueprocessedview");
			return redirectView;
		}
		else
		{
			RedirectView redirectView=new RedirectView();
			redirectView.setUrl(request.getContextPath()+"/notsufficientprocessed");
			return redirectView;			
		}	
    }
	@RequestMapping("/issueprocessedview")
	public String viewprocessedItem(Model m)
	{
		List<IssueProcessedItem> issueProcessedItem = issueProcessedItemDao.getAllIssueProcessedItem();
		m.addAttribute("issueProcessedItem",issueProcessedItem);
		return "issueprocessedview";
		
	}
}

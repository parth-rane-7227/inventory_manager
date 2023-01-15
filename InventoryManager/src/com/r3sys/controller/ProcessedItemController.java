package com.r3sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.r3sys.Dao.ProcessedItemDao;
import com.r3sys.modal.ProcessedItem;
import com.r3sys.modal.RawMaterial;

@Controller
public class ProcessedItemController {
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	ProcessedItemDao processedItemDao = (ProcessedItemDao) context.getBean("processedItemDao");
	
	@RequestMapping("/pdashboard")
	public String pdashboard()
	{
	return "pdashboard";                   
	}
	@RequestMapping("/processedmaterial")
	public String processedmaterial()
	{
	return "processedmaterial";
	}
	@RequestMapping("/addprocessed")
	public RedirectView insertProcessedItem(@ModelAttribute ProcessedItem processedItem,HttpServletRequest request)
	{
		processedItemDao.insert(processedItem);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/processedviewitem");
		
		return redirectView;
	
    }
	@RequestMapping("/processedviewitem")
	public String viewprocessedItem(Model m)
	{
		List<ProcessedItem> processedItem = processedItemDao.getAllProcessedItem();
		m.addAttribute("processedItem",processedItem);
		return "processedviewitem";
		
	}
	@RequestMapping(path="/delete1/{id}",method= RequestMethod.GET)
	public RedirectView deleteProcessedItem(@PathVariable("id") int id,HttpServletRequest request)
	{
		processedItemDao.deleteProcessedItem(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/processedviewitem");
		
		return redirectView;
	}
	@RequestMapping(value="/updateProcessedQuantity",method= RequestMethod.GET)
	public String rupdatequantity(@RequestParam int id, Model m)
	{
		return "updateProcessedQuantity";
	}
	
	@RequestMapping("/incrementProcessedQuantity")
	public RedirectView incrementProcessedQuantity(HttpServletRequest request)
	{
		System.out.println(request.getParameter("quantity"));
		System.out.println(request.getParameter("id"));
		int new_quantity =Integer.parseInt(request.getParameter("quantity"));
		int id =Integer.parseInt(request.getParameter("id"));
		ProcessedItem updatedProcessedItem = processedItemDao.getProcessedItem(id);
		updatedProcessedItem.setPquantity(updatedProcessedItem.getPquantity()+new_quantity);
		processedItemDao.updateProcessedItem(updatedProcessedItem);
		
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/processedviewitem");
		return redirectView;
		
	}
	
	@RequestMapping("/unprocessed")
	public String unprocessed(Model m)
	{
		List<ProcessedItem> processedItem=processedItemDao.getAllProcessedItem();
		m.addAttribute("processedItem",processedItem);
	    return "unprocessed";
	}
}

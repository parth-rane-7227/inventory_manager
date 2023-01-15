package com.r3sys.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.r3sys.modal.ProcessedItem;

@Component
public class ProcessedItemDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	// inserting the data
	@Transactional //for making transaction with database like insert, delete, update
	public int insert(ProcessedItem processedItem) {
	// insert
	Integer i = (Integer) this.hibernateTemplate.save(processedItem);
	return i;
	}
	
	
	// get the single data(object)
	public ProcessedItem getProcessedItem(int Rid) {
		ProcessedItem processedItem = this.hibernateTemplate.get(ProcessedItem.class, Rid);
	return processedItem;
	}
	
	
	// get all students(all rows)
	public List<ProcessedItem> getAllProcessedItem() {
	List<ProcessedItem> processedItem = this.hibernateTemplate.loadAll(ProcessedItem.class);
	return processedItem;
	}
	
	
	// deleting the data
	@Transactional //for making transaction with database like insert, delete, update
	public void deleteProcessedItem(int Rid) {
		ProcessedItem processedItem = this.hibernateTemplate.get(ProcessedItem.class, Rid);
	this.hibernateTemplate.delete(processedItem);
	}
	
	
	// updating data...
	@Transactional //for making transaction with database like insert, delete, update
	public void updateProcessedItem(ProcessedItem processedItem) {
	this.hibernateTemplate.update(processedItem);
	}
	
	public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
	}

}

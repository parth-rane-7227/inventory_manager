package com.r3sys.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.r3sys.modal.IssueProcessedItem;

@Component
public class IssueProcessedItemDao 
{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	// inserting the data
	@Transactional //for making transaction with database like insert, delete, update
	public int insert(IssueProcessedItem issueProcessedItem) {
	// insert
	Integer i = (Integer) this.hibernateTemplate.save(issueProcessedItem);
	return i;
	}
	
	
	// get the single data(object)
	public IssueProcessedItem getIssueProcessedItem(int Rid) {
		IssueProcessedItem issueProcessedItem = this.hibernateTemplate.get(IssueProcessedItem.class, Rid);
	return issueProcessedItem;
	}
	
	
	// get all students(all rows)
	public List<IssueProcessedItem> getAllIssueProcessedItem() {
	List<IssueProcessedItem> issueProcessedItem = this.hibernateTemplate.loadAll(IssueProcessedItem.class);
	return issueProcessedItem;
	}
	
	// deleting the data
	@Transactional //for making transaction with database like insert, delete, update
	public void deleteIssueProcessedItem(int Rid) {
		IssueProcessedItem issueProcessedItem = this.hibernateTemplate.get(IssueProcessedItem.class, Rid);
	this.hibernateTemplate.delete(issueProcessedItem);
	}
	
	
	// updating data...
	@Transactional //for making transaction with database like insert, delete, update
	public void updateIssueProcessedItem(IssueProcessedItem issueProcessedItem) {
	this.hibernateTemplate.update(issueProcessedItem);
	}
	
	public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
	}
}

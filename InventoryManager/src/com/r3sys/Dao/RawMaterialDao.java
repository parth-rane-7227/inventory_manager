package com.r3sys.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.r3sys.modal.RawMaterial;

@Component
public class RawMaterialDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	// inserting the data
	@Transactional //for making transaction with database like insert, delete, update
	public int insert(RawMaterial rawMaterial) {
	// insert
	Integer i = (Integer) this.hibernateTemplate.save(rawMaterial);
	return i;
	}
	
	
	// get the single data(object)
	public RawMaterial getRawMaterial(int Rid) {
		RawMaterial rawMaterial = this.hibernateTemplate.get(RawMaterial.class, Rid);
	return rawMaterial;
	}
	
	
	// get all students(all rows)
	public List<RawMaterial> getAllRawMaterial() {
	List<RawMaterial> rawMaterial = this.hibernateTemplate.loadAll(RawMaterial.class);
	return rawMaterial;
	}
	
	
	// deleting the data
	@Transactional //for making transaction with database like insert, delete, update
	public void deleteRawMaterial(int Rid) {
		RawMaterial rawMaterial = this.hibernateTemplate.get(RawMaterial.class, Rid);
	this.hibernateTemplate.delete(rawMaterial);
	}
	
	
	// updating data...
	@Transactional //for making transaction with database like insert, delete, update
	public void updateRawMaterial(RawMaterial rawMaterial) {
	this.hibernateTemplate.update(rawMaterial);
	}
	
	public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
	}
}

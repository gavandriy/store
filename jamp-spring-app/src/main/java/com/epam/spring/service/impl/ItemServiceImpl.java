package com.epam.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.spring.dao.ItemDAO;
import com.epam.spring.model.Item;
import com.epam.spring.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	public void refresh(Item item) {
		itemDAO.refresh(item);			
	}

	@Override
	public Item add(Item item) {
		return itemDAO.add(item);

	}

	@Override
	public boolean remove(Item item) {
		return itemDAO.remove(item);

	}

	@Override
	public Item getById(Long id) {
		return itemDAO.getById(id);
	}

	@Override
	public List<Item> getAll() {
		return itemDAO.getAll();
	}

	@Override
	public boolean update(Item item) {
		return itemDAO.remove(item);
	}

	@Override
	public Item getItemByArticulName(String articulName) {
		return itemDAO.getItemByArticulName(articulName);
	}

	@Override
	public Item getItemByBarcode(String barcode) {
		return itemDAO.getItemByBarcode(barcode);
	}

}

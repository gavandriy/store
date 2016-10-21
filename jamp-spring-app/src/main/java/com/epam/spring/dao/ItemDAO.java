package com.epam.spring.dao;

import com.epam.spring.model.Item;

public interface ItemDAO extends CommonDAO<Item>{
	
	Item getItemByArticulName(String articulName);
	
	Item getItemByBarcode(String barcode);

}

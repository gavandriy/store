package com.epam.spring.service;

import com.epam.spring.model.Articul;
import com.epam.spring.model.Item;

public interface ItemService extends CommonService<Item>{
	
	Item getItemByArticulName(String articulName);
	
	Item getItemByBarcode(String barcode);
	
	

}

package com.epam.spring.dao;

import com.epam.spring.model.Articul;

public interface ArticulDAO extends CommonDAO<Articul>{
	
	Articul getArticulByArticulName(String articulName);

}

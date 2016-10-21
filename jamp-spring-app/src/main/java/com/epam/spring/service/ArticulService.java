package com.epam.spring.service;

import com.epam.spring.model.Articul;

public interface ArticulService extends CommonService<Articul>{

	Articul getArticulByArticulName(String articulName);
}

package com.epam.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.spring.dao.ArticulDAO;
import com.epam.spring.model.Articul;
import com.epam.spring.service.ArticulService;

@Service
@Transactional
public class ArticulServiceImpl implements ArticulService{

	@Autowired
	private ArticulDAO articulDAO;
	
	@Override
	public void refresh(Articul articul) {
		articulDAO.refresh(articul);		
	}

	@Override
	public Articul add(Articul articul) {
		return articulDAO.add(articul);
	}

	@Override
	public boolean remove(Articul articul) {
		return articulDAO.remove(articul);
	}

	@Override
	public Articul getById(Long id) {
		return articulDAO.getById(id);

	}

	@Override
	public List<Articul> getAll() {
		return articulDAO.getAll();

	}

	@Override
	public boolean update(Articul articul) {
		return articulDAO.remove(articul);
	}

	@Override
	public Articul getArticulByArticulName(String articulName) {
		return articulDAO.getArticulByArticulName(articulName);
	}

}

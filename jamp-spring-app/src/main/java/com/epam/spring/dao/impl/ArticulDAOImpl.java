package com.epam.spring.dao.impl;

import java.util.Iterator;


import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.epam.spring.dao.ArticulDAO;
import com.epam.spring.model.Articul;
import com.epam.spring.model.User;

@Repository
public class ArticulDAOImpl extends CommonDAOImpl<Articul> implements ArticulDAO{

	@PostConstruct
	public void init() {
		targetClass = User.class;
	}
	
	@Override
	public Articul getArticulByArticulName(String articulName) {
		Session session = ((Session) entityManager.getDelegate());
		Query findByArticulNameQuery = session.createQuery("from Articul a  where a.articul_name = :articul_name ");
		findByArticulNameQuery.setParameter("articul_name", articulName);
		Iterator<Articul> iterate = findByArticulNameQuery.iterate();
		if (iterate.hasNext()) {
			return (Articul) iterate.next();
		} else {
			return null;
		}
	}

}

package com.epam.spring.dao.impl;

import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.epam.spring.dao.ItemDAO;
import com.epam.spring.model.Item;
import com.epam.spring.model.User;

@Repository
public class ItemDAOImpl extends CommonDAOImpl<Item> implements ItemDAO {

	@PostConstruct
	public void init() {
		targetClass = User.class;
	}

	@Override
	public Item getItemByArticulName(String articulName) {
		Session session = ((Session) entityManager.getDelegate());
		Query findByArticulNameQuery = session
				.createQuery("from Item i  where i.articul = :articul ");
		findByArticulNameQuery.setParameter("articul", articulName);
		Iterator<Item> iterate = findByArticulNameQuery.iterate();
		if (iterate.hasNext()) {
			return (Item) iterate.next();
		} else {
			return null;
		}
	}

	@Override
	public Item getItemByBarcode(String barcode) {
		Session session = ((Session) entityManager.getDelegate());
		Query findByBarcodeQuery = session
				.createQuery("from Item i  where i.barcode = :barcode ");
		findByBarcodeQuery.setParameter("barcode", barcode);
		Iterator<Item> iterate = findByBarcodeQuery.iterate();
		if (iterate.hasNext()) {
			return (Item) iterate.next();
		} else {
			return null;
		}
	}

}

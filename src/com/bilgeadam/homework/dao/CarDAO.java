package com.bilgeadam.homework.dao;

import java.util.ArrayList;
import org.hibernate.Session;

import com.bilgeadam.homework.model.Car;
import com.bilgeadam.homework.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class CarDAO implements DatabaseCRUDable<Car> {
	@Override
	public ArrayList<Car> retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM Car AS xxx";
		TypedQuery<Car> typedQuery = session.createQuery(hql, Car.class);

		ArrayList<Car> data = (ArrayList<Car>) typedQuery.getResultList();
		return data;
	}

	@Override
	public Car find(long oid) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String hql = "SELECT xxx FROM Car AS xxx WHERE xxx.oid =: key";
		TypedQuery<Car> typedQuery = session.createQuery(hql, Car.class);
		typedQuery.setParameter("key", oid);

		Car data = (Car) typedQuery.getSingleResult();
		return data;
	}
}

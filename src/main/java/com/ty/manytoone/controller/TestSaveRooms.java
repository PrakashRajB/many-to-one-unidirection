package com.ty.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytoone.dto.Hotel;
import com.ty.manytoone.dto.Room;

public class TestSaveRooms {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hotel hotel = new Hotel();
		hotel.setName("Hilton");
		hotel.setAddress("ECR road");

		// Hotel hotel = entityManager.find(Hotel.class, 1);

		Room room1 = new Room();
		room1.setType("Ac ultra");
		room1.setCapacity(2);
		room1.setHotel(hotel);

		Room room2 = new Room();
		room2.setType("Ac delux");
		room2.setCapacity(4);
		room2.setHotel(hotel);

		entityTransaction.begin();
		entityManager.persist(room1);
		entityManager.persist(room2);
		entityManager.persist(hotel);
		entityTransaction.commit();

		System.out.println("-------data Stored-------");
	}

}

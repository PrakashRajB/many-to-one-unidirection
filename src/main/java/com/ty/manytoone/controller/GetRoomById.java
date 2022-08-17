package com.ty.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytoone.dto.Room;

public class GetRoomById {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Room room = entityManager.find(Room.class, 1);
		if (room != null) {
			System.out.println("Hotel Name is " + room.getHotel().getName());
			System.out.println("Room Id is " + room.getId());
			System.out.println("Room Type is " + room.getType());
			System.out.println("Room capacity is " + room.getCapacity());
			System.out.println("----------------------------------------");
		}
	}

}

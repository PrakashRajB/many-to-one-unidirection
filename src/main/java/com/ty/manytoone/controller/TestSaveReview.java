package com.ty.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytoone.dto.Product;
import com.ty.manytoone.dto.Review;

public class TestSaveReview {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Product product = new Product();
		product.setName("Moto g10");
		product.setBrand("MOTOROLO");
		product.setCost(160000);

		Review review1 = new Review();
		review1.setUserName("Karthick");
		review1.setDescription("Battery is good and Charging time is less");
		review1.setProduct(product);

		Review review2 = new Review();
		review2.setUserName("Akhilesh");
		review2.setDescription("Display quality is not worth for the money");
		review2.setProduct(product);

		Review review3 = new Review();
		review3.setUserName("Raja");
		review3.setDescription("Budget friendly");
		review3.setProduct(product);

		entityTransaction.begin();
		entityManager.persist(product);
		entityManager.persist(review1);
		entityManager.persist(review2);
		entityManager.persist(review3);
		entityTransaction.commit();
		System.out.println("----data Stored----");
	}

}

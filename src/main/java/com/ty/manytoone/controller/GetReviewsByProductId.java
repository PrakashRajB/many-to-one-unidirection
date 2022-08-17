package com.ty.manytoone.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.manytoone.dto.Review;

public class GetReviewsByProductId {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "SELECT r FROM Review r WHERE product_id =?1";

		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, 1);

		List<Review> reviews = query.getResultList();
		System.out.println("Product Id - " + reviews.get(0).getProduct().getId());
		System.out.println("Product Name - " + reviews.get(0).getProduct().getName());

		for (Review r : reviews) {
			System.out.println("Review Id - " + r.getId());
			System.out.println("Reviewed By User - " + r.getUserName());
			System.out.println("Description About Product - " + r.getDescription());
			System.out.println("----------------------------------------");
		}
	}

}

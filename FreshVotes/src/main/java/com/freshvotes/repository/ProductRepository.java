package com.freshvotes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.freshvotes.domain.Product;
import com.freshvotes.domain.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByUser(User user);

	@Query("SELECT p FROM Product p JOIN FETCH p.user WHERE p.id = :id ")
	Optional<Product> findByIdWithUser(Long id);
}

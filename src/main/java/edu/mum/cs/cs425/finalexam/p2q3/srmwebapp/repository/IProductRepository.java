package edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.repository;

import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}

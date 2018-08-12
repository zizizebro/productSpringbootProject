package edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.service;

import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();
    Product addNewProduct(Product product);

}

package edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.service.impl;

import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.model.Product;
import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.repository.IProductRepository;
import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll(Sort.by("name"));
    }

    @Override
    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findByProductNumber(Long productNumber) {
        return productRepository.findAll().stream()
                .filter(p -> p.getProductNumber().equals(productNumber))
                .findFirst();
    }


    }



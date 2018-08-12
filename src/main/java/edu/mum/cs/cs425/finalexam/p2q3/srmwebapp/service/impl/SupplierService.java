package edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.service.impl;

import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.model.Supplier;
import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.repository.ISupplierRepository;
import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService implements ISupplierService {

    @Autowired
    private ISupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll(Sort.by("name"));
    }

    @Override
    public Supplier addNewSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
}

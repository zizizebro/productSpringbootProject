package edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.service;

import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.model.Supplier;

import java.util.List;

public interface ISupplierService {

    List<Supplier> getAllSuppliers();
    Supplier addNewSupplier(Supplier supplier);

}

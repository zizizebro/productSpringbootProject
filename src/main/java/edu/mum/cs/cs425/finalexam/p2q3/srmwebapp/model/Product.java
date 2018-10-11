package edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.model;

import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.model.validators.UniqueProductNumber;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    @NotNull(message = "* Product Number is required")
    @UniqueProductNumber
    private Long productNumber;

    @NotNull(message = "*Product Name is required")
    @NotBlank(message = "* Product Name is required")
    private String name;

    @NotNull(message = "* Unit Price is required")
    @Digits(integer = 9, fraction = 2, message = "* Unit Price must be a numeric/monetary amount in decimal (money) format as 'xxx.xx'")
    @NumberFormat(pattern = "#,###.##")
    private double unitPrice;

    @NotNull(message = "* Quantity in stock is required")
    @Digits(integer = 9, fraction = 0, message = "* Quantity must be a positive, integral value")
    @PositiveOrZero(message = "* Quantity must be a positive, integral value")
    private int quantityInStock;

    @NotNull(message = "* Date supplied is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSupplied;

    @ManyToOne()
    @JoinColumn(name = "supplierId", nullable = false)
    @NotNull(message = "* Supplier is required")
    private Supplier supplier;

    public Product() { }

    public Product(Long productNumber, String name, double unitPrice,
                   int quantityInStock, LocalDate dateSupplied) {
        this.productNumber = productNumber;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.dateSupplied = dateSupplied;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}

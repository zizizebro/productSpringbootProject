package edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.model.validators;

import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueProductNumberValidator implements ConstraintValidator<UniqueProductNumber, Long> {

    @Autowired
    private IProductService productService;

    public UniqueProductNumberValidator() { }

    public UniqueProductNumberValidator(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public void initialize(UniqueProductNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long productNumber, ConstraintValidatorContext context) {
        boolean valid;
        if(productService != null) {
            valid = (productNumber != null && !productService.findByProductNumber(productNumber).isPresent());
        } else {
            valid = true;
        }
        return valid;
    }
}

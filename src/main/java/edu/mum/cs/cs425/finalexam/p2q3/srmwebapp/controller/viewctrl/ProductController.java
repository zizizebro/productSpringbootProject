package edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.controller.viewctrl;

import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.model.Product;
import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.model.Supplier;
import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.service.IProductService;
import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/srm/secured/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ISupplierService supplierService;

    @GetMapping(value = "/browse")
    public ModelAndView displayListOfProducts() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.getAllProducts();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("secured/product/browse");
        return modelAndView;
    }


    @GetMapping(value = "/new")
//    public ModelAndView newProductForm(Model model) {
    public String newProductForm(Model model) {
//        ModelAndView modelAndView = new ModelAndView();
        List<Supplier> suppliers = supplierService.getAllSuppliers();
//        modelAndView.addObject("suppliers", suppliers);
//        modelAndView.setViewName("secured/product/new");
        model.addAttribute("product", new Product());
        model.addAttribute("suppliers", suppliers);
//        return modelAndView;
        return "secured/product/new";
    }

    @PostMapping(value = "/new")
    public String addNewProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<Supplier> suppliers = supplierService.getAllSuppliers();
            model.addAttribute("suppliers", suppliers);
            return "secured/product/new";
        }
        product = productService.addNewProduct(product);
        return "redirect:/srm/secured/product/browse";
    }

    /*@GetMapping("/pro/update")
    public String showFormForUpdate(@RequestParam("productId") Long proId, Model theModel) {

        // get the employee from the service
        Optional<Product> theProduct = productService.findByProductNumber(proId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("product", theProduct);

        // send over to our form
        return "product/new";
    }


*/
}

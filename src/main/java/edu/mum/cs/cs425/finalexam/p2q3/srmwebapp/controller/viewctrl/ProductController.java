package edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.controller.viewctrl;

import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.model.Product;
import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.model.Supplier;
import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.service.IProductService;
import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

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
    public ModelAndView newProductForm(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.setViewName("secured/product/new");
        model.addAttribute("product", new Product());
        return modelAndView;
    }

    @PostMapping(value = "/new")
    public String addNewProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/product/new";
        }
        product = productService.addNewProduct(product);
        return "redirect:/srm/secured/product/browse";
    }
}

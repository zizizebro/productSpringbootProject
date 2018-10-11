package edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.controller.viewctrl;

import edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.model.Supplier;
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
@RequestMapping(value = "/srm/secured/supplier")
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;

    @GetMapping(value = "/browse")
    public ModelAndView displayListOfSuppliers() {
        ModelAndView modelAndView = new ModelAndView();
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.setViewName("secured/supplier/browse");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String newSupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "secured/supplier/new";
    }

    @PostMapping(value = "/new")
    public String addNewSupplier(@Valid @ModelAttribute("supplier") Supplier supplier,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/supplier/new";
        }
        supplier = supplierService.addNewSupplier(supplier);
        return "redirect:/srm/secured/supplier/browse";
    }

}

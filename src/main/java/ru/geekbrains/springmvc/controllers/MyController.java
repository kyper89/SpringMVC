package ru.geekbrains.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.springmvc.model.entity.Product;
import ru.geekbrains.springmvc.model.repository.ProductRepository;

@Controller
@RequestMapping("/")
public class MyController {

    private final ProductRepository productRepository;

    public MyController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("message", "Hello World");
        return "index";
    }

    @GetMapping(value = "/products")
    public String products(Model uiModel){
        uiModel.addAttribute("products", productRepository.getProducts());
        return "products";
    }

    @GetMapping(value = "/products/add")
    public String addProducts(Model uiModel){
        uiModel.addAttribute("product", new Product());
        return "addingProducts";
    }

    @PostMapping(value = "/products/add")
    public String create(Product product) {
        productRepository.saveProduct(product);
        return "addingProducts";
    }

}

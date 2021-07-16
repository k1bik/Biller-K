package ru.keebi.TelegramBot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.keebi.TelegramBot.Entity.Product;
import ru.keebi.TelegramBot.service.ProductServiceImpl;

import java.util.List;

@RestController
public class RestProductController {

    private final ProductServiceImpl productService;

    public RestProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("rest/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping(value = "rest/products", params = {"name"})
    public Product getProductsByName(@RequestParam String name){
        return productService.getProductsByName(name);
    }

    @RequestMapping(value = "rest/products", params = {"id"})
    public Product getProductById(@RequestParam Long id){
        return productService.getProductById(id);
    }

    @RequestMapping(value = "rest/getTopPopular", params = {"top"})
    public List<Product> getTopPopular(@RequestParam Integer top){
        return productService.getTopPopular(top);
    }

    @RequestMapping(value = "rest/products", params = {"categoryId"})
    public List<Product> getCategoryProducts(@RequestParam Long categoryId){
        return productService.getCategoryProducts(categoryId);
    }

    @RequestMapping(value = "/rest/listClientProducts", params = {"id"})
    public List<Product> getClientProducts(@RequestParam Long id){
        return productService.getClientProducts(id);
    }

}

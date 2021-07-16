package ru.keebi.TelegramBot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.keebi.TelegramBot.Entity.Category;
import ru.keebi.TelegramBot.service.CategoryServiceImpl;

import java.util.List;

@RestController
public class RestCategoryController {

    private final CategoryServiceImpl clientService;

    public RestCategoryController(CategoryServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping("rest/categories")
    public List<Category> getAllCategories(){
        return clientService.getAllCategories();
    }

}

package ru.keebi.TelegramBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.keebi.TelegramBot.Entity.Category;
import ru.keebi.TelegramBot.Repos.CategoryRepo;
import ru.keebi.TelegramBot.service.interfaces.CategoryService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

}

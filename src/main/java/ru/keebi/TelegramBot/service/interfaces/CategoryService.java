package ru.keebi.TelegramBot.service.interfaces;

import ru.keebi.TelegramBot.Entity.Category;

import java.util.List;

/**
 * Сервис для работы с Категориями
 */

public interface CategoryService {

    /**
     * Возвращает список всех категорий
     */
    List<Category> getAllCategories();

}

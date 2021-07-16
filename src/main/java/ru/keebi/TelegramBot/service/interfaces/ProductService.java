package ru.keebi.TelegramBot.service.interfaces;

import ru.keebi.TelegramBot.Entity.Product;

import java.util.List;

/**
 * Сервис для работы с Продуктами
 */

public interface ProductService {

    /**
     * Возвращает список всех товаров
     */
    List<Product> getAllProducts();

    /**
     * Возвращает товар по его идентификатору
     * @param id идентификатор товар
     */
    Product getProductById(Long id);

    /**
     * Возвращает товар по его описанию
     * @param name описание товара
     */
    Product getProductsByName(String name);

    /**
     * Возвращает список товаров в категории
     * @param id идентификатор категории
     */
    List<Product> getCategoryProducts(Long id);

    /**
     * Возвращает указанное кол-во самых популярных товаров среди
     клиентов
     * @param top кол-во товаров
     */
    List<Product> getTopPopular(Integer top);

    /**
     * Возвращает список всех товаров купленных когда-либо клиентом
     * @param id идентификатор клиента
     */
    List<Product> getClientProducts(Long id);

}

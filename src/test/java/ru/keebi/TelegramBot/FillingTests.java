package ru.keebi.TelegramBot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import ru.keebi.TelegramBot.Entity.Category;
import ru.keebi.TelegramBot.Entity.Client;
import ru.keebi.TelegramBot.Entity.Product;
import ru.keebi.TelegramBot.Repos.CategoryRepo;
import ru.keebi.TelegramBot.Repos.ClientRepo;
import ru.keebi.TelegramBot.Repos.ProductRepo;


@SpringBootTest
public class FillingTests {

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    private Category getCategoryByName(String name){

        Category category = new Category();
        category.setName(name);
        return categoryRepo.findOne(Example.of(category)).orElse(null);

    }

    private void saveClient(String address, Long externalId, String fullName, Integer phoneNumber){

        Client client = new Client();
        client.setAddress(address);
        client.setExternalId(externalId);
        client.setFullName(fullName);
        client.setPhoneNumber(phoneNumber);

        clientRepo.save(client);
    }

    private void saveCategory (String name, Long parent){

        Category category = new Category();
        category.setName(name);
        category.setParent(parent);

        categoryRepo.save(category);
    }

    private void saveProduct (Category category, String name, String description, Double price){

        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setDescription(description);
        product.setPrice(price);

        productRepo.save(product);
    }

    @Test
    public void createTwoClients(){

        saveClient("address1", 1L, "fullName1", 123 );
        saveClient("address2", 2L, "fullName2", 321 );

    }

    @Test
    public void createCategories(){

        //Основные категории
        saveCategory("Pizza", 0L);
        saveCategory("Rolls", 1L);
        saveCategory("Burgers", 2L);
        saveCategory("Drinks", 3L);

        //Категория Роллы
        saveCategory("Classical Rolls", 1L);
        saveCategory("Baked Rolls", 1L);
        saveCategory("Sweet Rolls", 1L);
        saveCategory("Sets", 1L);

        //Категория Бургеры
        saveCategory("Classical Burgers", 2L);
        saveCategory("Spicy Burgers", 2L);

        //Категория Напитки
        saveCategory("Сarbonated Drinks", 3L);
        saveCategory("Energy Drinks", 3L);
        saveCategory("Juices Drinks", 3L);
        saveCategory("Others Drinks", 3L);

    }

    @Test
    public void createProducts(){

        //Пицца
        saveProduct(getCategoryByName("Pizza"), "4 cheese", "a lot of cheese", 1000.0);
        saveProduct(getCategoryByName("Pizza"), "Margherita", "tasty", 2000.0);
        saveProduct(getCategoryByName("Pizza"), "Marinara", "tasty", 1500.0);

        //Роллы
        saveProduct(getCategoryByName("Classical Rolls"), "Nigiri", "tasty", 900.0);
        saveProduct(getCategoryByName("Classical Rolls"), "Sashimi", "tasty", 750.0);
        saveProduct(getCategoryByName("Classical Rolls"), "Maki", "tasty", 300.0);

        saveProduct(getCategoryByName("Baked Rolls"), "Uramaki", "tasty", 600.0);
        saveProduct(getCategoryByName("Baked Rolls"), "Tekami", "tasty", 1200.0);
        saveProduct(getCategoryByName("Baked Rolls"), "Anago", "tasty", 500.0);

        saveProduct(getCategoryByName("Sweet Rolls"), "Hamachi", "tasty", 1800.0);
        saveProduct(getCategoryByName("Sweet Rolls"), "Ika", "tasty", 1500.0);
        saveProduct(getCategoryByName("Sweet Rolls"), "Hireme", "tasty", 1400.0);

        saveProduct(getCategoryByName("Sets"), "Ivasi", "tasty", 2500.0);
        saveProduct(getCategoryByName("Sets"), "Kani", "tasty", 2300.0);
        saveProduct(getCategoryByName("Sets"), "Maguro", "tasty", 3300.0);

        //Бургеры
        saveProduct(getCategoryByName("Classical Burgers"), "Bigtesty", "tasty", 150.0);
        saveProduct(getCategoryByName("Classical Burgers"), "Bigmag", "tasty", 200.0);
        saveProduct(getCategoryByName("Classical Burgers"), "Chikenburger", "tasty", 49.0);

        saveProduct(getCategoryByName("Spicy Burgers"), "Blackburger", "tasty", 300.0);
        saveProduct(getCategoryByName("Spicy Burgers"), "Spicyburger", "tasty", 200.0);
        saveProduct(getCategoryByName("Spicy Burgers"), "Hardburger", "tasty", 500.0);

        //Напитки
        saveProduct(getCategoryByName("Сarbonated Drinks"), "Water", "tasty", 100.0);
        saveProduct(getCategoryByName("Сarbonated Drinks"), "Lemonade", "tasty", 49.0);
        saveProduct(getCategoryByName("Сarbonated Drinks"), "Beer", "tasty", 180.0);

        saveProduct(getCategoryByName("Energy Drinks"), "Red bull", "tasty", 200.0);
        saveProduct(getCategoryByName("Energy Drinks"), "Tornado", "tasty", 100.0);
        saveProduct(getCategoryByName("Energy Drinks"), "Eon", "tasty", 30.0);

        saveProduct(getCategoryByName("Juices Drinks"), "Apple", "tasty", 40.0);
        saveProduct(getCategoryByName("Juices Drinks"), "Orange", "tasty", 50.0);
        saveProduct(getCategoryByName("Juices Drinks"), "Banan", "tasty", 60.0);

        saveProduct(getCategoryByName("Others Drinks"), "Tea", "tasty", 70.0);
        saveProduct(getCategoryByName("Others Drinks"), "Coffee", "tasty", 50.0);
        saveProduct(getCategoryByName("Others Drinks"), "Fruit drink", "tasty", 30.0);

    }
}

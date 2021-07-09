package ru.keebi.TelegramBot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.keebi.TelegramBot.Entity.Category;
import ru.keebi.TelegramBot.Entity.Client;
import ru.keebi.TelegramBot.Repos.CategoryRepo;
import ru.keebi.TelegramBot.Repos.ClientRepo;

import javax.swing.plaf.PanelUI;

@SpringBootTest
public class FillingTests {

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    public void createTwoClients(){

        Client client1 = new Client();
        client1.setAddress("address1");
        client1.setExternalId(1);
        client1.setFullName("fullName1");
        clientRepo.save(client1);

        Client client2 = new Client();
        client2.setAddress("address1");
        client2.setExternalId(1);
        client2.setFullName("fullName1");
        clientRepo.save(client2);

    }

    @Test
    public void createCategories(){

        //-------------------------------------------Основные категории
        //Пицца
        Category categoryPizza = new Category();
        categoryPizza.setName("Pizza");
        categoryPizza.setParent(0);
        categoryRepo.save(categoryPizza);

        //Роллы
        Category categoryRolls = new Category();
        categoryRolls.setName("Rolls");
        categoryRolls.setParent(1);
        categoryRepo.save(categoryRolls);

        //Бургеры
        Category categoryBurgers = new Category();
        categoryBurgers.setName("Burgers");
        categoryBurgers.setParent(2);
        categoryRepo.save(categoryBurgers);

        //Напитки
        Category categoryDrinks = new Category();
        categoryDrinks.setName("Drinks");
        categoryDrinks.setParent(3);
        categoryRepo.save(categoryDrinks);


        //-------------------------------------------Категория Роллы
        Category ClassicalRolls = new Category();
        ClassicalRolls.setName("Classical Rolls");
        ClassicalRolls.setParent(1);
        categoryRepo.save(ClassicalRolls);

        Category BakedRolls = new Category();
        BakedRolls.setName("Baked Rolls");
        BakedRolls.setParent(1);
        categoryRepo.save(BakedRolls);

        Category SweetRolls = new Category();
        SweetRolls.setName("Sweet Rolls");
        SweetRolls.setParent(1);
        categoryRepo.save(SweetRolls);

        Category RollSets = new Category();
        RollSets.setName("Sets");
        RollSets.setParent(1);
        categoryRepo.save(RollSets);


        //-------------------------------------------Категория Бургеры
        Category ClassicalBurgers = new Category();
        ClassicalBurgers.setName("Classical Burgers");
        ClassicalBurgers.setParent(2);
        categoryRepo.save(ClassicalBurgers);

        Category SpicyBurgers = new Category();
        SpicyBurgers.setName("Spicy Rolls");
        SpicyBurgers.setParent(2);
        categoryRepo.save(SpicyBurgers);


        //-------------------------------------------Категория Напитки
        Category СarbonatedDrinks  = new Category();
        СarbonatedDrinks.setName("Сarbonated Drinks");
        СarbonatedDrinks.setParent(3);
        categoryRepo.save(СarbonatedDrinks);

        Category EnergyDrinks = new Category();
        EnergyDrinks.setName("Energy Drinks");
        EnergyDrinks.setParent(3);
        categoryRepo.save(EnergyDrinks);

        Category JuicesDrinks = new Category();
        JuicesDrinks.setName("Juices Drinks");
        JuicesDrinks.setParent(3);
        categoryRepo.save(JuicesDrinks);

        Category OthersDrinks = new Category();
        OthersDrinks.setName("Others Drinks");
        OthersDrinks.setParent(3);
        categoryRepo.save(OthersDrinks);
    }
}

package ru.keebi.TelegramBot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.keebi.TelegramBot.Entity.*;
import ru.keebi.TelegramBot.Repos.*;

@SpringBootTest
public class FillingTests {

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ClientOrderRepo clientOrderRepo;

    @Autowired
    private OrderProductRepo orderProductRepo;

    public Client createClient(String fullName, String address, Long externalId, Integer phoneNumber){

        Client client = new Client();

        client.setFullName(fullName);
        client.setAddress(address);
        client.setExternalId(externalId);
        client.setPhoneNumber(phoneNumber);

        clientRepo.save(client);
        return client;

    }

    public Category createCategory(String name, Long parent){

        Category category = new Category();
        category.setName(name);
        category.setParent(parent);

        categoryRepo.save(category);
        return category;

    }

    public Product createProduct(String name, String description, Double price, Category category){

        Product product = new Product();

        product.setCategory(category);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        productRepo.save(product);
        return product;

    }

    public ClientOrder createClientOrder(Integer status, Double total, Client client){

        ClientOrder clientOrder = new ClientOrder();

        clientOrder.setStatus(status);
        clientOrder.setTotal(total);
        clientOrder.setClient(client);

        clientOrderRepo.save(clientOrder);
        return clientOrder;

    }

    public OrderProduct createOrderProduct(Integer countProduct, ClientOrder clientOrder, Product product){

        OrderProduct orderProduct = new OrderProduct();

        orderProduct.setCountProduct(countProduct);
        orderProduct.setOrder(clientOrder);
        orderProduct.setProduct(product);

        orderProductRepo.save(orderProduct);
        return orderProduct;
    }

    @Test
    public void createTests(){

        //Clients
        Client client1 = createClient("Kirill","address1",4L,2134);
        Client client2 = createClient("Sonya","address2",3L,6574);
        Client client3 = createClient("Dasha","address3",2L,8642);
        Client client4 = createClient("Alla","address4",6L,5343);
        Client client5 = createClient("Vlad","address5",7L,7654);

        //Orders
        ClientOrder clientOrder1 = createClientOrder(1,1000.00, client3);
        ClientOrder clientOrder2 = createClientOrder(1,2000.00, client2);
        ClientOrder clientOrder3 = createClientOrder(0,700.00, client1);
        ClientOrder clientOrder4 = createClientOrder(1,1200.00, client5);
        ClientOrder clientOrder5 = createClientOrder(0,900.00, client1);
        ClientOrder clientOrder6 = createClientOrder(1,999.00, client1);
        ClientOrder clientOrder7 = createClientOrder(0,150.00, client3);
        ClientOrder clientOrder8 = createClientOrder(1,1800.00, client5);
        ClientOrder clientOrder9 = createClientOrder(1,1800.00, client5);

        //Main category
        Category category1 = createCategory("Pizza",0L);
        Category category2 = createCategory("Rolls",0L);
        Category category3 = createCategory("Burgers",0L);
        Category category4 = createCategory("Drinks",0L);

        //Pizza
        Category category1c1 = createCategory("Meat pizza", category1.getId());
        Category category1c2 = createCategory("Sweet pizza", category1.getId());
        Category category1c3 = createCategory("Spicy pizza", category1.getId());

        //Rolls
        Category category2c1 = createCategory("Classical Rolls", category2.getId());
        Category category2c2 = createCategory("Baked Rolls", category2.getId());
        Category category2c3 = createCategory("Sweet Rolls", category2.getId());
        Category category2c4 = createCategory("Sets", category2.getId());

        //Burgers
        Category category3c1 = createCategory("Classical Burgers", category3.getId());
        Category category3c2 = createCategory("Spicy Burgers", category3.getId());

        //Drinks
        Category category4c1 = createCategory("Сarbonated Drinks", category4.getId());
        Category category4c2 = createCategory("Energy Drinks", category4.getId());
        Category category4c3 = createCategory("Juices", category4.getId());
        Category category4c4 = createCategory("Others Drinks", category4.getId());


        //Meat pizza
        Product product1 = createProduct("Margherita","Chicken, tomato, cheese",310.00, category1c1);
        Product product2 = createProduct("Napoli","Chicken, tomato, cheese, mushroom",350.00, category1c1);
        Product product3 = createProduct("Meatball","Tomato, mozzarella, ham, mushroom",410.00, category1c1);

        //Sweat pizza
        Product product4 = createProduct("Sea Food","M&M's, ham, mushroom",255.00, category1c2);
        Product product5 = createProduct("Banana","Banana, cheese, tuna, tomato",310.00, category1c2);
        Product product6 = createProduct("Cherry","Cherry, Banana",190.00, category1c2);

        //Spicy pizza
        Product product7 = createProduct("Mexico","Mozzarella, tuscan marinara, bacon",300.00, category1c3);
        Product product8 = createProduct("Loaded Italian","Italian sausage, mozzarella, mushroom, house dressing",410.00, category1c3);
        Product product9 = createProduct("Double Pepperoni","Pepperoni, tuscan marinara, mozzarella",390.00, category1c3);


        //Classical Rolls
        createProduct("Nigiri","Rice, nori, tuna, spicy cilantro sauce",210.00, category2c1);
        createProduct("Sashimi","Rice, nori, cucumber, white sesame",80.00, category2c1);
        createProduct("Maki","Rice, nori, salmon",109.00, category2c1);

        //Baked Rolls
        createProduct("Uramaki","Rice, nori, shrimps",180.00, category2c2);
        createProduct("Tekami","Rice, nori, white sesame, eel, unagi sauce",220.00, category2c2);
        createProduct("Anago","Rice, nori, spicy sauce, eel",400.00, category2c2);

        //Sweet Rolls
        createProduct("Hamachi","Rice, nori, spicy sauce, crab mix",90.00, category2c3);
        createProduct("Ika","Rice, nori, spicy sauce, salmon",270.00, category2c3);
        createProduct("Hireme","Rice, nori, white sesame, eel, unagi sauce",150.00, category2c3);

        //Sets
        createProduct("Ivasi","Rice, nori, tomato, tuna, green onion, mango, Mango mayo sauce, quinoa, Sweet wasabi sauce",1800.00, category2c4);
        createProduct("Kani","Rice, nori, cucumber, red masago, salmon, black sesame, furikake seasoning, Mango mayo sauce, quinoa",2900.00, category2c4);
        createProduct("Maguro","Rice, nori, cucumber, cream cheese, shrimps, red masago, salmon, white sesame, eel, Iceberg lettuce, Wasabi sauce, unagi sauce",990.00, category2c4);


        //Classical Burgers
        createProduct("Mammoth","Red onion, shredded cheese, served open-faced on sourdough",250.00, category3c1);
        createProduct("Junior","Cheddar, grilled onions, shredded cheese",130.00, category3c1);
        createProduct("BigMag","Served open-faced on sourdough, red onion, tomato",150.00, category3c1);

        //Spicy Burgers
        createProduct("Fire","Shredded cheese, served open-faced on sourdough",99.00,category3c2);
        createProduct("Mexico","Shredded cheese, red onion, tomato",130.00,category3c2);
        createProduct("Mammoth Turkey","Red onion, grilled onions, shredded cheese",210.00,category3c2);


        //Сarbonated Drinks
        createProduct("Pepsi","Pepsi 0.5l.",60.00, category4c1);
        createProduct("Coca-Cola","Coca-Cola 0.33l.", 40.00, category4c1);
        createProduct("Sprite","Sprite 0.5l.",70.00, category4c1);

        //Energy Drinks
        createProduct("Red Bull","Red Bull 0.33l.",60.00, category4c2);
        createProduct("Monster","Monster 0.5l.",80.00, category4c2);
        createProduct("Eon","Eon 1l.",110.00, category4c2);

        //Juices
        createProduct("Apple juice","Apple juice 1l.",90.00, category4c3);
        createProduct("Orange juice","Orange juice 1l.",70.00, category4c3);
        createProduct("Banana juice","Banana juice 1l.",90.00, category4c3);

        //Other Drinks
        createProduct("Fruit drink","Fruit drink 0.7l.",80.00,category4c4);
        createProduct("Coffee","Coffee 0.33l.",120.00,category4c4);
        createProduct("Tea","Tea 0.5l.",70.00,category4c4);


        //OrderProduct
        createOrderProduct(1,clientOrder1, product1);
        createOrderProduct(1,clientOrder2, product2);
        createOrderProduct(1,clientOrder3, product3);
        createOrderProduct(1,clientOrder4, product4);
        createOrderProduct(1,clientOrder5, product5);
        createOrderProduct(1,clientOrder6, product6);
        createOrderProduct(1,clientOrder7, product7);
        createOrderProduct(1,clientOrder8, product8);
        createOrderProduct(1,clientOrder9, product9);
    }
}

package ru.keebi.TelegramBot.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.keebi.TelegramBot.Entity.ClientOrder;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface ClientOrderRepo extends JpaRepository<ClientOrder, Long> {

    String GET_ORDERS_BY_STATUS_QUERY = "from ClientOrder where status = :status";
    @Query(GET_ORDERS_BY_STATUS_QUERY)
    List<ClientOrder> getOrderByStatus(@Param("status") Integer status);

    String GET_ORDERS_BY_CLIENT_NAME_QUERY = "from ClientOrder as co where co.client.fullName = :name";
    @Query(GET_ORDERS_BY_CLIENT_NAME_QUERY)
    List<ClientOrder> getClientOrdersByName(@Param("name") String name);

}

package ru.didcvee.mainservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.didcvee.mainservice.client.RestaurantServiceClient;
import ru.didcvee.mainservice.dto.OrderResponseDTO;

@Service
public class SwiggyAppService {

    @Autowired
    private RestaurantServiceClient restaurantServiceClient;

    public String greeting() {
        return "Welcome to Swiggy App Service";
    }

    public OrderResponseDTO checkOrderStatus(String orderId) {
        return restaurantServiceClient.fetchOrderStatus(orderId);
    }
}

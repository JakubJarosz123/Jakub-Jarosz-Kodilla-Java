package com.kodilla.kodillagoodpatterns.challenges;

public class ProductOrderService {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService, final OrderService orderService, final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final User user, final Product product, final int quantity) {
        boolean isOrdered = orderService.order(user, product, quantity);

        if (isOrdered) {
            informationService.inform(user);
            orderRepository.createOrder(user, product, quantity);
            return new OrderDto(user, true);
        } else {
            return new OrderDto(user, false);
        }
    }

}

package bsys.controller;

import bsys.model.Order;
import bsys.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ModelAndView allOrders() {
        List<Order> orderList = orderService.allOrders();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("OrderPage");
        modelAndView.addObject("orderList", orderList);
        return modelAndView;
    }

    @PostMapping(value = "/send/{id}")
    public ModelAndView sendOrder(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        orderService.setStatusSend(id);
        modelAndView.setViewName("redirect:/order");
        return modelAndView;
    }

/*

    @GetMapping(value = "/add")
    public ModelAndView addOrderPage() {
        List<Order> order = orderService.allOrders(); // +
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProductPage");
        modelAndView.addObject("orderList", order); // +
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addOrder(@AuthenticationPrincipal Client client, @ModelAttribute("order") Order order) {
        ModelAndView modelAndView = new ModelAndView();
        order.setIdClient(client);
        orderService.addOrder(order);
        modelAndView.setViewName("redirect:/order");
        return modelAndView;
    }
*/
    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteOrder(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        orderService.deleteOrder(id);
        modelAndView.setViewName("redirect:/order");
        return modelAndView;
    }

}

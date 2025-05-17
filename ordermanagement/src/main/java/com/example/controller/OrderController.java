// package com.example.ordermanagement.controller;

// import com.example.ordermanagement.model.Order;
// import com.example.ordermanagement.service.OrderService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/orders")
// public class OrderController {

//     @Autowired
//     private OrderService orderService;

//     @PostMapping
//     public Order createOrder(@RequestBody Order order) {
//         return orderService.createOrder(order);
//     }

//     @GetMapping
//     public List<Order> getAllOrders() {
//         return orderService.getAllOrders();
//     }

//     @GetMapping("/{id}")
//     public Optional<Order> getOrderById(@PathVariable String id) {
//         return orderService.getOrderById(id);
//     }

//     @PutMapping("/{id}")
//     public Order updateOrder(@PathVariable String id, @RequestBody Order order) {
//         return orderService.updateOrder(id, order);
//     }

//     @DeleteMapping("/{id}")
//     public boolean deleteOrder(@PathVariable String id) {
//         return orderService.deleteOrder(id);
//     }
// }

package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // ❌ Unused variable - Code Smell
    private String unusedField = "This is never used";

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        // ❌ Empty catch block - Bug
        try {
            int x = 10 / 0;
        } catch (Exception e) {
            // nothing here
        }

        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable String id) {
        // ❌ Potential NullPointerException - Bug
        String test = null;
        if (test.equals("abc")) {
            System.out.println("This will crash");
        }

        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable String id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public boolean deleteOrder(@PathVariable String id) {
        return orderService.deleteOrder(id);
    }

    // ❌ Duplicated method - Code Smell
    public void logInfo() {
        System.out.println("Logging order info");
    }

    public void logInfoDuplicate() {
        System.out.println("Logging order info"); // same as above
    }

}
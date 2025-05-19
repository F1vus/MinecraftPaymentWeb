package net.fiv.backend.controller;

import net.fiv.backend.model.ProductsTable;
import net.fiv.backend.service.rabbitmq.MessageSender;
import net.fiv.backend.service.userService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("api/v1")
public class OpenController {

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public List<ProductsTable> findAllProducts() {
        return productService.findAllProducts();
    }

    @PostMapping("hello_world")
    public ResponseEntity<String> hello(@RequestBody HashMap<String, String> message){
        if (message.get("message").isBlank()) {
            return new ResponseEntity<>("message not be blank", HttpStatusCode.valueOf(400));
        }
        messageSender.sendMessage(message.get("message"));
        return new ResponseEntity<>("Message delivered", HttpStatusCode.valueOf(200));
    }


}

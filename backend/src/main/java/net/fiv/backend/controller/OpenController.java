package net.fiv.backend.controller;

import net.fiv.backend.model.Products;
import net.fiv.backend.service.rabbitmq.MessageSender;
import net.fiv.backend.service.impl.ProductsImpl;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("api/v1")
public class OpenController {

    private final MessageSender messageSender;
    private final ProductsImpl productService;

    public OpenController(MessageSender messageSender, ProductsImpl productService) {
        this.messageSender = messageSender;
        this.productService = productService;
    }

    @GetMapping("products")
    public List<Products> findAllProducts() {
        return productService.findAll();
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

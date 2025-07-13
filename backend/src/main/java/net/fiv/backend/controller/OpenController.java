package net.fiv.backend.controller;

import net.fiv.backend.DTO.ProductsDTO;
import net.fiv.backend.service.rabbitmq.MessageSender;
import net.fiv.backend.service.impl.ProductsServiceImpl;
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
    private final ProductsServiceImpl productService;

    public OpenController(MessageSender messageSender, ProductsServiceImpl productService) {
        this.messageSender = messageSender;
        this.productService = productService;
    }

    @GetMapping("products")
    public List<ProductsDTO> findAllProducts() {
        return productService.getAllProducts();
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

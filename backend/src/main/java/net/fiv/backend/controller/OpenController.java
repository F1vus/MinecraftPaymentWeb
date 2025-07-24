package net.fiv.backend.controller;

import net.fiv.backend.DTO.ProductDTO;
import net.fiv.backend.mapper.Mapper;
import net.fiv.backend.model.Product;
import net.fiv.backend.service.rabbitmq.MessageSender;
import net.fiv.backend.service.service.ProductsService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/open")
public class OpenController {

    private final MessageSender messageSender;
    private final ProductsService productService;
    private final Mapper<Product, ProductDTO> productMapper;

    public OpenController(MessageSender messageSender, ProductsService productService, Mapper<Product, ProductDTO> productMapper) {
        this.messageSender = messageSender;
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/products")
    public List<ProductDTO> findAllProducts() {
        return productService.getAllProducts().stream()
                .map(productMapper::mapTo)
                .collect(Collectors.toList());
    }

    @PostMapping("/hello_world")
    public ResponseEntity<String> hello(@RequestBody HashMap<String, String> message){
        if (message.get("message").isBlank()) {
            return new ResponseEntity<>("message not be blank", HttpStatusCode.valueOf(400));
        }
        messageSender.sendMessage(message.get("message"));
        return new ResponseEntity<>("Message delivered", HttpStatusCode.valueOf(200));
    }


}

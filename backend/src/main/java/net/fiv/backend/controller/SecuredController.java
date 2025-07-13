package net.fiv.backend.controller;

import net.fiv.backend.DTO.ProductsDTO;
import net.fiv.backend.service.impl.ProductsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("secured/api/v1")
public class SecuredController {

    private final ProductsServiceImpl productsImpl;

    SecuredController(ProductsServiceImpl productsImpl) {
        this.productsImpl = productsImpl;
    }

    @GetMapping("user")
    public String userAccess(Principal principal) {
        if(principal == null) {
            return "You are not logged in";
        }
        return principal.getName();
    }

    @PostMapping("add_product")
    public ResponseEntity<String> addProduct(@RequestBody ProductsDTO addProductRequest) {
        try{
            productsImpl.createProduct(addProductRequest);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok("Product added");
    }

}

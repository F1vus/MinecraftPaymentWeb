package net.fiv.backend.controller;

import net.fiv.backend.DTO.AddProductRequest;
import net.fiv.backend.model.Products;
import net.fiv.backend.service.userService.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("secured/api/v1")
public class SecuredController {

    private final ProductsService productsService;

    SecuredController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("user")
    public String userAccess(Principal principal) {
        if(principal == null) {
            return "You are not logged in";
        }
        return principal.getName();
    }

    @PostMapping("add_product")
    public ResponseEntity<String> addProduct(@RequestBody AddProductRequest addProductRequest) {
        Products products = new Products();
        System.out.println(addProductRequest.toString());

        products.setTitle(addProductRequest.getTitle());
        products.setDescription(addProductRequest.getDescription());
        products.setPrice(addProductRequest.getPrice());
        products.setUrlimage(addProductRequest.getUrlimage());
        products.setMinecraftTag(addProductRequest.getMinecraft_tag());

        productsService.save(products);
        return ResponseEntity.ok("Product added");
    }

}

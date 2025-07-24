package net.fiv.backend.controller;

import net.fiv.backend.DTO.ProductBuyDTO;
import net.fiv.backend.DTO.ProductDTO;
import net.fiv.backend.mapper.impl.ProductMapperImpl;
import net.fiv.backend.model.Product;
import net.fiv.backend.model.Purchase;
import net.fiv.backend.model.User;
import net.fiv.backend.service.service.ProductsService;
import net.fiv.backend.service.service.PurchaseService;
import net.fiv.backend.service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/secured")
public class SecuredController {

    private final ProductsService productsImpl;
    private final UserService userService;
    private final PurchaseService purchaseService;
    private final ProductMapperImpl productMapper;

    public SecuredController(UserService userService, ProductsService productsImpl, PurchaseService purchaseService, ProductMapperImpl productMapper) {
        this.productsImpl = productsImpl;
        this.userService = userService;
        this.purchaseService = purchaseService;
        this.productMapper = productMapper;
    }

    @GetMapping("/user")
    public String userAccess(Principal principal) {
        if(principal == null) {
            return "You are not logged in";
        }

        return principal.getName();
    }

    @PostMapping("/add_product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO addProductRequest) {
        Product product = productMapper.mapFrom(addProductRequest);
        Product savedProduct = productsImpl.createProduct(product);
        return new ResponseEntity<>(productMapper.mapTo(savedProduct), HttpStatus.CREATED);
    }

    @PostMapping("/buy_product")
    public ResponseEntity<String> buyProduct(@RequestBody ProductBuyDTO productBuyDTO, Principal principal) {
        User customer = userService.getUserByUsername(principal.getName());
        Product product = productsImpl.getProductById(productBuyDTO.getProductId());
        purchaseService.buyProduct(customer, product);

        return new ResponseEntity<>("Product buy requested", HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_user_purchase")
    public HashMap<Long, Product> getUserPurchase(Principal principal) {
        User customer = userService.getUserByUsername(principal.getName());
        List<Purchase> purchaseList = customer.getPurchaseList();

        HashMap<Long, Product> userPurchase = new HashMap<>();

        purchaseList.forEach(purchase -> userPurchase.put(purchase.getId(), purchase.getProduct()));

        return userPurchase;
    }

}

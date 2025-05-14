package net.fiv.backend.controller;

import net.fiv.backend.model.UsersMiniWallet;
import net.fiv.backend.service.rabbitmq.MessageSender;
import net.fiv.backend.service.userwallet.UserMiniWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/v1")
public class FrontendController {

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private UserMiniWalletService walletService;

    @PostMapping("hello_world")
    public ResponseEntity<String> hello(@RequestBody HashMap<String, String> message){
        if (message.get("message").isBlank()) {
            return new ResponseEntity<>("message not be blank", HttpStatusCode.valueOf(400));
        }
        messageSender.sendMessage(message.get("message"));
        return new ResponseEntity<>("Message delivered", HttpStatusCode.valueOf(200));
    }

    @PostMapping("create_user")
    public ResponseEntity<String> createWallet(@RequestBody UsersMiniWallet wallet) {
        if(wallet.getUsername().isBlank() && wallet.getBalance() <=0){
            return new ResponseEntity<>("Bad data", HttpStatusCode.valueOf(400));
        }
        walletService.saveWallet(wallet);
        return new ResponseEntity<>("Message delivered", HttpStatusCode.valueOf(200));
    }
}

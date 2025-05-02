package net.fiv.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/test")
public class FrontendController {

    @PostMapping("hello_world")
    public ResponseEntity<String> hello(@RequestBody HashMap<String, String> message){
        if (message.get("message").equals("server pidar")) {
            System.out.println(message.get("message"));
            return new ResponseEntity<>("sam pidar", HttpStatusCode.valueOf(400));
        }
        System.out.println(message.get("message"));
        return new ResponseEntity<>("Message delivered", HttpStatusCode.valueOf(200));
    }

}

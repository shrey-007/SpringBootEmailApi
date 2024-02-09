package com.email.controller;

import com.email.model.EmailRequest;
import com.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @RequestMapping("/welcome")
    public String welcome(){
        return "hello this is my email api";
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest){


        System.out.println(emailRequest);
        boolean result=this.emailService.sendEmail(emailRequest.getSubject(),emailRequest.getMessage(),emailRequest.getTo());

        if(result){
            return ResponseEntity.ok("Done..");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent");
        }


    }

}

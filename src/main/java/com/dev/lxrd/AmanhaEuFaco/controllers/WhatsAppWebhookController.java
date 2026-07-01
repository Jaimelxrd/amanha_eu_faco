package com.dev.lxrd.AmanhaEuFaco.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Value;

@RestController
@RequestMapping("/webhook")
public class WhatsAppWebhookController {

    @Value("${whatsapp.webhook.verify-token}")
    private String verifyToken;

    @GetMapping
    public ResponseEntity<String> verificarWebhook(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.verify_token") String tokenRecebido,
            @RequestParam("hub.challenge") String challenge) {

        if ("subscribe".equals(mode) && verifyToken.equals(tokenRecebido)) {
            return ResponseEntity.ok(challenge);
        }
        return ResponseEntity.status(403).build();
    }

    @PostMapping
    public ResponseEntity<Void> receberMensagem(@RequestBody(required = false) String payload) {
        // por enquanto só aceita e não faz nada — implementamos depois
        System.out.println("Mensagem recebida: " + payload);
        return ResponseEntity.ok().build();
    }
}

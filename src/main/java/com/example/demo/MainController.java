package com.example.demo;

import com.example.demo.coreapi.CreateCommand;
import com.example.demo.coreapi.RedeemCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;
import java.util.concurrent.Future;

@RestController
public class MainController {

   private final CommandGateway commandGateway;

    public MainController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RequestMapping("/")
    public String handle(){
        return "Salammmmm";
    }
    @PostMapping("/create")
    public Future<String> add(@RequestBody @Valid  card cardSample) {
        String newId = UUID.randomUUID().toString();
        return commandGateway.send(new CreateCommand(newId, cardSample.getCardAmount()));
    }

    @PostMapping("/redeem")
    public Future<String> redeem(@RequestBody @Valid  card cardSample) {
        return commandGateway.send(new RedeemCommand(cardSample.getCardId(), cardSample.getCardAmount()));
    }

    public static class card{
    private String cardId;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public Integer getCardAmount() {
            return cardAmount;
        }

        public void setCardAmount(Integer cardAmount) {
            this.cardAmount = cardAmount;
        }

        private Integer cardAmount;
    }
}

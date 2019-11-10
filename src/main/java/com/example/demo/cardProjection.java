package com.example.demo;

import com.example.demo.coreapi.CreateEvent;
import com.example.demo.coreapi.RedeemEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.stereotype.Component;


@Component
public class cardProjection {

    private final cardRepository cardRepository;

    public cardProjection(com.example.demo.cardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @EventSourcingHandler
    public void on(CreateEvent event){

        this.cardRepository.save(new cardEntity(event.getId(),event.getAmount()));
    }

    @EventSourcingHandler
    public void on(RedeemEvent event){
        cardEntity card=this.cardRepository.findById(event.getId()).get();
        card.setAmount(card.getAmount()+ event.getAmount());
        cardRepository.save(card);

    }
}

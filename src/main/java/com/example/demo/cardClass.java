package com.example.demo;

import com.example.demo.coreapi.CreateCommand;
import com.example.demo.coreapi.CreateEvent;
import com.example.demo.coreapi.RedeemCommand;
import com.example.demo.coreapi.RedeemEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;


import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class cardClass {

    public cardClass() {
    }

    @AggregateIdentifier
    private String id;
    private Integer amount;

    @CommandHandler
    public cardClass(CreateCommand cmd){
        apply(new CreateEvent(cmd.getId(),cmd.getAmount()));
    }

    public cardClass(String id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }
    @CommandHandler
    public void handle(RedeemCommand cmd) {
        apply(new RedeemEvent(cmd.getId(),cmd.getAmount()));
    }

    @EventSourcingHandler
    public void on(RedeemEvent event){
        id=event.getId();
        amount=event.getAmount();
    }

    @EventSourcingHandler
    public void on(CreateEvent event){
        id=event.getId();
        amount=event.getAmount();
    }
}

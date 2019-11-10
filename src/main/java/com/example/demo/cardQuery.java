package com.example.demo;

import com.example.demo.coreapi.AllcardsQuery;
import com.example.demo.coreapi.CardAmountQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.*;


@Component
public class cardQuery {
    private final cardRepository cardRepository;

    public cardQuery(com.example.demo.cardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @QueryHandler
    public cardEntity on(CardAmountQuery query){
        return cardRepository.findById(query.getId()).get();
    }

    @QueryHandler
    public List<cardEntity> on(AllcardsQuery query){
        return cardRepository.findAll();
    }
}

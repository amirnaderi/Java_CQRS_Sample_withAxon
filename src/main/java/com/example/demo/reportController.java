package com.example.demo;

import com.example.demo.coreapi.AllcardsQuery;
import com.example.demo.coreapi.CardAmountQuery;
import org.axonframework.messaging.responsetypes.MultipleInstancesResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class reportController {
    private final QueryGateway queryGateway;

    public reportController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{id}")
    public cardEntity getone(@PathVariable String id) throws ExecutionException, InterruptedException {
        return queryGateway.query(new CardAmountQuery(id),cardEntity.class).get();
    }

    @GetMapping("/all")
    public Future<List<cardEntity>> all(){
        return queryGateway.query(new AllcardsQuery(),new MultipleInstancesResponseType<>(cardEntity.class));
    }
}

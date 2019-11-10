package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class cardEntity {
    @Id
    private String Id;
    private Integer Amount;

    public cardEntity(String id, Integer amount) {
        Id = id;
        Amount = amount;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public cardEntity() {
    }
}

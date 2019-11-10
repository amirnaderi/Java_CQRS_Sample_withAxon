package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface cardRepository extends JpaRepository<cardEntity,String> {

}

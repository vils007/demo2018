package com.example.demo.domen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<EventDTO, Long> {

    @Query("SELECT p FROM EventDTO p")
    public List<EventDTO> findAll();
}

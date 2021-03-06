package com.example.demo.domen;

import org.springframework.data.repository.CrudRepository;


import javax.transaction.Transactional;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

@Transactional
public interface EventDAO extends CrudRepository<EventDTO, Long> {
    public List<EventDTO> findAll();

    public List<EventDTO> findByType(String type);

    public List<EventDTO> findByDescription(String description);

}

package com.example.demo.domen;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface EventDAO extends CrudRepository<EventDTO, Long> {

    public List<EventDTO> findByType(String type);

    public List<EventDTO> findByDescription(String description);

    @Query("SELECT p FROM EventDTO p WHERE p.description LIKE %?1%")
    public List<EventDTO> findByDescriptionLike(String desc);

}

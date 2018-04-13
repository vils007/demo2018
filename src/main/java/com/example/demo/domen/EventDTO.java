package com.example.demo.domen;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Table(name = "event")
@Data
public class EventDTO {

    // An autogenerated id (unique for each user in the db)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String type;

    @NotNull
    private String description;

    @Column(name="EVENT_DT")
    private Date eventDt;
}
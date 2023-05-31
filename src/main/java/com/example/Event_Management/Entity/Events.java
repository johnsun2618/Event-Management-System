package com.example.Event_Management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Events {

    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uid;

    private String name;

    private String tagline;

    @Temporal(TemporalType.TIMESTAMP)
    private Date schedule = new Date(System.currentTimeMillis());

    private String description;

    private String moderator;

    private String category;

    private String sub_category;

    private int rigor_rank;




}

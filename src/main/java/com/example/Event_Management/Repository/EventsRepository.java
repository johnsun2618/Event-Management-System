package com.example.Event_Management.Repository;

import com.example.Event_Management.Entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Events, Integer> {
}

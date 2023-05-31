package com.example.Event_Management.Service;

import com.example.Event_Management.Entity.Events;
import com.example.Event_Management.Repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EventsService {

    @Autowired
    EventsRepository eventsRepository;

    //Post
    public String addEvents(Events events)
    {
        eventsRepository.save(events);
        return "Event Added";
    }

//    Get
    public List<Events> fetchEvents()
    {
        return eventsRepository.findAll();
    }

    //Get by page number
    public Page<Events> findEventByPagination(int limit, int page)
    {
        Page<Events> eventsPage =  eventsRepository.findAll(PageRequest.of(limit, page));
        return eventsPage;
    }

//    Get
    public Events getEventsById(int id)
    {
        return eventsRepository.findById(id).get();
    }


//    Put
    public Events updateEventByUniqueId(Events events)
    {
        return eventsRepository.save(events);
    }

//    Delete
    public String deleteUserFromUniqueId(int id){
        if(eventsRepository.existsById(id)){
            eventsRepository.deleteById(id);
            return "Delete User " + id;
        } else{
            return "Please Enter Correct Id";
        }

    }

}

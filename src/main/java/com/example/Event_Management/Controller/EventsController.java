package com.example.Event_Management.Controller;

import com.example.Event_Management.Entity.Events;
import com.example.Event_Management.Service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v3/app")
public class EventsController {


    @Autowired
    EventsService eventsService;

    @PostMapping(path = "/events")
    public String addEvents(@RequestBody Events events)
    {
       return eventsService.addEvents(events);
    }

    @GetMapping(path = "/fetchEvents")
    public List<Events> fetchEvents()
    {
        return eventsService.fetchEvents();
    }


    //get an event by its recency and paginate result by page number and limit of event per page
    @GetMapping(path = "/events/{limit}/{page}")
    public Page<Events> paginateEvents(@PathVariable int limit, @PathVariable int page)
    {
        Page<Events> eventsPage = eventsService.findEventByPagination(limit, page);
        return eventsPage;
    }


    //Gets an event by its unique id
    @GetMapping(path = "/events")
    public Events fetchEventById(@RequestParam("event_id") int id)
    {
        return eventsService.getEventsById(id);
    }


    //Update Event based on its Unique id
    @PutMapping(path = "/events")
    public Events updateEventByUniqueId(@RequestBody Events events)
    {
        return eventsService.updateEventByUniqueId(events);
    }


    //Deletes an event based on its Unique id
    @DeleteMapping("/events")
    public String deleteUserFromUniqueId(@PathVariable("delete_id") int id){
        return eventsService.deleteUserFromUniqueId(id);
    }

}

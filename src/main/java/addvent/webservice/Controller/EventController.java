package addvent.webservice.Controller;

import addvent.webservice.Model.Event;
import addvent.webservice.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    private EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @RequestMapping(value="/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> findAllEvents() {
        List<Event> events = eventRepository.findAllByOrderByTime();
        return events;
    }

    @RequestMapping(value="/nordEvents", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> findNordEvents() {
        List<Event> events = eventRepository.findByBynord(true);
        return events;
    }

    @RequestMapping(value="/otherEvents", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> findOtherEvents() {
        List<Event> events = eventRepository.findByBynord(false);
        return events;
    }

    /*@RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<Ride> AddUser(@RequestBody Ride r) {
        Ride ride = new Ride();
        ride.setFrom(r.getFrom());
        ride.setTo(r.getTo());
        ride.setFromDate(r.getFromDate());
        ride.setToDate(r.getToDate());
        ride.setUser(r.getUser());
        ride.setStopovers(r.getStopovers());

        rideRepository.save(ride);
        return new ResponseEntity<>(ride, HttpStatus.OK);
    }*/
}

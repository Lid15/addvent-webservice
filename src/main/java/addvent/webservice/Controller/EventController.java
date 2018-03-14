package addvent.webservice.Controller;

import addvent.webservice.Model.Event;
import addvent.webservice.Repository.EventRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    private EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @RequestMapping(value="/all", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public List<Event> findAllEvents() {
        List<Event> events = eventRepository.findAllByOrderByTime();
        return events;
    }

    @RequestMapping(value="/nordEvents", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> findNordEvents() {
        List<Event> events = eventRepository.findByBynordTrue();
        return events;
    }

    @RequestMapping(value="/otherEvents", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> findOtherEvents() {
        List<Event> events = eventRepository.findByBynordFalse();
        return events;
    }

    @RequestMapping(value="/addEvent", method = RequestMethod.GET)

    public ResponseEntity<Event> addEvent(/*@RequestBody Event e*/){
        Event event = new Event();
        event.setBynord(true);
        event.setDescription("spilakvöld niðrí nörd");
        event.setHost("Nörd");
        event.setLocation("Nördakjallarinn");

        event.setTime("2018-3-16 17:00:00");
        event.setTitle("Spilakvöld Nörd");
        eventRepository.save(event);

        return new ResponseEntity<>(event, HttpStatus.OK);
    }

}

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

    @RequestMapping(value="/addEvent", method = RequestMethod.POST)

    public ResponseEntity<Event> addEvent(@RequestBody Event e){
        /*Event event = new Event();
        event.setBynord(true);
        event.setDescription("spilakvöld niðrí nörd");
        event.setHost("Nörd");
        event.setLocation("Nördakjallarinn");

        event.setTime("2018-3-16 17:00:00");
        event.setTitle("Spilakvöld Nörd");
        eventRepository.save(event);

        Event event1 = new Event();
        event1.setBynord(true);
        event1.setDescription("Rosa skemmtileg vísó í Origo");
        event1.setHost("Nörd");
        event1.setLocation("Origo");

        event1.setTime("2018-3-23 17:00:00");
        event1.setTitle("Vísó í Origo");
        eventRepository.save(event1);

        Event event2 = new Event();
        event2.setBynord(false);
        event2.setDescription("Útilega með öllum í FV");
        event2.setHost("FV");
        event2.setLocation("Úti á landi");

        event2.setTime("2018-7-19 14:00:00");
        event2.setTitle("Útilega FV");
        eventRepository.save(event2);

        Event event3 = new Event();
        event3.setBynord(true);
        event3.setDescription("Árshátíð Nörd verður algjör snilld");
        event3.setHost("Nörd");
        event3.setLocation("Félagsheimili Seltjarnarnes");

        event3.setTime("2018-3-24 18:00:00");
        event3.setTitle("Árshátíð Nörd");
        eventRepository.save(event3);*/

        Event event = new Event();
        event.setTitle(e.getTitle());
        event.setLocation(e.getLocation());
        event.setHost(e.getHost());
        event.setDescription(e.getDescription());
        event.setBynord(e.getBynord());
        event.setTime(e.getTime());
        eventRepository.save(event);
        
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

}

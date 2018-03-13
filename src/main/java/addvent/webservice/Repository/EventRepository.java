package addvent.webservice.Repository;

import addvent.webservice.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByOrderByTime();

    List<Event> findByByNord(Boolean byNord);
}

package addvent.webservice.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@Version
    private Long version;*/

    @NotNull
    @Size(min = 2, max = 30)
    private String title;

    @org.hibernate.annotations.Type(type="true_false")
    @NotNull
    @JsonProperty
    private boolean bynord;

    private String location;

    private String host;

    @Size(min = 2, max = 140)
    private String description;

    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd hh:mm:ss")
    //@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private String time;

    public Event() {
    }

    public Event(String title, String location, String host, String description, LocalDateTime time, boolean byNord) {
        this();
        this.title = title;
        this.location = location;
        this.host = host;
        this.description = description;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.time = time.format(formatter);
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.time = LocalDateTime.parse(time.format(formatter), formatter);*/
        //this.bynord = Boolean.parseBoolean(byNord);
        this.bynord = byNord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.time = LocalDateTime.parse(time.format(formatter), formatter);*/
        this.time = time;
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.time = time.format(formatter);*/
    }

    public boolean getBynord() {
        return bynord;
    }

    public void setBynord(boolean byNord) {
        this.bynord = byNord;
    }
}

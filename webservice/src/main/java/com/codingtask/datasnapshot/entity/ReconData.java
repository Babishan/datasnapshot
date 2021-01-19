package com.codingtask.datasnapshot.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.util.Calendar;

@Entity
@Table(name = "RECON_DATA")
public class ReconData {
    @Id
    @Column(name="PRIMARY_KEY")
    @NotBlank(message = "NO_PRIMARY_KEY")
    private String id;

    @Column(name="NAME")
    @NotBlank(message = "NO_NAME")
    private String name;

    @Column(name="DESCRIPTION")
    @NotBlank(message = "NO_DESCRIPTION")
    private String description;

    @Column(name = "UPDATED_TIMESTAMP", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    @PastOrPresent(message = "FUTURE_TIMESTAMP")
    private Calendar timestamp;

    public ReconData() {
    }

    public ReconData(String id, String name, String description, Calendar timestamp) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ReconData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

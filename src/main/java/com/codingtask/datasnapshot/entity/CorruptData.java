package com.codingtask.datasnapshot.entity;

import javax.persistence.*;

@Entity
@Table(name = "CORRUPT_DATA")
public class CorruptData {
    @Id
    @Column(name = "GENERATED_PRIMARY_KEY")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "RAW_DATA")
    @Lob
    private String rawData;

    public CorruptData() {
    }

    public CorruptData( String reason,String rawData) {
        this.reason = reason;
        this.rawData = rawData;
    }

    public Integer getId() {
        return id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    @Override
    public String toString() {
        return "CorruptData{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                ", rawData='" + rawData + '\'' +
                '}';
    }
}

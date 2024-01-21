package com.common.test_task.model;
import jakarta.persistence.*;

@Entity
@Table(name = "intervall")
public class IntervalDigits {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "startt")
    private int startt;
    @Column(name = "endd")
    private int endd;

    public IntervalDigits() { }

    public IntervalDigits(int start, int end) {
        this.startt = start;
        this.endd = end;
    }

    public int getStart() {
        return startt;
    }

    public int getEnd() {
        return endd;
    }

    public void setEnd(int end) {
        this.endd = end;
    }
}
package com.common.test_task.models;
import jakarta.persistence.*;
@Entity
@Table(name = "digit_intervals")
public class IntervalDigits {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "_start")
    private int start;
    @Column(name = "_end")
    private int end;
    public IntervalDigits() { }
    public IntervalDigits(int start, int end) {
        this.start = start;
        this.end = end;    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }}
package com.common.test_task.model;
 import jakarta.persistence.*; // for Spring Boot 3
@Entity
@Table(name = "intervals")
public class Interval {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "start")
    private int start;
    @Column(name = "end")
    private int end;

    public Interval() {
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
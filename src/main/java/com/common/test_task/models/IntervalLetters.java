package com.common.test_task.models;
import jakarta.persistence.*;
@Entity
@Table(name = "letter_intervals")
public class IntervalLetters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "_start")
    private char start;
    @Column(name = "_end")
    private char end;
    public IntervalLetters() { }
    public IntervalLetters(char start, char end) {
        this.start = start;
        this.end = end;    }
    public char getStart() {
        return start;
    }
    public char getEnd() {
        return end;
    }
    public void setEnd(char end) {
        this.end = end;
    }}
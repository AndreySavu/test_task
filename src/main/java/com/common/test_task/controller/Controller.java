package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.common.test_task.Interval;
import com.common.test_task.repository.IntervalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/intervals")
public class Controller {
    @Autowired
    IntervalRepository intervalRepository;
    @PostMapping("/merge")
    public ResponseEntity<List<Interval>> mergeIntervals(@RequestParam String kind
                                                         List<Interval> intervals){

    }
    @GetMapping("/min")
    public Interval getMinInterval(@RequestParam String kind){

    }


}
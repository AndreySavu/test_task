package com.common.test_task.controllers;

import java.util.*;

import com.common.test_task.models.*;
import com.common.test_task.services.*;
import com.common.test_task.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/v1/intervals")
public class Controller {
    @Autowired
    private IntervalDigitsRepository intervalDigitsRepository;
    @Autowired
    private IntervalLettersRepository intervalLettersRepository;

    @PostMapping("/merge")
    public ResponseEntity<HttpStatus> mergeIntervals(@RequestParam(defaultValue = "digits") String kind,
                                                     @RequestBody List<List<?>> intervals) {
        if (intervals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (kind.equals("digits")) { //обработка случая с интервалами цифр
            List<IntervalDigits> mergedList = IntervalDigitsService.getMergedListOfDigits(intervals);
            intervalDigitsRepository.saveAll(mergedList);
        }
        else if (kind.equals("letters")) { //обработка случая с интервалами букв
            List<IntervalLetters> mergedList = IntervalLettersService.getMergedListOfLetters(intervals);
            intervalLettersRepository.saveAll(mergedList);
        }
        else { //обработка несуществующего параметра запроса
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/min")
    @ResponseBody
    public List<?> getMinInterval(@RequestParam(defaultValue = "digits") String kind) {
        if (kind.equals("digits")) {
            IntervalDigits res = intervalDigitsRepository.findMin();
            return Arrays.asList(res.getStart(), res.getEnd());
        }
        else if (kind.equals("letters")) {
            IntervalLetters res = intervalLettersRepository.findMin();
            return Arrays.asList(res.getStart(), res.getEnd());
        }
        return Collections.emptyList();
    }
}
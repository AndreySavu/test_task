package com.common.test_task.services;
import com.common.test_task.models.IntervalDigits;
import com.common.test_task.models.IntervalLetters;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class IntervalLettersService {
    // преобразуем List<List<String> в List<IntervalDigits> с сортировкой по первому элементу интервала

    public static List<IntervalLetters> getMergedListOfLetters(List<List<?>> listStr) {
        // преобразуем List<List<?> в List<IntervalLetters> с сортировкой по первому элементу интервала
        List<IntervalLetters> intervals = listStr.stream()
                .map(e -> new IntervalLetters(e.get(0).toString().charAt(0), e.get(1).toString().charAt(0)))
                .sorted(Comparator.comparing(IntervalLetters::getStart))
                .collect(Collectors.toList());
        return mergeIntervalLetters(intervals);
    }
    // производим объединение пересекающихся интервалов
    private static List<IntervalLetters> mergeIntervalLetters(List<IntervalLetters> intervals) {
        List<IntervalLetters> mergedList = new ArrayList<>();
        IntervalLetters prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            IntervalLetters current = intervals.get(i);
            if ((int) current.getStart() <= (int) prev.getEnd()) {
                prev.setEnd((char) Math.max((int) prev.getEnd(), (int) current.getEnd()));
            } else {
                mergedList.add(prev);
                prev = current;
            }
        }
        mergedList.add(prev);
        return mergedList;
    }
}

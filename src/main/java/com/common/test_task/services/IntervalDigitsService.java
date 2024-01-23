package com.common.test_task.services;
import com.common.test_task.models.IntervalDigits;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class IntervalDigitsService {
    // преобразуем List<List<String> в List<IntervalDigits> с сортировкой по первому элементу интервала
    public static List<IntervalDigits> getMergedListOfDigits(List<List<?>> listStr) {
        List<IntervalDigits> intervals = listStr.stream()
                .map(e -> new IntervalDigits((int)e.get(0), (int)e.get(1)))
                .sorted(Comparator.comparing(IntervalDigits::getStart))
                .collect(Collectors.toList());
        return mergeIntervalDigits(intervals);
    }

    // производим объединение пересекающихся интервалов
    private static List<IntervalDigits> mergeIntervalDigits(List<IntervalDigits> intervals) {
        List<IntervalDigits> mergedList = new ArrayList<>();
        IntervalDigits prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            IntervalDigits current = intervals.get(i);
            if (current.getStart() <= prev.getEnd()) {
                prev.setEnd(Math.max(prev.getEnd(), current.getEnd()));
            } else {
                mergedList.add(prev);
                prev = current;
            }
        }
        mergedList.add(prev);
        return mergedList;
    }
}
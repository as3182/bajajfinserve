package com.bajaj.bajajfinserv.services;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataService {

    public Map<String, Object> processData(List<String> data) {
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        Map<String, Object> response = new LinkedHashMap<>();

        for (String item : data) {
            if (item.matches("\\d+")) {
                numbers.add(item);
            } else if (item.matches("[A-Za-z]")) {
                alphabets.add(item);
            }
        }

        if (numbers.isEmpty() || alphabets.isEmpty()) {
            return Collections.emptyMap();
        }

        String highestAlphabet = Collections.max(alphabets, String.CASE_INSENSITIVE_ORDER);

        response.put("is_success", true);
        response.put("user_id", "ayush_sharma_09112003");
        response.put("email", "as9.ayushsharma@gmail.com");
        response.put("roll_number", "RA2111026030143");
        response.put("numbers", numbers);
        response.put("alphabets", alphabets);
        response.put("highest_alphabet", Collections.singletonList(highestAlphabet));

        return response;
    }
}

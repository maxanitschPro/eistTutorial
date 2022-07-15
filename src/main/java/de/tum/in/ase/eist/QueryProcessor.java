package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Max";
        } else if (query.contains("plus")) {
            List<String> list = findIntegers(query);

            int sum = 0;
            for (String integer: list) {
                int number = Integer.valueOf(integer);
                sum += number;
            }
            // TODO extend the programm here
            return String.valueOf(sum);
        } else if (query.contains("largest")) {
            List<String> list = findIntegers(query);

            int largestNumber = 0;
            for (String integer: list) {
                int currentNumber = Integer.valueOf(integer);

                if (largestNumber == 0) {
                    largestNumber = currentNumber;
                }

                if (currentNumber >= largestNumber) {
                    largestNumber = currentNumber;
                }
            }

            return String.valueOf(largestNumber);
        }

        return "";
    }

    List<String> findIntegers(String stringToSearch) {
        Pattern integerPattern = Pattern.compile("\\d");
        Matcher matcher = integerPattern.matcher(stringToSearch);

        List<String> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(matcher.group());
        }

        return integerList;
    }

}

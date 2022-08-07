package search.services;

import search.entity.Person;
import search.util.Msg;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllSearch implements SortingMethod {


    @Override
    public void search(List<Person> personList, String target, Map<String, Set<Integer>> invertedIndex) {
        String[] split = target.split("\\s+");
        int size = split.length;

        for (String s : split) {
            if (invertedIndex.get(s) != null) {
                size--;
            }
        }

        boolean isEmpty = true;
        if (size == 0) {
            Set<Integer> integers = invertedIndex.get(split[0]);
            for (Integer i : integers) {
                System.out.println(personList.get(i));
            }
            isEmpty = false;
        }

        if (isEmpty) {
            System.out.println(Msg.NO_MATCHING_PEOPLE);
        }
    }
}

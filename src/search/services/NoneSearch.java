package search.services;

import search.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NoneSearch implements SortingMethod {

    @Override
    public void search(List<Person> personList, String target, Map<String, Set<Integer>> invertedIndex) {
        String[] split = target.split("\\s+");

        List<Integer> except = new ArrayList<>();

        for (String s : split) {
            if (invertedIndex.get(s) != null) {
                Set<Integer> integers = invertedIndex.get(s);
                except.addAll(integers);
            }
        }

        for (int i = 0; i < personList.size(); i++) {
            if (!except.contains(i)) {
                System.out.println(personList.get(i));
            }
        }


    }
}

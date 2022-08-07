package search.services;

import search.entity.Person;
import search.util.Msg;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnySearch implements SortingMethod {

    @Override
    public void search(List<Person> personList, String target, Map<String, Set<Integer>> invertedIndex) {
        String[] split = target.split("\\s+");

        boolean isEmpty = true;

        for (String s : split) {
            if (invertedIndex.get(s) != null) {
                Set<Integer> integers = invertedIndex.get(s);
                for (Integer i : integers) {
                    System.out.println(personList.get(i));
                }
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println(Msg.NO_MATCHING_PEOPLE);
        }
    }
}

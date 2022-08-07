package search.services;

import search.entity.Person;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChoseSearch {

    private SortingMethod sortingMethod;

    public void setSortingMethod(SortingMethod sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    public void search(List<Person> personList, String target, Map<String, Set<Integer>> invertedIndex) {
        this.sortingMethod.search(personList, target, invertedIndex);

    }
}

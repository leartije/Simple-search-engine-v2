package search.services;

import search.entity.Person;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SortingMethod {


    void search(List<Person> personList, String target, Map<String, Set<Integer>> invertedIndex);


}

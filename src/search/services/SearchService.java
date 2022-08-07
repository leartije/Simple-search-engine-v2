package search.services;

import search.entity.Person;
import search.util.Msg;

import java.util.*;

public class SearchService {

    public final Map<String, Set<Integer>> invertedIndex;
    private final ChoseSearch choseSearch;

    public SearchService() {
        this.invertedIndex = new HashMap<>();
        this.choseSearch = new ChoseSearch();

    }

    public void search(List<Person> list, String target, String type) {
        switch (type) {
            case "ALL" -> {
                choseSearch.setSortingMethod(new AllSearch());
                choseSearch.search(list, target, invertedIndex);
            }
            case "ANY" -> {
                choseSearch.setSortingMethod(new AnySearch());
                choseSearch.search(list, target, invertedIndex);
            }
            case "NONE" -> {
                choseSearch.setSortingMethod(new NoneSearch());
                choseSearch.search(list, target, invertedIndex);
            }
            default -> System.out.println("Greskica");
        }
    }

    public void setInvertedIndex(List<Person> list) {

        for (int i = 0; i < list.size(); i++) {

            Person current = list.get(i);

            String name = current.getName() != null ? current.getName().toLowerCase() : null;
            String lastName = current.getLastName() != null ? current.getLastName().toLowerCase() : null;
            String email = current.getEmail() != null ? current.getEmail().toLowerCase() : null;


            if (name != null) {
                if (invertedIndex.get(name) != null) {
                    invertedIndex.get(name).add(i);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    invertedIndex.put(name, set);
                }

            }

            if (lastName != null) {
                if (invertedIndex.get(lastName) != null) {
                    invertedIndex.get(lastName).add(i);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    invertedIndex.put(lastName, set);
                }
            }

            if (email != null) {
                if (invertedIndex.get(email) != null) {
                    invertedIndex.get(email).add(i);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    invertedIndex.put(email, set);
                }
            }
        }
    }

    public void listOfAllPeeps(List<Person> list) {
        System.out.println(Msg.LIST_OF_PEEPS);
        list.forEach(System.out::println);
    }

}

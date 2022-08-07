package search.services;

import search.data.Load;
import search.entity.Person;

import java.util.*;

public class TakeInput {

    private final Load load;

    public TakeInput() {
        this.load = new Load();
    }

    public List<Person> getInput(String fileName) {

        List<String> getInput = load.loadData(fileName);
        List<Person> personList = new ArrayList<>();

        for (String current : getInput) {

            String[] parse = current.split("\\s+");

            if (parse.length == 1) {
                Person person = new Person(parse[0], null, null);
                personList.add(person);
                continue;
            }
            if (parse.length == 2) {
                Person person = new Person(parse[0], parse[1], null);
                personList.add(person);
                continue;
            }
            if (parse.length == 3) {
                Person person = new Person(parse[0], parse[1], parse[2]);
                personList.add(person);
            }

        }

        return personList;
    }

}

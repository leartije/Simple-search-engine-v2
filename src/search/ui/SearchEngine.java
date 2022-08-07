package search.ui;

import search.entity.Person;
import search.services.SearchService;
import search.services.TakeInput;
import search.util.Msg;

import java.util.List;
import java.util.Scanner;

public class SearchEngine {

    private final TakeInput takeInput;
    private final SearchService searchService;

    public SearchEngine() {
        this.takeInput = new TakeInput();
        this.searchService = new SearchService();

    }

    public void start(String fileName) {
        Scanner scanner = new Scanner(System.in);
        List<Person> input = takeInput.getInput(fileName);
        searchService.setInvertedIndex(input);

        while (true) {
            System.out.println(Msg.MAIN_MENU);
            String in = scanner.nextLine();
            switch (in) {
                case "1" -> {
                    System.out.println(Msg.SEARCH_MENU);
                    String type = scanner.nextLine().toUpperCase();
                    System.out.println(Msg.ENTER_DATA_TO_SEARCH);
                    String target = scanner.nextLine().toLowerCase();
                    searchService.search(input, target, type);
                }
                case "2" -> searchService.listOfAllPeeps(input);
                case "0" -> {
                    System.out.println(Msg.BYE);
                    System.exit(0);
                }
                default -> System.out.println(Msg.INCORRECT_OPTION);
            }
        }
    }
}

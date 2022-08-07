package search;

import search.ui.SearchEngine;

public class Main {
    public static void main(String[] args) {


        String fileName = null;
        if (args.length > 1) {
            if (args[0].equals("--data")) {
                fileName = args[1];
            }
        }

        new SearchEngine().start(fileName);

    }
}

package search.data;

import search.util.Msg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Load {


    public List<String> loadData(String fileName) {
        if (fileName == null) {
            System.out.println(Msg.FILE_NAME_NOT_FOUND);
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new BufferedReader(new FileReader(fileName)))) {
            String in;
            while ((in = br.readLine()) != null) {
                list.add(in);
            }
        } catch (IOException e) {
            System.out.println(fileName + " is wrong");
            e.printStackTrace();
        }

        return list;
    }

}

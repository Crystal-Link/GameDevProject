package sample;

import java.io.*;
import java.util.ArrayList;

public class Backend {


    public static ArrayList<Question> fromCSV() throws IOException {


        ArrayList<Question> z = new ArrayList<>();
        InputStream csvStream = Backend.class.getResourceAsStream("Final.csv");

        InputStreamReader isr = new InputStreamReader(csvStream);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null)
        {
            String[] attributes = line.split(",");

            Question temp = Question.createQuestion(attributes);

            z.add(temp);
            line = br.readLine();

        }

        return z;
    }
}
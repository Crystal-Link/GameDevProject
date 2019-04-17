package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.Question;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Backend {


    public static ArrayList<Question> fromCSV() {


        ArrayList<Question> z = new ArrayList<>();
        Path pathToFile = Paths.get("src/final.csv");

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
                String line = br.readLine();
                if (line == null) {
                    return z;
                }
                while (line != null) {
                    String[] attributes = line.split(",");

                    Question temp = Question.createQuestion(attributes);

                    z.add(temp);
                    line = br.readLine();

                }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return z;
    }
}
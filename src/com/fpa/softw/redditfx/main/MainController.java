package com.fpa.softw.redditfx.main;

import com.fpa.softw.redditfx.models.Submission;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainController {

    private final String REDDIT_DATA_FILE = "reddit_data.dat";

    @FXML
    private ListView listViewSubreddits;

    public void initialize()  {

        this.listViewSubreddits.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        File f = new File(REDDIT_DATA_FILE);

        if (f.exists()){

            try {
                InputStreamReader inputReader = new FileReader(f);
                BufferedReader reader = new BufferedReader(inputReader);

                List<Submission> submissions = new ArrayList<>();

                String subreddit = "";
                while(true){
                    String line = reader.readLine();
                    if(line == null || line.equals("")){
                        break;
                    } else if (line.contains("SUBREDDIT:")) {
                        subreddit = line;
                    }

                    String[] sm = line.split("|");
                    String title = sm[0];
                    String url = sm[1];
                    String shortlink = sm[2];

                    Submission submission = new Submission(subreddit, title, url, shortlink);

                    submissions.add(submission);
                }

                this.listViewSubreddits.getItems().addAll(submissions);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("File " + REDDIT_DATA_FILE + " not found. Generating test file.");
            try {
                Runtime.getRuntime().exec("python E:\\Projects\\Java\\RedditFX\\src\\com\\fpa\\softw\\redditfx\\integration\\run.py");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

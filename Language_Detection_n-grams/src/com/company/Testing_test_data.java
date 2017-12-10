package com.company;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Testing_test_data {

    public static void main(String[] args) throws IOException {

        List<String> languages_to_consider = new ArrayList<>();
        languages_to_consider.add("cs");
        languages_to_consider.add("en");
        languages_to_consider.add("fr");
        languages_to_consider.add("de");
        languages_to_consider.add("it");
        languages_to_consider.add("sk");
        languages_to_consider.add("es");


        Properties props = new Properties();
        props.put("annotators", "tokenize");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        String test_path = "data/testing_data_sample";

        BufferedReader br = new BufferedReader(new FileReader(test_path));

        int count = 0;
        int tp = 0;

        String text = " ";

        try {
            String line = br.readLine();
            while (line != null) {

                if (line.length() > 1) {

                    String actual_label = line.substring(0,2);

                    if(languages_to_consider.contains(actual_label)) {


                        text = line.substring(2);

                        String predicted_label = Detection_test.get_Language(text, pipeline);

                        //check the prediction
                        if (actual_label.equals(predicted_label)) {
                            tp++;
                           // System.out.println(tp + "======================\n");
                        }

                        if(actual_label.equals("cs") && predicted_label.equals("sk")){

                            System.out.println(text);
                        }

                        count++;
                    }
                }

                line = br.readLine();
                //System.out.println(count);
            }
        } catch (IOException e) {


        } finally {
            br.close();
        }

        double acc = ((double)tp/count);
        System.out.println("True Positive Count:" + tp);
        System.out.println("Total number of sentence in the test data:" + count);
        System.out.println("Accuracy:" + acc*100);
    }
}

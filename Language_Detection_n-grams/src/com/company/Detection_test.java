package com.company;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.*;
import java.util.*;

import static com.company.Detection_train.OutOfPlaceScore;
import static com.company.Detection_train.PrepareProfile;


public class Detection_test {

    static final String Language_path = "extra_Language_Models_Serialized_top_600_K_10000/";
    static HashMap<String, List<String>> LanguageProfiles = new HashMap<String, List<String>>();

    public static String get_Language(String test,StanfordCoreNLP pipeline) throws IOException {

        String detected = "";
        int optimumscore = 100000000;

        List<String> TestProfile = PrepareProfile(test, pipeline);

        File folder = new File(Language_path);

        for (File file : folder.listFiles()) {

                ArrayList<String> Language_Profile = new ArrayList<String>();
                try
                {
                    FileInputStream fis = new FileInputStream(file);

                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Language_Profile = (ArrayList) ois.readObject();

                    ois.close();
                    fis.close();

                }catch(IOException ioe){
                    ioe.printStackTrace();
                    //return;
                }catch(ClassNotFoundException c){
                    System.out.println("Class not found");
                    c.printStackTrace();
                    //return;
                }

                int score = OutOfPlaceScore(Language_Profile, TestProfile);

               // System.out.println("\n" + file.toString().split("/")[1] + " ,Score:" + score + "\n" + "================================");

                if (score < optimumscore) {

                    //System.out.println(Language_Profile.subList(0,50));
                    optimumscore = score;
                    detected = file.toString().split("/")[1];
                    //System.out.println(detected);
                }
            }

            //System.out.println("------" + detected);
            String label = detected.substring(detected.length()-3,detected.length()-1);

            System.out.println("\n****************************************\nLanguage of the Document: "+ detected);
            return label;
        }
    }

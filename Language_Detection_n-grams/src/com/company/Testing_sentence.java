package com.company;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Testing_sentence
{
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Properties props = new Properties();
        props.put("annotators", "tokenize");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        System.out.print("Enter the sentence: ");

        String text = scanner.nextLine();

        //System.out.println(text);
        Detection_test.get_Language(text,pipeline);
    }
}

//cs Jen přijeďte, a my si pak můžeme být jisti, že Smlouva bude schválena, až zazní názory podobné těm vašim, a ozve se hlas takové kontinentální Evropy, kterou si vy přejete rozvíjet.
//cs Bylo zde zmíněno, že toto soutěžení nebylo příliš velké, alespoň ne dosud. // for (ambiguity)


package org.kazu;

public class kuromoji_cli {
    
    public static void main( String[] args ) {

        if (args.length < 1) {
            System.out.println("You must specify the text for Tokenization!");
            return;
        }

        String input = args[1];
//        String input = args[0].replaceAll("\\s","");

        Object cliTokenizerClient;
        String type = args[0].toLowerCase();

        if (type.contains("ipadic")) {
            System.out.println("==== IPAdic =======================");
            cliTokenizerClient = new cliIPAdic();
        } else if (type.contains("unidic")) {
            System.out.println("==== UniDic =======================");
            cliTokenizerClient = new cliUnidic();
        } else {
            System.out.println("==== IPAdic =======================");
            cliTokenizerClient = new cliIPAdic();
            ((cliClient)cliTokenizerClient).transform(input);
            System.out.println("==== UniDic =======================");
            cliTokenizerClient = new cliUnidic();
        }
        ((cliClient)cliTokenizerClient).transform(input);
    }
}

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
            System.out.println("== IPAdic =========================");
            cliTokenizerClient = new cliKuromojiIPA();
            ((cliClient)cliTokenizerClient).transform(input);
            System.out.println("==== Lucene/Solr =======================");
            cliTokenizerClient = new cliLuceneIPA();
        } else if (type.contains("unidic")) {
            System.out.println("== UniDic =========================");
            cliTokenizerClient = new cliKuromojiUniDic();
            ((cliClient)cliTokenizerClient).transform(input);
        } else {
            System.out.println("== IPAdic =========================");
            cliTokenizerClient = new cliKuromojiIPA();
            ((cliClient)cliTokenizerClient).transform(input);
            System.out.println("== UniDic ==========================");
            cliTokenizerClient = new cliKuromojiUniDic();
            ((cliClient)cliTokenizerClient).transform(input);
            System.out.println("== Lucene/Solr (IPAdic) ==========================");
            cliTokenizerClient = new cliLuceneIPA();
            ((cliClient)cliTokenizerClient).transform(input);
        }
        ((cliClient)cliTokenizerClient).transform(input);
    }
}

package org.kazu;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import java.util.List;

public class kuromoji_cli {
    public static void main( String[] args ) {

        if (args.length < 1) {
            System.out.println("You must specify the text for Tokenization!");
            return;
        }

        String input = args[0];
//        String input = args[0].replaceAll("\\s","");

        Tokenizer tokenizer = new Tokenizer();
        List<Token> tokens = tokenizer.tokenize(input);
        for (Token token : tokens) {
            System.out.println(token.getSurface() + "\t" + token.getAllFeatures());
        }
        System.out.println("EOS");
    }
}

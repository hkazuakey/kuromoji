package org.kazu;

import com.atilika.kuromoji.unidic2.Token;
import com.atilika.kuromoji.unidic2.Tokenizer;

import java.util.List;

public class cliUnidic2 extends cliClient {

    public cliUnidic2() {
        tokenizer = new Tokenizer();
    }

    @Override
    void transform(String input) {
        List<Token> tokens = ((Tokenizer)tokenizer).tokenize(input);
        for (Token token : tokens) {
            System.out.println(token.getSurface() + "\t" + token.getAllFeatures());
        }
        System.out.println("EOS");
    }
}
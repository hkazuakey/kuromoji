package org.kazu;

import com.atilika.kuromoji.ipadic2.Token;
import com.atilika.kuromoji.ipadic2.Tokenizer;

import java.util.List;

public class cliIPAdic2 extends cliClient {

    public cliIPAdic2() {
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
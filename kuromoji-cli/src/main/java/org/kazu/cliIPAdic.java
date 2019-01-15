package org.kazu;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

import java.util.List;

public class cliIPAdic extends cliClient {

    public cliIPAdic() {
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
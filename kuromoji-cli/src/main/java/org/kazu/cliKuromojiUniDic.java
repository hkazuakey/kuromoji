package org.kazu;

import com.atilika.kuromoji.unidic.Token;
import com.atilika.kuromoji.unidic.Tokenizer;

import java.util.List;

public class cliUnidic extends cliClient {

    public cliUnidic() {
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
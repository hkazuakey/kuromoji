package org.kazu;

// import org.apache.lucene.analysis.ja;
import org.apache.lucene.analysis.ja.JapaneseTokenizer;
import org.apache.lucene.analysis.ja.Token;
import org.apache.lucene.analysis.ja.tokenattributes.*;
import org.apache.lucene.analysis.*;

import java.util.List;
import java.util.Locale;

public class cliLuceneIPA extends cliClient {

    JapaneseTokenizer.Mode mode = JapaneseTokenizer.Mode.valueOf(JapaneseTokenizer.DEFAULT_MODE.toString().toUpperCase(Locale.ROOT));

    public cliLuceneIPA() {
        tokenizer = new JapaneseTokenizer(
            TokenStream.DEFAULT_TOKEN_ATTRIBUTE_FACTORY,
            null,
            true,
            mode);
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
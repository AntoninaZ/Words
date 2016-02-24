package wordsandlearn.ua.wordsandlearn;

import java.util.ArrayList;

/**
 * Created by antonina on 24.02.16.
 */
public class WordObject extends ArrayList<LetterObject>{

    public LetterObject getLeterById(int id) {
        LetterObject letterObject = new LetterObject();
        for (LetterObject obj: this) {
            if (id == obj.getId()) {
                letterObject = obj;
            } else letterObject = null;
        }
        return letterObject;
    }

}

package wordsandlearn.ua.wordsandlearn.model;

import java.util.ArrayList;

import wordsandlearn.ua.wordsandlearn.model.LetterObject;

/**
 * Created by antonina on 24.02.16.
 */
public class WordObject extends ArrayList<LetterObject>{

    public LetterObject getLetterById(int id) {
        LetterObject letterObject = new LetterObject();
        for (LetterObject obj: this) {
            if (id == obj.getId()) {
                letterObject = obj;
                break;
            } else letterObject = null;
        }
        return letterObject;
    }

}

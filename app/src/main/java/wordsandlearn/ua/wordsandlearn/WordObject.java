package wordsandlearn.ua.wordsandlearn;

import java.util.ArrayList;

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

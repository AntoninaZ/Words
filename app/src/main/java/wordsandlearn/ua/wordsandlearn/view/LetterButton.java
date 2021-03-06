package wordsandlearn.ua.wordsandlearn.view;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;

import wordsandlearn.ua.wordsandlearn.model.LetterObject;

/**
 * Created by antonina on 26.02.2016.
 */
public class LetterButton extends Button {

      public LetterButton(Context context, LetterObject obj) {
        super(context);
        this.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
        this.setId(obj.getId());
        this.setText(obj.getLetter());
    }

}

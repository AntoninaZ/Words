package wordsandlearn.ua.wordsandlearn.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import wordsandlearn.ua.wordsandlearn.LetterObject;
import wordsandlearn.ua.wordsandlearn.WordObject;

/**
 * Created by antonina on 25.02.2016.
 */
public class UserWordLayout extends LinearLayout {
    private WordObject mWord = new WordObject();
    private int mWordLength;

    public UserWordLayout(Context context) {
        super(context);
    }

    public UserWordLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UserWordLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public UserWordLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public WordObject getWord() {
        return mWord;
     }

    public void addLetter(LetterObject obj) {
        mWord.add(obj);
        TextView letterTV = new TextView(getContext());
        letterTV.setTextSize(40);
        letterTV.setId(obj.getId());
        letterTV.setText(String.valueOf(obj.getLetter()));
        this.addView(letterTV);
    }

    public void deleteLetter () {
        mWordLength = mWord.size();
        if (mWordLength >= 1 ) {
            this.removeView(findViewById(mWord.get(mWordLength - 1).getId()));
            mWord.remove(mWordLength - 1);
            mWordLength -= 1;
        }
    }
}

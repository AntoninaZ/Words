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
    private Context mContext;
    private WordObject mWord = new WordObject();
    private int mWordLength;

    public UserWordLayout(Context context) {
        super(context);
        this.mContext = context;
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

    public void setWordLength() {
        mWordLength  = mWord.size();
    }

    public int getmWordLength() {
        return mWordLength;
    }

    public void addLetter(LetterObject obj) {
        mWord.add(obj);
        setWordLength();
        TextView tvLetter = new TextView(getContext());
        tvLetter.setTextSize(40);
        tvLetter.setId(obj.getId());
        tvLetter.setText(String.valueOf(obj.getLetter()));
        this.addView(tvLetter);
    }

    public void deleteLetter () {
        LetterObject removeLetter = mWord.get(mWordLength - 1);
        this.removeView(findViewById(removeLetter.getId()));
        mWord.remove(mWordLength - 1);
        setWordLength();
    }
}

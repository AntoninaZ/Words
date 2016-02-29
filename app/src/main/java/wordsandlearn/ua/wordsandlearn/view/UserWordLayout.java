package wordsandlearn.ua.wordsandlearn.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import wordsandlearn.ua.wordsandlearn.MainActivity;
import wordsandlearn.ua.wordsandlearn.WordFragment;
import wordsandlearn.ua.wordsandlearn.model.LetterObject;
import wordsandlearn.ua.wordsandlearn.model.WordObject;


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

    private int getWordLength() {
        return mWord.size();
    }

    public String getWord() {
        String word = "";
        for (LetterObject obj: mWord) {
            word += obj.getLetter();
        }
        return word;
     }

    public void addLetter(LetterObject obj) {
        mWord.add(obj);
        TextView tvLetter = new TextView(getContext());
        tvLetter.setTextSize(40);
        tvLetter.setId(obj.getId());
        tvLetter.setText(String.valueOf(obj.getLetter()));
        this.addView(tvLetter);
    }

    public void deleteLetter () {
        mWordLength = getWordLength();
        if (mWordLength >= 1 ) {
            this.removeView(findViewById(mWord.get(mWordLength - 1).getId()));
            ((WordFragment) ((MainActivity) getContext()).getPresentFragment())
                 .mCurrentWordLL.setEnableLetterButton(mWord.get(mWordLength - 1));
            mWord.remove(mWordLength - 1);
        }
    }

    public void clearWord () {
        this.removeAllViews();
        for (int i = getWordLength() - 1; i >= 0 ; i--) {
           ((WordFragment) ((MainActivity) getContext())
                 .getPresentFragment()).mCurrentWordLL.setEnableLetterButton(mWord.get(i));
            mWord.remove(i);
        }
    }
}

package wordsandlearn.ua.wordsandlearn.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import wordsandlearn.ua.wordsandlearn.model.LetterObject;
import wordsandlearn.ua.wordsandlearn.MainActivity;
import wordsandlearn.ua.wordsandlearn.WordFragment;
import wordsandlearn.ua.wordsandlearn.model.WordObject;

/**
 * Created by antonina on 22.02.2016.
 */
public class CurrentWordLayout extends LinearLayout implements View.OnClickListener {
     private String mWord;
    private WordObject mWordObject;

    public CurrentWordLayout(Context context) {
        super(context);
    }

    public void init(String word) {
        this.mWord = word;
        mWordObject = new WordObject();
        convertToWordObject();
        createCurrentLayout();
    }

    public CurrentWordLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CurrentWordLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CurrentWordLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void convertToWordObject() {
        for( int i = 0; i < mWord.length(); i++ ) {
            LetterObject obj = new LetterObject();
            obj.setId(i);
            obj.setLetter(String.valueOf(mWord.charAt(i)));
            mWordObject.add(obj);
        }
    }

    private void createCurrentLayout() {
        for (LetterObject obj: mWordObject) {
            LetterButton btn = new LetterButton(getContext(), obj);
            btn.setOnClickListener(this);
            this.addView(btn);
        }
    }

    public void setEnableLetterButton(LetterObject obj) {
        findViewById(obj.getId()).setEnabled(true);
    }

   @Override
   public void onClick(View v) {
       ((WordFragment)((MainActivity) getContext()).getPresentFragment())
               .mUserWordLL.addLetter(mWordObject.getLetterById(v.getId()));
       v.setEnabled(false);
    }
}

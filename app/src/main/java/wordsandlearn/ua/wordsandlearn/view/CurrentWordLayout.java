package wordsandlearn.ua.wordsandlearn.view;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import wordsandlearn.ua.wordsandlearn.LetterObject;
import wordsandlearn.ua.wordsandlearn.MainActivity;
import wordsandlearn.ua.wordsandlearn.WordFragment;
import wordsandlearn.ua.wordsandlearn.WordObject;

/**
 * Created by antonina on 22.02.2016.
 */
public class CurrentWordLayout extends LinearLayout implements View.OnClickListener {
    private Context mContext;
    private String mWord;
    private WordObject mWordObject;

    public CurrentWordLayout(Context context, String word) {
        super(context);
        this.mContext = context;
        this.mWord = word;
        mWordObject = new WordObject();
        this.setOrientation(HORIZONTAL);
        init();
    }

   public void init() {
        for( int i = 0; i < mWord.length(); i++ ) {
            LetterObject obj = new LetterObject();
            obj.setId(i);
            obj.setLetter(mWord.charAt(i));
            mWordObject.add(obj);
            this.addView(makeLetterBtn(obj));
        }
    }

    private Button makeLetterBtn(LetterObject obj) {
        Button letterBtn = new Button(mContext);
        letterBtn.setId(obj.getId());
        letterBtn.setText(String.valueOf(obj.getLetter()));
        letterBtn.setOnClickListener(this);
        return letterBtn;
    }

   @Override
   public void onClick(View v) {

       ((WordFragment)((MainActivity) mContext).getPresentFragment())
               .mUserWordLL.addLetter(mWordObject.getLetterById(v.getId()));
       v.setEnabled(false);
    }
}

package wordsandlearn.ua.wordsandlearn;

import android.content.Context;
import android.graphics.Color;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by antonina on 22.02.2016.
 */
public class WordLayout extends LinearLayout implements View.OnClickListener {
    private Context mContext;
    private String mWord;
    private WordObject mWordObject;

    public WordLayout(Context context, String word) {
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
               .updateUserWordTextView(mWordObject.getLeterById(v.getId()));

    }
}

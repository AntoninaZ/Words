package wordsandlearn.ua.wordsandlearn;

import android.content.Context;
import android.graphics.Color;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by antonina on 22.02.2016.
 */
public class WordLayout extends LinearLayout implements View.OnClickListener {
    private Context mContext;
    private RelativeLayout mCurrentWordRL;
    private String mWord;

    public WordLayout(Context context, String word) {
        super(context);
        this.mContext = context;
        this.mWord = word;
        this.setOrientation(HORIZONTAL);
        init();
    }

   public void init() {
        for( int i = 0; i < mWord.length(); i++ ) {
            this.addView(makeLetterBtn(i));
        }
    }

    private Button makeLetterBtn(int i) {
        Button letterBtn = new Button(mContext);
        letterBtn.setId(i);
        letterBtn.setWidth(30);
        letterBtn.setHeight(30);
        letterBtn.setBackgroundColor(Color.DKGRAY);
        letterBtn.setText(String.valueOf(mWord.charAt(i)));
        letterBtn.setOnClickListener(this);
        return letterBtn;
    }

    @Override
    public void onClick(View v) {
         Toast.makeText(mContext, String.valueOf(mWord.charAt(v.getId())), Toast.LENGTH_SHORT).show();
    }
}

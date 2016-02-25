package wordsandlearn.ua.wordsandlearn;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import wordsandlearn.ua.wordsandlearn.view.CurrentWordLayout;
import wordsandlearn.ua.wordsandlearn.view.UserWordLayout;

import static wordsandlearn.ua.wordsandlearn.Constans.CONST_TAG_LETTER_ADD;
import static wordsandlearn.ua.wordsandlearn.Constans.CONST_TAG_LETTER_DELETE;

/**
 * Created by antonina on 21.02.16.
 */
public class WordFragment extends Fragment implements View.OnClickListener{
    public UserWordLayout mUserWordLL;
    private Button mDeleteBtn;
    private Button mApplyBtn;
    private RelativeLayout mCurrentWordRL;
    private CurrentWordLayout mWordRL;

    public static WordFragment newInstance () {
        return new WordFragment();
    }

       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word, container, false);
        mUserWordLL = (UserWordLayout) view.findViewById(R.id.llUserWord);
        mDeleteBtn = (Button) view.findViewById(R.id.btnDelete);
           mDeleteBtn.setOnClickListener(this);
        mApplyBtn  = (Button) view.findViewById(R.id.btnApply);
        mCurrentWordRL = (RelativeLayout) view.findViewById(R.id.rlCurrentWord);
        mWordRL = new CurrentWordLayout(getActivity(), "word");
        mCurrentWordRL.addView(mWordRL);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDelete:
                    mUserWordLL.deleteLetter();
                break;
            case R.id.btnApply:
                break;
        }
    }
}
package wordsandlearn.ua.wordsandlearn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import wordsandlearn.ua.wordsandlearn.model.LetterObject;
import wordsandlearn.ua.wordsandlearn.view.CurrentWordLayout;
import wordsandlearn.ua.wordsandlearn.view.LetterButton;
import wordsandlearn.ua.wordsandlearn.view.UserWordLayout;

/**
 * Created by antonina on 21.02.16.
 */
public class WordFragment extends Fragment implements View.OnClickListener{
    public UserWordLayout mUserWordLL;
    private ImageButton mDeleteBtn;
    private ImageButton mApplyBtn;
    public CurrentWordLayout mCurrentWordLL;

    public static WordFragment newInstance () {
        return new WordFragment();
    }

       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word, container, false);
        mUserWordLL = (UserWordLayout) view.findViewById(R.id.llUserWord);
        mDeleteBtn = (ImageButton) view.findViewById(R.id.btnDelete);
           mDeleteBtn.setOnClickListener(this);
        mApplyBtn  = (ImageButton) view.findViewById(R.id.btnApply);
        mCurrentWordLL = (CurrentWordLayout) view.findViewById(R.id.llCurrentWord);
           mCurrentWordLL.init("woggru");
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
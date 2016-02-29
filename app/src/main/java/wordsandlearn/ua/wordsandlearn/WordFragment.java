package wordsandlearn.ua.wordsandlearn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

import wordsandlearn.ua.wordsandlearn.view.CurrentWordLayout;
import wordsandlearn.ua.wordsandlearn.view.UserWordLayout;

/**
 * Created by antonina on 21.02.16.
 */
public class WordFragment extends Fragment implements View.OnClickListener{
    public UserWordLayout mUserWordLL;
    private ImageButton mBackSpaceBtn;
    private ImageButton mClearBtn;
    private ImageButton mApplyBtn;
    private ListView mAllWordsLV;
    private ArrayAdapter<String> mAllWordsAdapter;
    private ArrayList<String> mAllWordsArray;
    public CurrentWordLayout mCurrentWordLL;

    public static WordFragment newInstance () {
        return new WordFragment();
    }

       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word, container, false);
           initViews(view);
           setListeners();
        return view;
    }
    private void initViews(View view) {
        mUserWordLL     = (UserWordLayout) view.findViewById(R.id.llUserWord);
        mBackSpaceBtn   = (ImageButton) view.findViewById(R.id.btnDelete);
        mClearBtn       = (ImageButton) view.findViewById(R.id.btnClear);
        mApplyBtn       = (ImageButton) view.findViewById(R.id.btnApply);
        mAllWordsLV     = (ListView) view.findViewById(R.id.lvAllWords);
        mAllWordsArray  = new ArrayList();
        mAllWordsAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, mAllWordsArray);
        mAllWordsLV.setAdapter(mAllWordsAdapter);
        mCurrentWordLL  = (CurrentWordLayout) view.findViewById(R.id.llCurrentWord);
        mCurrentWordLL.init("woggru");
    }

    private void setListeners() {
        mBackSpaceBtn.setOnClickListener(this);
        mClearBtn.setOnClickListener(this);
        mApplyBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDelete:
                mUserWordLL.deleteLetter();
                break;
            case R.id.btnApply:
                mAllWordsArray.add(mUserWordLL.getWord());
                mAllWordsAdapter.notifyDataSetChanged();
                break;
            case R.id.btnClear:
                mUserWordLL.clearWord();
                break;
        }
    }
}
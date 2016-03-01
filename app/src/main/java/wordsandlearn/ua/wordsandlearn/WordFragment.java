package wordsandlearn.ua.wordsandlearn;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import wordsandlearn.ua.wordsandlearn.adapters.VariableAdapter;
import wordsandlearn.ua.wordsandlearn.view.CurrentWordLayout;
import wordsandlearn.ua.wordsandlearn.view.UserWordLayout;

/**
 * Created by antonina on 21.02.16.
 */
public class WordFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener{
    public UserWordLayout mUserWordLL;
    private ImageButton mBackSpaceBtn;
    private ImageButton mClearBtn;
    private ImageButton mApplyBtn;
    private ListView mAllWordsLV;
    private VariableAdapter mAllWordsAdapter;
    private ArrayList<String> mAllWordsArray;
    public CurrentWordLayout mCurrentWordLL;

    private int position = 0;

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
        mAllWordsAdapter = new VariableAdapter(getContext(), 10);
        mAllWordsLV.setAdapter(mAllWordsAdapter);
        mCurrentWordLL  = (CurrentWordLayout) view.findViewById(R.id.llCurrentWord);
        mCurrentWordLL.init("woggru");
    }

    private void setListeners() {
        mBackSpaceBtn.setOnClickListener(this);
        mClearBtn.setOnClickListener(this);
        mApplyBtn.setOnClickListener(this);
        mAllWordsLV.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDelete:
                mUserWordLL.deleteLetter();
                break;
            case R.id.btnApply:
                mAllWordsAdapter.updateList(position, mUserWordLL.getWord());
                break;
            case R.id.btnClear:
                mUserWordLL.clearWord();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        view.setBackgroundColor(getActivity().getResources().getColor(R.color.light_pink));
    }
}
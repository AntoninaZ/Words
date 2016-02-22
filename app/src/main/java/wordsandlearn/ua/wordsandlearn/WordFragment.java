package wordsandlearn.ua.wordsandlearn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by antonina on 21.02.16.
 */
public class WordFragment extends Fragment{
    public static WordFragment newInstance () {
        return new WordFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_word, container, false);
            return view;
    }
}

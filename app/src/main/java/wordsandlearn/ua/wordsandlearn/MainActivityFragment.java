package wordsandlearn.ua.wordsandlearn;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import wordsandlearn.ua.wordsandlearn.adapters.MainGridAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static MainActivityFragment newInstance () {
        return new MainActivityFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        GridView gridview = (GridView) view.findViewById(R.id.gvMainMenu);
        gridview.setNumColumns(4);
        gridview.setAdapter(new MainGridAdapter(getActivity()));
        return view;
    }
}

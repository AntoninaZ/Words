package wordsandlearn.ua.wordsandlearn.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import wordsandlearn.ua.wordsandlearn.R;

/**
 * Created by antonina on 01.03.2016.
 */
public class VariableAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<String> mWordsArray;

    public VariableAdapter(Context c, int count) {
        mContext = c;
        mInflater = LayoutInflater.from(c);
        mWordsArray = new ArrayList<>(count);
    }

    @Override
    public int getCount() {
        return mWordsArray.size();
    }

    @Override
    public Object getItem(int position) {
        return mWordsArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateList(int position, String word) {
        mWordsArray.set(position, word);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
               View view = convertView;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.item_traslate_adapter, parent, false);
        }

        TextView tvWord = (TextView) view.findViewById(R.id.tvWordOrTranslate);
        tvWord.setText(mWordsArray.get(position));

        return view;
    }

}

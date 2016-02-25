package wordsandlearn.ua.wordsandlearn;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

/**
 * Created by antonina on 21.02.16.
 */
public class MainGridAdapter  extends BaseAdapter {
    private Context mContext;
    public String[] filenames = {
            "Word 1",
            "Word 2",
            "Word 3",
            "Word 4",
            "Word 5",
            "Word 6",
            "Word 7",
            "Word 8"};

    public MainGridAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return filenames.length;
    }

    public Object getItem(int position) {
        return filenames[position];
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Button btn;
        if (view == null) {
            btn = new Button(mContext);
            btn.setLayoutParams(new GridView.LayoutParams(100, 55));
            btn.setPadding(8, 8, 8, 8);
        }
        else {
            btn = (Button) view;
        }
        btn.setText(filenames[i]);
        btn.setTextColor(Color.DKGRAY);
        btn.setId(i);
        btn.setOnClickListener(new MyOnClickListener(i, mContext));
        return btn;
    }

    class MyOnClickListener implements View.OnClickListener {
        private final int position;
        private final Context c;

        public MyOnClickListener(int position, Context c)
        {
            this.position = position;
            this.c = c;
        }

        public void onClick(View v)
        {
            ((MainActivity) c).configContent(WordFragment.newInstance());
        }
    }
}

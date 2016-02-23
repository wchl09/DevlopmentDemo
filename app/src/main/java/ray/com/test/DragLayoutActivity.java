package ray.com.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DragLayoutActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView mListView;
    private DragDrawerLayout mDragDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_drag_layout);
        mDragDrawerLayout = (DragDrawerLayout) findViewById(R.id.DragLayout);
        findViewById(R.id.handler).setOnClickListener(this);
        mListView = (ListView) findViewById(R.id.contentListView);
        mListView.setAdapter(new MyAdapter());
    }

    @Override
    public void onClick(View v) {
        mDragDrawerLayout.animateToggle();
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 40;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = new TextView(DragLayoutActivity.this);
            }
            ((TextView) convertView).setText("这是第" + position + "个");
            return convertView;
        }
    }

}

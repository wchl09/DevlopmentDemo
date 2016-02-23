package ray.com.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MoveImageViewActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        mListView = (ListView) findViewById(R.id.content);
        mListView.setAdapter(new MyAdapter());
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                for (int i = 0; i < visibleItemCount; i++) {
                    View child = view.getChildAt(i);
                    //子布局一般都会有嵌套，用child.findViewById初始化MyImageView就行
                    //必须是MyImageView重绘才行
                    child.invalidate();
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 5;
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
            MyImageView myImageView;
            if (convertView == null) {
                myImageView = new MyImageView(MoveImageViewActivity.this);
            } else {
                myImageView = (MyImageView) convertView;
            }
            myImageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 600));
            myImageView.setRadius(0.4f);
            int imageId;
            switch (position) {
                case 1:
                    imageId = R.mipmap.l2;
                    break;
                case 2:
                    imageId = R.mipmap.l3;
                    break;
                case 3:
                    imageId = R.mipmap.l4;
                    break;
                case 4:
                    imageId = R.mipmap.l5;
                    break;
                default:
                    imageId = R.mipmap.l1;
                    break;
            }
            myImageView.setImageDrawable(getDrawable(imageId));
            return myImageView;
        }
    }
}

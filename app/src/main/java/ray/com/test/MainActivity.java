package ray.com.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Ray";
    /**
     * The {@link PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_main);
        String a = "Rayon";
        Log.e(TAG, getClass().getName()+"onCreate");
//        HttpClient client;
//        Window window = getWindow();
//        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        StickyScrollView

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        findViewById(R.id.tabLayout);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
//        tabLayout.addTab(tabLayout.newTab().setText("第一个").setIcon(R.mipmap.ic_launcher));
//        tabLayout.addTab(tabLayout.newTab().setText("第二个").setIcon(R.mipmap.ic_launcher));
//        tabLayout.addTab(tabLayout.newTab().setText("第三个").setIcon(R.mipmap.ic_launcher));
        mSectionsPagerAdapter = new SectionsPagerAdapter(MainActivity.this, getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                startActivity(new Intent(MainActivity.this, MoveImageViewActivity.class));
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {
        static Activity mActivity;
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(Activity activity, int sectionNumber) {
            if (mActivity == null)
                mActivity = activity;
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            Log.e(TAG, getClass().getName()+"onCreate");
            super.onCreate(savedInstanceState);
        }

        @Override
        public void onAttach(Context context) {
            Log.e(TAG, getClass().getName()+"onAttach");
            super.onAttach(context);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            Log.e(TAG, getClass().getName()+"onActivityCreated");
            super.onActivityCreated(savedInstanceState);
        }

        @Override
        public void onDestroy() {
            Log.e(TAG, getClass().getName()+"onDestroy");
            super.onDestroy();
        }

        @Override
        public void onDetach() {
            Log.e(TAG, getClass().getName()+"onDetach");
            super.onDetach();
        }

        @Override
        public void onDestroyView() {
            Log.e(TAG, getClass().getName()+"onDestroyView");
            super.onDestroyView();
        }

        @Override
        public void onPause() {
            Log.e(TAG, getClass().getName()+"onPause");
            super.onPause();
        }

        @Override
        public void onResume() {
            Log.e(TAG, getClass().getName()+"onResume");
            super.onResume();
        }

        @Override
        public void onViewStateRestored(Bundle savedInstanceState) {
            Log.e(TAG, getClass().getName()+"onViewStateRestored");
            super.onViewStateRestored(savedInstanceState);
        }

        @Override
        public void onStart() {
            Log.e(TAG, getClass().getName()+"onStart");
            super.onStart();
        }

        @Override
        public void onStop() {
            Log.e(TAG, getClass().getName()+"onStop");
            super.onStop();
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            Log.e(TAG, getClass().getName()+"onViewCreated");
            super.onViewCreated(view, savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.e(TAG, getClass().getName()+"onCreateView");
            View rootView = null;
            int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
            if (sectionNumber == 1) {

                rootView = inflater.inflate(R.layout.guid_fragment_layout, container, false);
                rootView.findViewById(R.id.showMyImageView).setOnClickListener(this);
                rootView.findViewById(R.id.showDragLayout).setOnClickListener(this);
                rootView.findViewById(R.id.showMyScrollView).setOnClickListener(this);
                rootView.findViewById(R.id.showDrawerLayout).setOnClickListener(this);
                rootView.findViewById(R.id.scrollingActivity).setOnClickListener(this);
                rootView.findViewById(R.id.bitmapOPtions).setOnClickListener(this);
            } else {
                rootView = inflater.inflate(R.layout.fragment_main, container, false);
                WebView webView = (WebView) rootView.findViewById(R.id.web);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://www.baidu.com");
            }
            return rootView;
        }

        @Override
        public void onClick(View v) {
            Class<?> cls = null;
            switch (v.getId()) {
                case R.id.showMyImageView://打开带视差动画的ImageView
                    cls = MoveImageViewActivity.class;
                    break;
                case R.id.showDragLayout:
                    cls = DragLayoutActivity.class;
                    break;
                case R.id.showMyScrollView://可以超出边界的Scrollview
                    cls = ScrollViewActivity.class;
                    break;
                case R.id.showDrawerLayout:
                    cls = Main22Activity.class;
                    break;
                case R.id.scrollingActivity:
                    cls = ScrollingActivity.class;
                    break;
                case R.id.bitmapOPtions:
                    cls = Main23Activity.class;
                    break;
            }
            startActivity(new Intent(getContext(), cls));
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        Activity activity;

        public SectionsPagerAdapter(Activity activity, FragmentManager fm) {
            super(fm);
            activity = activity;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(activity, position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }

    @Override
    protected void onStart() {
        Log.e(TAG, getClass().getName()+"onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG, getClass().getName()+"onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, getClass().getName()+"onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(TAG, getClass().getName()+"onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG,getClass().getName()+ "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, getClass().getName()+"onDestroy");
        super.onDestroy();
    }
}


package ray.com.test;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class Main23Activity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main23, menu);
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
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
            synchronized ()
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        @Override
        public void onCreate(Bundle savedInstanceState) {
            Log.e(MainActivity.TAG, getClass().getName() + "onCreate");
            super.onCreate(savedInstanceState);
        }

        @Override
        public void onAttach(Context context) {
            Log.e(MainActivity.TAG, getClass().getName()+"onAttach");
            super.onAttach(context);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            Log.e(MainActivity.TAG, getClass().getName()+"onActivityCreated");
            super.onActivityCreated(savedInstanceState);
        }

        @Override
        public void onDestroy() {
            Log.e(MainActivity.TAG, getClass().getName()+"onDestroy");
            super.onDestroy();
        }

        @Override
        public void onDetach() {
            Log.e(MainActivity.TAG, getClass().getName()+"onDetach");
            super.onDetach();
        }

        @Override
        public void onDestroyView() {
            Log.e(MainActivity.TAG, getClass().getName()+"onDestroyView");
            super.onDestroyView();
        }

        @Override
        public void onPause() {
            Log.e(MainActivity.TAG, getClass().getName()+"onPause");
            super.onPause();
        }

        @Override
        public void onResume() {
            Log.e(MainActivity.TAG, getClass().getName()+"onResume");
            super.onResume();
        }

        @Override
        public void onViewStateRestored(Bundle savedInstanceState) {
            Log.e(MainActivity.TAG, getClass().getName()+"onViewStateRestored");
            super.onViewStateRestored(savedInstanceState);
        }

        @Override
        public void onStart() {
            Log.e(MainActivity.TAG, getClass().getName()+"onStart");
            super.onStart();
        }

        @Override
        public void onStop() {
            Log.e(MainActivity.TAG, getClass().getName()+"onStop");
            super.onStop();
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            Log.e(MainActivity.TAG, getClass().getName()+"onViewCreated");
            super.onViewCreated(view, savedInstanceState);
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.e(MainActivity.TAG, getClass().getName()+"onCreateView");
            View rootView = inflater.inflate(R.layout.fragment_main23, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
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
}

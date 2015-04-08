package cc.jhz.cgup;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class MainPage extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    int BundleToGuidePageVal = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);


        // Set up the drawer+.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        String tempString  = null ;
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (position+1){
            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                        .commit();
                BundleToGuidePageVal = position;
                setTitle(R.string.menu1);

                break;
            case 2:
                StatusFragment statusFragment = new StatusFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, statusFragment)
                        .commit();
                BundleToGuidePageVal = position;
                setTitle(R.string.menu2);
                break;
            case 3:

                BundleToGuidePageVal = position;
                setTitle(R.string.menu3);
                break;
            case 4:

                BundleToGuidePageVal = position;
                setTitle(R.string.menu4);
                break;
            case 5:

                BundleToGuidePageVal = position;
                setTitle(R.string.menu5);
                break;

        }

    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.menu1);
                break;
            case 2:
                mTitle = getString(R.string.menu2);
                break;
            case 3:
                mTitle = getString(R.string.menu3);
                break;
            case 4:
                mTitle =getString(R.string.menu4);
                break;
            case 5:
                mTitle =getString(R.string.menu5);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        //actionBar.setDisplayShowTitleEnabled(true);
        //actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        //actionBar.setLogo(R.drawable.btnback);
        //actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main_page, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id==R.id.action_example)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("BundleToGuidePageVal",BundleToGuidePageVal);
            Intent welcomeToMain= new Intent(this,GuidePage.class);
            welcomeToMain.putExtras(bundle);
            startActivity(welcomeToMain);

            return true;

        }
        //noinspection SimplifiableIfStatement


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

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int[] imageRes = {R.drawable.polarbear,R.drawable.chimpazees,R.drawable.macaw,R.drawable.fox,R.drawable.panda,
                    R.drawable.seal,R.drawable.gorilla,
                    R.drawable.redpanda,R.drawable.sloth};
            View rootView = inflater.inflate(R.layout.fragment_main_page, container, false);
            ListView mainpagelistview = (ListView)rootView.findViewById(R.id.fragment_main_page_listview);
            mainpagelistview.setAdapter(new CustomerbaseadAdapter(getActivity(),imageRes));
            mainpagelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getActivity(),"This is position:"+ position,Toast.LENGTH_LONG).show();
                }
            });
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainPage) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}

package cc.jhz.cgup;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import cc.jhz.cgup.service.ScreenService;
import cc.jhz.cgup.service.ScreenService2;


public class MainPage extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;;
    private  FragmentManager fragmentManager;
    int BundleToGuidePageVal = 0 , Position2,AnimalNo;
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

    /*2015/4/19
    *  1. MainPage.java creative two method setPosition ,getPosition and startIntent
    * setPosition value passed by PlaceholderFragment content (listview setonclickListener).
    *  2. if setonclicklisener event happen in PlaceholderFragment, it will call two method getPosition and startIntent in Main.java
    * and go to IntroAnimals's Activity.
    * */

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        fragmentManager = getSupportFragmentManager();
        switch (position+1){
            case 1:
                PlaceholderFragment placeholderFragment = new PlaceholderFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, placeholderFragment)
                        .commit();
                BundleToGuidePageVal = position;
                setTitle(R.string.menu1);
                break;
            case 2:
                CheckPos();

                Toast.makeText(this,""+Position2,Toast.LENGTH_SHORT).show();
                    fragmentManager.beginTransaction()
                            .replace(R.id.container,  AnimalAnimation.newInstance(Position2))
                            .commit();
                    BundleToGuidePageVal = position;

                setTitle(R.string.menu2);
                break;
            case 5:

                BundleToGuidePageVal = position;
                setTitle(R.string.menu5);
                break;

        }

    }
    public int getAnimalNo(){
        return this.AnimalNo;
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
        //actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.customactionbar);
        actionBar.setDisplayUseLogoEnabled(true);
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

    @Override
    protected void onResume() {
        super.onResume();

    }
    public void CheckPos()
    {
        SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
        String animal =  preferences.getString("AnimalNO", "");
        if(animal.equals(""))
        {
            Position2 = 0 ;
        }
        else
        {
            Position2 = Integer.valueOf(animal);
        }

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        private static final String ARG_SECTION_NUMBER = "section_number";


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
            int[] imageRes = {
                    R.drawable.phnimalsanimals_01,R.drawable.phnimalsanimals_02
                    ,R.drawable.phnimalsanimals_03,R.drawable.phnimalsanimals_04
                   };
            View rootView = inflater.inflate(R.layout.fragment_main_page, container, false);
            ListView mainpagelistview = (ListView)rootView.findViewById(R.id.fragment_main_page_listview);
            mainpagelistview.setAdapter(new CustomerbaseadAdapter(getActivity(),imageRes));
            mainpagelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    getActivity().getSupportFragmentManager().
                            beginTransaction()
                            .replace(R.id.container, new IntroAnimals().newInstance(position)).commit();

                }
            });
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            //((MainPage) activity).onSectionAttached(
                //    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}

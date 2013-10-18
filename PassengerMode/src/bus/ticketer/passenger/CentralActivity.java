package bus.ticketer.passenger;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.*;
import android.view.*;

public class CentralActivity extends FragmentActivity {
	CentralPagerAdapter mCentralActivity;
	ViewPager mViewPager;
	private int nSwipes = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_central);
		
        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        mCentralActivity =
                new CentralPagerAdapter(
                        getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.CentralPager);
        mViewPager.setAdapter(mCentralActivity);
        
        final ActionBar actionBar = getActionBar();

        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create a tab listener that is called when the user changes tabs.
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {


			@Override
			public void onTabReselected(Tab arg0,
					android.app.FragmentTransaction arg1) {
				// probably ignore, eh?
				
			}

			@Override
			public void onTabSelected(Tab arg0,
					android.app.FragmentTransaction arg1) {
				// show the tab
				
			}

			@Override
			public void onTabUnselected(Tab arg0,
					android.app.FragmentTransaction arg1) {
				// hide the tab
				
			}
        };

        // Add 3 tabs, specifying the tab's text and TabListener
        for (int i = 0; i < nSwipes; i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText("Tab " + (i + 1))
                            .setTabListener(tabListener));
        }
	}

	public class CentralPagerAdapter extends FragmentStatePagerAdapter {
	    public CentralPagerAdapter(FragmentManager fm) {
	        super(fm);
	    }

	    @Override
	    public Fragment getItem(int i) {
	        Fragment fragment = new CentralFragment();
	        Bundle args = new Bundle();
	        // Our object is just an integer :-P
	        args.putInt(CentralFragment.ARG_OBJECT, i + 1);
	        fragment.setArguments(args);
	        return fragment;
	    }

	    @Override
	    public int getCount() {
	        return nSwipes;
	    }

	    @Override
	    public CharSequence getPageTitle(int position) {
	        return "OBJECT " + (position + 1);
	    }
	}
	
	// Instances of this class are fragments representing a single
	// object in our collection.
	public static class CentralFragment extends Fragment {
	    public static final String ARG_OBJECT = "object";

	    @Override
	    public View onCreateView(LayoutInflater inflater,
	            ViewGroup container, Bundle savedInstanceState) {

	    	Bundle args = getArguments();
	    	View rootView;
	    	if(args.getInt(ARG_OBJECT) == 1) {
	    		rootView = inflater.inflate(
		                R.layout.fragment_show_tickets, container, false);	
	    	}
	    	else {
	    		rootView = inflater.inflate(
		                R.layout.fragment_buy_tickets, container, false);
	    	}
	    	
	        return rootView;
	    }
	}

}

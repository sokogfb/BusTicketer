package bus.ticketer.passenger;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class CentralActivity extends FragmentActivity {
	CentralPagerAdapter mCentralActivity;
	ViewPager mViewPager;
	static View rootView;
	private int nSwipes = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_central);
		
		tabHandler();
	}
	
	public void tabHandler() {
        mCentralActivity =
                new CentralPagerAdapter(
                        getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.CentralPager);
        mViewPager.setAdapter(mCentralActivity);
        
       mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        getActionBar().setSelectedNavigationItem(position);
                    }
                });
        
        final ActionBar actionBar = getActionBar();
        
        actionBar.setDisplayShowTitleEnabled(false); 
        actionBar.setDisplayShowHomeEnabled(false);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {


			@Override
			public void onTabReselected(Tab arg0,
					android.app.FragmentTransaction arg1) {
				// probably ignore, eh?
				
			}

			@Override
			public void onTabSelected(Tab arg0,
					android.app.FragmentTransaction arg1) {
				mViewPager.setCurrentItem(arg0.getPosition());
			}

			@Override
			public void onTabUnselected(Tab arg0,
					android.app.FragmentTransaction arg1) {
				// hide the tab
				
			}
        };

        actionBar.addTab(actionBar.newTab().setText("Validate").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Buy Tickets").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("History").setTabListener(tabListener));
        

	}

	public class CentralPagerAdapter extends FragmentStatePagerAdapter {
		
	    public CentralPagerAdapter(FragmentManager fm) {
	        super(fm);
	    }

	    @Override
	    public Fragment getItem(int i) {
	        Fragment fragment = new CentralFragment();
	        Bundle args = new Bundle();
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

	public static class CentralFragment extends Fragment {
	    public static final String ARG_OBJECT = "object";

	    @Override
	    public View onCreateView(LayoutInflater inflater,
	            ViewGroup container, Bundle savedInstanceState) {

	    	Bundle args = getArguments();
	    	if(args.getInt(ARG_OBJECT) == 1) {
	    		rootView = inflater.inflate(
		                R.layout.fragment_show_tickets, container, false);
	    		
	    		showTicketsHandler();
	    	}
	    	else if(args.getInt(ARG_OBJECT) == 2) {
	    		rootView = inflater.inflate(
		                R.layout.fragment_buy_tickets, container, false);
	    		
	    		buyTicketsHandler();
	    	}
	    	else {
	    		rootView = inflater.inflate(
		                R.layout.fragment_history_tickets, container, false);	    		
	    	}

	        return rootView;
	    }
	    
	    public void showTicketsHandler() {
			RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.ticket_radio);
			radioGroup.check(R.id.t1_radio);
			final TextView ticketsText = (TextView) rootView.findViewById(R.id.show_ticket_amount);
			ticketsText.setText("T1 Tickets");
		    radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		        public void onCheckedChanged(RadioGroup group, int checkedId) {
		          	switch(checkedId) {
		          		case R.id.t1_radio:
		          			ticketsText.setText("T1 Tickets");
		          			break;
		          		case R.id.t2_radio:
		          			ticketsText.setText("T2 Tickets");
		          			break;
		          		case R.id.t3_radio:
		          			ticketsText.setText("T3 Tickets");
		          			break;
	          			default:
	          				break;
		          	}
		          			
		        }
		    });	    	
	    }
	    
	    public void buyTicketsHandler() {
	    	Button t1Minus = (Button) rootView.findViewById(R.id.t1_ticket_minus);
	    	Button t2Minus = (Button) rootView.findViewById(R.id.t2_ticket_minus);
	    	Button t3Minus = (Button) rootView.findViewById(R.id.t3_ticket_minus);
	    	Button t1Plus = (Button) rootView.findViewById(R.id.t1_ticket_plus);
	    	Button t2Plus = (Button) rootView.findViewById(R.id.t2_ticket_plus);
	    	Button t3Plus = (Button) rootView.findViewById(R.id.t3_ticket_plus);
	    	final TextView t1Tickets = (TextView) rootView.findViewById(R.id.t1_ticket_quantity_buy);
	    	final TextView t2Tickets = (TextView) rootView.findViewById(R.id.t2_ticket_quantity_buy);
	    	final TextView t3Tickets = (TextView) rootView.findViewById(R.id.t3_ticket_quantity_buy);
	    	
	    	t1Minus.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					int current = Integer.parseInt(t1Tickets.getText().toString());
					
					if(current == 0)
						return;
					
					current--;
					t1Tickets.setText(current+"");
				}
	    		
	    	});
	    	
	    	t2Minus.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					int current = Integer.parseInt(t2Tickets.getText().toString());
					
					if(current == 0)
						return;
					
					current--;
					t2Tickets.setText(current+"");
				}
	    		
	    	});
	    	
	    	t3Minus.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					int current = Integer.parseInt(t3Tickets.getText().toString());
					
					if(current == 0)
						return;
					
					current--;
					t3Tickets.setText(current+"");
				}
	    		
	    	});
	    	
	    	t1Plus.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					int current = Integer.parseInt(t1Tickets.getText().toString());
					current++;
					t1Tickets.setText(current+"");
				}
	    		
	    	});
	    	
	    	t2Plus.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					int current = Integer.parseInt(t2Tickets.getText().toString());
					current++;
					t2Tickets.setText(current+"");
				}
	    		
	    	});
	    	
	    	t3Plus.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					int current = Integer.parseInt(t3Tickets.getText().toString());
					current++;
					t3Tickets.setText(current+"");
				}
	    		
	    	});
	    }
	}

}

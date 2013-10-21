package bus.ticketer.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import bus.ticketer.fragments.CentralFragment;

public class CentralPagerAdapter extends FragmentStatePagerAdapter {

	private int nSwipes = 3;
	
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

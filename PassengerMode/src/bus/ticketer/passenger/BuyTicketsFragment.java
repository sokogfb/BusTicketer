package bus.ticketer.passenger;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass. Activities that
 * contain this fragment must implement the
 * {@link BuyTicketsFragment.OnFragmentInteractionListener} interface to handle
 * interaction events. Use the {@link BuyTicketsFragment#newInstance} factory
 * method to create an instance of this fragment.
 * 
 */
@SuppressLint("NewApi")
public class BuyTicketsFragment extends Fragment {

	// TODO: Rename and change types and number of parameters
	public static BuyTicketsFragment newInstance(String param1, String param2) {
		BuyTicketsFragment fragment = new BuyTicketsFragment();
		return fragment;
	}

	public BuyTicketsFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater
				.inflate(R.layout.fragment_buy_tickets, container, false);
	}


}
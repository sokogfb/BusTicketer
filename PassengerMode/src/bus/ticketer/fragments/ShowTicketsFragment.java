package bus.ticketer.fragments;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bus.ticketer.connection.ConnectionThread;
import bus.ticketer.passenger.BusTicketer;
import bus.ticketer.passenger.R;
import bus.ticketer.utils.FileHandler;
import bus.ticketer.utils.Method;
import bus.ticketer.utils.RESTFunction;

public class ShowTicketsFragment extends Fragment {

	private View rootView;
	private RESTFunction currentFunction;
	private String IPAddress = "";

	@SuppressLint("HandlerLeak")
	private Handler threadConnectionHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

		}
	};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_show_tickets, container, false);
		IPAddress = ((BusTicketer) getActivity().getApplication()).getIPAddress();
		getTicketInfo();
		return rootView;
	}
	
	public void refresh() {
		getTicketInfo();
	}
	
	private void getTicketInfo() {
		FileHandler fHandler = new FileHandler(((BusTicketer) getActivity().getApplication()).getClientFilename(), "");
		ArrayList<String> fileContents = fHandler.readFromFile();

		currentFunction = RESTFunction.GET_CLIENT_TICKETS;
		
		ConnectionThread dataThread = new ConnectionThread(
				IPAddress+"list/" + fileContents.get(2),
				Method.GET, null, threadConnectionHandler, null,
				currentFunction, rootView, getActivity());
		dataThread.start();
	}
}

package bus.ticketer.passenger;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.widget.*;

public class MainActivity extends Activity {

    @SuppressLint("InlinedApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_Holo_NoActionBar_Fullscreen);
        setContentView(R.layout.activity_main);
        
        TextView text = (TextView) findViewById(R.id.terms_textbox);
        text.setMovementMethod(new ScrollingMovementMethod());
        
        Intent i = new Intent(MainActivity.this, CentralActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

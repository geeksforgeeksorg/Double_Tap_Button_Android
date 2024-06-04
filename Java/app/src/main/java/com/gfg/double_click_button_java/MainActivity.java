package com.gfg.double_click_button_java;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare the button from the layout file as Text View
        // Since the method works only on Views
        TextView dBtn = findViewById(R.id.btn);

        // Implementing a DoubleClickListener on the Button
        dBtn.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick(View v) {
                Toast.makeText(getApplicationContext(), "Double Click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // This class has methods that check if two clicks were registered
    // within a span of DOUBLE_CLICK_TIME_DELTA i.e., in our case
    // equivalent to 300 ms
    public abstract static class DoubleClickListener implements View.OnClickListener {
        private long lastClickTime = 0;

        @Override
        public void onClick(View v) {
            long clickTime = System.currentTimeMillis();
            if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA) {
                onDoubleClick(v);
            }
            lastClickTime = clickTime;
        }

        public abstract void onDoubleClick(View v);

        private static final long DOUBLE_CLICK_TIME_DELTA = 300; // milliseconds
    }
}

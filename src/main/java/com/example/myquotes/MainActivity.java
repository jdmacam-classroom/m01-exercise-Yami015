package com.example.myquotes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView quote;
    Button btnNext;

    String [] quotes = {
            "If you don't take risks, you can't create a future.",
            "Push through the pain. Giving up hurts more.",
            "Hard work is worthless for those that don't believe in themselves.",
            "The important thing is not how long you live. It's what you accomplish with your life.",
            "I'ts quiet, but you can hear it? Little by little the tides are changing, and the world with them.",
            "If you don't listen to anyone, you can't give proper advice.",
            "Sometimes you need a little wishful thinking to keep on living.",
            "I guess, as long as I have life, all I can do is fight with all my might.",
            "When you give up, that's when the game ends.",
            "You see, sometimes friends have to go away, but a part of them stays behind with you."
    };
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        quote = findViewById(R.id.textView);
        btnNext = findViewById(R.id.button);

        btnNext.setOnClickListener(v -> {
            if (index < quotes.length){
                quote.setText(quotes[index]);
                index++;
            }

            if (index == quotes.length){
                btnNext.setEnabled(false);
                btnNext.setText("Done");
            }

        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
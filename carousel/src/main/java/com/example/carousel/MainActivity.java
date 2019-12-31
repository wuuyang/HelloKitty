package com.example.carousel;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carousel.controls.Carousel;
import com.example.carousel.controls.CarouselAdapter;
import com.example.carousel.controls.CarouselItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Carousel carousel = findViewById(R.id.carousel);
        carousel.setOnItemClickListener(new CarouselAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CarouselAdapter<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        String.format("%s has been clicked",
                                ((CarouselItem) parent.getChildAt(position)).getName()),
                        Toast.LENGTH_SHORT).show();
            }
        });

        carousel.setOnItemSelectedListener(new CarouselAdapter.OnItemSelectedListener() {
            @Override
            public void onItemSelected(CarouselAdapter<?> parent, View view, int position, long id) {
                TextView txt = findViewById(R.id.selected_item);

                switch (position) {
                    case 0:
                        txt.setText("0");
                        break;
                    case 1:
                        txt.setText("1");
                        break;
                    case 2:
                        txt.setText("2");
                        break;
                    case 3:
                        txt.setText("3");
                        break;
                    case 4:
                        txt.setText("4");
                        break;
                    case 5:
                        txt.setText("5");
                        break;
                }
            }

            @Override
            public void onNothingSelected(CarouselAdapter<?> parent) {

            }
        });

    }
}

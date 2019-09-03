package com.example.onboardingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager nSliderViewPaper;
    private LinearLayout nDotLayout;

    private TextView[] nDots;
    private SliderAdapter sliderAdapter;

    private Button nNextBtn;
    private Button nBackBtn;

    private int nCurrentPage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nSliderViewPaper=findViewById(R.id.slideViewPager);
        nDotLayout=findViewById(R.id.dotsLayout);
        //control de botones
        nNextBtn=findViewById(R.id.button3);
        nBackBtn=findViewById(R.id.backbtn);

        sliderAdapter=new SliderAdapter(this);
        nSliderViewPaper.setAdapter(sliderAdapter);
        //Añade los puntos de imagenes
        addotsIndicator(0);
        //cambia de color a los puntos

        nSliderViewPaper.addOnPageChangeListener(viewListener);
        //Onclick Listener

        nNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nSliderViewPaper.setCurrentItem(nCurrentPage+1);
            }
        });
        nBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nSliderViewPaper.setCurrentItem(nCurrentPage-1);
            }
        });
    }

    public void addotsIndicator(int position){
            nDots=new TextView[3];
           nDotLayout.removeAllViews();
            for(int i=0;i<nDots.length;i++){
                nDots[i]=new TextView(this);
                nDots[i].setText(Html.fromHtml("&#8226;"));
                nDots[i].setTextSize(35);
                nDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

                nDotLayout.addView(nDots[i]);

            }
            if(nDots.length > 0){
                nDots[position].setTextColor(getResources().getColor(R.color.colorWhrite));
            }
    }

    ViewPager.OnPageChangeListener viewListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addotsIndicator(position);
            nCurrentPage=position;
            if(position==0){
                nNextBtn.setEnabled(true);
                nBackBtn.setEnabled(false);
                nBackBtn.setVisibility(View.INVISIBLE);

                nNextBtn.setText("Next");
                nBackBtn.setText("");
            }else if(position==nDots.length-1){
                nNextBtn.setEnabled(true);
                nBackBtn.setEnabled(true);
                nBackBtn.setVisibility(View.VISIBLE);

                nNextBtn.setText("Finish");
                nBackBtn.setText("Back");

            }else{
                nNextBtn.setEnabled(true);
                nBackBtn.setEnabled(true);
                nBackBtn.setVisibility(View.INVISIBLE);

                nNextBtn.setText("Next");
                nBackBtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}

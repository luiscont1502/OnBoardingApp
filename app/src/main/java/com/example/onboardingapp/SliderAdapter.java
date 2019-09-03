package com.example.onboardingapp;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.onboardingapp.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context=context;
    }
    public int[] slide_images={
            R.drawable.eat,
            R.drawable.code,
            R.drawable.codes
    };
    public String[] slide_headings={
      "Eat",
      "Sleep",
      "Code"
    };
    public String[] slide_descs={
            "Loren inoun deler sit amet",
            "Loren inoun deler sit amet",
            "Loren inoun deler sit amet"
    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject( View view,  Object o) {
        return view== (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView=(ImageView) view.findViewById(R.id.imageView3);
        TextView slideHeading=(TextView) view.findViewById(R.id.textView);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);

        container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
         container.removeView((RelativeLayout)object);

    }
    public void d(){
    String dt="msfkn";
    }
}

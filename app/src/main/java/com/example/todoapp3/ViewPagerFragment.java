package com.example.todoapp3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class ViewPagerFragment extends Fragment {
    public ViewPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_viewpager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textViewVP=view.findViewById(R.id.textVPFrag);
        ImageView image=view.findViewById(R.id.imageVPFrag);
        assert getArguments() != null;
        int pos=getArguments().getInt("pos");
        switch (pos){
            case 0:
                textViewVP.setText("Welcome to ToDo App!");
                image.setImageResource(R.drawable.first);
                break;
            case 1:
                textViewVP.setText("This App will help you to organize your life! ");
                image.setImageResource(R.drawable.second);
                break;
            case 2:
                textViewVP.setText("Organize.Enjoy.Live");
                image.setImageResource(R.drawable.third);
                break;


        }


    }
}
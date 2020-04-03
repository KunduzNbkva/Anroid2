package com.example.anroid2.ui.OnBoard;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anroid2.MainActivity;
import com.example.anroid2.Prefs;
import com.example.anroid2.R;
public class BoardFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView=view.findViewById(R.id.text_view);
        ImageView imageView=view.findViewById(R.id.image_view);
        final Button getStarted=view.findViewById(R.id.getStarted);
        int pos=getArguments().getInt("pos");
        switch(pos){
            case 0:
                textView.setText("Welcome to Task App!");
                imageView.setImageResource(R.drawable.i1);
                break;
            case 1:
                textView.setText("This App will help you to organize your life! ");
                imageView.setImageResource(R.drawable.i2);

                break;
            case 2:
                textView.setText("Organize.Enjoy.Live");
                imageView.setImageResource(R.drawable.i3);
                getStarted.setVisibility(View.VISIBLE);
                break;
        }
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prefs.getInstance(getContext()).saveShown();
                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finish();

            }
        });

    }
}

package com.example.guest.underthebridge.ui;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guest.underthebridge.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoriesActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addTopicButton) Button mAddTopicButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);

        mAddTopicButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mAddTopicButton) {
            FragmentManager fm = getFragmentManager();
            NewTopicFragment newTopicFragment = new NewTopicFragment();
            newTopicFragment.show(fm, "Topic Fragment");
        }
    }
}

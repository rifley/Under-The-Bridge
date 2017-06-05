package com.example.guest.underthebridge.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.underthebridge.R;

/**
 * Created by Guest on 6/5/17.
 */

public class NewTopicFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_topic_form, container, false);
        getDialog().setTitle("Topic Fragment");
        return rootView;
    }
}

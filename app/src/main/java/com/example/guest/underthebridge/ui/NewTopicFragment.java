package com.example.guest.underthebridge.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.guest.underthebridge.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 6/5/17.
 */

public class NewTopicFragment extends DialogFragment {

   EditText mTopicEditText;
   EditText mImageUrlEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_topic_form, container, false);
        getDialog().setTitle("Topic Fragment");
        mTopicEditText = (EditText) rootView.findViewById(R.id.topicEditText);
        mImageUrlEditText = (EditText) rootView.findViewById(R.id.imageUrlEditText);
        return rootView;
    }
}

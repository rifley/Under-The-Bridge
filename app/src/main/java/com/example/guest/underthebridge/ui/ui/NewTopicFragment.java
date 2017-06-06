package com.example.guest.underthebridge.ui.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.guest.underthebridge.R;
import com.example.guest.underthebridge.ui.models.Topic;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 6/5/17.
 */

public class NewTopicFragment extends DialogFragment implements View.OnClickListener{
    private DatabaseReference mTopicReference;

    EditText mTopicEditText;
    EditText mImageUrlEditText;
    ImageButton mTrollTickleButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_topic_form, container, false);
        getDialog().setTitle("Topic Fragment");
        mTopicEditText = (EditText) rootView.findViewById(R.id.topicEditText);
        mImageUrlEditText = (EditText) rootView.findViewById(R.id.imageUrlEditText);
        mTrollTickleButton = (ImageButton) rootView.findViewById(R.id.trollTickleButton);

        mTrollTickleButton.setOnClickListener(this);

        mTopicReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child("topics");

        return rootView;
    }

    @Override
    public void onClick(View v) {
        if(v == mTrollTickleButton) {
            String topic = mTopicEditText.getText().toString();
            String imageURL = mImageUrlEditText.getText().toString();

            Topic newTopic = new Topic(topic, imageURL);
            saveTopicToFirebase(newTopic);
            dismiss();
        }
    }
    public void saveTopicToFirebase(Topic newTopic) {
        mTopicReference.push().setValue(newTopic);
    }
}

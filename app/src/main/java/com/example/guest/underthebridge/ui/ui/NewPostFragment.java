package com.example.guest.underthebridge.ui.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.guest.underthebridge.R;
import com.example.guest.underthebridge.ui.models.Post;
import com.example.guest.underthebridge.ui.models.Topic;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Guest on 6/7/17.
 */

public class NewPostFragment extends DialogFragment implements View.OnClickListener {
    private DatabaseReference mTopicReference;
    private DatabaseReference mPostReference;

    EditText mPostTitleEditText;
    EditText mPostBodyEditText;
    ImageButton mTrollTickleButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_topic_form, container, false);
        getDialog().setTitle("Post Fragment");
        mPostTitleEditText = (EditText) rootView.findViewById(R.id.postTitleEditText);
        mPostBodyEditText = (EditText) rootView.findViewById(R.id.postBodyEditText);
        mTrollTickleButton = (ImageButton) rootView.findViewById(R.id.trollTickleButton);

        mTrollTickleButton.setOnClickListener(this);

        mTopicReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child("topics")
                .child("posts");

        mPostReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child("posts");


        return rootView;
    }

    @Override
    public void onClick(View v) {
        if(v == mTrollTickleButton) {
            String postTitle = mPostTitleEditText.getText().toString();
            String postBody = mPostBodyEditText.getText().toString();

            Post newPost = new Post(postTitle, postBody);
//            savePostToFirebase(newPost);
            dismiss();
        }
    }
    public void saveTopicToFirebase(Topic newTopic) {
        mTopicReference.push().setValue(newTopic);
    }
}

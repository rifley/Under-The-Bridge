package com.example.guest.underthebridge.ui.ui;

import android.app.FragmentManager;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.guest.underthebridge.R;
import com.example.guest.underthebridge.ui.adapters.TopicListAdapter;
import com.example.guest.underthebridge.ui.models.Topic;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoriesActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addTopicButton) Button mAddTopicButton;
    @Bind(R.id.categoriesRecyclerView) RecyclerView mCategoriesRecyclerView;

    private DatabaseReference mTopicReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    private TopicListAdapter mAdapter;

    public ArrayList<Topic> mTopics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);

        mTopicReference = FirebaseDatabase.getInstance().getReference("topics");
        setUpFirebaseAdapter();

        Log.d("REFERENCE", mTopicReference.child("-Km2UEs3MeMK0GIZnAG8").child("image").toString());

        mAddTopicButton.setOnClickListener(this);

    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Topic, TopicListAdapter.TopicViewHolder>
                (Topic.class, R.layout.topic_list_item, TopicListAdapter.TopicViewHolder.class, mTopicReference) {

            @Override
            public void populateViewHolder(TopicListAdapter.TopicViewHolder viewHolder, Topic model, int position) {
                viewHolder.bindTopic(model);
            }
        };
        mCategoriesRecyclerView.setHasFixedSize(true);
        mCategoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCategoriesRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
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

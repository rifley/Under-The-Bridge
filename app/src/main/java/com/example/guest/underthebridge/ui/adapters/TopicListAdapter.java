package com.example.guest.underthebridge.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.BinderThread;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.underthebridge.R;
import com.example.guest.underthebridge.ui.models.Topic;
import com.example.guest.underthebridge.ui.ui.TopicDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 6/7/17.
 */

public class TopicListAdapter extends RecyclerView.Adapter<TopicListAdapter.TopicViewHolder> {
    private  ArrayList<Topic> mTopics = new ArrayList<>();
    private Context mContext;

    public TopicListAdapter(Context context, ArrayList<Topic> topics){
        mContext = context;
        mTopics = topics;
    }

    @Override
    public TopicListAdapter.TopicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_list_item, parent, false);
        TopicViewHolder viewHolder = new TopicViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TopicListAdapter.TopicViewHolder holder, int position) {
        holder.bindTopic(mTopics.get(position));
    }

    @Override
    public int getItemCount() {
        return mTopics.size();
    }

    public static class TopicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final int MAX_WIDTH = 200;
        private static final int MAX_HEIGHT = 200;

        View view;
        private Context mContext;


        public TopicViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindTopic(Topic topic){
            TextView mTopicListTextView = (TextView) view.findViewById(R.id.topicTitleListTextView);
            ImageView mTopicListImageView = (ImageView) view.findViewById(R.id.topicListImageView);

            mTopicListTextView.setText(topic.getTitle());
            Picasso.with(mContext)
                    .load(topic.getImage())
                    .resize(MAX_WIDTH, MAX_HEIGHT)
                    .centerCrop()
                    .into(mTopicListImageView);
        }

        @Override
        public void onClick(View view){
            final ArrayList<Topic> topics = new ArrayList<>();
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("topics");
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        topics.add(snapshot.getValue(Topic.class));
                    }

                    int itemPosition = getLayoutPosition();

                    Intent intent = new Intent(mContext, TopicDetailActivity.class);
                    intent.putExtra("position", itemPosition + "");
                    intent.putExtra("topics", Parcels.wrap(topics));

                    mContext.startActivity(intent);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}

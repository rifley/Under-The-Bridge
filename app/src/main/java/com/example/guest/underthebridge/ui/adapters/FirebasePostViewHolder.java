package com.example.guest.underthebridge.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.underthebridge.R;
import com.example.guest.underthebridge.ui.models.Post;
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

/**
 * Created by Guest on 6/7/17.
 */

public class FirebasePostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View view;
    private Context mContext;

    public FirebasePostViewHolder (View itemView) {
        super(itemView);
        view = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindPost(Post post){
//        TextView mPostTitleListTextView = (TextView) view.findViewById(R.id.postTitleListTextView);
//        TextView mPostBodyListTextView = (TextView) view.findViewById(R.id.postBodyListTextView);


//        mPostTitleListTextView.setText(post.getTitle());
//        mPostBodyListTextView.setText(post.getBody());

    }
    @Override
    public void onClick(View view){
        final ArrayList<Post> posts = new ArrayList<>();
    }

}

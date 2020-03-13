package com.thesetediousthings.modelbuddy;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CommentRecyclerViewAdapter extends RecyclerView.Adapter<CommentRecyclerViewAdapter.ViewHolder> {

    private final Activity mParentActivity;
    private final List<Comment> mValues;

    public CommentRecyclerViewAdapter(Activity parent, List<Comment> comments) {
        mValues = comments;
        mParentActivity = parent;
    }

    @Override
    public CommentRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_list_content, parent, false);
        return new CommentRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CommentRecyclerViewAdapter.ViewHolder holder, int position) {

        Comment aComment = mValues.get(position);
        holder.mCreatedView.setText("A formtatted date");
        holder.mMadeByView.setText(aComment.getMadeBy());
        holder.mCommentView.setText(aComment.getComment());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mCreatedView;
        final TextView mMadeByView;
        final TextView mCommentView;

        ViewHolder(View view) {
            super(view);
            mCreatedView = (TextView) view.findViewById(R.id.comment_created);
            mMadeByView = (TextView) view.findViewById(R.id.comment_madeby);
            mCommentView = (TextView) view.findViewById(R.id.comment_comment);
        }
    }
}

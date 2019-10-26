package com.aysel.multirowrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static com.aysel.multirowrecyclerview.Family.CHILD_TYPE;
import static com.aysel.multirowrecyclerview.Family.PARENT_TYPE;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Family> mList;

    public Adapter(List<Family> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i) {
            case PARENT_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_parent, viewGroup, false);
                return new ParentViewHolder(view);
            case CHILD_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_child, viewGroup, false);
                return new ChildViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Family user = mList.get(i);
        if (user != null) {
            switch (user.getUserType()) {
                case PARENT_TYPE:
                    ((ParentViewHolder) viewHolder).mParentName.setText(user.getUserName());
                    break;
                case CHILD_TYPE:
                    ((ChildViewHolder) viewHolder).mChildName.setText(user.getUserName());
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList != null) {
            Family object = mList.get(position);
            if (object != null) {
                return object.getUserType();
            }
        }
        return 0;
    }

    private class ParentViewHolder extends RecyclerView.ViewHolder {
        TextView mParentName;

        public ParentViewHolder(View view) {
            super(view);
            mParentName = view.findViewById(R.id.tv_parent);
        }
    }

    private class ChildViewHolder extends RecyclerView.ViewHolder {
        TextView mChildName;

        public ChildViewHolder(View view) {
            super(view);
            mChildName = view.findViewById(R.id.tv_child);
        }
    }
}

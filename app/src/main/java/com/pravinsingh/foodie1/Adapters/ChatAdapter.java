package com.pravinsingh.foodie1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pravinsingh.foodie1.Modules.ChatModel;

import java.util.ArrayList;

import foodie1.R;

public class ChatAdapter extends RecyclerView.Adapter{

    ArrayList<ChatModel> chatModelArrayList;
    Context context;

    public ChatAdapter(ArrayList<ChatModel> chatModelArrayList, Context context) {
        this.chatModelArrayList = chatModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userholder,parent,false);
                return new UserViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.supportholder,parent,false);
                return new SupportViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ChatModel chatModel = chatModelArrayList.get(position);
        switch (chatModelArrayList.get(position).getSender()){
            case "user":
                ((UserViewHolder)holder).UserMsg.setText(chatModel.getMessage());
                break;
            case "support":
                ((SupportViewHolder)holder).SupportMsg.setText(chatModel.getMessage());
                break;

        }

    }

    @Override
    public int getItemCount() {
        return chatModelArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (chatModelArrayList.get(position).getSender()){
            case "user":
                return 0;
            case "support":
                return 1;
            default:return -1;
        }
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView UserMsg;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            UserMsg = itemView.findViewById(R.id.UserMsg);
        }
    }
    public static class SupportViewHolder extends RecyclerView.ViewHolder {
        TextView SupportMsg;
        public SupportViewHolder(@NonNull View itemView) {
            super(itemView);
            SupportMsg = itemView.findViewById(R.id.SupportMsg);
        }
    }

}

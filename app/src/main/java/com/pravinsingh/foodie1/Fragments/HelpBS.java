package com.pravinsingh.foodie1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.pravinsingh.foodie1.Adapters.ChatAdapter;
import com.pravinsingh.foodie1.Modules.ChatModel;
import com.pravinsingh.foodie1.Modules.MsgModel;
import com.pravinsingh.foodie1.RetroFitApi;

import java.util.ArrayList;

import foodie1.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HelpBS#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HelpBS extends BottomSheetDialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HelpBS() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HelpBS.
     */
    // TODO: Rename and change types and number of parameters
    public static HelpBS newInstance(String param1, String param2) {
        HelpBS fragment = new HelpBS();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    RecyclerView recyclerView;
    EditText sendmsg;
    ImageView send;
    ArrayList<ChatModel> chatModelArrayList;
    ChatAdapter chatAdapter;

    private final String USER_KEY = "user";
    private final String SUPPORT_KEY = "support";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_help_b_s, container, false);


        recyclerView = view.findViewById(R.id.recyclerViewchat);
        send = view.findViewById(R.id.send);
        sendmsg = view.findViewById(R.id.message);
        chatModelArrayList = new ArrayList<>();
        chatAdapter = new ChatAdapter(chatModelArrayList, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(chatAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sendmsg.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Please enter your message", Toast.LENGTH_SHORT).show();
                }
                getResponse(sendmsg.getText().toString());
                sendmsg.setText("");

            }
        });
        return view;

    }

    private void getResponse(String message) {
        chatModelArrayList.add(new ChatModel(message, USER_KEY));
        chatAdapter.notifyDataSetChanged();
        String url = "http://api.brainshop.ai/get?bid=163444&key=g82g8ZlVGh5ZlthY&uid=[uid]&msg=" + message;

        String BASE_URL = "http://api.brainshop.ai/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetroFitApi retroFitApi = retrofit.create(RetroFitApi.class);
        Call<MsgModel> call = retroFitApi.getMessage(url);
        call.enqueue((new Callback<MsgModel>() {
            @Override
            public void onResponse(Call<MsgModel> call, Response<MsgModel> response) {
                if (response.isSuccessful()) {
                    MsgModel msgModel = response.body();
                    chatModelArrayList.add(new ChatModel(msgModel.getCnt(), SUPPORT_KEY));
                    chatAdapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(chatModelArrayList.size() - 1);
                }
            }

            @Override
            public void onFailure(Call<MsgModel> call, Throwable t) {
                chatModelArrayList.add(new ChatModel("no response", SUPPORT_KEY));
                chatAdapter.notifyDataSetChanged();

            }
        }));
    }
}
package com.easv.oe.friendsv1.GUI;

import com.easv.oe.friendsv1.Model.*;
import com.easv.oe.friendsv1.R;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class FriendActivity03 extends ListActivity {

    Friends m_friends;
    FriendAdapter fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Friend Activity 03");

        m_friends = new Friends();

        fa = new FriendAdapter(this, R.layout.cell_extended, m_friends.getAll());
        this.setListAdapter(fa);
    }

    @Override
    public void onResume() {
        super.onResume();
        //fa.notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView parent,
                                View v, int position, long id) {
        // position is in the list!
        Toast.makeText(this, "Hi " + m_friends.getAll().get(position).getName() + "! Have you done your homework?",
                Toast.LENGTH_LONG).show();
    }
}

class FriendAdapter extends ArrayAdapter<BEFriend> {

    private ArrayList<BEFriend> friends;
    private final int[] colours = {
            Color.parseColor("#AAAAAA"),
            Color.parseColor("#EEEEEE")
    };


    public FriendAdapter(Context context, int textViewResourceId,
                         ArrayList<BEFriend> friends) {
        super(context, textViewResourceId, friends);
        this.friends = friends;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        if (v == null) {
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.cell_extended, null);
            Log.d("LIST", "Position: " + position + " View created");
        }
        else
            Log.d("LIST", "Position: " + position + " View Reused");

        v.setBackgroundColor(colours[position % colours.length]);


        BEFriend f = friends.get(position);

        TextView name = (TextView) v.findViewById(R.id.name);
        TextView phone = (TextView) v.findViewById(R.id.phone);
        ImageView favorite = (ImageView) v.findViewById(R.id.favorite);

        name.setText(f.getName());
        phone.setText(f.getPhone());

        favorite.setImageResource(f.isFavorite() ? R.drawable.ok : R.drawable.notok);

        return v;
    }
}

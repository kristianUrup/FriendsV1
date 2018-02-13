package com.easv.oe.friendsv1.GUI;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.easv.oe.friendsv1.Model.BEFriend;
import com.easv.oe.friendsv1.Model.Friends;

import java.util.ArrayList;

public class FriendActivity01 extends ListActivity {

    Friends m_friends;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Friend Activity 01");
        m_friends = new Friends();

        String[] friends;

        friends = m_friends.getNames();

        ListAdapter adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        friends);

        setListAdapter(adapter);

    }


    @Override
    public void onListItemClick(ListView parent, View v, int position,
                                long id) {

        Toast.makeText(this, "Hi " + m_friends.getAll().get(position).getName() + "! Have you done your homework?",
                Toast.LENGTH_SHORT).show();

    }



}

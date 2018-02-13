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

public class FriendActivity01A extends ListActivity {


    String[] m_friends;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Friend Activity 01");
        new FriendLoader().start();
        Toast.makeText(this, "We are ready....", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onListItemClick(ListView parent, View v, int position,
                                long id) {

        Toast.makeText(this, "Hi " + m_friends[position] + "! Have you done your homework?",
                Toast.LENGTH_SHORT).show();

    }

    void setupFriends(String[] f) {
        final String[] ff = f;
        runOnUiThread(new Runnable() {
            public void run() {
                ListAdapter adapter =
                        new ArrayAdapter<String>(FriendActivity01A.this,
                                android.R.layout.simple_list_item_1,
                                ff);

                setListAdapter(adapter);
            }
        });
    }

    class FriendLoader extends Thread
    {
        @Override
        public void run()
        {
            Friends m_friends = new Friends();
            String[] friends;
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            friends = m_friends.getNames();
            FriendActivity01A.this.setupFriends(friends);
        }
    }


}

package com.easv.oe.friendsv1.GUI;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.easv.oe.friendsv1.Model.BEFriend;
import com.easv.oe.friendsv1.Model.Friends;

import java.util.ArrayList;

public class FriendActivity01AS extends ListActivity {


    String[] m_friends;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Friend Activity 01");
        new FriendLoader().execute();
        Toast.makeText(this, "We are ready....", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onListItemClick(ListView parent, View v, int position,
                                long id) {

        Toast.makeText(this, "Hi " + m_friends[position] + "! Have you done your homework?",
                Toast.LENGTH_SHORT).show();

    }

    void setupFriends(String[] f) {

        m_friends = f;
        ListAdapter adapter =
                        new ArrayAdapter<String>(FriendActivity01AS.this,
                                android.R.layout.simple_list_item_1,
                                f);

                setListAdapter(adapter);
    }

                                        //input, progress, result
    class FriendLoader extends AsyncTask<Void, Void, String[]>
    {

        @Override
        protected String[] doInBackground(Void... voids) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new Friends().getNames();
        }

        @Override
        protected void onPostExecute(String[] result) {
            FriendActivity01AS.this.setupFriends(result);
        }
    }


}

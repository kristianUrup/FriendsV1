package com.easv.oe.friendsv1.GUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.easv.oe.friendsv1.Model.*;
import com.easv.oe.friendsv1.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class FriendActivity02  extends ListActivity {

    Friends m_friends;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Friend Activity 02");
        m_friends = new Friends();

        setListAdapter(createAdapter());

    }


    @Override
    public void onListItemClick(ListView parent,
                                View v, int position, long id)
    {
        // position is in the list!
        Toast.makeText(this, "Hi " + m_friends.getAll().get(position).getName() +"! Have you done your homework?",
                Toast.LENGTH_LONG).show();
    }



    private List<Map<String, String>> asListMap(List<BEFriend> src)
    {
        List<Map<String, String>> res =
                new ArrayList<Map<String, String>>();
        for (BEFriend s : src)
        {
            Map<String, String> e = new HashMap<String, String>();
            e.put("name", s.getName());
            e.put("phone", s.getPhone());
            res.add(e);
        }
        return res;
    }

    protected SimpleAdapter createAdapter() {
        SimpleAdapter adapter =
                new SimpleAdapter(this,
                        asListMap(m_friends.getAll()),
                        R.layout.cell,
                        new String[] { "name", "phone" },
                        new int[] { R.id.name, R.id.phone });

        return adapter;
    }

}

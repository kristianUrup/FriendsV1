package com.easv.oe.friendsv1.Model;

import java.util.ArrayList;

public class Friends {

	ArrayList<BEFriend> m_friends;
	
	public Friends()
	{
		m_friends = new ArrayList<BEFriend>();
		m_friends.add(new BEFriend("Ronni", "123456", true));
		m_friends.add(new BEFriend("Kristjan", "234567"));
		m_friends.add(new BEFriend("Nikolaj", "126256", true));
		m_friends.add(new BEFriend("Jan", "234567"));
		m_friends.add(new BEFriend("Hardy", "123456"));
		m_friends.add(new BEFriend("Rasmus", "994567"));
		m_friends.add(new BEFriend("Kenneth", "127426"));
		m_friends.add(new BEFriend("Frederik", "204587", true));
		m_friends.add(new BEFriend("Rune", "123456"));
		m_friends.add(new BEFriend("Gleen", "234567", true));
		m_friends.add(new BEFriend("Jimmy", "123456"));
		m_friends.add(new BEFriend("Klaus", "234567"));
		m_friends.add(new BEFriend("Jonathan", "123456"));
		m_friends.add(new BEFriend("Mads", "234567", true));
		m_friends.add(new BEFriend("Max", "123456"));
		m_friends.add(new BEFriend("Andy", "234567"));
	}
	
	public ArrayList<BEFriend> getAll()
	{ return m_friends; }
	
	public String[] getNames()
	{
		String[] res = new String[m_friends.size()];
		for(int idx=0; idx < res.length; idx++)
			res[idx] = m_friends.get(idx).getName();
		return res;
	}
	
	
}

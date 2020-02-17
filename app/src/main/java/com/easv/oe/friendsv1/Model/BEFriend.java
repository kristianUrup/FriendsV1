package com.easv.oe.friendsv1.Model;

public class BEFriend {

    private String m_name;
    private String m_phone;
    private Boolean m_isFavorite;
    private String m_homepage;

    public BEFriend(String name, String phone) {
        this(name, phone, false);
    }

    public BEFriend(String name, String phone, Boolean isFavorite) {
        m_name = name;
        m_phone = phone;
        m_isFavorite = isFavorite;
    }

    public String getPhone() {
        return m_phone;
    }


    public String getName() {
        return m_name;
    }

    public Boolean isFavorite() { return m_isFavorite; }

}

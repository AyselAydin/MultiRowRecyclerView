package com.aysel.multirowrecyclerview;

public class Family {
    public static final int PARENT_TYPE = 1;
    public static final int CHILD_TYPE = 2;

    private String userName;
    private int userType;

    public Family(String userName, int userType) {
        this.userName = userName;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}

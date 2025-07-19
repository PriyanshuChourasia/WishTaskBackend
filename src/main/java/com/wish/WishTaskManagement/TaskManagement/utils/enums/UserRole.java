package com.wish.WishTaskManagement.TaskManagement.utils.enums;

public enum UserRole {
    ADMIN("Administrator",1),
    DEVELOPER("Developer",2),
    USER("Standard User",3);

    private final String displayName;
    private final int level;

    UserRole( String displayName1, int level){
        this.displayName = displayName1;
        this.level = level;
    }

    public String getDisplayName(){
        return displayName;
    }

    public int getLevel(){
        return level;
    }
}

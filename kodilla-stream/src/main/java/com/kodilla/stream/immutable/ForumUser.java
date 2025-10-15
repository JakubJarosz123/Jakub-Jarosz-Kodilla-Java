package com.kodilla.stream.immutable;

public final class ForumUser {
    private final String userName;
    private final String realName;

    public ForumUser(final String username, final String realname, String userName, String realName) {
        this.userName = userName;
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public String getRealName() {
        return realName;
    }
}
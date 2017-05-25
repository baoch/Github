package com.sam.entity;

/**
 * Created by vieth on 5/23/2017.
 */
public class Account {
    private int accountId;
    private int roleId;
    private String username;
    private String password;
    private boolean isDeleted;
    private boolean isDeactivated;

    public Account() {
    }

    public Account(int accountId, int roleId, String username, String password, boolean isDeleted, boolean isDeactivated) {
        this.accountId = accountId;
        this.roleId = roleId;
        this.username = username;
        this.password = password;
        this.isDeleted = isDeleted;
        this.isDeactivated = isDeactivated;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        isDeleted = false;
        isDeactivated = false;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isDeactivated() {
        return isDeactivated;
    }

    public void setDeactivated(boolean deactivated) {
        isDeactivated = deactivated;
    }
}

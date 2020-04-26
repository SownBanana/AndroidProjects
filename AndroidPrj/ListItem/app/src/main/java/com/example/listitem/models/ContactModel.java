package com.example.listitem.models;

public class ContactModel {
    private String name;
    private  int avatarRs;
    boolean isSelected;

    public ContactModel(String name, int avatarRs) {
        this.name = name;
        this.avatarRs = avatarRs;
        this.isSelected = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatarRs() {
        return avatarRs;
    }

    public void setAvatarRs(int avatarRs) {
        this.avatarRs = avatarRs;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

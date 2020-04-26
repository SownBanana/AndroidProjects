package com.example.listitem.models;

import android.graphics.Color;

import java.util.Random;

public class MailModel {
    private String name;
    private String subject;
    private String content;
    private String time;
    private boolean isFavorite;
    private boolean isRead;
    private int rdColor;

    public MailModel(String name, String subject, String content, String time) {
        this.name = name;
        this.subject = subject;
        this.content = content;
        this.time = time;
        isFavorite = false;
        isRead = false;
        this.rdColor = new Random().nextInt(0xffffff);
    }

    public MailModel(String name, String subject, String content, String time, boolean isFavorite, boolean isRead) {
        this.name = name;
        this.subject = subject;
        this.content = content;
        this.time = time;
        this.isFavorite = isFavorite;
        this.isRead = isRead;
        this.rdColor = new Random().nextInt(0xffffff);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public MailModel(String name, String subject, String content, boolean isFavorite) {
        this.name = name;
        this.subject = subject;
        this.content = content;
        this.isFavorite = isFavorite;
    }

    public int getRdColor() {
        return rdColor;
    }

    public void setRdColor(int rdColor) {
        this.rdColor = rdColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}

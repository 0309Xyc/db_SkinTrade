package com.example.pojo;

public class ListingInfo {

    private double price;
    private String username;
    private String skin_name;
    private String weapon_type;

    public ListingInfo(Listing listing, User user, Item item) {
        this.price = listing.getPrice();
        this.username = user.getUsername();
        this.skin_name = item.getSkin_name();
        this.weapon_type = item.getWeapon_type();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSkin_name() {
        return skin_name;
    }

    public void setSkin_name(String skin_name) {
        this.skin_name = skin_name;
    }

    public String getWeapon_type() {
        return weapon_type;
    }

    public void setWeapon_type(String weapon_type) {
        this.weapon_type = weapon_type;
    }

    public ListingInfo() {
    }
}

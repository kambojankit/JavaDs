package com.techarha.training.ds;

public enum Marketplace {
    FLIPKART("http://api.flipkart.com", ""),
    AMAZON("api.amz.com",""),
    SNAPDEAL("api.spd.com","");

    private String url;
    private String userName;
    private String password;

    Marketplace(String url, String userName) {
        this.url = url;

        this.userName = userName;
        this.password = "asdf";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package com.techarha.training.ds;

public class MapTest {
    public static final String MAR_FLIPKART = "http://api.flipkart.com";
    public static final String MAR_FLIPKART_USER = "ABC_ZYS";
    public static final String MAR_FLIPKART_PASS = "PASS";
    public static final String MAR_AMAZON = "http://api.amazon.com";


    public static void main(String[] args) {
        System.out.println("My flipkart api url is: " + MAR_FLIPKART);
        System.out.println("My flipkart api url is: " + MAR_AMAZON);

        /*

         Connection cnnFlip = new HttpClient(MAR_FLIPKART, userName, pass)



         */


        Marketplace[] constants =  Marketplace.values();
        for(Marketplace marketplace: constants) {
            System.out.println(marketplace);
//            System.out.println(Marketplace.valueOf(marketplace.toString()));
        }


        System.out.println("My flipkart api url is: " + Marketplace.FLIPKART);
        System.out.println("My amazon api url is: " + Marketplace.AMAZON);
    }
}

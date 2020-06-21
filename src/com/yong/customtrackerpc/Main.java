package com.yong.customtrackerpc;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        String trackUrl = "http://defcon.or.kr:90/get%sInfo?trackNum=%d";
        int trackNum = Integer.valueOf(args[1]);
        if(args[0].equals("Track")){
            trackUrl = String.format(Locale.getDefault(), trackUrl, "Track", trackNum);
        }else if(args[0].equals("Parcel")){
            trackUrl = String.format(Locale.getDefault(), trackUrl, "Parcel", trackNum);
        }


    }
}

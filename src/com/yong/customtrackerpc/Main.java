package com.yong.customtrackerpc;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args){
        String defaultkUrl = "http://defcon.or.kr:90/get%sInfo?trackNum=%s";
        String trackUrl = "";
        String trackNum = args[1];
        if(args[0].equals("Track")){
            trackUrl = String.format(defaultkUrl, "Track", trackNum);
            getParcelData(trackUrl);
        }else if(args[0].equals("Parcel")){
            trackUrl = String.format(defaultkUrl, "Parcel", trackNum);
            getTrackData(trackUrl);
        }
    }

    static void getTrackData(String strURL){

    }

    static void getParcelData(String strURL){
        Source htmlSource = null;
        try {
            htmlSource = new Source(new URL(strURL));
            List<Element> tagList = htmlSource.getAllElements();

            System.out.println(htmlSource);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

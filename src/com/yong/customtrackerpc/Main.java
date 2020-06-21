package com.yong.customtrackerpc;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args){
        String defaultkUrl = "http://defcon.or.kr:90/get%sInfo?trackNum=%s";
        String trackUrl = "";
        String trackNum = args[1];
        if(args[0].equals("Track")){
            trackUrl = String.format(defaultkUrl, "Track", trackNum);
            getTrackData(trackUrl);
        }else if(args[0].equals("Parcel")){
            trackUrl = String.format(defaultkUrl, "Parcel", trackNum);
            getParcelData(trackUrl);
        }
    }

    static void getTrackData(String strURL){
        try {
            Source pageResult = new Source(new URL(strURL));
            String[] steps = pageResult.toString().split("&&\n");

            for(String step : steps){
                SimpleDateFormat formatBefore = new SimpleDateFormat("yyyyMMddHHmmss");
                Date date = formatBefore.parse(step.split(":")[0]);
                SimpleDateFormat formatAfter = new SimpleDateFormat("yyyy. MM. dd. HH:mm");
                String newDate = formatAfter.format(date);

                System.out.println(String.format("%s :%s", newDate, step.split(":")[1]));
            }

        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }
    }

    static void getParcelData(String strURL){
        try {
            Source htmlSource = new Source(new URL(strURL));

            System.out.println(htmlSource);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

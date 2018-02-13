package com.example.ullesy.ullesy.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by kailash on 15/2/18.
 */

public class AppConstants {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    public static  final  String formatedDate = dateFormat.format(Calendar.getInstance().getTime());

    public static final String API_SERVER_URL = "http://127.0.0.1:5551/";
    public static final String GIT_SERVER_URL = "https://api.github.com/";
    public static final String API_KEY="ULLESY@2018";

    public static final String EVERYDAY_FEED_URL=API_SERVER_URL+"news/everyday/"+API_KEY;

}

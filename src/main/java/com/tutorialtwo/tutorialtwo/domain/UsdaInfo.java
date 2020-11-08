package com.tutorialtwo.tutorialtwo.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class UsdaInfo {

    private static Log log = LogFactory.getLog(UsdaInfo.class);

    public void createUsdaMap(String[] args) throws IOException {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("src/main/resources/Zip2USDAZone.csv")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.error("Necessary file Zip2USDAZone.csv was not found.", e);

        }
        String str="";
        Map<String,String> usdaZipMap = new HashMap<String,String>();
        while((str=br.readLine())!=null)
        {
            usdaZipMap.put(str.split(",")[0],str.split(",")[1]);
        }
    }

    public static void createUsdaTempsMap(String[] args) throws IOException {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("src/main/resources/ZonesLowTemp.csv")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.error("Necessary file ZonesLowTemp.csv was not found.", e);

        }
        String str="";
        //Temps in F can add conversion logic later if needed
        Map<String,String> usdaLowTempsMap = new HashMap<String,String>();
        while((str=br.readLine())!=null)
        {
            usdaLowTempsMap.put(str.split(",")[0],str.split(",")[1]);
        }
        System.out.println(usdaLowTempsMap);

    }
}




package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args)
    {

        String json = "{" +
                "\"one\": 100.0, " +
                "\"two\": [10, 20, 30], " +
                "\"three\":{\"red\": 255, \"blue\": 26}" +
            "}";

        JSONObject myObject = null;

        try {
            myObject = new JSONObject(json);
            double one = myObject.getDouble("one");
            System.out.println("one: " + one);

            JSONObject colors = myObject.getJSONObject("three");
            int blue = colors.getInt("blue");
            System.out.println("blue: " + blue);

            int red = myObject.getJSONObject("three").getInt("red");
            System.out.println("red: " + red);

            JSONArray myArray = myObject.getJSONArray("two");
            int index = myArray.getInt(1);
            System.out.println("index: " + index);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        //QUIZ 5 LEAGUE PARSER
        LoLParser parsedLOL = new LoLParser();
        System.out.println(" server region: " + parsedLOL.region);
        System.out.println("       service: " + parsedLOL.game);
        System.out.println("service status: " + parsedLOL.gameStatus);
        System.out.println("");
        System.out.println("       service: " + parsedLOL.store);
        System.out.println("service status: " + parsedLOL.storeStatus);
        System.out.println("");
        System.out.println("       service: " + parsedLOL.website);
        System.out.println("service status: " + parsedLOL.websiteStatus);
        System.out.println("");
        System.out.println("       service: " + parsedLOL.client);
        System.out.println("service status: " + parsedLOL.clientStatus);
        System.out.println("");

        //url parsing
        /*
        URL myUrl = null;
        try
        {
            myUrl = new URL("https://itunes.apple.com/search?term=david+bowie&entity=album");
            //myUrl = new URL("https://na1.api.riotgames.com/lol/status/v3/shard-data");
            URLConnection myUrlConnection = myUrl.openConnection();

            java.io.InputStream myInputStream = myUrlConnection.getInputStream();

            InputStreamReader myInputStreamReader;
            myInputStreamReader = new InputStreamReader(myInputStream);

            BufferedReader in = new BufferedReader(myInputStreamReader);

            String line, str = null;

            str = "";
            System.out.print("\n");
            while ((line = in.readLine()) != null)
            {
                str += line;

                System.out.println(line);
            }

            JSONObject myJsonObject = new JSONObject(str);
            JSONArray results = myJsonObject.getJSONArray("results");

            for (int i = 0; i < results.length(); i++)
            {
                JSONObject subResult = results.getJSONObject(i);
                String name = subResult.getString("collectionName");
                System.out.println(name);
            }



            //league api parser


            JSONObject lolServices = new JSONObject(str);
            JSONArray services = lolServices.getJSONArray("services");

            for (int i = 0; i < results.length(); i ++)
            {
                JSONObject result = services.getJSONObject(i);
                String name = result.getString("name");
                System.out.println("name: " + name);
                JSONObject result2 = services.getJSONObject(i);
                String status = result2.getString("status");
                System.out.println("status: " + status);
            }



            JSONObject myJsonObject2;
            myJsonObject2 = new JSONObject(str);
            // Parse: You do!
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    */
    }
}

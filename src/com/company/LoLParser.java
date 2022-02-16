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

public class LoLParser
{
    String region;
    String game;
    String gameStatus;
    String store;
    String storeStatus;
    String website;
    String websiteStatus;
    String client;
    String clientStatus;
    public static final String test = "{\n" +
        "    \"name\": \"North America\",\n" +
        "    \"slug\": \"na\",\n" +
        "    \"locales\": [\n" +
        "        \"en_US\"\n" +
        "    ],\n" +
        "    \"hostname\": \"prod.na1.lol.riotgames.com\",\n" +
        "    \"region_tag\": \"na1\",\n" +
        "    \"services\": [\n" +
        "        {\n" +
        "            \"name\": \"Game\",\n" +
        "            \"slug\": \"game\",\n" +
        "            \"status\": \"online\",\n" +
        "            \"incidents\": [\n" +
        "                {\n" +
        "                    \"id\": 14190,\n" +
        "                    \"active\": true,\n" +
        "                    \"created_at\": \"2019-12-09T16:08:18.580Z\",\n" +
        "                    \"updates\": []\n" +
        "                },\n" +
        "                {\n" +
        "                    \"id\": 14383,\n" +
        "                    \"active\": true,\n" +
        "                    \"created_at\": \"2020-01-22T02:27:05.671Z\",\n" +
        "                    \"updates\": [\n" +
        "                        {\n" +
        "                            \"id\": \"5e27b2f98d0391e7b7333f51\",\n" +
        "                            \"author\": \"\",\n" +
        "                            \"heading\": \"10.02\",\n" +
        "                            \"content\": \"On 01/23/20, starting at, 01:30 Pacific Time (09:30 UTC), ranked queues will be disabled in preparation for patch 10.02. At 03:00 Pacific time (11:00 UTC), the servers will be shut down and all games currently in progress will end in a draw and stats will not be recorded. We estimate the battlegrounds will be unavailable for 3 hours.\",\n" +
        "                            \"severity\": \"info\",\n" +
        "                            \"created_at\": \"2020-01-22T02:27:05.671Z\",\n" +
        "                            \"updated_at\": \"2020-01-22T02:27:05.671Z\",\n" +
        "                            \"translations\": []\n" +
        "                        }\n" +
        "                    ]\n" +
        "                },\n" +
        "                {\n" +
        "                    \"id\": 14440,\n" +
        "                    \"active\": true,\n" +
        "                    \"created_at\": \"2020-02-04T02:21:37.928Z\",\n" +
        "                    \"updates\": [\n" +
        "                        {\n" +
        "                            \"id\": \"5e38d53100b0549fff19ccfc\",\n" +
        "                            \"author\": \"\",\n" +
        "                            \"heading\": \"10.03\",\n" +
        "                            \"content\": \"On 02/05/20, starting at, 01:30 Pacific Time (09:30 UTC), ranked queues will be disabled in preparation for patch 10.03. At 03:00 Pacific time (11:00 UTC), the servers will be shut down and all games currently in progress will end in a draw and stats will not be recorded. We estimate the battlegrounds will be unavailable for 3 hours.\",\n" +
        "                            \"severity\": \"info\",\n" +
        "                            \"created_at\": \"2020-02-04T02:21:37.928Z\",\n" +
        "                            \"updated_at\": \"2020-02-04T02:21:37.928Z\",\n" +
        "                            \"translations\": []\n" +
        "                        }\n" +
        "                    ]\n" +
        "                },\n" +
        "                {\n" +
        "                    \"id\": 14499,\n" +
        "                    \"active\": true,\n" +
        "                    \"created_at\": \"2020-02-18T23:38:54.567Z\",\n" +
        "                    \"updates\": [\n" +
        "                        {\n" +
        "                            \"id\": \"5e4c758eb8b4698f8188d3c3\",\n" +
        "                            \"author\": \"\",\n" +
        "                            \"heading\": \"10.04\",\n" +
        "                            \"content\": \"On 02/20/20, starting at, 01:30 Pacific Time (09:30 UTC), ranked queues will be disabled in preparation for patch 10.04. At 03:00 Pacific time (11:00 UTC), the servers will be shut down and all games currently in progress will end in a draw and stats will not be recorded. We estimate the battlegrounds will be unavailable for 3 hours.\",\n" +
        "                            \"severity\": \"info\",\n" +
        "                            \"created_at\": \"2020-02-18T23:38:54.567Z\",\n" +
        "                            \"updated_at\": \"2020-02-18T23:38:54.567Z\",\n" +
        "                            \"translations\": []\n" +
        "                        }\n" +
        "                    ]\n" +
        "                }\n" +
        "            ]\n" +
        "        },\n" +
        "        {\n" +
        "            \"name\": \"Store\",\n" +
        "            \"slug\": \"store\",\n" +
        "            \"status\": \"online\",\n" +
        "            \"incidents\": []\n" +
        "        },\n" +
        "        {\n" +
        "            \"name\": \"Website\",\n" +
        "            \"slug\": \"website\",\n" +
        "            \"status\": \"online\",\n" +
        "            \"incidents\": []\n" +
        "        },\n" +
        "        {\n" +
        "            \"name\": \"Client\",\n" +
        "            \"slug\": \"client\",\n" +
        "            \"status\": \"online\",\n" +
        "            \"incidents\": []\n" +
        "        }\n" +
        "    ]\n" +
        "}";
    public LoLParser()
    {
        JSONObject lolObject = null;
        try
        {
            lolObject = new JSONObject(test);
            region = lolObject.getString("name");

            JSONArray services = lolObject.getJSONArray("services");
            JSONObject service0 = services.getJSONObject(0);
            game = service0.getString("name");
            gameStatus = service0.getString("status");

            JSONObject service1 = services.getJSONObject(1);
            store = service1.getString("name");
            storeStatus = service1.getString("status");

            JSONObject service2 = services.getJSONObject(2);
            website = service2.getString("name");
            websiteStatus = service2.getString("status");

            JSONObject service3 = services.getJSONObject(3);
            client = service3.getString("name");
            clientStatus = service3.getString("status");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

}

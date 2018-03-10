package com.intolergy.intolergy;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ApiClient {
    static CookieManager cookieManager = new CookieManager();
    public static OkHttpClient client = new OkHttpClient.Builder()
            .cookieJar(new JavaNetCookieJar(cookieManager))
            .build();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final String baseURL = "https://intolergy.herokuapp.com/api";

    static String addQueries (String url, JSONObject queries) {
        if (!url.endsWith("?")) {
            url += "?";
        }
        Iterator<String> keys = queries.keys();
        while(keys.hasNext()) {
            try {
                String name= keys.next();
                String value = queries.getString(name);
                url += name + "=" + value + "&";
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return url;
    }

    static JSONObject get(String url, JSONObject queries) throws IOException, JSONException {
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        Request request = new Request.Builder()
                .url(addQueries(url, queries))
                .build();
        Response response = client.newCall(request).execute();
        return new JSONObject(response.body().string());
    }
    static JSONObject get(String url) throws IOException, JSONException {
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return new JSONObject(response.body().string());
    }

    static JSONObject post (String url, JSONObject json) throws IOException, JSONException {
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        RequestBody body = RequestBody.create(JSON, json.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return new JSONObject(response.body().string());
    }

    static JSONObject login (JSONObject json) throws IOException, JSONException {
        return post(baseURL + "/login", json);
    }

    static JSONObject signup (JSONObject signup) throws IOException, JSONException {
        return post(baseURL + "/signup", signup);
    }

    static JSONObject getPosts (JSONObject queries) throws IOException, JSONException {
        return get(baseURL + "/post", queries);
    }

    static JSONObject getPlaces (JSONObject queries) throws IOException, JSONException {
        return get(baseURL + "/place", queries);
    }

    public static JSONObject getProducts (JSONObject queries) throws IOException, JSONException {
        return get(baseURL + "/product", queries);
    }

    public static JSONObject getProductsCarrefour (JSONObject queries) throws IOException, JSONException {
        return get(baseURL + "/product/carrefour", queries);
    }


    static JSONObject postPlace (JSONObject body) throws IOException, JSONException {
        return post(baseURL + "/place", body);
    }

    static JSONObject postProduct (JSONObject body) throws IOException, JSONException {
        return post(baseURL + "/product", body);
    }

    static JSONObject getVotes (String type, Integer id) throws IOException, JSONException {
        JSONObject json = get(baseURL + "/vote/" + type + "/" + id);
        return (JSONObject) json.get("data");
    }

    static JSONObject getProductVotes (Integer id) throws IOException, JSONException {
        return getVotes("product", id);
    }

    static JSONObject getPlaceVotes (Integer id) throws IOException, JSONException {
        return getVotes("place", id);
    }

    static JSONObject getPostVotes (Integer id) throws IOException, JSONException {
        return getVotes("post", id);
    }
    static JSONObject postVote (String type, Integer id, Boolean value) throws JSONException, IOException {
        JSONObject body = new JSONObject();
        body.put("type", type);
        body.put("id", id);
        body.put("value", value ? 1 : -1);
        return post(baseURL + "/vote", body);
    }
}

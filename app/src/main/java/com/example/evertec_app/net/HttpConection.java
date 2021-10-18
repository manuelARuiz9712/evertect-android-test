package com.example.evertec_app.net;

import android.content.Context;

import com.example.evertec_app.R;
import com.example.evertec_app.models.ResponseRequest;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpConection {
    OkHttpClient client;
    String baseUrl = "";
    Context context ;
    public MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public HttpConection(Context context) {
        this.client = new OkHttpClient();
        this.context = context;
        this.baseUrl = context.getString(R.string.base_uri_placetopay);
    }

    public ResponseRequest PostRequest(String path, String params){

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(this.JSON, params);

        ResponseRequest responseRequest = new ResponseRequest();


        Request request = new Request.Builder()
                .url(this.baseUrl+"/"+path)
                .post(body)
                .build();

        try {
           Response response = client.newCall(request).execute();

           if (response.isSuccessful()){
               responseRequest.setStatus(200);
               responseRequest.setBody(response.body().toString());
               responseRequest.setMessage("data");
           }else{
               responseRequest.setStatus(response.code());
               responseRequest.setBody(response.body().toString());
               responseRequest.setMessage(response.message());

           }
        } catch (IOException e) {
            responseRequest.setStatus(0);
            responseRequest.setBody(null);
            responseRequest.setMessage(e.getMessage());
        }
        return  responseRequest;
    }

    public ResponseRequest getRequest(String path,String params){
        ResponseRequest responseRequest = new ResponseRequest();
        return responseRequest;
    }





}

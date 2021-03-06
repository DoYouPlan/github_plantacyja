package ru.mantis.app;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

public class HttpSession  {
    private CloseableHttpClient httpclient;
    private AppManager app;


    public HttpSession(AppManager app){
        this.app = app;
        httpclient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
    }
    public boolean login(String username, String password) throws IOException {
        HttpPost post = new HttpPost(app.getProperty("web.BaseUrl") + "/login.php");
        ArrayList params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("secure_session", "on"));
        params.add(new BasicNameValuePair("return", "index.php"));
        post.setEntity(new UrlEncodedFormEntity(params));
        CloseableHttpResponse response = httpclient.execute(post);
        String body = goTextForm(response);
        return body.contains(String.format("<span class=\"italic\">%s</span>",username));
    }
    private String goTextForm(CloseableHttpResponse response) throws IOException {
        try {
            return EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }
    }
    public boolean isLoggedInAs(String username) throws IOException {
        HttpGet get = new HttpGet(app.getProperty("web.BaseUrl") + "/index.php");
        CloseableHttpResponse response = httpclient.execute(get);
        String body = goTextForm(response);
        return body.contains(String.format("<span class=\"italic\">%s</span>",username));

    }
}

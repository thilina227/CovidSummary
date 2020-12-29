package com.mycompany.covidsummary.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.covidsummary.config.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SummaryService {

    public Map<String, Object> getSummary() {
        try {
            Config config = Config.getInstance();
            String url = config.getUrl() + config.getCountryCode();

            //Invoking API
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            HttpResponse httpResponse = httpclient.execute(httpget);
            String response = EntityUtils.toString(httpResponse.getEntity());

            //Object Mapper to map Json output from API to Java objects
            ObjectMapper mapper = new ObjectMapper();

            System.out.println(response);//printing output for debug purposes
            ArrayList<Map<String, Object>> results = mapper.readValue(response, ArrayList.class);

            return results.get(0);

        } catch (IOException ex) {
            Logger.getLogger(SummaryService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

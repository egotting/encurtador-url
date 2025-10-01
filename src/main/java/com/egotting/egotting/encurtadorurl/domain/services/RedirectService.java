package com.egotting.egotting.encurtadorurl.domain.services;

import com.egotting.egotting.encurtadorurl.domain.services.Interface.IRedirectService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.*;

@Service
public class RedirectService implements IRedirectService {
    @Override
    public boolean isValid(String url) {
        try {
            int status = 0;
            URI _url = new URI(url);
            URLConnection conn = _url.toURL().openConnection();
            if (conn instanceof HttpURLConnection http_conn) {
                http_conn.setRequestMethod("HEAD");
                http_conn.setConnectTimeout(3000);
                status = http_conn.getResponseCode();
            }
            return status >= 200 && status < 400;
        } catch (URISyntaxException | IOException e) {
            return false;
        }
    }
}

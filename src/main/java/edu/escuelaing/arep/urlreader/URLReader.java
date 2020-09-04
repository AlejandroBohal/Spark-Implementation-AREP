package edu.escuelaing.arep.urlreader;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The type Url reader.
 */
public class URLReader {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        readURL("http://localhost:36000/archivo.txt");
    }

    /**
     * Read url.
     *
     * @param siteToRead the site to read
     */
    public static void readURL(String siteToRead) {
        try {
            URL siteURL = new URL(siteToRead);
            URLConnection urlConnection = siteURL.openConnection();
            Map<String, List<String>> headers = urlConnection.getHeaderFields();
            Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
            for (Map.Entry<String, List<String>> entry : entrySet) {
                String headerName = entry.getKey();
                if (headerName != null) {
                    System.out.print(headerName + ":");
                }
                List<String> headerValues = entry.getValue();
                for (String value : headerValues) {
                    System.out.print(value);
                }
                System.out.println("");
            }
            System.out.println("-------message-body------");
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

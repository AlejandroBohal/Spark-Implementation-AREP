package edu.escuelaing.arep.urlreader;

import java.net.MalformedURLException;
import java.net.URL;

public class URLScanner {
    public static void main(String[] args){
        scanURL("https://ldbn.is.escuelaing.edu.co/courses/Quantum/index.html");
    }
    public static void scanURL (String siteUrl){
        try {
            URL site = new URL(siteUrl);
            System.out.println("Protocols: " + site.getProtocol());
            System.out.println("Host: " + site.getHost());
            System.out.println("Path: " + site.getPath());
            System.out.println("File: " + site.getFile());
            System.out.println("Query: " + site.getQuery());
            System.out.println("Ref: " + site.getRef());
            System.out.println("Authority: " + site.getAuthority());
            System.out.println("Port: " + site.getPort());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

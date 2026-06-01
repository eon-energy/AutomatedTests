package com.technokratos.appmanager;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Settings {
    private static final String FILE = "Settings.xml";

    private static Document document;

    private static String baseUrl;
    private static String login;
    private static String password;

    static {
        try {
            File file = new File(FILE);

            if (!file.exists()) {
                throw new RuntimeException("Settings file not found: " + FILE);
            }

            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(file);

            document.getDocumentElement().normalize();
        } catch (Exception e) {
            throw new RuntimeException("Cannot read settings file", e);
        }
    }

    public static String getBaseUrl() {
        if (baseUrl == null) {
            baseUrl = getNodeValue("baseUrl");
        }

        return baseUrl;
    }

    public static String getLogin() {
        if (login == null) {
            login = getNodeValue("login");
        }

        return login;
    }

    public static String getPassword() {
        if (password == null) {
            password = getNodeValue("password");
        }

        return password;
    }

    private static String getNodeValue(String tagName) {
        Node node = document.getElementsByTagName(tagName).item(0);

        if (node == null) {
            throw new RuntimeException("Tag not found in Settings.xml: " + tagName);
        }

        return node.getTextContent();
    }
}
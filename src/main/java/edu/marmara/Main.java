package edu.marmara;

import edu.marmara.service.JsonService;
import edu.marmara.service.impl.JsonServiceImpl;
import edu.marmara.view.View;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    private static final JsonService jsonService = new JsonServiceImpl();

    public static void main(String[] args) throws IOException, ParseException {
        View.start();
        jsonService.end();
    }
}
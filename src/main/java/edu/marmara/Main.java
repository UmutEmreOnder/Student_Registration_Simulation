package edu.marmara;

import edu.marmara.service.JsonService;
import edu.marmara.service.impl.JsonServiceImpl;
import edu.marmara.view.View;

public class Main {
    private static final JsonService jsonService = new JsonServiceImpl();

    public static void main(String[] args) {
        try {
            View.start();
            jsonService.end();
        } catch (Exception e) {
            View.logger.warning(e.getMessage());
        }

    }
}
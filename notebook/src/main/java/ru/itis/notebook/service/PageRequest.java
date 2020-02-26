package ru.itis.notebook.service;

import ru.itis.notebook.Logger;

public class PageRequest {

    public static int get(String page, long count, int current) throws IllegalAccessException {

        if(page.equals("next")) {
            ++current;
        }
        else if(page.equals("prev")) {
            --current;
        }
        else if(page.equals("end")){
            current = (int) ((count - 1) / 5);
        }
        else {
            try {
                current = Integer.parseInt(page) - 1;
            }
            catch (IllegalArgumentException e) {
                Logger.red_write("Not a number!");
                throw new IllegalAccessException();
            }
        }

        return current;

    }
}

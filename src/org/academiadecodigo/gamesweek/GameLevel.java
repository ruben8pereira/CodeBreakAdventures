package org.academiadecodigo.gamesweek;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameLevel {
    private BufferedReader bReader;
    private ArrayList<boolean[]> cadetLevelConfig;
    public static int MAX_BEERS_PER_ROW = 12;

    public GameLevel(String file) {
        cadetLevelConfig = new ArrayList<>();
        try {
            bReader = new BufferedReader(new FileReader(file));
            loadFromFile();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean[] lineParser(String line) throws IOException {
        String[] lineValues = line.split(",");
        if(lineValues.length > 12){
            throw new IOException();
        }
        boolean[] beerBooleans = new boolean[MAX_BEERS_PER_ROW];
        for (int i = 0; i < lineValues.length; i++) {
            if(lineValues[i].equals("0")) {
                beerBooleans[i] = false;
            } else {
                beerBooleans[i] = true;
            }
        }
        return beerBooleans;
    }

    public void loadFromFile() {
        try {
            String line;
            while((line = bReader.readLine()) != null){
                cadetLevelConfig.add(lineParser(line));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<boolean[]> getCadetArray() {
        return cadetLevelConfig;
    }
}

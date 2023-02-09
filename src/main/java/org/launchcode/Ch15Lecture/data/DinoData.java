package org.launchcode.Ch15Lecture.data;

import org.launchcode.Ch15Lecture.models.Dinosaur;

import java.util.ArrayList;

public class DinoData {

    private static ArrayList<Dinosaur> allDinos = new ArrayList<>();

    public static ArrayList<Dinosaur> getAllDinos() {
        return allDinos;
    }

    public static void addDino(Dinosaur newDinoObj) {
        allDinos.add(newDinoObj);
    }

}

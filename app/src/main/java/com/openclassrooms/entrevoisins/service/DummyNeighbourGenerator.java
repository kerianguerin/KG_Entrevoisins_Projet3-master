package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "https://i.pravatar.cc/150?u=a042581f4e29026704d", false),
            new Neighbour(2, "Jack", "https://i.pravatar.cc/600?u=a042581f4e29026704e", false),
            new Neighbour(3, "Chloé", "https://i.pravatar.cc/600?u=a042581f4e29026704f", true),
            new Neighbour(4, "Vincent", "https://i.pravatar.cc/600?u=a042581f4e29026704a", false),
            new Neighbour(5, "Elodie", "https://i.pravatar.cc/600?u=a042581f4e29026704b", true),
            new Neighbour(6, "Sylvain", "https://i.pravatar.cc/600?u=a042581f4e29026704c", false),
            new Neighbour(7, "Laetitia", "https://i.pravatar.cc/600?u=a042581f4e29026703d", true),
            new Neighbour(8, "Dan", "https://i.pravatar.cc/600?u=a042581f4e29026703b", false),
            new Neighbour(9, "Joseph", "https://i.pravatar.cc/600?u=a042581f4e29026704d", false),
            new Neighbour(10, "Emma", "https://i.pravatar.cc/600?u=a042581f4e29026706d", false),
            new Neighbour(11, "Patrick", "https://i.pravatar.cc/600?u=a042581f4e29026702d", false),
            new Neighbour(12, "Ludovic", "https://i.pravatar.cc/600?u=a042581f3e39026702d", false)
    );

    public static List<Neighbour> NEW_NEIGHBOUR = Arrays.asList(
            new Neighbour(13, "Caroline", "https://i.pravatar.cc/150?u=a042581f4e29026704d", false),
            new Neighbour(14, "Jack", "https://i.pravatar.cc/600?u=a042581f4e29026704e", false),
            new Neighbour(15, "Chloé", "https://i.pravatar.cc/600?u=a042581f4e29026704f", true),
            new Neighbour(16, "Vincent", "https://i.pravatar.cc/600?u=a042581f4e29026704a", false),
            new Neighbour(17, "Elodie", "https://i.pravatar.cc/600?u=a042581f4e29026704b", true)
            );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }
}

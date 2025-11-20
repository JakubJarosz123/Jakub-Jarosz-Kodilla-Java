package com.kodilla.spring.library;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class Library {

    private final List<String> books = new ArrayList<>();
    private LibraryDbController dbController;

    public Library(final LibraryDbController dbController) {
        this.dbController = dbController;
    }

    public Library() {}

    public void saveToDb() {
        dbController.saveData();
    }

    public void loadFromDb() {
        dbController.loadData();
    }
}

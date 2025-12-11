package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private final List<SudokuElement> cols = new ArrayList<>();

    public SudokuRow() {
        for (int col = 0; col < 10; col++)
            cols.add(new SudokuElement());
    }

    public List<SudokuElement> getCols() {
        return cols;
    }
}

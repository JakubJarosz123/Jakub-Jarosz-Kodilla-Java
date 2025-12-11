package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    private final List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for (int col = 0; col < 10; col++)
            rows.add(new SudokuRow());
    }

    public SudokuElement getBoard(int row, int col) {
        return rows.get(row).getCols().get(col);
    }

    public void setBoard(int row, int col, SudokuElement element) {
        rows.get(row).getCols().set(col, element);
    }
}

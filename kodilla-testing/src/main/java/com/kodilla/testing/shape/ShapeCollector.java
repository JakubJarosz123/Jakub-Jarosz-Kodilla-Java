package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape){
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape){
        return shapes.remove(shape);
    }

    public Shape getFigure(int n){
        if (n >= 0 || n < shapes.size()) {
            return shapes.get(n);
        }
        return null;
    }

    public String showFigures(){
        String result = "";
        for (Shape shape : shapes) {
            if (!result.equals("")) result += ", ";
                result += shape.getShapeName();
        }
        return result;
    }

    public List<Shape> getShapes(){
        return shapes;
    }
}

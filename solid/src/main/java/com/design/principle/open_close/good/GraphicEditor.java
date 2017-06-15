package com.design.principle.open_close.good;

/**
 * Created by sujitagarwal on 30/03/17.
 */

// Open-Close Principle - Good example
public class GraphicEditor {

    public void drawShape(Shape shape)
    {
        shape.drawShape();
    }

}
abstract class Shape{

    abstract void  drawShape();
}

class Rectangle extends Shape
{
    @Override
    void drawShape() {

    }
}
class Square extends Shape
{
    @Override
    void drawShape() {

    }
}
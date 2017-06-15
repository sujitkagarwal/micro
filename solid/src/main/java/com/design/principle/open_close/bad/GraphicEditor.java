package com.design.principle.open_close.bad;


// Open-Close Principle - Bad example
class GraphicEditor {

    public void drawShape(Shape s) {
        if (s.m_type==1)
            drawRectangle((Rectangle) s);
        else if (s.m_type==2)
            drawCircle((Circle)s);
    }

    public void drawCircle(Circle r) {

    }

    public void drawRectangle(Rectangle r) {

    }
}

class Shape {
    int m_type;
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type=1;
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type=2;
    }
}
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Draw a Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Draw a Rectangle");
    }
}

class Triangle implements Shape {
    public void draw() {
        System.out.println("Draw a Triangle");
    }
}

class ShapeFactory {
    public Shape createShape(String type) {
        switch (type) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "triangle":
                return new Triangle();
            default:
                throw new IllegalArgumentException("Unknown shape type");
        }
    }
}

public class FactoryMethodPattern{
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.createShape("circle");
        shape1.draw();

        Shape shape2 = shapeFactory.createShape("rectangle");
        shape2.draw();

        Shape shape3 = shapeFactory.createShape("triangle");
        shape3.draw();
    }
}
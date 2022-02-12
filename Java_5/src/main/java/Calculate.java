import jdk.jfr.MetadataDefinition;

public class Calculate {
    double figureAreaTriangle(double side, double height) {
        double square = 0.5 * side * height;
        return square;
    }
    double figureAreaRectangle(double length, double width) {
        double square = length * width;
        return square;
    }
    double figureAreaSquare(double side) {
        double square = side * side;
        return square;
    }
    double figureAreaRhombus(double length, double height) {
        double square = length * height;
        return square;
    }
    double convertUSDToRUB(double amount) {
        final double course = 2.5;
        return amount * course;
    }
    double convertEUROToRUB(double amount) {
        final double course = 2.91;
        return amount * course;
    }
    double convertGBPToRUB(double amount) {
        final double course = 3.48;
        return amount * course;
    }

    double convertJPYToRUB(double amount) {
        final double course = 0.022;
        return amount * course;
    }
}

import jdk.jfr.MetadataDefinition;

public class Calculate {
    // площадь треугольника
    double figureAreaTriangle(double side, double height) {
        double square = 0.5 * side * height;
        return square;
    }
    // площадь прямоугольника
    double figureAreaRectangle(double length, double width) {
        double square = length * width;
        return square;
    }
    // площадь квадрата
    double figureAreaSquare(double side) {
        double square = side * side;
        return square;
    }
    // площадь ромба
    double figureAreaRhombus(double length, double height) {
        double square = length * height;
        return square;
    }
    // конвертировать доллар в рубли
    double convertUSDToRUB(double amount) {
        final double course = 2.5;
        return amount * course;
    }
    // конвертировать евро в рубли
    double convertEUROToRUB(double amount) {
        final double course = 2.91;
        return amount * course;
    }
    // конвертировать фунт стерлингов в рубли
    double convertGBPToRUB(double amount) {
        final double course = 3.48;
        return amount * course;
    }
    // конвертировать йены в рубли
    double convertJPYToRUB(double amount) {
        final double course = 0.022;
        return amount * course;
    }
    // проверка является ли строка палиндромом
    boolean isPalindrome(String str) {
        return str.replaceAll("\\W","")
                .equalsIgnoreCase(new StringBuilder(str.replaceAll("\\W",""))
                .reverse()
                .toString());
    }
    //  Подсчет количества вхождений слова в строку
    public int countEntry(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }

}

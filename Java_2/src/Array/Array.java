package Array;

import java.util.Random;

public class Array implements IMath {
    private int[] array;
    private int length;

    protected Array() {

    }

    public Array(int length) {
        if (length <= 0) {
            length = 1;
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Длина массива должна иметь значение больше 0. Установлена минимальная длина массива - 1.");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        this.length = length;
        array = new int[length];
        initArray(length);
    }

    @Override
    public int Max() {
        int max = array[0];
        for (int i = 0; i < length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    @Override
    public int Min() {
        int min = array[0];
        for (int i = 0; i < length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public float Avg() {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += array[i];
        }
        return sum / length;
    }

    void initArray(int length) {
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = rnd.nextInt(100);
        }
    }

    public void printArray() {
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

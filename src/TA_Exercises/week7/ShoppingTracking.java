package TA_Exercises.week7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class ShoppingTracking {

    private int size = 0;
    private int capacity = 10;
    private Shopping[] array = new Shopping[capacity];

    public void growSize(){
        Shopping[] temp = new Shopping[capacity * 2];
        System.arraycopy(array, 0, temp, 0, size);
        array = temp;
        capacity *= 2;
    }

    public void addElement(Shopping n) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(n.getDateOfShopping(), array[i].getDateOfShopping())) {
                throw new RuntimeException("You already had shopping in that day");
            }
        }
        if (size == capacity) {
            growSize();
        }
        array[size] = n;
        size++;
    }

    public void addElementAt(Shopping n, int index){
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == capacity) {
            growSize();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = n;
        size++;
    }

    public void removeElement(){
        if (size > 0) {
            array[size - 1] = null;
            size--;
        }
    }

    public void removeElementAt(int index){
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
    }

    public void shrink(){
        Shopping[] temp = new Shopping[size];
        System.arraycopy(array, 0, temp, 0, size);
        array = temp;
        capacity = size;
    }

    public double averagePrice() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += array[i].getPrice();
        }
        return total / size;
    }

    public double averagePriceByShop(String shopName) {
        double total = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].getShopName().equals(shopName)) {
                total += array[i].getPrice();
                count++;
            }
        }
        return total / count;
    }

    public void mergeShops(String oldShopName, String newShopName) {
        for (int i = 0; i < size; i++) {
            if (array[i].getShopName().equals(oldShopName)) {
                array[i].setShopName(newShopName);
            }
        }
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i].display()).append("\n");
        }
        return sb.toString();
    }

    public void createFile(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(display());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(display());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return size;
    }

    public Shopping getElementAt(int i) {
        if (i < 0 || i >= size){
            throw new RuntimeException("Wrong index");
        }
        return array[i];
    }
}

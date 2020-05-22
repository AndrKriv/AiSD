package my.pack;
import java.util.ArrayList;
import java.util.Collections;
class fibSort {
    public ArrayList<Integer>[] fibMass;//определение массива, содержащего в себе некоторые нужные функции (изменение размерности. функция сортировки sort)
    fibSort(int fSize) {
        fibMass = new ArrayList[fSize];
        for (int i = 0; i < fSize; i++){
            fibMass[i] = new ArrayList<>();
        }
    }
    void add(int fSize, int value){//добавление элементов в части (разделение массива на части для последующей сортировки)
        fibMass[fSize].add(value);
    }
    int length(){//определение размерности исходного массива
        return fibMass.length;
    }
    void output(){//вывод частей массива в процессе сортировки
        for (ArrayList<Integer> integers : fibMass) {
            for (Integer s : integers) {
                System.out.print(" " + s + " ");
            }
            System.out.print(" | ");
        }
        System.out.println();
    }
    fibSort change(fibSort file1, fibSort file2, fibSort file3){// основа для выполнения сортировка
        int size = 0;
        int start = 0;
        for(int i = 0; i < file2.length(); i++){
            if(!file2.fibMass[i].isEmpty()) size++;
            if(file2.fibMass[i].isEmpty()) start++;
            if(i != file2.length() - 1)
                if(!file2.fibMass[i].isEmpty() && file2.fibMass[i+1].isEmpty()){
                    break;
                }
        }
        for(int i = 0; i < size; i++) {   // исключая пустые
            for (int j = 0; j < file1.fibMass[i].size(); j++) {
                file3.add(i, file1.fibMass[i].get(j));
                file1.fibMass[i].remove(j);
                j--;
            }
        }
        for(int i = start; i < file2.length(); i++) {
            for(int j = 0; j < file2.fibMass[i].size(); j++) {
                file3.add(i - start, file2.fibMass[i].get(j));
                file2.fibMass[i].remove(j);
                j--;
            }
        }
        for (int i = 0; i < file3.length(); i++){
            Collections.sort(file3.fibMass[i]);//функция сортировки
        }
        return file3;
    }
    boolean Empty(){
        for(int i = 0; i < fibMass.length; i++)
            if(!fibMass[i].isEmpty())//проверка на заполнение массива
                return false;
        return true;
    }
}
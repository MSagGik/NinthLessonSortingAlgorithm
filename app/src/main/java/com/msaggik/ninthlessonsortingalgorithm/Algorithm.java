package com.msaggik.ninthlessonsortingalgorithm;

import java.util.Arrays;

public class Algorithm {

    // создание метода сортировки входных данных
    public String sortData(String input) {
        /** Необходимо данные разделить по маркеру ","
         * Затем поместить в массив и произвести сортировку
         * После в отсортированном виде снова упаковать в строку
         */

        String[] dataArrays; // массив для временного хранения данных
        String divider = "\\s*,\\s*"; // делитель, записанный в виде регулярного выражения (\\s* - означает от 0 и больше количества пробелов)

        // разделение входных данных на составные части
        dataArrays = input.split(divider);

        // простая сортировка (используя встроенные методы java)
        Arrays.sort(dataArrays);

        return Arrays.toString(dataArrays);
    }

    // создание метода сортировки входных данных для чисел
    public String sortIntData(String input) {

        String[] dataArrays; // массив для временного хранения данных
        String divider = "\\s*,\\s*"; // делитель, записанный в виде регулярного выражения (\\s* - означает от 0 и больше количества пробелов)

        // разделение входных данных на составные части
        dataArrays = input.split(divider);

        // инициализация пустого числого массива
        int[] dataIntArrays = new int[dataArrays.length]; // массив для временного хранения числовых данных
        // заполнение пустого числого массива данными из строкого массива
        for(int i = 0; i < dataArrays.length; i++) {
            dataIntArrays[i] = Integer.parseInt(dataArrays[i]);
        }

        // сортировка "Пузырьком" (сложность О(n*n))
        boolean isSorted = false; // логическое значение
        int buf; // буферное значение
        while(!isSorted) { // бесконечный цикл до конца сортировки (в худшем случае количество циклов равняется длине сортированного массива)
            isSorted = true; // переназначаем булевское значение и спускаемся ниже
            for (int i = 0; i < dataIntArrays.length-1; i++) { // перебор (n-1) значений массива
                if(dataIntArrays[i] > dataIntArrays[i+1]){ // если соседние числа не отсортированны, то спускаемся ещё ниже
                    isSorted = false; // возвращаем обратно булевское значение (значит до возврата из цикла while() ещё не меньше одного цикла while()

                    buf = dataIntArrays[i]; // сохраняем левое значение, иначе оно потеряется при перестановке
                    dataIntArrays[i] = dataIntArrays[i+1]; // перестановка
                    dataIntArrays[i+1] = buf; // возврат буферного значения на место правого
                }
            }
        }

        return Arrays.toString(dataIntArrays); // возврат отсортированного массива
    }
}

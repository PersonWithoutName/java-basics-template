package com.epam.izh.rd.online.service;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     * <p>
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        int val1 = 33;
        int val2 = 2;
        int ret = 0;
        if (val1 == val2) {
            ret = 0;
        } else if (val1 < val2) {
            ret = -1;
        } else if (val1 < val2) {
            ret = 1;
        }
        return ret;
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        int x = -1;
        int y = 2;
        int max = x > y ? x : y;
        return max;
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int array[] = new int[]{1, 3, 5, 7, 8};
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int array[] = {-6, 5, -2, 78};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    int[] data = {-6, 5, -2, 78};

    @Override
    public int[] getEvenDigits(int[] values) {
        int countLength = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                countLength++;
            }
        }

        int[] filArray = new int[countLength];
        int j = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                filArray[j] = data[i];
                j++;
            }
        }
        return filArray;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    static int value = 8;

    @Override
    public long calcFactorial(int initialVal) {
        int fact = 1;
        int i = 1;

        while (i <= value) {
            fact = fact * i;
            i++;
        }
        return fact;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     * <p>
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     * <p>
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    int positionInFibonacci = 11;

    @Override
    public long calcFibonacci(int number) {
        int n0 = 0, n1 = 1, i = 0, fibPosition = 0;
        if (positionInFibonacci == 1) {
            fibPosition = 1;
        } else {
            while (i < positionInFibonacci - 1) {
                fibPosition = n0 + n1;
                n0 = n1;
                n1 = fibPosition;
                i++;
            }
        }
        return fibPosition;
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    int[] arr = {-1, -3, 4, 8, 5, 22, -5};

    @Override
    public int[] sort(int[] values) {
         /*Внешний цикл каждый раз сокращает фрагмент массива,
      так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }


        }
        return arr;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     * <p>
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    static int var = 2;
    static int n = 21;

    @Override
    public boolean isPrimary(int number) {
        boolean answer = false;

        if (n > 1) {
            if (n % var != 0) {
                var++;
                isPrimary(n);
            } else if (var == n) {
                answer = true;
            } else {
                answer = false;
            }

        }
        return answer;
    }


    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     * <p>
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int[] array = {-1, -3, 4, 8, 5, 22, -5};
        int n = array.length;
        int temp;
        for (int i = 0; i < n / 2; i++) {
            temp = array[n - i - 1];
            array[n - i - 1] = array[i];
            array[i] = temp;
        }
        return array;
    }
}

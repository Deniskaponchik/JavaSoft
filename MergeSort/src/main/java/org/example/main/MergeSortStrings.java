package org.example.main;

public class MergeSortStrings {

    public static String[] getSortedStrArr(String[] values, boolean sortType) {
        mergeSortDes(values, 0, values.length - 1, sortType);
        //System.out.println("Result " + Arrays.toString(values));
        return values;
    }
    public static void mergeSortDes(String[] a, int from, int to, boolean sortType) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
        // сортировка первой и второй половины
        mergeSortDes(a, from, mid, sortType);
        mergeSortDes(a, mid + 1, to, sortType);
        mergeDes(a, from, mid, to, sortType);
    }
    public static void mergeDes(String[] a, int from, int mid, int to, boolean sortType) {
        int n = to - from + 1;       // размер диапазона для объединения
        String[] b = new String[n];  // объединить обе половины во временный массив b
        int i1 = from;               // следующий элемент для рассмотрения в первом диапазоне
        int i2 = mid + 1;            // следующий элемент для рассмотрения во втором диапазоне
        int j = 0;                   // следующая открытая позиция в b

        // пока ни i1, ни i2 не дошли до конца, перемещаем меньший в b
        while (i1 <= mid && i2 <= to) {

            if (sortType) {
                if (a[i1].compareTo(a[i2]) < 0) {   //для прямой сортировки
                //if (a[i2].compareTo(a[i1]) < 0) {
                    b[j] = a[i1];
                    i1++;
                } else {
                    b[j] = a[i2];
                    i2++;
                }
            } else {

                //if (a[i1].compareTo(a[i2]) < 0) {   //для прямой сортировки
                if (a[i2].compareTo(a[i1]) < 0) {    //для обратной сортировки
                    b[j] = a[i1];
                    i1++;
                } else {
                    b[j] = a[i2];
                    i2++;
                }
            }
            j++;



        }
        //выполняется только один из двух циклов while ниже.
        // копируем все оставшиеся записи первой половины
        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
        }
        // копируем любые оставшиеся записи второй половины
        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
        }
        //копируем обратно из временного массива
        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }
    }









}


public class lab1 {
    public static void main(String[] args) {
    //------------1-часть-------------    
        int num = 20; // переменная, которая будет уменьшаться до 6, заполняя массив
        long[] c = new long[8]; // первый массив длиной 15 (6-20 ==> 8 чётных чисел)
        for (int i = 0; i < c.length; i++) {
            c[i] = num; // даём каждому эл-ту нужное значение
            num -= 2; // уменьшаем на 2, чтобы пройти по четным числам в порядке убывания
        }
    //-------------2-часть-------------
        double[] x = new double[18]; // массив типа double с 18 эл-тами
        for (int i = 0; i < x.length; i++) {
            x[i] = Math.random() * 16 - 10; // даём каждому эл-ту рандомное значение; (* 16 - 10
            // для того, чтобы растянуть и сдвинуть диапазон Math.random())
        }
    //-------------3-часть-------------
        double[][] m = new double [8][18]; // третий, двумерный массив
        for (int i = 0; i < m.length; i ++) { // проходим по каждому из 8 подмассивов
            for (int j = 0; j < m[i].length; j++) { // проходим каждый подмассив в частности
                if (c[i] == 16) { // первое усл - е
                    m[i][j] = Math.pow(Math.sin(Math.tan(x[j])), (Math.cbrt(x[j]) + 1) / 4);
                }else if (c[i] == 8 || c[i] == 12 || c[i] == 14 || c[i] == 20) { // второе усл-е
                    m[i][j] = Math.sin(Math.log(Math.sqrt(Math.abs(x[j]))));
                }else { // третье усл-е
                    m[i][j] = Math.pow(Math.asin(Math.sin(Math.atan(Math.pow((x[j] - 2) / 16, 2))))
                        * (Math.cos(Math.pow(0.25 + Math.pow(x[j] / (1 - x[j]), 3), 2)) + 1), 2);
                }
                System.out.printf("%.2f ", m[i][j]); // вывод с 2 знаками после запятой
            }
        System.out.println();
        }
    }
}
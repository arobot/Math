package com.example;

public class Pseudorandom {
    public static void main(String[] args) {
        double c = 0.00014;
        double p = 0.0;
        int n = 1;

        while (p < 1) {
            p = C(recursion(c, 0, 1));
            if ((int) (p * 100) % 100 - n == 0) {
                System.out.println("P(E)=" + p + "------" + "C=" + c);
                n++;
            }
            c += 0.000001;
        }

    }

    /**
     *
     * @param a 伪随机的期望次数
     * @return  伪随机的期望概率
     */
    public static double C(double a) {
        return 1 / a;
    }

    /**
     * 求得伪随机的期望次数
     * @param a 伪随机基准概率
     * @param b 前i次action期望和
     * @param i action次数
     * @return
     */
    public static double recursion(double a, double b, int i) {
        if (a * i < 1) {
            b += i * p(a, i, 1, 1) * (a * i);
            i++;
            return recursion(a, b, i);
        } else
            return b + i * p(a, i, 1, 1);

    }

    /**
     *
     * @param a 基准概率
     * @param i 第i次
     * @param j 方法内迭代
     * @param p 方法内迭代
     * @return  第i次不成功的概率
     */
    public static double p(double a, int i, int j, double p) {
        if (j < i) {
            p *= (1 - a * j);
            j++;
            return p(a, i, j, p);
        } else {
            return p;
        }

    }
}

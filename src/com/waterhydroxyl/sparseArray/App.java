package com.waterhydroxyl.sparseArray;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] =2;
        chessArr1[2][6] =2;
        
        System.out.println("原始:");
        for(int[] row : chessArr1){
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sum = 0;
        for (int[] value : chessArr1) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (value[j] != 0) {
                    sum++;
                }
            }
        }
       // System.out.println("sum=" + sum);

        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;
        int cout = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    cout ++;
                    sparseArr[cout][0] = i;
                    sparseArr[cout][1] = j;
                    sparseArr[cout][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("稀疏：");
        for(int[] row : sparseArr){
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        System.out.println("稀疏返回棋盘：");

        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        // for(int[] row : chessArr2){
        //     for (int data : row) {
        //         System.out.printf("%d\t", data);
        //     }
        //     System.out.println();
        // }

        System.out.println("正在写入数据到本地>>>>>>>>>");
        //  BufferedWriter bufferedWriter = null;
        FileWriter fos = null;

        try {
            fos = new FileWriter("map.data",true);
            for (int[] ints : sparseArr) {
                for (int anInt : ints) {
                    try {
                        fos.write(anInt+"\t");//存入的数据乱码了！！！
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                fos.write("\n");
            }

        } finally {
            try {
                assert fos != null;
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("完成数据写入到本地");
    }      


}

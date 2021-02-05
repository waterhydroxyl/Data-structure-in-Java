package com.waterhydroxyl.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        String key;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("s:showStack");
            System.out.println("e:exit");
            System.out.println("push");
            System.out.println("pop");
            System.out.println("请输入你要进行的操作：");
            key = scanner.next();
            switch (key) {
                case "s":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("Enter the Number: ");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.printf("The Number %d is out", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
            System.out.println("The programmer is closed");
        }
    }
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //StackIsFull
    public boolean isFull() {
        return top == maxSize - 1;

    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        return stack[top--];
    }

    public void list() {
        for (int i = top; i >= 0; i--) {
            System.out.printf("Stack[%d]=%d\n", i, stack[i]);
        }
    }
}
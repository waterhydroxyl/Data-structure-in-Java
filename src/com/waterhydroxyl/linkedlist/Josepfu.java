package com.waterhydroxyl.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(7);
        circleSingleLinkedList.showBoys();
    }
}

class CircleSingleLinkedList {
    private Boy first = new Boy(-1);

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("输入必须大于0");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //如果第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }

        }
    }

    public void showBoys() {
        if (first == null) {
            System.out.println("No Boys");
            return;
        }
        Boy curBoy = first;
        do {
            System.out.printf("Boy's No.%d\n", curBoy.getNo());
            curBoy = curBoy.getNext();
        } while (curBoy != first);
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

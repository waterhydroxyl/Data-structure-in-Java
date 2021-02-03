package com.waterhydroxyl.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(0, "1", "2");
        HeroNode2 hero2 = new HeroNode2(3, "4", "5");
        HeroNode2 hero3 = new HeroNode2(2, "7", "8");
        HeroNode2 hero4 = new HeroNode2(1, "1", "2");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero4);

        doubleLinkedList.list();
        HeroNode2 hero5 = new HeroNode2(2, "222","weq");
        System.out.println("paixuhou:");
        doubleLinkedList.del(hero5);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    private final HeroNode2 head = new HeroNode2(0, null, null);

    public HeroNode2 getHead() {
        return head;
    }

    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        boolean flag = false;
        HeroNode2 next;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }else if (temp.next.no > heroNode.no) {
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("排序同");
        }else {
            if (temp.next != null) {
                temp.next.pre = heroNode;
                heroNode.next = temp.next;
                temp.next = heroNode;
                heroNode.pre = temp;
            }
            temp.next = heroNode;
            heroNode.pre = temp;
        }

    }

//    public void add(HeroNode2 heroNode) {
//        HeroNode2 temp = head;
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = heroNode;
//        heroNode.pre = temp;
//
//    }

    public void del(HeroNode2 heroNode) {
        HeroNode2 temp = head.next;
        boolean flag = false;
        if (temp == null) {
            System.out.println("空链表，无法删除");
        }
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.println("没有找到，无法删除");
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("列表空");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void update(HeroNode2 newerNode) {
        HeroNode2 temp = head.next;
        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表空，无法添加");
        }
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newerNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newerNode.name;
            temp.nickName = newerNode.nickName;
        } else {
            System.out.println("没有找到，无法更换");
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

}
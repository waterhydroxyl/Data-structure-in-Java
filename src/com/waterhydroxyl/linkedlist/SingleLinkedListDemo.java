package com.waterhydroxyl.linkedlist;

import java.util.List;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "李白", "诗仙");
        HeroNode hero3 = new HeroNode(2, "杜甫", "诗圣");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");



        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);

        HeroNode newnode = new HeroNode(4, "555","222");
        singleLinkedList.list();
        System.out.println("替换后");
        singleLinkedList.update(newnode);
        singleLinkedList.list();
        HeroNode delnode1 = new HeroNode(2, "杜甫", "诗圣");
        HeroNode delnode2 = new HeroNode(5, "林冲", "豹子头");
        //HeroNode delnode3 = new HeroNode(1, "李白", "诗仙");
        singleLinkedList.del(delnode1);
        singleLinkedList.del(delnode2);

        System.out.println("删除后");
        singleLinkedList.list();
        System.out.println("节点个数：");
        System.out.println(getLength(singleLinkedList.getHead()));
        System.out.println("查找到的是：");
        System.out.println(findLsatIndex(singleLinkedList.getHead(), 0));
        System.out.println("反转链表：");

        reversetList(singleLinkedList.getHead());
        singleLinkedList.list();
        System.out.println("逆序输出：");
        reversPrint(singleLinkedList.getHead());

    }
    public static void reversPrint(HeroNode head) {
        if (head.next == null) {
            System.out.println("链表空，无法打印");
            return;
        }
        Stack<HeroNode>  listStack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null){
            listStack.add(cur);
            cur = cur.next;
        }
        while (!listStack.isEmpty()) {
            System.out.println(listStack.pop());
        }
    }

    public  static void reversetList(HeroNode head) {
        HeroNode cur = head.next;
        HeroNode next;
        HeroNode reversHead = new HeroNode(0,null,null);

        while (cur != null) {
            next = cur.next;
            cur.next = reversHead.next;
            reversHead.next = cur;
            cur = next;
        }
        head.next = reversHead.next;
    }

    public static HeroNode findLsatIndex(HeroNode head, int index) {
        int length = getLength(head);
        HeroNode cur = head.next;
        if (length == 0) {
            return null;
        }
        if (index > length || index <=0) {
            System.out.println("输入越界");
            return null;
        }
        for (int i = 0; i < length - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static int getLength(HeroNode head) {
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length ++;
            cur = cur.next;
        }
        return length;
    }
}

class SingleLinkedList {
    private final HeroNode head = new HeroNode(0, null, null);

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;

    }

    public void del(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        if (temp.next == null) {
            System.out.println("空链表，无法删除");
        }
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;

        }else {
            System.out.println("没有找到，无法删除");
        }
    }

    public void  addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;

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
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("列表空");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void update(HeroNode newheroNode) {
        HeroNode temp = head.next;
        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表空，无法添加");
        }
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newheroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newheroNode.name;
            temp.nickName = newheroNode.nickName;
        }else {
            System.out.println("没有找到，无法更换");
        }
    }


}


class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
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

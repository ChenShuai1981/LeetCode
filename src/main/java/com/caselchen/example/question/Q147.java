package com.caselchen.example.question;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 样例
 * Given 1->3->2->0->null,
 * Return 0->1->2->3->null
 *
 * 解题思路
 * 本题用两个指针指向进行比较的前后两个结点，如果后面结点值不小于前面结点值，则将两个指针分别右移一位。
 * 如果后面结点值小于前面结点值，需要从头开始遍历找到插入的位置。
 */
public class Q147 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,0};
        Node node = setupNodes(nums);
        print(node);
        Node sorted = sort(node);
        print(sorted);
    }

    // 根据插入排序
    // 1->3->2->0->null
    // h/q->p->pn
    private static Node sort(Node head) {
        if(head==null || head.next==null) {
            return head;
        }

        Node p = head.next;
        head.next = null;

        while(p != null) {
            Node pnext = p.next;
            Node q = head;
            if (p.val <= q.val) {
                p.next = q;
                head = p;
            } else { // p.val > q.val
                while(q!=null && q.next != null && q.next.val < p.val) {
                    q = q.next;
                }
                p.next = q.next;
                q.next = p;
            }
            p = pnext;
        }
        return head;
    }

    private static Node setupNodes(int[] nums) {
        Node lastNode = null;
        for (int i=nums.length-1; i>=0; i--) {
            int num = nums[i];
            Node node = new Node(num, lastNode);
            lastNode = node;
        }
        return lastNode;
    }

    private static void print(Node head) {
        System.out.print(head.val);
        System.out.print(" -> ");

        Node p = head.next;
        while(p != null) {
            System.out.print(p.val);
            System.out.print(" -> ");
            p = p.next;
        }
        System.out.print("null");
        System.out.println();
    }

    @Data
    @AllArgsConstructor
    static class Node {
        Integer val;
        Node next;
    }
}

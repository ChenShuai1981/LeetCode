//package com.caselchen.example.lesson3;
//
//public class NumberSort {
//    public static void main(String[] args) {
//        int[] nums = new int[]{2,1,7,9,5,8};
//        int[] sortedNums = mergeSort(nums);
//        print(sortedNums);
//    }
//
//    private static void print(int[] nums) {
//        for (int num : nums) {
//            System.out.print(num);
//            System.out.print(" ");
//        }
//    }
//
//    /**
//     * 2,1,7,9,5,8
//     * 1,2,7,9,5,8
//     * 1,2,7,5,9,8
//     * 1,2,5,7,9,8
//     * 1,2,5,7,8,9
//     * @param nums
//     * @return
//     * 空间复杂度 O(1)
//     * 时间复杂度 O(n2)
//     * 稳定排序
//     */
//    public static int[] bubbleSort(int[] nums) {
//        boolean hasChange = true;
//        for (int i=0; i<nums.length-1 && hasChange; i++) {
//            hasChange = false;
//            // 每一轮将最大的数上浮到最右边
//            for (int j=0; j<nums.length-1-i; j++) {
//                if (nums[j] > nums[j+1]) {
//                    swap(nums, j, j+1);
//                    hasChange = true;
//                }
//            }
//        }
//        return nums;
//    }
//
//    /**
//     * 2,1,7,9,5,8
//     * 1,2,7,9,5,8
//     * 1,2,7,9,5,8
//     * 1,2,7,9,5,8
//     * 1,2,5,7,9,8
//     * 1,2,5,7,8,9
//     * @param nums
//     * @return
//     * 空间复杂度 O(1)
//     * 时间复杂度 O(n2)
//     * 稳定排序
//     *
//     * 插入排序
//     */
//    public static int[] insertionSort(int[] nums) {
//        for (int i=1,j,current; i<nums.length; i++) {
//            current = nums[i];
//            for (j=i-1; j>=0 && nums[j] > current; j--) {
//                nums[j+1] = nums[j];
//            }
//            nums[j+1] = current;
//        }
//
//        return nums;
//    }
//
//    /**
//     * 2,1,7,9,5,8
//     * 2,1,7 9,5,8
//     * 2,1 7 9,5 8
//     * 1,2 7 5,9 8
//     * 1,2,7 5,8,9
//     * 1,2,5,7,8,9
//     * 归并排序
//     * @param nums
//     * @return
//     * 空间复杂度 O(n)
//     * 时间复杂度 O(nlogn)
//     * 稳定排序
//     */
//    public static int[] mergeSort(int[] nums) {
//        msort(nums, 0, nums.length-1);
//        return nums;
//    }
//
//    private static void msort(int[] nums, int low, int high) {
//        if (low >= high) return;
//        int mid = low + (high - low) / 2;
//        msort(nums, low, mid);
//        msort(nums, mid+1, high);
//        merge(nums, low, mid, high);
//    }
//
//    // [1,3,8|2,6,9]
//    // low=1, mid=8, high=9
//    // [1,2,3,6,8,9]
//    private static void merge(int[] nums, int low, int mid, int high) {
//        int[] copy = nums.clone();
//        int k=low,i=low,j=mid+1;
//        while(k <= high) {
//            if (i > mid) {
//                nums[k++] = copy[j++];
//            } else if (j > high) {
//                nums[k++] = copy[i++];
//            } else if (copy[j] <= copy[i]) {
//                nums[k++] = copy[j++];
//            } else {
//                nums[k++] = copy[i++];
//            }
//        }
//    }
//
//    public static int[] quickSort(int[] nums) {
//        qsort(nums, 0, nums.length-1);
//        return nums;
//    }
//
//    private static void qsort(int[] nums, int low, int high) {
//        if (low >= high) return;
//        int p = partition(nums,low,high);
//        qsort(nums, low, p-1);
//        qsort(nums, p+1, high);
//    }
//
//    private static int partition(int[] nums, int low, int high) {
//        // 随机选择一个数作为基准值，nums[high]就是基准值
//        swap(nums, randRange(low, high), high);
//        int i,j;
//        for (i=low,j=low; j<high; j++) {
//            if (nums[j] <= nums[high]) {
//                swap(nums, i++, j);
//            }
//        }
//        swap(nums,i,j);
//        // 返回指针i作为基准点的位置
//        return i;
//    }
//
//    private static void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
//}

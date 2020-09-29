package com.wangzhen.algorithm.leetcode.lt_88;

import java.util.Arrays;

/**
 * Description:
 * Datetime:    2020/9/28   10:09 下午
 * Author:   王震
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
}

package com.xiaobai.leetcood;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * @author yin_zhj
 * @date 2020/4/14
 */
public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(null == candidates || candidates.length == 0) {
            return result;
        }
        List<Integer> track = new ArrayList<>();
        process(0, candidates, target, track);
        return result;
    }

    public void process(int index, int[] candidates, int target, List<Integer> track) {
        if(target == 0) {
            result.add(new ArrayList<>(track));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = index;i < candidates.length;i++) {
            track.add(candidates[i]);
            int tmp = target - candidates[i];
            process(i, candidates, tmp, track);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2,3,6,7};
        List<List<Integer>> list = combinationSum.combinationSum(candidates, 7);
        for(List<Integer> list1 : list) {
            for(int num : list1) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }
}

package leetcode.problems;

import leetcode.datastructures.NestedInteger;

import java.util.*;

public class A364_Nested_List_Weight_Sum_II {

    public int depthSumInverse(List<NestedInteger> nestedList) {
//        int unweighted = 0, weighted = 0;
//        while (!nestedList.isEmpty()) {
//            List<NestedInteger> nextLevel = new ArrayList<>();
//            for (NestedInteger ni : nestedList) {
//                if (ni.isInteger())
//                    unweighted += ni.getInteger();
//                else
//                    nextLevel.addAll(ni.getList());
//            }
//            weighted += unweighted;
//            nestedList = nextLevel;
//        }
//        return weighted;
        if (nestedList == null) return 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        int prev = 0;
        int total = 0;
        for (NestedInteger next: nestedList) {
            queue.offer(next);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger current = queue.poll();
                if (current.isInteger()) levelSum += current.getInteger();
                List<NestedInteger> nextList = current.getList();
                if (nextList != null) {
                    for (NestedInteger next: nextList) {
                        queue.offer(next);
                    }
                }
            }
            prev += levelSum;
            total += prev;
        }
        return total;
    }


}

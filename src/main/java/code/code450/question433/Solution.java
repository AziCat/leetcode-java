package code.code450.question433;

import java.util.*;

/**
 * 最小基因变化
 *
 * @author yan
 * @version 1.0
 * @date 2020/10/10
 */
public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        //起点队列
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(start);
        //下个位置的候选队列
        LinkedList<String> bankQueue = new LinkedList<>();
        Collections.addAll(bankQueue, bank);
        return minMutation(queue, end, bankQueue, 0);
    }

    private int minMutation(LinkedList<String> queue, String end, LinkedList<String> bankQueue, int step) {
        int size = queue.size();
        while (size != 0) {
            String begin = queue.poll();
            size--;
            int i = bankQueue.size();
            while (i != 0) {
                String item = bankQueue.poll();
                i--;
                int diffSize = compareString(begin, item);
                //如果相差1
                if (diffSize == 1) {
                    //相等即找到结果
                    if (item.equals(end)) {
                        return step + 1;
                    }
                    //否则item作为新的起点放到起点队列中
                    queue.offer(item);
                } else if (diffSize != 0) {
                    //不满足变异要求，放回候选队列
                    bankQueue.offer(item);
                }
            }
        }
        if (queue.isEmpty()) {
            return -1;
        } else {
            //地点队列不为空，继续递归
            return minMutation(queue, end, bankQueue, step + 1);
        }
    }

    private int compareString(String begin, String item) {
        char[] b = begin.toCharArray();
        char[] i = item.toCharArray();
        int diff = 0;
        for (int i1 = 0; i1 < b.length; i1++) {
            if (b[i1] != i[i1]) {
                diff++;
            }
        }
        return diff;
    }
}

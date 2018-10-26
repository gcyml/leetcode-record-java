class Solution {
    public int strStr(String haystack, String needle) {
        return indexOf(haystack, needle);
    }
    public int indexOf(String s, String t) {
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        return indexOf(source, 0, source.length,
                target, 0, target.length,
                0);
    }
    static int indexOf(char[] source, int sourceOffset, int sourceCount,
            char[] target, int targetOffset, int targetCount,
            int fromIndex) {
        //如果开始搜索的位置大于资源数组长度，直接返回资源数组长度（目标数组长度为0）或-1
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        //如果开始搜索位置小于0，则设为0
        // if (fromIndex < 0) {
        //     fromIndex = 0;
        // }
        
        //如果目标数组长度为0，直接返回开始搜索位置。
        if (targetCount == 0) {
            return fromIndex;
        }
        //取到目标是数组的第一个char值
        char first = target[targetOffset];
        //取到最后一次搜索的位置
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            //取到第一个字符相同的位置
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            //循环比较接下来所有所有的字符，如果全部相同则返回第一个字符的位置
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
}

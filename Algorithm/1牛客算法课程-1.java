转圈打印
    确定左上和右下两个点，确定行走路线，然后变化两个点

之字形打印
    两个坐标标记斜线，打印斜线的内容，然后将坐标分别向两个方向移动，循环

一个字符串，提供一个最长回文字串(不是连续的),然后将原字符串添加成最长回文
    如AB1C2DE34F3GHJ21KL，字串1234321 
    原字符长度n，最长字串长度m，返回结果长度2n-m
    从1开始，左侧AB，右侧KL，变为ABLK1...1KLBA，依次类推

查找数组中某个出现次数大于一般的数，用两个变量，一个候选，一个当前保存次数，
然后比较每个数，如果等于，加次数，不能，减下去，最后遍历确定次数
查找数组中出现n/k的数，准备k-1个候选
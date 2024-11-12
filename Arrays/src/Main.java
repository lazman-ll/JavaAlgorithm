import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n =4;
        int[][] ints = {{1,2,3},
                        {4,5,6},
                        {7,8,9},
                        {10,11,12},
                        {13,14,15}};
        List<Integer> integers = spiralOrder(ints);
        System.out.println("integers = " + integers);
    }

    /**
     * 移除元素(快慢指针法)
     * @param nums 原始数组
     * @param val 需要移除的值
     * @return 返回数组中非val的元素的个数，并保证移除后数组的前面都是非val的元素
     */
    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(val != nums[i]){
                //该元素不是目标值，将快指针上的值赋值给慢指针，并将快、慢指针都右移
                nums[j++] =nums[i];
            }
            //该元素是目标值，则将快指针右移(即i++)，慢指针不动
        }
        return j;
    }

    /**
     * 移除元素(快慢指针法优化)
     * @param nums 原始数组
     * @param val 需要移除的值
     * @return 返回数组中非val的元素的个数，并保证移除后数组的前面都是非val的元素
     */
    public static int removeElement02(int[] nums, int val) {
        int left = 0;
        int right = nums.length;

        while(left < right){
            if(nums[left] == val){
                //找到目标值，将末尾元素复制到该位置
                nums[left] = nums[right-1];
                right --;
            }else {
                //该元素不是目标值，指针右移
                left++;
            }
        }
        return left;
    }

    /**
     * 删除数组中的重复元素
     * @param nums 非严格递增排列的数组
     * @return 返回数组中非重复的元素的个数，并保证移除后数组的前面都是非重复的元素，且顺序与原数组一致
     */

    public static int removeDuplicates(int[] nums) {
        //i，指向的是下一个不同的元素要被填入的位置
        int i = 1;
        //j，指向的是遍历数组到达的位置
        for (int j = 1; j < nums.length; j++) {
            if(nums[j-1]!= nums[j]){
                //当相邻的两个元素不相等时，表示当前指向的元素是下一个被需要的元素
                nums[i] = nums[j];
                i++;
            }
        }
        //最后返回i，即为数组的长度
        return i ;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param nums 初始数组
     */
    /**
     * 0,1,0,3,12 0 0
     * 1 0 0 3 12 1 1
     * 1 3 0 0 12 2 3
     * 1 3 12 0 0
     */
    public static void moveZeroes(int[] nums) {
        //指向已经处理好序列的头部
        int i = 0;
        int temp;
        //指向待处理序列的第一个元素
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=0){
                //如果待处理序列的第一个元素不为0,则将两元素交换
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

    /**
     * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符
     * @param s 字符串1
     * @param t 字符串2
     * @return true为两字符串相等,反之为false
     * 法一：使用堆栈,重构字符串
     */
    public boolean backspaceCompare1(String s, String t) {
        return rebuild(s).equals(rebuild(t));
    }

    /**
     * 重构字符串，遇到 # 则将栈顶元素抛出，否则压入当前元素
     * @param s 初始字符串
     * @return 重构后的字符串
     */
    public String rebuild(String s){
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(c !='#'){
                //将元素加入栈
                sb.append(c);
            }else {
                //删除栈顶元素
                if(!sb.isEmpty()){
                    //不为空，才能删除，否则会出现空指针异常
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符
     * @param s 字符串1
     * @param t 字符串2
     * @return true为两字符串相等,反之为false
     * 法一：使用双指针
     */
    public boolean backspaceCompare2(String s, String t) {
        int lenS = s.length() - 1;
        int lenT = t.length() - 1;
        int skipS = 0,skipT = 0;
        //逆序遍历
        while(lenT>= 0 || lenS >= 0){
            while(lenT >= 0){
                if(t.charAt(lenT)=='#'){
                    //是退格符，将待删除的个数加1，并移动指针
                    skipT++;
                    lenT--;
                }else if(skipT > 0){
                    //不是退格符，且待删除的个数不为0，移动指针
                    lenT--;
                    skipT--;
                }else {
                    //不是退格符，且无待删除的元素，直接结束循环
                    //代表当前字符不会被消除，我们可以用来和 S 中的当前字符作比较。
                    break;
                }
            }
            while(lenS >= 0){
                if(s.charAt(lenS)=='#'){
                    //是退格符，将待删除的个数加1，并移动指针
                    skipS++;
                    lenS--;
                }else if(skipS > 0){
                    //不是退格符，且待删除的个数不为0，移动指针
                    lenS--;
                    skipS--;
                }else {
                    //不是退格符，且无待删除的元素，直接结束循环
                    //代表当前字符不会被消除，我们可以用来和 T 中的当前字符作比较。
                    break;
                }
            }
            //找到已确定的字符，将两者进行比较
            if (lenT >= 0 && lenS >= 0) {
                if(s.charAt(lenS) != t.charAt(lenT)){
                    //两者不等，直接返回
                    return false;
                }
            }else if(lenT >= 0 || lenS >= 0){
                //当两字符串其中一个字符串已经没了，但是另一个还有，直接返回
                return false;
            }
            lenT--;
            lenS--;
        }
        return true;
    }

    /**
     * 给你一个按非递减顺序排序的整数数组 nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     * @param nums 非递减顺序 序的整数数组
     * @return 每个数字的平方组成的新数组，要求也按非递减顺序排序
     */
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        //本方法，是找第一个非负元素，故，若都是负数时，right初始值应在数组的外面，即在最后一个元素之后
        int right = len;
        //left初始值应为数组中的最后一个元素的位置
        int left = len - 1;
        //找到第一个非负元素的位置
        for (int i = 0; i < len; i++) {
            if(nums[i]>=0){
                right = i;
                left = i - 1;
                break;
            }
        }
        int[] result = new int[len];
        int i = 0;
        //从第一个非负元素，开始向两边遍历
        while(left >= 0 || right < len){
            if(left < 0){
                //负数没了，直接将正数平方即可
                result[i++] = nums[right] * nums[right];
                right ++;
            } else if (right >= len) {
                //正数没了，直接将负数平方
                result[i++] = nums[left]*nums[left];
                left --;
            } else if(nums[right]*nums[right] > nums[left]*nums[left]){
                //右边的大
                result[i++] = nums[left]*nums[left];
                left --;
            }else{
                //左边的大
                result[i++] = nums[right]*nums[right];
                right ++;
            }
        }
        return result;
    }

    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * @param n 一个正整数
     * @return 返回一个正方形矩阵
     */
    public static int[][] generateMatrix(int n) {
        //每一圈的开始位置(行)
        int startX = 0;
        //每一圈的开始位置(列)
        int startY = 0;
        //一共要循环多少圈
        int loop = n/2;
        //中间位置，n为奇数是要额外指定中间位置的值
        int mid = n/2;
        //需要控制每一条边遍历的长度，每次循环右边界收缩一位o
        int offset = 1;
        //定义每一次要填的数
        int count = 1;

        //定义二维数组，用于保存矩阵
        int[][] array  = new int[n][n];
        
        //循环,当loop大于0的时候，一直循环
        while(loop-- > 0){
            //用i，j表示当前要填的位置
            int i=startX,j=startY;

            //遍历上面的边
            for ( j = startY; j < n - offset; j++) {
                array[i][j] = count++;
            }
            //遍历右边的边
            for ( i = startX; i < n - offset; i++) {
                array[i][j] = count++;
            }
            //遍历下面的边
            for ( j = n - offset ; j > startY ; j--) {
                array[i][j] = count++;
            }
            //遍历左边的边
            for ( i = n - offset ; i > startX ; i--) {
                array[i][j] = count++;
            }

            //一圈转完，要改变起始位置
            startX++;
            startY++;

            //每次循环右边界收缩一位
            offset++;
        }
        //若n为奇数，要额外指定中间位置的值
        if(n%2!=0){
            array[mid][mid] = n*n;
        }
        return array;
    }

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * @param matrix m 行 n 列的矩阵 matrix
     * @return 阵中的所有元素,一个一维数组
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            //若二维数组为空，或者没有数字，直接返回一个空的数组
            return order;
        }
        //存储每一圈的起始位置
        int left = 0;
        int high = 0;
        //获取二维矩阵的行和列
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while (left <= right && high <= bottom ){
            for (int column = left; column <= right; column++) {
                order.add(matrix[high][column]);
            }
            for (int row = high + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && high < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > high; row--) {
                    order.add(matrix[row][left]);
                }
            }

            left++;
            high++;
            right--;
            bottom--;
        }
        return order;
    }
}
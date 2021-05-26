package offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HashPath {
    public static void main(String[] args) {
        boolean b = hasPaths("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8, "SGGFIECVAASABCEHJIGQEM".toCharArray());
        System.out.println(b);
    }

    public static boolean hasPaths(char[] matrix, int rows, int cols, char[] str) {
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (matrix[i*cols + j] == str[0]) {
                   if (isRightPath(matrix,str,rows,cols,i,j,0)){
                       return true;
                   }
                }
            }
        }
        return false;
    }

    private static boolean isRightPath(char[] matrix, char[] str, int rows, int cols, int i, int j, int count) {

        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[i*cols + j] == '0' || matrix[i*cols + j] != str[count]) {
            return false;
        }

        if (count == str.length-1){
            return true;
        }

        char temp = matrix[i*cols + j];
        matrix[i*cols + j] = '0';

        boolean flag = isRightPath(matrix,str,rows,cols,i+1,j,count+1)
                    || isRightPath(matrix,str,rows,cols,i-1,j,count+1)
                    || isRightPath(matrix,str,rows,cols,i,j-1,count+1)
                    || isRightPath(matrix,str,rows,cols,i,j+1,count+1);


        if (flag){
            return true;
        }

        matrix[i*cols + j] = temp;

        return false;
    }

    private static boolean judge(char[] matrix, int rows, int cols, int i, int j, boolean[][] flag, char[] str,int k) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[i*cols + j]=='0' || matrix[i*cols + j] != str[k]){
            return false;
        }
        if (k == str.length-1){
            return true;
        }
        char temp = matrix[i*cols + j];
        matrix[i*cols + j] = '0';
        flag[i][j] = true;
        if (judge(matrix,rows,cols,i-1,j,flag,str,k+1)||
                judge(matrix,rows,cols,i,j-1,flag,str,k+1)||
                judge(matrix,rows,cols,i+1,j,flag,str,k+1)||
                judge(matrix,rows,cols,i,j+1,flag,str,k+1)){
            return true;
        }
        matrix[i*cols + j] = temp;
        flag[i][j] = false;
        return false;

    }

        public static boolean judge1(char[] array, int i, int j, int rows, int cols, boolean[][] flag, char[] str, int k) {

                if(i < 0 || j < 0 || i >= rows || j >= cols || flag[i][j] || array[i*cols+j] != str[k] ){
                    return false;
                }
                if (k == str.length-1){
                    return true;
                }
                flag[i][j]= true;
                  if(judge1(array,i-1,j,rows,cols,flag,str,k+1)
                         ||  judge1(array,i,j-1,rows,cols,flag,str,k+1)
                         ||  judge1(array,i+1,j,rows,cols,flag,str,k+1)
                         ||  judge1(array,i,j+1,rows,cols,flag,str,k+1)){
                     return true;
            }
                 flag[i][j] = false;
                  return false;
         }
    //judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    private static boolean judge(char[] matrix,int i,int j,int rows,int cols,boolean[] flag,char[] str,int k){
        //先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i*cols+j;
        //递归终止条件t
        if(i<0 || j<0 || i>=rows || j>=cols || matrix[index] != str[k] || flag[index] == true)
            return false;
        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if(k == str.length-1)
            return true;
        //要走的第一个位置置为true，表示已经走过了
        flag[index] = true;

        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if(judge(matrix,i-1,j,rows,cols,flag,str,k+1) ||
                judge(matrix,i+1,j,rows,cols,flag,str,k+1) ||
                judge(matrix,i,j-1,rows,cols,flag,str,k+1) ||
                judge(matrix,i,j+1,rows,cols,flag,str,k+1)  )
        {
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        flag[index] = false;
        return false;
    }




}

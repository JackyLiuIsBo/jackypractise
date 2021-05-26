package pracktiseskill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName findWords
 * @Description
 * @Author liubo
 * @Date 2021/5/6 8:37 下午
 **/
public class findWords {
    public static void main(String[] args) {
        char [][] board = {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        String [] words = {"eaabcdgfa"};
        List<String> words1 = findWords(board, words);
        System.out.println(Arrays.toString(words1.toArray()));
    }
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word: words) {
           boolean flag =  isMatch(board,word);
           if(flag){
               result.add(word);
           }
        }
        return result;
    }

    private static boolean isMatch(char[][] board, String word) {

        boolean[][] isStep = new boolean[board.length][board[0].length];
        boolean match = false;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
             match = match(board, word, i, j, 0,isStep);
             if (match){
                 return match;
             }
            }
        }
        return match;
    }

    private static boolean match(char[][] board, String word, int row, int col, int pos,boolean[][] isStep ) {
        HashMap<Character,Integer> map = new HashMap<>();
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || (isStep[row][col]) || board[row][col] != word.charAt(pos)){

            return false;
        }

        if (pos == word.length() - 1 && board[row][col] == word.charAt(pos)){
            return true;
        }
        isStep[row][col] = true;
        if( match(board,word,row+1,col,pos + 1,isStep)
            ||  match(board,word,row-1,col,pos + 1,isStep)
            ||  match(board,word,row,col-1,pos + 1,isStep)
            ||  match(board,word,row,col+1,pos + 1,isStep)){
            return true;
        }

        //关键在这边，如果某条路径尝试过走不通，需要把原来走过的标志抹除掉。
        isStep[row][col] = false;
        return false;

    }
}

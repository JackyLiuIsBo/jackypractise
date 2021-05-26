package pracktiseskill.hot100;

/**
 * @ClassName Trie
 * @Description
 * @Author liubo
 * @Date 2021/5/22 6:53 下午
 **/
public class Trie {
    Trie[] chirld ;
    Boolean isEnd ;

    Trie (){
        chirld = new Trie[26];
        isEnd = true;
    }

    public void insert(String str){
        Trie node = this;
        for (int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - 'a';
            this.chirld[index] = node;
            node = node.chirld[index];

        }

        node.isEnd = true;

    }

    public boolean search(String word) {
        Trie node =  searchPre(word);
        return node != null && node.isEnd;
    }

    private Trie searchPre(String word) {
        Trie node = this;
        for(int i =0; i < word.length();i++){
            int index = word.charAt(i);
            if (node.chirld[i] == null){
                return null;
            }
            node = node.chirld[index];
        }
        return node;
    }

    public boolean startsWith(String prefix) {
        return searchPre(prefix) != null;
    }

}

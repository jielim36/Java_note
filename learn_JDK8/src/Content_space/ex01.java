package Content_space;

public class ex01 {
    public static void main(String[] args) {
        //String中连续三个 " 符号可以达到一个文本框的效果，我们字符串的换行可以和输出的结果保持一致。
        String content = """
                hallo
                my name is
                lim yee jie
                """;

        // \s 符号：空一格的效果
        // \ 符号：取消换行操作
        String content2 = """
                hallo\
                my name is\
                lim\syee\sjie
                """;

        System.out.println("===Original:==="+content);
        System.out.println("\n===Cancel Space:===\n"+content);
    }
}

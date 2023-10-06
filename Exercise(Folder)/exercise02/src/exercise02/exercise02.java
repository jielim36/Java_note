package exercise02;
/*
练习题：
输入用户名，密码，邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
注意：
1.密码的长度必须是6，要求全部都是数字
2.用户名长度为2-4
3.邮箱中包含@和.符号，并且@必须在.的前面
 */
public class exercise02 {
    public static void main(String[] args) {
        try {
            login(null,"123456",new StringBuffer("jielim00@gmail.com"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void login(String userName , String password  , StringBuffer email){

        //防护机制思路：过关斩将
        //第一关：用户名
        if (!(userName != null &&userName.length() >= 2 && userName.length() <= 4 )){ //先把“正确的行为”写下来然后括号起来放个感叹号取反就是“只要不是正确的行为，就执行以下代码”
            throw new RuntimeException("用户名不能为空，且必须在2-4个字数之间");
        }

        //第二关：密码长度
        if (!( password.length() == 6 && judgmentPassword(password) )){
            throw new RuntimeException("密码格式错误!");
        }

        int find = email.indexOf("@");
        int find2 = email.indexOf(".");
        if (!(find != -1 && find2 != -1 && find2 > find )){
            throw new RuntimeException("邮箱格式错误！");
        }

        System.out.println("注册成功!!!");

    }

    public static boolean judgmentPassword(String password){
        char [] pwd = password.toCharArray();

        for (int i = 0 ; i < pwd.length ; i++){

            if (pwd[i] < '0' || pwd[i] > '9'){ //这里是char字符，<'0' 的0指的是ASCII编码
                return false;
            }

        }
        return true;
    }
}

package Example02_Syntax;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 关于分组的详细介绍
 */
public class ex06_group {
    @Test
    public void test01(){
        /**
         (pattern) - 非命名捕获。捕获匹配的子字符串。
         编号为0的第一个捕获是由整个正则表达式模式匹配的文本，其它捕获结果则根据左括号的顺序从1开始自动编号

         (?<name>pattern) - 命名捕获。将匹配的子字符串捕获到一个组名称或编号名称中。
         用于name的字符串不能包含任何标点符号，并且不能以数字开头。可以用单引号替代尖括号，例如(?'name')
         */
        String content = "Aaaa%%Bbbb%%Cccc%%Eeee";
//        String regStr = "[A-C][a-z]{3}";//第一种：第一个字符大写的A,B,C任意一个，后面需要有三个随机小写字母,且没有分组
//        String regStr = "([A-C])[a-z]{3}";//第二种：有分一个组,这时候如果group方法传入2会报错
        String regStr = "([A-C])([a-z]{3})";//第三种：有分两组,这时候如果group方法传入1或2就可以分别只输出第一或第二组，组的编号从左开始算到右，从1开始


        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));//根据第三种方式，group方法传入0时会显示全部匹配到的字符串
            System.out.println("第一组：" + matcher.group(1));//传入1时：依然会匹配到全部条件，但只输出第一组的字符
            System.out.println("第二组：" + matcher.group(2));//传入2时：依然会匹配到全部条件，但只输出第二组的字符
            System.out.println("==============");
        }

    }

    @Test
    public void test02(){
        /**
         * (?<name>pattern) - 命名捕获。将匹配的子字符串捕获到一个组名称或编号名称中。
         *          用于name的字符串不能包含任何标点符号，并且不能以数字开头。可以用单引号替代尖括号，例如(?'name')
         */
        String content = "Aaaa%%Bbbb%%Cccc%%Eeee";
        String regStr = "(?<upCase>[A-C])(?<lowCase>[a-z]{3})";//两种命名方式：?<name> 和 ?'name' ，写在括号内(但是不知为什么?'name'我的会报错)


        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
            System.out.println("upCase组别：" + matcher.group("upCase"));//通过字符串调用
            System.out.println("lowCase组别：" + matcher.group("lowCase"));
            System.out.println("==============");
        }
    }

    @Test
    public void test03(){
        /**
         (?:pattern) - 匹配pattern但不能捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。
                        这对于用"or"字符 | 组合模式不见的情况很有用。
                        例如：原本要匹配：industry|industries ， 可以写成 industr(?:y|ies),这是更好的写法
         */
        String content = "hello韩顺平教育 jack韩顺平老师 韩顺平同学hello";
        String regStr = "韩顺平(?:教育|老师|同学)";//目标:找到韩顺平教育，韩顺平老师，韩顺平同学 子字符串
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));//不能单独输出的非捕获分组
        }
    }
    @Test
    public void test04(){
        /**
         (?=pattern) - 非捕获匹配。例如：Windows (?=95|98|NT|2000) 表示匹配到这些之后，并不会输出(?=)组内的内容，只会输出Windows
                        如果文本是 Windows 3.1，就表示无法匹配，连Windows都输出不了。
                        即：必须同时实现(?=)括号内的匹配规则，但输出时不会输出(?=)内的匹配内容
         */
        String content = "hello韩顺平教育 jack韩顺平老师 韩顺平同学hello";
        String regStr = "韩顺平(?=教育|老师)";//目标:找到韩顺平教育，韩顺平老师 子字符串，但是只输出韩顺平
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));//有三个韩顺平，但是目标只是匹配教育和老师后缀的，而且也不输出后缀，只输出韩顺平
            //所以输出结果只有重复两次韩顺平
        }
    }

    @Test
    public void test05(){
        /**
         (?!pattern) - 非捕获匹配。例如：Windows (?=95|98|NT|2000) 表示匹配"除了"(?!)括号内的东西
                        且输出时也不输出(?!)内的东西, 类似于 [^pattern]的功能
                        例如： Windows 95 是不匹配的， Windows 3.1是匹配的，但只输出Windows

         */
        String content = "hello韩顺平教育 jack韩顺平老师 韩顺平同学hello";
//        String regStr = "韩顺平[^教育|老师]{2}"; //和下面使用?!的区别是，这个会输出同学后缀，但?!是只能输出韩顺平
        String regStr = "韩顺平(?!教育|老师)";//目标:找到不是韩顺平教育，韩顺平老师，但又有韩顺平的子字符串
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));
        }
    }

}

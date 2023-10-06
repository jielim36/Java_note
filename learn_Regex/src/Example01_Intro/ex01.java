package Example01_Intro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regex(Regular Expression) - 正则表达式
 *
 * 正则表达式是处理文本的利器
 */
public class ex01 {
    public static void main(String[] args) {

        String content = "语言最开始只是Sun微系统（Sun MicroSystems）公司在1990年12月开始研究的一个内部项目。Sun微系统公司的一个叫做帕特里克·诺顿的工程师被公司自己开发的C++和C语言编译器搞得焦头烂额，因为其中的API极其难用。帕特里克决定改用NeXT，同时他也获得了研究公司的一个叫做“Stealth计划”的项目的机会。\n" +
                "\n" +
                "“Stealth计划”后来改名为“Green计划”，詹姆斯·高斯林和麦克·舍林丹（Mike Sheridan）也加入了帕特里克的工作小组。他们和其他几个工程师一起在加利福尼亚州门罗帕克市沙丘路的一个小工作室里面研究开发新技术，瞄准下一代智能家电（如微波炉）的程序设计，Sun微系统预料未来科技将在家用电器领域大显身手。团队最初考虑使用C++语言，但是很多成员包括Sun微系统的首席科学家比尔·乔伊，发现C++和可用的API在某些方面存在很大问题。\n" +
                "\n" +
                "工作小组使用的是嵌入式系统，可以用的资源极其有限。很多成员发现C++太复杂以至很多开发者经常错误使用。他们发现C++缺少垃圾回收系统，还有可移植的安全性、分布程序设计、和多线程功能。最后，他们想要一种易于移植到各种设备上的平台。\n" +
                "\n" +
                "根据可用的资金，乔伊决定开发一种集C语言和Mesa语言大成的新语言，在一份报告上，乔伊把它叫做“未来”，他提议Sun微系统的工程师应该在C++的基础上，开发一种面向对象的环境。最初，高斯林试图修改和扩展C++的功能，他自己称这种新语言为C++ -- [来源请求]，但是后来他放弃了。他将要创造出一种全新的语言，被他命名为“Oak”（橡树），以他的办公室外的橡树命名。\n" +
                "\n" +
                "就像很多开发新技术的秘密工程一样，工作小组没日没夜地工作到了1993年的夏天，他们能够演示新平台的一部分了，包括Green操作系统，Oak的程序设计语言，类库及其硬件。最初的尝试是面向一种类PDA设备，被命名为Star7，这种设备有鲜艳的图形界面和被称为“Duke”的智能代理来帮助用户。1992年12月3日，这台设备进行了展示。\n" +
                "\n" +
                "同年11月，Green计划被转化成了“FirstPerson有限公司”，一个Sun微系统的全资子公司，团队也被重新安排到了帕洛阿尔托。FirstPerson团队对建造一种高度交互的设备感兴趣，当时代华纳发布了一个关于电视机顶盒的征求提议书时（Request for proposal），FirstPerson改变了他们的目标，作为对征求意见书的响应，提出了一个机顶盒平台的提议。但是有线电视业界觉得FirstPerson的平台给予用户过多的控制权，因此FirstPerson的投标败给了SGI。与3DO公司的另外一笔关于机顶盒的交易也没有成功，由于他们的平台不能在电视工业产生任何效益，公司被并回Sun微系统。";

        //提取文章中的英文单词
        //思路：判断英文字的ASCII码，然后如果连续判断到都是英文字,就拼接就可以组成一个英文单词

        //传统方法：通过遍历方式，但是代码量巨大，效率不高

        //演示正则表达式Regular Expression (Regex)

//        Pattern pattern = Pattern.compile("[a-zA-Z]+"); //寻找英文单词
//        Pattern pattern = Pattern.compile("[0-9]+"); //寻找数字
//        Pattern pattern = Pattern.compile("([0-9]+)|([a-zA-Z]+)"); //数字和英文单词
//        Matcher matcher = pattern.matcher(content);
//        while(matcher.find()){
//            System.out.println("找到: " + matcher.group(0));
//        }

        System.out.println("==============获取热搜榜数据==========");
        String content2 = rank();//获取数据
        Pattern pattern = Pattern.compile("'電影排行榜','電影排行榜_台北票房榜','(\\S*)'");
        Matcher matcher = pattern.matcher(content2);
        int tier = 1;
        while(matcher.find()){
            System.out.println("找到: "+ (tier++) + "  " + matcher.group(1));
        }
    }

    public static String rank(){
        //假设这个是我们爬虫到的数据
        String sourceCode = "<ul class=\"ranking_list_r\">\n" +
                "                                        <a\n" +
                "                    class=\"gabtn\"\n" +
                "                    href=\"https://movies.yahoo.com.tw/movieinfo_main/%E8%B6%85%E7%B4%9A%E7%91%AA%E5%88%A9%E6%AD%90%E5%85%84%E5%BC%9F%E9%9B%BB%E5%BD%B1%E7%89%88-the-super-mario-bros-movie-14299\"\n" +
                "                    data-ga=\"['電影排行榜','電影排行榜_台北票房榜','超級瑪利歐兄弟電影版']\"\n" +
                "                >\n" +
                "                    <li class=\"select\">\n" +
                "                        <div class=\"num\">1</div>\n" +
                "                        <span>超級瑪利歐兄弟電影版</span>\n" +
                "                    </li>\n" +
                "                </a>\n" +
                "                                                <a\n" +
                "                    class=\"gabtn\"\n" +
                "                    href=\"https://movies.yahoo.com.tw/movieinfo_main/%E9%80%9F%E5%91%BD%E9%81%93-red-line-14696\"\n" +
                "                    data-ga=\"['電影排行榜','電影排行榜_台北票房榜','速命道']\"\n" +
                "                >\n" +
                "                    <li class=\"\">\n" +
                "                        <div class=\"num\">2</div>\n" +
                "                        <span>速命道</span>\n" +
                "                    </li>\n" +
                "                </a>\n" +
                "                                                <a\n" +
                "                    class=\"gabtn\"\n" +
                "                    href=\"https://movies.yahoo.com.tw/movieinfo_main/%E9%BE%8D%E8%88%87%E5%9C%B0%E4%B8%8B%E5%9F%8E-%E7%9B%9C%E8%B3%8A%E6%A6%AE%E8%80%80-dungeons-dragons-honor-among-thieves-13733\"\n" +
                "                    data-ga=\"['電影排行榜','電影排行榜_台北票房榜','龍與地下城：盜賊榮耀']\"\n" +
                "                >\n" +
                "                    <li class=\"\">\n" +
                "                        <div class=\"num\">3</div>\n" +
                "                        <span>龍與地下城：盜賊榮耀</span>\n" +
                "                    </li>\n" +
                "                </a>\n" +
                "                                                <a\n" +
                "                    class=\"gabtn\"\n" +
                "                    href=\"https://movies.yahoo.com.tw/movieinfo_main/%E6%A2%B5%E8%92%82%E5%B2%A1%E9%A9%85%E9%AD%94%E5%A3%AB-the-popes-exorcist-14898\"\n" +
                "                    data-ga=\"['電影排行榜','電影排行榜_台北票房榜','梵蒂岡驅魔士']\"\n" +
                "                >\n" +
                "                    <li class=\"\">\n" +
                "                        <div class=\"num\">4</div>\n" +
                "                        <span>梵蒂岡驅魔士</span>\n" +
                "                    </li>\n" +
                "                </a>\n" +
                "                                                <a\n" +
                "                    class=\"gabtn\"\n" +
                "                    href=\"https://movies.yahoo.com.tw/movieinfo_main/%E9%88%B4%E8%8A%BD%E4%B9%8B%E6%97%85-suzume-14652\"\n" +
                "                    data-ga=\"['電影排行榜','電影排行榜_台北票房榜','鈴芽之旅']\"\n" +
                "                >\n" +
                "                    <li class=\"\">\n" +
                "                        <div class=\"num\">5</div>\n" +
                "                        <span>鈴芽之旅</span>\n" +
                "                    </li>\n" +
                "                </a>\n" +
                "                                                <a\n" +
                "                    class=\"gabtn\"\n" +
                "                    href=\"https://movies.yahoo.com.tw/movieinfo_main/%E6%8D%8D%E8%A1%9B%E4%BB%BB%E5%8B%994-john-wick-chapter-4-14653\"\n" +
                "                    data-ga=\"['電影排行榜','電影排行榜_台北票房榜','捍衛任務4']\"\n" +
                "                >\n" +
                "                    <li class=\"\">\n" +
                "                        <div class=\"num\">6</div>\n" +
                "                        <span>捍衛任務4</span>\n" +
                "                    </li>\n" +
                "                </a>\n" +
                "                                                <a\n" +
                "                    class=\"gabtn\"\n" +
                "                    href=\"https://movies.yahoo.com.tw/movieinfo_main/%E7%B5%95%E5%9C%B0%E7%87%9F%E6%95%91-the-covenant-15031\"\n" +
                "                    data-ga=\"['電影排行榜','電影排行榜_台北票房榜','絕地營救']\"\n" +
                "                >\n" +
                "                    <li class=\"\">\n" +
                "                        <div class=\"num\">7</div>\n" +
                "                        <span>絕地營救</span>\n" +
                "                    </li>\n" +
                "                </a>\n" +
                "                                                <a\n" +
                "                    class=\"gabtn\"\n" +
                "                    href=\"https://movies.yahoo.com.tw/movieinfo_main/%E9%AC%BC%E7%8E%A9%E4%BA%BA-%E5%BE%A9%E6%B4%BB-evil-dead-rise-14618\"\n" +
                "                    data-ga=\"['電影排行榜','電影排行榜_台北票房榜','鬼玩人：復活']\"\n" +
                "                >\n" +
                "                    <li class=\"\">\n" +
                "                        <div class=\"num\">8</div>\n" +
                "                        <span>鬼玩人：復活</span>\n" +
                "                    </li>\n" +
                "                </a>\n" +
                "                                                <a\n" +
                "                    class=\"gabtn\"\n" +
                "                    href=\"https://movies.yahoo.com.tw/movieinfo_main/%E7%96%AB%E8%B5%B7-eye-of-the-storm-14783\"\n" +
                "                    data-ga=\"['電影排行榜','電影排行榜_台北票房榜','疫起']\"\n" +
                "                >\n" +
                "                    <li class=\"\">\n" +
                "                        <div class=\"num\">9</div>\n" +
                "                        <span>疫起</span>\n" +
                "                    </li>\n" +
                "                </a>\n" +
                "                                                <a\n" +
                "                    class=\"gabtn\"\n" +
                "                    href=\"https://movies.yahoo.com.tw/movieinfo_main/%E9%99%90%E6%99%82%E8%BF%BD%E6%8D%95-the-blackout-15095\"\n" +
                "                    data-ga=\"['電影排行榜','電影排行榜_台北票房榜','限時追捕']\"\n" +
                "                >\n" +
                "                    <li class=\"\">\n" +
                "                        <div class=\"num\">10</div>\n" +
                "                        <span>限時追捕</span>\n" +
                "                    </li>\n" +
                "                </a>\n" +
                "                        </ul>";
        return sourceCode;
    }
}

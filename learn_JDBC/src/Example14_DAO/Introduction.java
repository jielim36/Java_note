package Example14_DAO;

/**
 * Example14 主要讲解关于BasicDao的使用
 *
 * 为什么使用BasicDao？
 * BasicDao的出现是因为原始的ApUtils等都只能完成最简单基本的操作
 * 如果有多个类的话我们的代码就需要重复写（代码复用率差）
 *
 * BasicDao的分析：
 * 该案例的BasicDao中会有三个Package（按需求，该案例主要学习BasicDao，所以没有太多的包）
 * 1. Domain包：主要负责存放所有domain（JavaBean）,也就是类似数据库中的表对应的类，如：Actor,News等
 * 2. test包：主要放入我们的测试类
 * 3. dao包：我们主要学习的BasicDao部分，里面是一个BasicDao接口和它的子类，每个子类都是每个domain类对应的数据库操作类
 * 4. Utils：工具类
 */

public class Introduction {
}

package Example14_DAO.dao;

import Example14_DAO.Domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;


/**
 * 该类是针对Actor这个Domain类进行增删改查操作的类
 * 比起BasicDAO的各种通用方法，这里会编写Actor的特有方法
 */
public class ActorDAO extends BasicDAO<Actor>{//ActorDAO继承了BasicDAO，并且泛型改为Actor这个Domain类
    @Test
    public void testActorDAO(){
        ActorDAO actorDAO = new ActorDAO();
        //1.查询多个记录
        List<Actor> actors = actorDAO.queryMulti(Actor.class, "select * from actor where id >= ?",1);
        System.out.println("====查询结果====");
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        //2.查询单条记录
        Actor actor = actorDAO.querySingle(Actor.class , "select * from actor where id = 2" , null);
        System.out.println("\n\n===查询单条记录===");
        System.out.println(actor);

        //3.查询单行单列
        Object obj = actorDAO.queryScalar("select name from actor where id = ?" , 7);
        System.out.println("\n\n===查询单行单列的数据===");
        System.out.println(obj);

        //4. DML操作
        int affectedRow = actorDAO.update("update actor set name = ? where id = ?" , "Hang" , 7);
        System.out.println(affectedRow > 0 ? "修改成功，共影响了"+affectedRow+"行记录" : "修改失败或表没有被修改");
    }

}

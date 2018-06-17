import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * Created by zhongxuexi on 2018/6/17.
 */
public class TestRedis {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.0.188");
        System.out.println("连接成功");
        //System.out.println(jedis.get("zhong"));
        //jedis.set("zhong","jess");
        //获取String
        System.out.println(jedis.get("hello1"));
        //查看服务是否运行

        System.out.println("服务正在运行: "+jedis.ping());
        //获取List存储数据并输出
        List<String> list = jedis.lrange("listTest",0,10);
        System.out.println("list中的值是：");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        //获取Set存储数据并输出
        Set<String> set = jedis.smembers("setTest");
        System.out.println("set中的值是：");
        for(String i:set){
            System.out.println(i);
        }
    }
}

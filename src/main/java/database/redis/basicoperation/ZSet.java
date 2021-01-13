package database.redis.basicoperation;

import database.redis.RedisConf;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class ZSet {
    @Test
    public void test(){
        RedisConf redisConf=new RedisConf();
        Jedis jedis=new Jedis(redisConf.getIpAddress(),redisConf.getPort());
        //往key中添加成员及其分数
        jedis.zadd("myZSet",100,"ni");
        //获取集合中的成员数
        jedis.zcard("myZSet");
        //获取集合中某个元素的索引
        jedis.zrank("myZSet","ni");
        //获取索引区间内的元素
        jedis.zrange("myZSet",0,2);
        //获取分数区间内的元素
        jedis.zrangeByScore("myZSet",50,100);
        //删除元素,存在的所有成员无论分数都会被删除
        jedis.zrem("myZSet","ni");
        //删除元素，按照索引区间和分数区间
        jedis.zremrangeByRank("myZSet",0,1);
        jedis.zremrangeByScore("myZSET",50,100);


    }
}

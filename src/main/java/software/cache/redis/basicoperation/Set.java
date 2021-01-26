package software.cache.redis.basicoperation;

import software.cache.redis.RedisConf;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Set {
    @Test
    public void test(){
        RedisConf redisConf=new RedisConf();
        Jedis jedis=new Jedis(redisConf.getIpAddress(),redisConf.getPort());
        //添加成员
        jedis.sadd("mySet","nihaoa");
        //随意移除并获取集合中的一个成员
        jedis.spop("mySet");
        //获取set中的所有成员的数量
        jedis.scard("mySet");
        //获取set中的所有成员
        jedis.smembers("mySet");
        //获取第一个集合与其他集合的差集,即只有第一个集合拥有的成员
        jedis.sdiff("mySet","mySet2");
        //返回交集
        jedis.sinter("mySet","mySet2");
    }
}

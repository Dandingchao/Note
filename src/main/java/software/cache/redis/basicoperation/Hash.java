package software.cache.redis.basicoperation;

import software.cache.redis.RedisConf;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class Hash {
    @Test
    public void test(){
        RedisConf redisConf=new RedisConf();
        Jedis jedis=new Jedis(redisConf.getIpAddress(),redisConf.getPort());
        //redis hash类型的结构上 key - field - value ，由键域对共同确定一个值
        //一个键可以对应n个域值对，
        //重复的键域对会覆盖原先的值

        jedis.hset("hi","myhash","nihaoa");
        jedis.hget("hi","myhash");
        Map<java.lang.String, java.lang.String> map=new HashMap<>();
        map.put("myhash","nimyhash");
        map.put("myhash1","nimyhash1");
        jedis.hmset("ni",map);
        //显示键域对是否存在
        jedis.hexists("hi","myhash");
        //显示该键存在多少域值对
        jedis.hlen("hi");
        //只有当不存在时设置值,即键域对不存在时，成功时返回1，不成功时返回0
        jedis.hsetnx("hi","myhash2","nihaoa");
        //删除该键域对及其对应的值
        jedis.hdel("hi","myhash");


    }
}

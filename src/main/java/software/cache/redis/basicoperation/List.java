package software.cache.redis.basicoperation;

import software.cache.redis.RedisConf;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class List {
    @Test
    public void test(){
        RedisConf redisConf=new RedisConf();
        Jedis jedis=new Jedis(redisConf.getIpAddress(),redisConf.getPort());
        //redis列表是一个队列，可以先进先出也可以先进后出，left为头，right为尾
        jedis.lpush("redislist","niahao");
        jedis.rpush("redislist","nihaoar");
        jedis.lpop("redislist");
        jedis.rpop("redislist");
        //输出长度
        jedis.llen("redislist");
        //删除指定列表，指定元素，指定的个数
        jedis.lrem("redislist",1,"nihaoa");
        //删除指定区间
        jedis.ltrim("redialist",0,1);
        //输出范围数据
        jedis.lrange("redislist",0,1);

    }
}

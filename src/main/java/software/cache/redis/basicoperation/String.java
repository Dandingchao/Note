package software.cache.redis.basicoperation;

import software.cache.redis.RedisConf;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class String {
    @Test
    public void test(){
        RedisConf redisConf=new RedisConf();
        Jedis jedis=new Jedis(redisConf.getIpAddress(),redisConf.getPort());
        //String类型
        jedis.set("hi","wobuhao");
        jedis.get("hi");
        jedis.del("hi");
    }
}

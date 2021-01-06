package database.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;
public class redis {
    public static void main(String[] args) {
        /**
         * 集群设置，但是目前没有集群。。
         */
        /*
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMaxIdle(2);
        Set<HostAndPort> jedisNode =new HashSet<HostAndPort>();
        jedisNode.add(new HostAndPort("172.30.123.240",6379));
        JedisCluster jc=new JedisCluster(jedisNode,config);
        jc.set("name","超超");
        System.out.println(jc.get("name"));*/

        Jedis jedis=new Jedis("172.30.123.240",6333);
        //jedis.auth();
        System.out.println(jedis.ping());
    }
}

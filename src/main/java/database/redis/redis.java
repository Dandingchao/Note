package database.redis;

import entity.Dog;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class redis {
    public static void main(String[] args) {
        RedisConf redisConf=new RedisConf();
        /**
         * 集群设置，但是目前没有集群。。
         *//*
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMaxIdle(2);
        Set<HostAndPort> jedisNode =new HashSet<HostAndPort>();
        jedisNode.add(new HostAndPort("172.30.123.240",6379));
        JedisCluster jc=new JedisCluster(jedisNode,config);
        jc.set("name","超超");
        System.out.println(jc.get("name"));*/

        Jedis jedis=new Jedis(redisConf.getIpAddress(),redisConf.getPort());
        //jedis.auth();
        //String类型
        jedis.set("hi","wobuhao");
        jedis.get("hi");
        jedis.del("hi");

        //一个键可以对应n个域，值对，
        jedis.hset("hi","myhash","nihaoa");
        jedis.hset("hi","myhash1","ninini");
        jedis.hget("hi","myhash");
        Map<String,String> map=new HashMap<>();
        map.put("myhash","nimyhash");
        map.put("myhash1","nimyhash1");
        jedis.hmset("ni",map);
        jedis.hexists("hi","myhash");
        jedis.hlen("hi");
        //只有当不存在时设置值,即键域对不存在时，成功时返回1，不成功时返回0
        System.out.println(jedis.hsetnx("hi","myhash2","nihaoa"));
        System.out.println(jedis.hsetnx("ni","myhash2","nihaoa"));
        jedis.hdel("hi","myhash");
        System.out.println(jedis.hsetnx("hi","myhash3","nihaoa"));
        System.out.println(jedis.ping());



    }
}

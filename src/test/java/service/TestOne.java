package service;

import com.example.leetcode.LRU.Lru;
import org.junit.jupiter.api.Test;

/**
 * @author kai·yang
 * @Date 2021/8/30 18:35
 */
public class TestOne {


    @Test
    void test(){
        Lru<String, String> lru = new Lru<>(16);

        lru.add("1", "1");
        lru.add("2", "2");
        lru.add("3", "3");
        lru.add("4", "4");

        System.out.println(lru.toString());
    }
}

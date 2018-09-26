package xin.zhuyao.httputiltest;

import xin.zhuyao.httputil.HttpUtils;

import java.util.HashMap;
import java.util.Map;

public class HttpUtilsTest {


    public static void main(String[] args) {
        test1();
        test2();
    }


    public static void test1() {
        String gets = HttpUtils.gets("https://www.zhuyao.xin/api/joke");
        System.out.println(gets);
    }


    public static void test2() {
        Map<String,String> map = new HashMap<>();
        map.put("crity","砀山");
        String posts = HttpUtils.posts("https://www.zhuyao.xin/api/crityinfo", map);
        System.out.println(posts);
    }


    /**
     * 这个是假的无结果
     * 没有例子
     */
    public static void teste() {
        Map<String,String> map1 = new HashMap<>();
        map1.put("crity","砀山");
        Map<String,String> map2 = new HashMap<>();
        map2.put("crity","砀山");
        String posts = HttpUtils.postsHeader("https://www.zhuyao.xin/api/crityinfo", map1,map2);
        System.out.println(posts);
    }
    /**
     * 等等一系列
     * 源码在：https://github.com/zywaiting/httputil
     */
}

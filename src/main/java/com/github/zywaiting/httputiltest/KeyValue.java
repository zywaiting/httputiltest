package com.github.zywaiting.httputiltest;

/**
 * Created on 2018/9/25.<br>
 * 简单工具对象，用来存放键值对。
 *
 * @author zy
 * @version 1.0
 */
public class KeyValue {
    private String key;
    private Object value;

    public KeyValue() {
    }

    public KeyValue(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KeyValue{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}

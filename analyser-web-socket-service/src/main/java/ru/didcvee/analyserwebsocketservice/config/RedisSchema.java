package ru.didcvee.analyserwebsocketservice.config;

public class RedisSchema {
    //set
    public static String groupKeys(){
        return KeyHelper.getKey("groups");
    } // app:groups

    //hash with summary types
    public static String groupKey(String groupName) {
        return KeyHelper.getKey("groups:" + groupName);
    }

    // если три параметра, можно как мапу: ключ = app:groups:IP1-22
    // и поля: avg: 1

}

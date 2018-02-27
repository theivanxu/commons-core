package com.theivanxu.reflection;

/**
 * Created by xushaonan on 2018/1/10.
 **/
public class MainTest {

    public static void main(String[] args) {

        QueryUserRequest queryUserRequest = new QueryUserRequest("Ivan", 18, true);

        queryUserRequest.nullFieldValidation();

        queryUserRequest.receiveInfo(null);
    }
}

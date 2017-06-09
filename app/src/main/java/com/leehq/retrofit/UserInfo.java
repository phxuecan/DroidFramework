package com.leehq.retrofit;

import io.realm.RealmObject;

/**
 * *********************************************** <br>
 * 文件名称: UserInfo <br>
 * 版权声明: <b>深圳市葡萄信息技术有限公司</b> 版权所有 <br>
 * 创建人员: putao_lhq <br>
 * 文件描述: <br>
 * 修改时间: 17-6-5 <br>
 * 修改历史:  <br>
 * ************************************************
 */

public class UserInfo extends RealmObject
{
    private String username;
    private String phone;
    private String uid;
    private String token;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }
}

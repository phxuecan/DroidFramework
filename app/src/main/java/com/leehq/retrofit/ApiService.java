package com.leehq.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * *********************************************** <br>
 * 文件名称: ApiService <br>
 * 版权声明: <b>深圳市葡萄信息技术有限公司</b> 版权所有 <br>
 * 创建人员: putao_lhq <br>
 * 文件描述: <br>
 * 修改时间: 17-6-5 <br>
 * 修改历史:  <br>
 * ************************************************
 */

public interface ApiService
{
    @GET("user/login")
    Call<UserInfo> getUserInfo(@Query("username") String username,
                               @Query("password") String password);
}

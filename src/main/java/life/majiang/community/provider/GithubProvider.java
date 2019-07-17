package life.majiang.community.provider;

import com.alibaba.fastjson.JSON;
import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO){
         MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string= response.body().string();
                System.out.println(string);
                String token = string.split("&")[0].split("=")[1];
                System.out.println(token);
                    return  token;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return  null;
    }

    //利用接口得到user的信息
    public GithubUser getUser(String accessToken){
        //利用okhttp来处理这个get请求
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?"+accessToken)
                .build();
        try{
            Response response = client.newCall(request).execute();
            String string=response.body().string();
System.out.println("++++"+string);
            //将String的类对象自动转化成java的类对象
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);

System.out.println(githubUser.getName());
            return  githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


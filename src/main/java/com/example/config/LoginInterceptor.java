package com.example.config;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre handler----------");

        /*if(request.getRequestURL().toString().indexOf("/miniapp")==-1){
            return true;
        }


        String ucode=request.getParameter("ucode");
        if(ucode==null || ucode.isEmpty()){
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String s = "";
                while ((s = br.readLine()) != null) sb.append(s);
                JSONObject jsonObj = JSONUtil.parseObj(sb.toString());
                request.setAttribute("POST",jsonObj);
                ucode = jsonObj.getStr("ucode");
            }catch (Exception e){

            }

            if(ucode==null || ucode.isEmpty()){
                ucode= IdUtil.randomUUID();
            }
        }

        String reqUrl=request.getRequestURL().toString();

        Map<String,Object> sessData=this.allDao.SelectOne("session",
                    "WHERE ucode='"+ucode+"'","");
        if(sessData==null || !JSONUtil.isTypeJSON(sessData.get("txt").toString())){
            Map<String,Object> mResp=new HashMap<>();
            mResp.put("code",501);    //未登录
            mResp.put("ucode",ucode);

            if(reqUrl.indexOf("/miniapp/user")!=-1){
                response.getOutputStream().write(JSONUtil.toJsonStr(mResp).getBytes("utf-8"));
                return false;
            }
        }else{
            JSONObject userData=JSONUtil.parseObj(sessData.get("txt").toString());
            request.setAttribute("user",userData);
        }*/

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post handler-------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after completion-------------");
    }
}

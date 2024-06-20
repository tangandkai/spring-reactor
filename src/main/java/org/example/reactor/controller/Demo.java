package org.example.reactor.controller;

import com.alibaba.fastjson2.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;


@Api
@RestController
@RequestMapping("/reactor_demo")
public class Demo {

    @ApiOperation("响应测试")
    @RequestMapping("/emitter")
    public SseEmitter see(@RequestBody JSONObject param, HttpServletResponse httpServletResponse){
        httpServletResponse.setContentType("text/event-stream");
        httpServletResponse.setCharacterEncoding("UTF-8");
        SseEmitter emitter = new SseEmitter();
        new Thread(()->{
            try {
                for (int i=0;i<10;i++){
                    String data = "data battch "+i+" for parameter "+param.toString();
                    emitter.send(data);
                    Thread.sleep(1000);
                }
                emitter.complete();
            }catch (Exception e){
                emitter.completeWithError(e);
            }
        }).start();
        return emitter;
    }
}

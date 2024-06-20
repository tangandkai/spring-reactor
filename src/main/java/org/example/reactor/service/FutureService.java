package org.example.reactor.service;

import lombok.extern.slf4j.Slf4j;
import org.example.reactor.vo.RespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@Slf4j
@Service
//@Scope(value = "prototype")
public class FutureService {

    @Autowired
    private FutureServiceA futureServiceA;
//    public FutureService(FutureServiceA futureServiceA){
//        this.futureServiceA = futureServiceA;
//    }

    public RespVO<String> getResult(String id,int timeout){
        log.info("任务开始执行，当前时间: [{}]，持续等待中", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        try {
            Thread.sleep(timeout);
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("任务执行完成，当前时间: [{}]，持续等待中", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return RespVO.success("task complete");
    }
}

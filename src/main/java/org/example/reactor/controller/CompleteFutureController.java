package org.example.reactor.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.reactor.service.FutureService;
import org.example.reactor.vo.RespVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.*;


@Slf4j
@RestController
@RequestMapping("/future")
public class CompleteFutureController {

    private static final ExecutorService taskService = new ThreadPoolExecutor(2,2,2, TimeUnit.SECONDS,new ArrayBlockingQueue<>(20));

    private FutureService futureService;
    public CompleteFutureController(FutureService futureService){
        this.futureService = futureService;
    }

    @RequestMapping("/query")
    public CompletableFuture<?> futureQuery(@RequestParam("timeout") int timeout){
        log.info("接收请求，开始处理，当前时间: [{}]", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        CompletableFuture<RespVO<String>> future = CompletableFuture.supplyAsync(() -> futureService.getResult(UUID.randomUUID().toString(), timeout), taskService);
        log.info("接收任务线程完成并退出，当前时间: [{}]",LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return future;
    }
}

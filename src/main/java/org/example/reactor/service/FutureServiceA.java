package org.example.reactor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Lazy
@Service
//@Scope(value = "prototype")
public class FutureServiceA {

    @Autowired
    private FutureService futureService;
//    public FutureServiceA(FutureService futureService){
//        this.futureService = futureService;
//    }
}

package org.example.reactor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespVO<T> implements Serializable {

    private String code;

    private String desc;

    private T data;


    public static <T>RespVO<T> success(T data){
        return new RespVO<>("200","success",data);
    }
}

package com.example.hanghaememo.dto;

import lombok.Getter;

@Getter
public class MemoRequestDto { // 서버가 클라이언트에게 요청한다.

    private String username;
    private String contents;

}

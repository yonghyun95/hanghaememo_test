package com.example.hanghaememo.controller;

import com.example.hanghaememo.dto.MemoRequestDto;
import com.example.hanghaememo.entity.Memo;
import com.example.hanghaememo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index"); // ModelAndView 안에 index.html으로 반환한다.
    }

    @PostMapping("/api/memos")  // 등록, 저장해주는 Post 방식
    public Memo createMemo(@RequestBody MemoRequestDto memoRequestDto){
        return memoService.createMemo(memoRequestDto);
    }
    @GetMapping("/api/memos") // 조회 해주는 get 방식
    public List<Memo> getMemo() {
        return memoService.getMemos();
    }
    @PutMapping("api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.update(id, requestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        return memoService.deleteMemo(id);
    }

}

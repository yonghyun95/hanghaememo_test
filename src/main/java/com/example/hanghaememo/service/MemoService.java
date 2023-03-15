package com.example.hanghaememo.service;

import com.example.hanghaememo.dto.MemoRequestDto;
import com.example.hanghaememo.entity.Memo;
import com.example.hanghaememo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Memo createMemo(MemoRequestDto memoRequestDto) {
        Memo memo = new Memo(memoRequestDto);
        memoRepository.save(memo);
        return memo;
    }

    @Transactional(readOnly = true) // 읽기만 가능하게 해주는 readOnly = true
    public List<Memo> getMemos() { // List 형식의 Memo로 조회하는 기능
        return memoRepository.findAllByOrderByModifiedAtDesc(); // findAll()이라는 함수는 Repo에서 Memo로 된 데이터를 가져온다.
    }

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) { // 수정하는 부분
        Memo memo = memoRepository.findById(id).orElseThrow(    // 수정한 메모에 id를 가져와서 실제 db에 수정할 메모가 있는지 확인 -> 오류가 발생하지 않으면 수정할 메모가 있다.
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.upadate(requestDto);
        return memo.getId();
    }

    @Transactional
    public Long deleteMemo(Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}

package com.example.hanghaememo.repository;

import com.example.hanghaememo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    List<Memo> findAllByOrderByModifiedAtDesc(); // 수정된 시간이 가장 최근으로 볼 수 있는 기능!!
}

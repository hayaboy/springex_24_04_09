package com.green.springex.mapper;

import com.green.springex.domain.TodoVO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    //글 삽입
    void insert(TodoVO todoVO);


    //모든 글 조회
    List<TodoVO> selectAll();

    //글 조회
    TodoVO selectOne(Long tno);


    //글 수정
    void update(TodoVO todoVO);

    //글 삭제
    void delete(TodoVO todoVO);
}

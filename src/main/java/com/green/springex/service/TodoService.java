package com.green.springex.service;

import com.green.springex.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);
    List<TodoDTO> getAll();

    TodoDTO getOne(Long tno);

    // 수정
    void modify(TodoDTO todoDTO);

    // 삭제
    void delete(TodoDTO todoDTO);



}

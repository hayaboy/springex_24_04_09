package com.green.springex.service;

import com.green.springex.domain.TodoVO;
import com.green.springex.dto.TodoDTO;
import com.green.springex.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoMapper todoMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info("modelMapper : " + modelMapper);

        TodoVO todoVO=modelMapper.map(todoDTO, TodoVO.class);
        log.info("todoVO"+todoVO);

        todoMapper.insert(todoVO);
    }

    @Override
    public List<TodoDTO> getAll() {


        List<TodoDTO> dtoList =todoMapper.selectAll().stream()
                .map((vo)->{return modelMapper.map(vo,TodoDTO.class);})
                .collect(Collectors.toList());


        return dtoList;
    }
}

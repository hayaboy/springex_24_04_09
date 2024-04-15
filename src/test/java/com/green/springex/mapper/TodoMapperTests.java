package com.green.springex.mapper;

import com.green.springex.domain.TodoVO;
import com.green.springex.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {


    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTime(){
        log.info("현재 시간 : " + todoMapper.getTime());
    };


    @Test
    public void testInsert(){
        TodoVO todoVO=TodoVO.builder().title("스프링테스트1")
                .dueDate(LocalDate.of(2024,04,17)).writer("user00").build();
        todoMapper.insert(todoVO);
    };

    @Test
    public void testSelectAll() {
        List<TodoVO> voList =todoMapper.selectAll();

        voList.forEach((vo)->{log.info(vo);});
    }


    @Test
    public void testSelectOne() {
        TodoVO todoVO =todoMapper.selectOne(5L);

        log.info(todoVO);
    }
}

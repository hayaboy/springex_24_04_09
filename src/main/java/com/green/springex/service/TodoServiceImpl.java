package com.green.springex.service;

import com.green.springex.domain.TodoVO;
import com.green.springex.dto.PageRequestDTO;
import com.green.springex.dto.PageResponseDTO;
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

    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO todoVO=todoMapper.selectOne(tno);

        TodoDTO todoDTO=  modelMapper.map(todoVO, TodoDTO.class);

        return todoDTO;
    }

    //글 수정
    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO=modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.update(todoVO);
    }


    //글 삭제
    @Override
    public void delete(TodoDTO todoDTO) {
        TodoVO todoVO=modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.delete(todoVO);
    }

    //페이징 처리
    @Override
    public PageResponseDTO<TodoDTO> getPagingList(PageRequestDTO pageRequestDTO) {

        List<TodoVO> voList= todoMapper.selectPagingList(pageRequestDTO);

        log.info("voList : " + voList);
        List<TodoDTO> dtoList=voList.stream().map((vo)->modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());

        log.info("dtoList : " + dtoList);
        int total=todoMapper.getCount(pageRequestDTO);
        log.info("total : " + total);

        log.info("page :" + pageRequestDTO.getPage());




        PageResponseDTO<TodoDTO> pageResponseDTO=PageResponseDTO.<TodoDTO>myMethod()
                .dtoList(dtoList).total(total).pageRequestDTO(pageRequestDTO).build();

        log.info("조회 결과의 마지막 번호 end : " + pageResponseDTO.getEnd() );

        log.info("조회 결과의 시작 번호 start : " + pageResponseDTO.getStart() );

        log.info("마지막 페이지 last : " + (int)(Math.ceil((total/(double)10))) + "페이지");

        // 10 > 103  false 이므로 end는 10, 반대인 경우는 last(103)
        log.info("end 점검");
        log.info(pageResponseDTO.getEnd() > (int)(Math.ceil((total/(double)10))) ? (int)(Math.ceil((total/(double)10))): pageResponseDTO.getEnd());
        log.info("최종 end : " + pageResponseDTO.getEnd());

        log.info("prev 버튼 여부 " + (pageResponseDTO.getStart() > 1) );

        log.info("next 버튼 여부 " + (total >  pageResponseDTO.getEnd() * 10 ));
        return pageResponseDTO;
    }


}

package com.green.springex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> { // 게시판이나 회원 정보 등도 페이징 처리가 필요할 수 있기 때문에 공통적인 처리를 위해서 제너릭으로 구성
    private int page;
    private int size;
    private int total;

    //시작  번호
    private int start;
    //끝  번호
    private int end;

    //이전 페이지의 존재 여부
    private boolean prev;
    //다음 페이지의 존재 여부
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "myMethod") //빌더 메서드의 이름을 사용자가 지정할 때 사용
    PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){
        this.page=pageRequestDTO.getPage();
        this.size=pageRequestDTO.getSize();
        this.total=total;
        this.dtoList= dtoList;

        //결과의 마지막 번호
        this.end=(int)(Math.ceil(this.page / 10.0 )) *  10;

        //시작  번호
        this.start = this.end - 9;


        //마직막 페이지
        int last =  (int)(Math.ceil((total/(double)size)));

        this.end =  end > last ? last: end;

        //이전 페이지 존재 여부
        this.prev = this.start > 1;

        //다음 페이지 존재 여부(마지막 페이지와 페이지당 개수를 곱한 값보다 전체 개수가 더 많은지 보고 판단)
        this.next =  total > this.end * this.size;



    }


}

package com.green.springex.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    public int getSkip(){
        return (page-1)*10;
    }




    // 글 조회 후 해당 글이 있는 위치를 문자열로 저장
    private String link;
    public String getLink() {
        if(link == null){
            StringBuilder builder = new StringBuilder();

            builder.append("page=" + this.page);

            builder.append("&size=" + this.size);
            link = builder.toString();
        }
        return link;
    }


    @Override
    public String toString() {
        return "PageRequestDTO{" +
                "page=" + page +
                ", size=" + size +", "+"skip="+getSkip()+
                '}';
    }
}

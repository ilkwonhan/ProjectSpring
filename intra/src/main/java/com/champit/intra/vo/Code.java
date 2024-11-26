package com.champit.intra.vo;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Alias("code")
@Getter
@Setter
public class Code {

    private String code1;       //대분류
    private String code2;       //소분류
    private String code_name;   //코드명
    private String memo;        //내용
    private String memo2;       //메모


    private Company company;    //sql Join 선언


}

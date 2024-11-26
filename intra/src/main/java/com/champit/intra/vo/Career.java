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
@Alias("career")
@Getter
@Setter
public class Career {

    private String  emp_no;                  //사원번호
    private int     out_com_yy;              //사외경력전산년
    private int     out_com_mm;              //사외경력전산월
    private int     out_etc_yy;              //사외경력비전산년
    private int     out_etc_mm;              //사외경력비전산월
    private String  school_cd;               //학력코드
    private String  license_cd;              //자격증코드
    private String  military_cd;             //병역코드
    private String  promotion_ym;            //최종진급년월
    private String  schedule_ym;             //승진예정년월



}

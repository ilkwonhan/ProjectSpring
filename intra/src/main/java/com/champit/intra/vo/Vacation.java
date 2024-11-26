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
@Alias("vacation")
@Getter
@Setter
public class Vacation {

    private String emp_no;                 //사원번호
    private String year;                   //년도
    private int    seq;                    //일련번호
    private String vac_d;                  //휴가일자
    private String vac_c;                  //휴가코드
    private String resnon;                 //사유
    private String acpt_nm;                //인수자
    private String auth_emp_no;            //승인자사번
    private String auth_d;                 //승인일
    private String auth_c;                 //승인코드
    private String auth_memo;              //승인메모
    private String prjt_id;                //프로젝트ID



}

package com.champit.intra.entity;

import java.io.Serializable;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vacation")
public class Vacation implements Serializable {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_no")
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

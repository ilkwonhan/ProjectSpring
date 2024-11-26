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
@Alias("company")
@Getter
@Setter
public class Company {

    private String emp_no;         //사원번호
    private String login_id;       //ID
    private String login_pw;       //비밀번호
    private String name;           //성명
    private String rank_c;         //직급
    private String in_d;           //입사일
    private String out_d;          //퇴사일
    private String prjt_id;        //프로젝트코드
    private String emp_c;          //직원코드
    private String photo_id;       //사진
    private String aut_c;          //권한코드
    private String ucamp;          //UCAMP기수
    private String depart_cd;      //부서코드
    private String ssn;            //주민번호암호화
    private String sex_cd;         //성별코드
    private String snh_in_d;       //snh입사일자
    private String memo;           //메모
    private String payment_date;   //급여지급일


}

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
@Alias("emp")
@Getter
@Setter
public class Emp {
    private String emp_no;      //사원번호
    private String bth_d;       //생일
    private String bth_c;       //생일구분
    private String hm_phn_1;    //자택전화1
    private String hm_phn_2;    //자택전화2
    private String hm_phn_3;    //자택전화3
    private String mb_phn_1;    //핸드폰1
    private String mb_phn_2;    //핸드폰2
    private String mb_phn_3;    //핸드폰3
    private String off_phn_1;   //직장전화1
    private String off_phn_2;   //직장전화2
    private String off_phn_3;   //직장전화3
    private String hm_adr_1;    //자택주소1
    private String hm_adr_2;    //자택주소2
    private String email;       //이메일
    private String hm_zip;      //우편번호
    private String em_phn_1;    //긴급전화번호1
    private String em_phn_2;    //긴급전화번호2
    private String em_phn_3;    //긴급전화번호3

    private String prjt_nm;     //프로젝트명
    private String rank_nm;     //직급
    private String hm_phn;      //자택전화
    private String mb_phn;      //핸드폰
    private String emp_nm;      //직원구분
    private String aut_nm;      //권한

    
    private String max_emp_no_m;    //권한
    private String max_emp_no_f;    //권한

    
    private Company company;    //sql Join 선언
    private Career  career;     //sql Join 선언

}

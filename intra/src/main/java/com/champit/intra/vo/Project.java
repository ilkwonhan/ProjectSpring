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
@Alias("project")
@Getter
@Setter
public class Project {

    private String prjt_id;            //프로젝트ID
    private String prjt_nm;            //프로젝트명
    private String srt_d;              //시작일
    private String end_d;              //종료일
    private String cus_nm;             //고객사명
    private String machin;             //기종
    private String lang;               //언어
    private String tool;               //툴



}

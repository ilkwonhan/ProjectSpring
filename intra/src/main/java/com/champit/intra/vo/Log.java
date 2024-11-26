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
@Alias("log")
@Getter
@Setter
public class Log {

    //BatchJob Log VO
    private String job_instance_id;     //jobId
    private String job_name;            //jobName
    private String create_time;         //jobCreateTime
    private String start_time;          //jobStartTime
    private String end_time;            //jobEndTime
    private String status;              //jobStatus
    private String exit_code;           //jobExitCode
    private String last_updated;        //jobReturnTime

}

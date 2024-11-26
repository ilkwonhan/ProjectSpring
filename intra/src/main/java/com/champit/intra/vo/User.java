package com.champit.intra.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {
	private String username;
	private String default_tablespace;
	private String account_status;
}
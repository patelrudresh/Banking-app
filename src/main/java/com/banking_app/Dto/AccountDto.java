package com.banking_app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class AccountDto {
	
	private Long id;
	private String account_holderName;
	private Double balance;

}

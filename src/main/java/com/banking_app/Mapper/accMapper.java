package com.banking_app.Mapper;

import com.banking_app.Dto.AccountDto;
import com.banking_app.entity.Account;

public class accMapper {

	public static Account maptoAccount(AccountDto accDto) {
		Account acc = new Account(

				accDto.getId(), accDto.getAccount_holderName(), accDto.getBalance());
		return acc;
	}

	public static AccountDto maptoaccountDto(Account account) {
		AccountDto accountt = new AccountDto(account.getId(), account.getAccount_holderName(), account.getBalance());
		return accountt;
	}
}

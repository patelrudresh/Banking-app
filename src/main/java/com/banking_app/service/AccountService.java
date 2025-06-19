package com.banking_app.service;

import java.util.List;

import com.banking_app.Dto.AccountDto;

public interface AccountService {
	public AccountDto CreateAcc(AccountDto account);
	public AccountDto getaccById(Long accid);
	public AccountDto deposit(Long Id,double deposit);
	public AccountDto withdraw(Long Id,double withdraw);
	public List<AccountDto> getAllAccount();
	public void deleteAccount(Long Id);

}

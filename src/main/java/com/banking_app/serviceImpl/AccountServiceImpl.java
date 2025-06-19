package com.banking_app.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.banking_app.Dto.AccountDto;
import com.banking_app.Mapper.accMapper;
import com.banking_app.Repository.AccountRepository;
import com.banking_app.entity.Account;
import com.banking_app.exception.ResourceNotFoundExceptoin;
import com.banking_app.service.AccountService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;

	@Override
	public AccountDto CreateAcc(AccountDto accountdto) {

		Account acc = accMapper.maptoAccount(accountdto);
		Account saved = accountRepository.save(acc);
		return accMapper.maptoaccountDto(saved);
	}

	@Override
	public AccountDto getaccById(Long accId) {
		Account accountfind = accountRepository.findById(accId)
				.orElseThrow(() -> new ResourceNotFoundExceptoin("account not found" + accId));
		return accMapper.maptoaccountDto(accountfind);
	}

	@Override
	public AccountDto deposit(Long Id, double amount) {
		Account account = accountRepository.findById(Id)
				.orElseThrow(() -> new RuntimeException("Account does not exits"));
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return accMapper.maptoaccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Long Id, double amount) {

		Account account = accountRepository.findById(Id)
				.orElseThrow(() -> new RuntimeException("account does not exits"));
		if (account.getBalance() < amount) {
			throw new RuntimeException("insufficent balance");
		}
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account totalamount = accountRepository.save(account);
		return accMapper.maptoaccountDto(totalamount);
	}

	@Override
	public List<AccountDto> getAllAccount() {
	List<Account >totalaccount=	accountRepository.findAll();
	return totalaccount.stream().map((user)->accMapper.maptoaccountDto(user)).collect(Collectors.toList());
		 
	}
	
	@Override
	public void deleteAccount(Long Id) {
		Account account=accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("account does not exits"));	
		 accountRepository.delete(account);
	}

}

package com.banking_app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking_app.Dto.AccountDto;
import com.banking_app.serviceImpl.AccountServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/acc")
public class AccountController {

	private AccountServiceImpl accountServiceImpl;

	@PostMapping
	public ResponseEntity<AccountDto> createAcc(@RequestBody AccountDto AccDto) {
		return new ResponseEntity<>(accountServiceImpl.CreateAcc(AccDto), HttpStatus.CREATED);
	}
	  
	@GetMapping("{id}")
	public ResponseEntity<AccountDto> getaccById(@PathVariable ("id") Long accid){
		AccountDto accbyid=accountServiceImpl.getaccById(accid);
		return ResponseEntity.ok(accbyid);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposite(@PathVariable("id") Long id , @RequestBody Map<String, Double> request){
		double amount=request.get("amount");
	AccountDto accountdto=		accountServiceImpl.deposit(id,amount );
	return ResponseEntity.ok(accountdto);
	}
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdrawamount(@PathVariable("id") Long accId ,@RequestBody Map<String , Double> request){
		double Amount=request.get("amount");
		AccountDto accountdto=accountServiceImpl.withdraw(accId, Amount);
		return ResponseEntity.ok(accountdto);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<AccountDto>> getallAcc(){
		        return ResponseEntity.ok(accountServiceImpl.getAllAccount());
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAcc(@PathVariable("id") Long accId) {
		accountServiceImpl.deleteAccount(accId);
		return ResponseEntity.ok("account has been deleted");
	}
}

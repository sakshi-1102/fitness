package com.fitness.fitness_freak.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.fitness_freak.exception.ResourceNotFoundException;
import com.fitness.fitness_freak.model.Member;
import com.fitness.fitness_freak.repository.MemberRepository;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/")
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;
	
	// get all member
	@GetMapping("/members")
	public List<Member> getAllMembers(){
		return memberRepository.findAll();
	}		
	
	// create member rest api
	@PostMapping("/members")
	public Member createMember(@RequestBody Member member) {
		return memberRepository.save(member);
	}
	
	// get member by id rest api
	@GetMapping("/members/{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
		Member member = memberRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Member not exist with id :" + id));
		return ResponseEntity.ok(member);
	}
	
	// update member rest api
	
	@PutMapping("/members/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member memberDetails){
		Member member = memberRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Member not exist with id :" + id));
		
		member.setFullName(memberDetails.getFullName());
		member.setContactDetails(memberDetails.getContactDetails());
		member.setMembershipType(memberDetails.getMembershipType());
		member.setPaymentHistory(memberDetails.getPaymentHistory());
		
		Member updatedMember = memberRepository.save(member);
		return ResponseEntity.ok(updatedMember);
	}
	
	// delete Member rest api
	@DeleteMapping("/members/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMember(@PathVariable Long id){
		Member member = memberRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Member not exist with id :" + id));
		
		memberRepository.delete(member);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
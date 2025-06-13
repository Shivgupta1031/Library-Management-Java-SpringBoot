package com.kiet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kiet.model.Member;
import com.kiet.repository.MemberRepository;

@Service
public class MemberService {

	private MemberRepository repository;

	public MemberService(MemberRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Member> retrieveAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Member retrieveById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
	
	public List<Member> retrieveActiveMembers(boolean active) {
	    return repository.findByActive(active);
	}

	public Member addMember(Member member) {
		// TODO Auto-generated method stub
		return repository.save(member);
	}

	public void removebyid(int id) {
		// TODO Auto-generated method stub
		 repository.deleteById(id);
	}
	

}

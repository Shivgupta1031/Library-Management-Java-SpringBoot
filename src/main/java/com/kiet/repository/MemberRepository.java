package com.kiet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiet.model.Member;

@Repository
public interface MemberRepository  extends JpaRepository<Member,Integer>{

    List<Member> findByActive(boolean active);

}

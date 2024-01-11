package com.fitness.fitness_freak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitness.fitness_freak.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}

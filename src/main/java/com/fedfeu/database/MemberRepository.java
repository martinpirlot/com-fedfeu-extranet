package com.fedfeu.database;

import org.springframework.data.repository.CrudRepository;

import com.fedfeu.beans.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {
}

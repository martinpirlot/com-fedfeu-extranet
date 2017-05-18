package com.fedfeu.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fedfeu.beans.Result;

public interface ResultRepository extends CrudRepository<Result, Long> {
	List<Result> findByMemberId(Long memberId);
	
	List<Result> findByMemberIdAndDisciplineId(Long memberId, Long disciplineId);
	
	List<Result> findByMemberIdAndDisciplineIdAndCupId(Long memberId, Long disciplineId, Long cupId);
	
	List<Result> findByMemberIdAndCupId(Long memberId, Long cupId);
	
	List<Result> findByDisciplineIdAndCupId(Long disciplineId, Long cupId);
}

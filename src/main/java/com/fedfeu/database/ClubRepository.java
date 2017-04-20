package com.fedfeu.database;

import org.springframework.data.repository.CrudRepository;

import com.fedfeu.beans.Club;

public interface ClubRepository extends CrudRepository<Club, Long> {
}

package com.fedfeu.database;

import org.springframework.data.repository.CrudRepository;

import com.fedfeu.beans.Cup;

public interface CupRepository extends CrudRepository<Cup, Long> {
}

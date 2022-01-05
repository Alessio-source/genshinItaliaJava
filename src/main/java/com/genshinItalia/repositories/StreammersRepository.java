package com.genshinItalia.repositories;

import com.genshinItalia.entity.Streammer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreammersRepository extends JpaRepository<Streammer, Integer> {
}

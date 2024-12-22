package com.example.roommaintennance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.roommaintennance.model.KathaBook;

@Repository
public interface KathaBookRepository extends JpaRepository<KathaBook,Long>{

}

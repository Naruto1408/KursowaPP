package com.nulp.repository;

import com.nulp.gemstone.Gemstone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GemstoneRepository extends MongoRepository<Gemstone, String> {
}

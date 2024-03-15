package com.example.awssqs.repository;

import com.example.awssqs.entity.Recipient;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface RecipientRepository extends R2dbcRepository<Recipient, String> {
}

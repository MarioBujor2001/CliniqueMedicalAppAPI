package com.example.medicalappapi.repositories;

import com.example.medicalappapi.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo<T extends Person> extends CrudRepository<T, String> {
}

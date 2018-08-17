package com.example.springtutorial;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RepositorioAvaliacao extends CrudRepository<Avaliacao, Long> {
}

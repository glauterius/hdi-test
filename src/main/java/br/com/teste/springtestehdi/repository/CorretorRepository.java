package br.com.teste.springtestehdi.repository;

import br.com.teste.springtestehdi.model.CorretorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorretorRepository extends CrudRepository<CorretorModel, Long> {

}

package br.com.hadryan.sales.repository;

import br.com.hadryan.sales.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}

package br.com.hadryan.sales.mapper;

import br.com.hadryan.sales.dto.SaleDTO;
import br.com.hadryan.sales.model.Sale;
import org.mapstruct.Mapper;

@Mapper
public interface SaleMapper {

    SaleDTO toDTO(Sale sale);

    Sale toEntity(SaleDTO saleDTO);

}

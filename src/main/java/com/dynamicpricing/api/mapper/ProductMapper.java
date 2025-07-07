package com.dynamicpricing.api.mapper;

import com.dynamicpricing.api.dto.ProductDTO;
import com.dynamicpricing.api.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO productToProductDTO(Product product);
}

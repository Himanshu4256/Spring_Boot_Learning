package com.example.mapStruct.mapper;

import com.example.mapStruct.dto.ProductDto;
import com.example.mapStruct.entity.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-15T16:55:35+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto modelToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setDescription( product.getDesc() );
        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setPrice( product.getPrice() );
        productDto.setQuantity( product.getQuantity() );

        productDto.setItemId( UUID.randomUUID().toString() );

        return productDto;
    }

    @Override
    public List<ProductDto> modelsToDtos(List<Product> product) {
        if ( product == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( product.size() );
        for ( Product product1 : product ) {
            list.add( modelToDto( product1 ) );
        }

        return list;
    }

    @Override
    public Product dtoToModel(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setDesc( productDto.getDescription() );
        product.setId( productDto.getId() );
        product.setItemId( productDto.getItemId() );
        product.setName( productDto.getName() );
        product.setPrice( productDto.getPrice() );
        product.setQuantity( productDto.getQuantity() );

        return product;
    }
}

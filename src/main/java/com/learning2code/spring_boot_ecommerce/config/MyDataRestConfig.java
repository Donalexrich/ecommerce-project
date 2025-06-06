package com.learning2code.spring_boot_ecommerce.config;

import com.learning2code.spring_boot_ecommerce.Entity.Product;
import com.learning2code.spring_boot_ecommerce.Entity.ProductCategory;
import org.hibernate.metamodel.model.domain.DomainType;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[ ] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        //disable HTTP Methods for Product: Put, Post and Delete
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) ->  httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure(((metdata, httpMethods) ->  httpMethods.disable(theUnsupportedActions)));

        //disable HTTP Methods for Product Category: Put, Post and Delete
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) ->  httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure(((metdata, httpMethods) ->  httpMethods.disable(theUnsupportedActions)));
    }
}

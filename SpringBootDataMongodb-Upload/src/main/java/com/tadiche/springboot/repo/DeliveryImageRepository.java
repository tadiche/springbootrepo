package com.tadiche.springboot.repo;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tadiche.springboot.model.ImageModel;

public interface DeliveryImageRepository extends MongoRepository<ImageModel, Long>{
    Optional<ImageModel> findByBarcode(String barcode);
}

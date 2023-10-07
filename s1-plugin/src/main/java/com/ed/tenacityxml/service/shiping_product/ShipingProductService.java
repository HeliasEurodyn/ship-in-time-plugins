package com.ed.tenacityxml.service.shiping_product;

import com.ed.tenacityxml.dto.shiping_product.ShipingProductDTO;
import com.ed.tenacityxml.dto.user.SoftoneUserDTO;
import com.ed.tenacityxml.repository.shiping_product.ShipingProductRepository;
import com.ed.tenacityxml.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShipingProductService {

    private final ShipingProductRepository shipingProductRepository;

    public ShipingProductService(ShipingProductRepository shipingProductRepository) {
        this.shipingProductRepository = shipingProductRepository;
    }

    public void registerNewShipingProduct(ShipingProductDTO shipingProductDTO) {
        this.shipingProductRepository.registerNew(shipingProductDTO);
    }

    public Map<String, String> getIdByS1Id(String s1id) {
        String id = this.shipingProductRepository.getIdByS1Id(s1id);
       return Collections.singletonMap("id",id);
    }
}

package com.ed.tenacityxml.controller.shiping_product;

import com.ed.tenacityxml.dto.shiping_product.ShipingProductDTO;
import com.ed.tenacityxml.dto.user.SoftoneUserDTO;
import com.ed.tenacityxml.service.shiping_product.ShipingProductService;
import com.ed.tenacityxml.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@Validated
@RequestMapping("/s1-shiping-product")
public class ShipingProductController {

    @Autowired
    ShipingProductService shipingProductService;

    @PostMapping(path="/register")
    public void post(
            @RequestBody ShipingProductDTO shipingProductDTO)  {
        this.shipingProductService.registerNewShipingProduct(shipingProductDTO);
    }

    @GetMapping(path="/get-id-by-s1-id")
    public Map<String, String> post(@RequestParam("id") String id)  {
        return this.shipingProductService.getIdByS1Id(id);
    }

}

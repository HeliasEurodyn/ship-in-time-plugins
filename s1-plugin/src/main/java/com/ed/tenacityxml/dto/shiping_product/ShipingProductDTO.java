package com.ed.tenacityxml.dto.shiping_product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
@Builder
public class ShipingProductDTO {
    private String id;
    private String qty;
    private Instant trndate;
    private String from;
    private String to;
    private String truck;
    private List<RouteDTO> routes;
}

package com.ed.tenacityxml.repository.shiping_product;

import com.ed.tenacityxml.dto.shiping_product.RouteDTO;
import com.ed.tenacityxml.dto.shiping_product.ShipingProductDTO;
import com.ed.tenacityxml.dto.user.SoftoneUserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipingProductRepository {

    private final EntityManager entityManager;
    private final PlatformTransactionManager transactionManager;
    private final PasswordEncoder passwordEncoder;
    private final TransactionTemplate transactionTemplate;

    public ShipingProductRepository(EntityManager entityManager,
                                    PlatformTransactionManager transactionManager,
                                    PasswordEncoder passwordEncoder,
                                    TransactionTemplate transactionTemplate) {
        this.entityManager = entityManager;
        this.transactionManager = transactionManager;
        this.passwordEncoder = passwordEncoder;
        this.transactionTemplate = transactionTemplate;
    }

    public void registerNew(ShipingProductDTO shipingProductDTO) {
        Boolean exists = this.checkExistance(shipingProductDTO.getId());
        if (exists) {
            return;
        }

        this.save(shipingProductDTO);
    }



    public Boolean checkExistance(String id) {
        Query query = this.entityManager.createNativeQuery("SELECT * FROM shiping_product WHERE s1_id = :id ");
        query.setParameter("id", id);
        List<Object[]> results = query.getResultList();

        return results.size() > 0;
    }

    public void save(ShipingProductDTO shipingProductDTO) {

        String spQueryString =
                " INSERT INTO shiping_product " +
                "(" +
                "s1_id, " +
                "created_by, " +
                "created_on, " +
                "modified_by, " +
                "modified_on, " +
                "shiping_date, " +
                "status, " +
                "quantity, " +
                "mu, " +
                "message, " +
                "from_area_id, " +
                "to_area_id," +
                "truck_type_id" +
                ") VALUES  " + "(" +
                ":id, " +
                "'s1', " +
                "CURRENT_TIMESTAMP, " +
                "'s1', " +
                "CURRENT_TIMESTAMP, " +
                ":shiping_date, " +
                "'active', " +
                ":quantity, " +
                "'tone', " +
                "'', " +
                "(SELECT id FROM municipality WHERE postcode = :from_area_id LIMIT 1), " +
                "(SELECT id FROM municipality WHERE postcode = :to_area_id LIMIT 1) ," +
                ":truck " +
                ");  ";

        Query spQuery = entityManager.createNativeQuery(spQueryString);
        spQuery.setParameter("id", shipingProductDTO.getId());
        spQuery.setParameter("shiping_date", shipingProductDTO.getTrndate());
        spQuery.setParameter("quantity", shipingProductDTO.getQty());
        spQuery.setParameter("from_area_id", shipingProductDTO.getFrom());
        spQuery.setParameter("to_area_id", shipingProductDTO.getTo());
        spQuery.setParameter("truck",shipingProductDTO.getTruck().equals("")?null:shipingProductDTO.getTruck());

        transactionTemplate.execute(transactionStatus -> {
            spQuery.executeUpdate();

            Object id = entityManager.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult();

            int order = 0;
            for(RouteDTO route: shipingProductDTO.getRoutes()) {
                String sprQueryString =
                        " INSERT INTO shiping_product_route " +
                                "(" +
                                "area_id, " +
                                "short_order, " +
                                "shiping_product_id " +
                                ") VALUES  " +
                                "(" +
                                "(SELECT id FROM municipality WHERE postcode = :to LIMIT 1), " +
                                ":order, " +
                                ":shiping_product_id " +
                                ");  ";
                Query sprQuery = entityManager.createNativeQuery(sprQueryString);
                sprQuery.setParameter("to", route.getTo());
                sprQuery.setParameter("order", order);
                sprQuery.setParameter("shiping_product_id", id);
                sprQuery.executeUpdate();

                order ++;
            }

            transactionStatus.flush();
            return null;
        });
    }

    public String getIdByS1Id(String s1id) {
        Query query = this.entityManager.createNativeQuery("SELECT id FROM shiping_product WHERE s1_id = :s1id ");
        query.setParameter("s1id", s1id);
        List<Object> results = query.getResultList();

        if (results.size() == 0){
            return "";
        } else {
            return results.get(0).toString();
        }
    }

}

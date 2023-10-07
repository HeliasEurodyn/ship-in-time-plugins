package com.ed.tenacityxml.repository;

import com.ed.tenacityxml.model.pnr.IataPnrgovNotifRq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IataPnrgovNotifRqRepository  extends JpaRepository<IataPnrgovNotifRq,Long> {
}

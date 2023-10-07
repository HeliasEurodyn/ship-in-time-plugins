package com.ed.tenacityxml.repository;

import com.ed.tenacityxml.model.file.XmlFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XmlFileRepository extends JpaRepository<XmlFile, Long> {
}

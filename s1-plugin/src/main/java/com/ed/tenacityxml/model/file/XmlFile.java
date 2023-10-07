package com.ed.tenacityxml.model.file;

import com.ed.tenacityxml.model.pnr.IataPnrgovNotifRq;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity(name = "xmlFile")
@Table(name = "xml_file")
public class XmlFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_data", columnDefinition = "MEDIUMTEXT")
    private String fileData;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_size")
    private String fileSize;

    @Column(name = "file_type")
    private String fileType;

    @CreatedDate
    @Column(name = "created_on", updatable = false, nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant createdOn;

    @LastModifiedDate
    @Column(name = "modified_on", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant modifiedOn;

    @Column(name = "created_by", columnDefinition = "VARCHAR(36)")
    private String createdBy;

    @Column(name = "modified_by", columnDefinition = "VARCHAR(36)")
    private String modifiedBy;

    @Column(name = "iata_pnrgov_notif_rq_id")
    private Long iataPnrgovNotifRqId;

//    @OneToOne
//    @JoinColumn(name = "iata_pnrgov_notif_rq_id")
//    private IataPnrgovNotifRq iataPnrgovNotifRq;

}


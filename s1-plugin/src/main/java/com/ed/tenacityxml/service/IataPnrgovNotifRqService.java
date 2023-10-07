package com.ed.tenacityxml.service;

import com.ed.tenacityxml.dto.pnr.IataPnrgovNotifRqDTO;
import com.ed.tenacityxml.dto.user.UserDTO;
import com.ed.tenacityxml.controller.user.mapper.IataPnrgovNotifRqMapper;
import com.ed.tenacityxml.model.file.XmlFile;
import com.ed.tenacityxml.model.pnr.IataPnrgovNotifRq;
import com.ed.tenacityxml.repository.IataPnrgovNotifRqRepository;
import com.ed.tenacityxml.repository.XmlFileRepository;
import com.ed.tenacityxml.rest_template.UserRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
public class IataPnrgovNotifRqService {

    @Autowired
    private IataPnrgovNotifRqRepository iataPnrgovNotifRqRepository;

    @Autowired
    private IataPnrgovNotifRqMapper iataPnrgovNotifRqMapper;

    @Autowired
    private UserRestTemplate userRestTemplate;
    @Autowired
    private XmlFileRepository xmlFileRepository;

    public List<IataPnrgovNotifRqDTO> getObject() {
        List<IataPnrgovNotifRq> entities = iataPnrgovNotifRqRepository.findAll();
        //return iataPnrgovNotifRqMapper.map(entities);
        return null;
    }

    public IataPnrgovNotifRqDTO getObject(Long id) {
        IataPnrgovNotifRq entity = iataPnrgovNotifRqRepository.findById(id).orElseThrow(() -> new NullPointerException("Calendar Does Not Exist"));
        IataPnrgovNotifRqDTO dto = iataPnrgovNotifRqMapper.mapEntity(entity);

        return dto;
    }

    @Transactional
    public Long postFile(Map<String, Map<String, Object>> parameters, Map<String, String> headers) throws JAXBException {

        Map<String, Object> iataPnrgovNotifRq = parameters.get("iata_pnrgov_notif_rq");
        Map<String, Object> subEntities = (Map<String, Object>) iataPnrgovNotifRq.get("sub-entities");
        Map<String, Object> xmlFile = (Map<String, Object>) subEntities.get("xml_file");
        String dataStream = (String) xmlFile.get("file_data");
        String fileName = (String) xmlFile.get("file_name");
        String fileSize = String.valueOf(xmlFile.get("file_size"));
        String fileType = (String) xmlFile.get("file_type");

        String[] dataStreamArray = dataStream.split(",");
        String base64FileData = dataStreamArray[1];
        byte[] fileDataBytes = Base64.getDecoder().decode(base64FileData);
        String xmlRequest = new String(fileDataBytes);

        Long createdIataPnrgovNotifRqId = this.postObject(xmlRequest, headers);

        XmlFile xmlFileObj = new XmlFile();
        xmlFileObj.setFileData(dataStream);
        xmlFileObj.setFileName(fileName);
        xmlFileObj.setFileSize(fileSize);
        xmlFileObj.setFileType(fileType);
        xmlFileObj.setIataPnrgovNotifRqId(createdIataPnrgovNotifRqId);
        xmlFileRepository.save(xmlFileObj);

        return createdIataPnrgovNotifRqId;
    }



    @Transactional
    public Long postObject(String xmlRequest, Map<String, String> headers) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(IataPnrgovNotifRqDTO.class);
        IataPnrgovNotifRqDTO iataPnrgovNotifRqDTO = context.createUnmarshaller()
                .unmarshal(new StreamSource(new StringReader(xmlRequest)), IataPnrgovNotifRqDTO.class).getValue();

        IataPnrgovNotifRq iataPnrgovNotifRq = iataPnrgovNotifRqMapper.map(iataPnrgovNotifRqDTO);

        UserDTO userDTO = userRestTemplate.getCurrentUser(headers);

        iataPnrgovNotifRq.setCreatedOn(Instant.now());
        iataPnrgovNotifRq.setCreatedBy(userDTO.getId());
        iataPnrgovNotifRq.setModifiedOn(Instant.now());
        iataPnrgovNotifRq.setModifiedBy(userDTO.getId());

        //FlightLeg flightLeg = iataPnrgovNotifRq.getFlightLeg();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXXX");
        Instant departureDateTime = null;
        Instant arrivalDateTime = null;

        if (iataPnrgovNotifRq.getFlightLegDepartureDateTimeStr() == null || iataPnrgovNotifRq.getFlightLegDepartureDateTimeStr() == "") {
            departureDateTime = null;
        } else {
            departureDateTime = Instant.from(formatter.parse(iataPnrgovNotifRq.getFlightLegDepartureDateTimeStr()));
        }

        if (iataPnrgovNotifRq.getFlightLegArrivalDateTimeStr() == null || iataPnrgovNotifRq.getFlightLegArrivalDateTimeStr() == "") {
            arrivalDateTime = null;
        } else {
            arrivalDateTime = Instant.from(formatter.parse(iataPnrgovNotifRq.getFlightLegArrivalDateTimeStr()));
        }

        iataPnrgovNotifRq.setFlightLegDepartureDateTime(departureDateTime);
        iataPnrgovNotifRq.setFlightLegArrivalDateTime(arrivalDateTime);

        IataPnrgovNotifRq createdIataPnrgovNotifRq = this.iataPnrgovNotifRqRepository.save(iataPnrgovNotifRq);
        return createdIataPnrgovNotifRq.getId();
    }

}

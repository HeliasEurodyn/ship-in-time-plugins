package com.ed.tenacityxml.controller;

import com.ed.tenacityxml.dto.pnr.IataPnrgovNotifRqDTO;
import com.ed.tenacityxml.service.IataPnrgovNotifRqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@Validated
@RequestMapping("/pnr-notification")
public class IataPnrgovNotifRqController {

    @Autowired
    IataPnrgovNotifRqService iataPnrgovnotifRqService;

    @GetMapping
    List<IataPnrgovNotifRqDTO> getObject() {return iataPnrgovnotifRqService.getObject();}

    @GetMapping(path = "/by-id")
    IataPnrgovNotifRqDTO getObject(@RequestParam("id") Long id){return iataPnrgovnotifRqService.getObject(id);}

    @PostMapping(produces = "application/json", consumes = "application/xml")
    public Long postObject(@RequestBody String xmlRequest, @RequestHeader Map<String, String> headers) throws JAXBException {
        return iataPnrgovnotifRqService.postObject(xmlRequest, headers);
    }

    @PostMapping(path="/save")
    public Long post(
            @RequestParam("id") String formId,
            @RequestBody Map<String, Map<String, Object>> parameters,
            @RequestHeader Map<String, String> headers) throws JAXBException {
         return iataPnrgovnotifRqService.postFile(parameters, headers);
    }
}

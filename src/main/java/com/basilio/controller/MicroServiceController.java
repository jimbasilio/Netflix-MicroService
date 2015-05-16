package com.basilio.controller;

import java.time.LocalTime;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.basilio.dto.MicroServiceDTO;

@RestController
@RequestMapping(value = "/service")
public class MicroServiceController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public MicroServiceDTO getById(@PathVariable(value = "id") Long id)
            throws InterruptedException {
        MicroServiceDTO toReturn = new MicroServiceDTO();

        if (id.equals(1)) {
            toReturn.setTime(LocalTime.now());
            toReturn.setUUID(UUID.randomUUID());
            Thread.sleep(100); // simulate some delay for service
        }

        return toReturn;
    }

}

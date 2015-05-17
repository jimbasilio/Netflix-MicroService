package com.basilio.controller;

import java.time.LocalTime;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.basilio.dto.MicroServiceDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/data")
public class MicroServiceDataController {

    // not thread safe ... don't care for this purpose since a human is driving
    // this slowly
    private boolean down = false;

    public MicroServiceDTO fallbackGetById(@PathVariable(value = "id") Long id) {
        MicroServiceDTO toReturn = new MicroServiceDTO();

        return toReturn;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @HystrixCommand(fallbackMethod = "fallbackGetById")
    public MicroServiceDTO getById(@PathVariable(value = "id") Long id)
            throws InterruptedException {

        if (this.down) {
            throw new RuntimeException(
                    "I'm in ur bases. Eating all your service calls.");
        }

        MicroServiceDTO toReturn = new MicroServiceDTO();

        if (id.equals(1)) {
            toReturn.setTime(LocalTime.now());
            toReturn.setUUID(UUID.randomUUID());
            Thread.sleep(100); // simulate some delay for service
        }

        return toReturn;
    }

    @RequestMapping(value = "/down", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void down() {
        this.down = true;
    }

    @RequestMapping(value = "/up", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void up() {
        this.down = false;
    }
}

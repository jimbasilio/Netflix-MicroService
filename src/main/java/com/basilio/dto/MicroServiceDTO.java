package com.basilio.dto;

import java.time.LocalTime;
import java.util.UUID;

import org.springframework.util.Assert;

public class MicroServiceDTO {
    private LocalTime time = LocalTime.now();
    private UUID uuid = UUID.randomUUID();

    public MicroServiceDTO() {
        super();
    }

    public MicroServiceDTO(LocalTime time, UUID uuid) {
        super();
        this.time = time;
        this.uuid = uuid;
    }

    public String getTime() {
        Assert.notNull(this.time);
        return time.toString();
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public UUID getUUID() {
        Assert.notNull(this.uuid);
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }
}

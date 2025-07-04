package com.jbobadilla.facturacion.domain.dto;

import com.jbobadilla.facturacion.domain.enums.AgenciaStatus;

public class StatusDTO {
    private AgenciaStatus status;

    public AgenciaStatus getStatus() {
        return status;
    }

    public void setStatus(AgenciaStatus status) {
        this.status = status;
    }
}

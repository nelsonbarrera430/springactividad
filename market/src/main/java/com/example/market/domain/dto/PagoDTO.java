package com.example.market.domain.dto;

import java.util.Date;

public class PagoDTO {
    private Long id;
    private Long ordenId;
    private Double monto;
    private Date fechaPago;
    private String metodoPago;
    private String estado; // 👈 NUEVO CAMPO

    public PagoDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(Long ordenId) {
        this.ordenId = ordenId;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstado() { // 👈 GET
        return estado;
    }

    public void setEstado(String estado) { // 👈 SET
        this.estado = estado;
    }
}

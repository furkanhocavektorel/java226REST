package com.vektorel.restful.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AllException {

    ADMIN_ZATEN_KAYITLI(2000,"BU MAIL ILE ADMIN ZATEN MEVCUT"),
    ADMIN_BULUNAMADI(2001,"BU ADA AIT ADMIN/ADMINLER BULUNAMADI");

    int statusCode;
    String errorMessage;
}

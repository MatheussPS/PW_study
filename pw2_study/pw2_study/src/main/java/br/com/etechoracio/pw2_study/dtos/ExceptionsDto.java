package br.com.etechoracio.pw2_study.dtos;

import org.springframework.http.HttpStatus;

public record ExceptionsDto(HttpStatus status, String mensagem) {
}

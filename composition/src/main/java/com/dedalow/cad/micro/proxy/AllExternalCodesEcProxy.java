package com.dedalow.cad.micro.proxy;

import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcAddGenerosBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcChangeVarBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcEmptyExternalBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcRollbackChangeVarBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcSumatorioBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcTestExternalCodeBodyRequestDto;
import com.dedalow.cad.micro.commons.dto.request.AllExternalCodesEcValidateTypesBodyRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "externalcode")
public interface AllExternalCodesEcProxy {

  @RequestMapping(
      value = "/all-external-codes_ec/validate-types",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> validateTypes(
      @RequestBody AllExternalCodesEcValidateTypesBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/all-external-codes_ec/empty-external",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> emptyExternal(
      @RequestBody AllExternalCodesEcEmptyExternalBodyRequestDto bodyRequest);

  @RequestMapping(value = "/all-external-codes_ec/change-value", method = RequestMethod.POST)
  public ResponseEntity<?> changeValue();

  @RequestMapping(
      value = "/all-external-codes_ec/add-generos",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> addGeneros(
      @RequestBody AllExternalCodesEcAddGenerosBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/all-external-codes_ec/sumatorio",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> sumatorio(
      @RequestBody AllExternalCodesEcSumatorioBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/all-external-codes_ec/change-var",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> changeVar(
      @RequestBody AllExternalCodesEcChangeVarBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/all-external-codes_ec/rollback-change-var",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> rollbackChangeVar(
      @RequestBody AllExternalCodesEcRollbackChangeVarBodyRequestDto bodyRequest);

  @RequestMapping(
      value = "/all-external-codes_ec/test-external-code",
      method = RequestMethod.POST,
      consumes = "application/json")
  public ResponseEntity<?> testExternalCode(
      @RequestBody AllExternalCodesEcTestExternalCodeBodyRequestDto bodyRequest);
}

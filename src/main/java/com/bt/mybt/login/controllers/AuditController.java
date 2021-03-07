package com.bt.mybt.login.controllers;

import com.bt.mybt.login.service.AuditService;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class AuditController {

    @Autowired
    private AuditService auditService;

    @GetMapping("/api/v1/audit/{username}")
    public ResponseEntity<StreamingResponseBody> getAuditForUser(@PathVariable(name = "username") String username) throws IOException {
        Workbook workBook = auditService.getAuditForUser(username);

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=\"myfilename.xlsx\"")
                .body(workBook::write);
    }
}

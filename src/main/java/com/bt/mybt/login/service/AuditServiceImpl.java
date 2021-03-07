package com.bt.mybt.login.service;

import com.bt.mybt.login.entity.TimestampEntity;
import com.bt.mybt.login.repo.TimestampRepo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private TimestampRepo timestampRepo;

    @Override
    public Workbook getAuditForUser(String username) throws IOException {

        List<TimestampEntity> timestampEntities = timestampRepo.findByUsername(username);
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("report");

        int rowCount = 0;

        for (TimestampEntity entity : timestampEntities) {
            Row row = sheet.createRow(rowCount);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(entity.getDate().toString());

            Cell cell2 = row.createCell(1);
            cell2.setCellValue(entity.getLocale());

            Cell cell3 = row.createCell(2);
            cell3.setCellValue(entity.getUsername());

            Cell cell4 = row.createCell(3);
            cell4.setCellValue(entity.getOs());

            rowCount ++;
        }

        return workbook;
    }
}

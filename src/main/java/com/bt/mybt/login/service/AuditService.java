package com.bt.mybt.login.service;

import org.apache.poi.ss.usermodel.Workbook;
import java.io.IOException;

public interface AuditService {
    Workbook getAuditForUser(String user) throws IOException;
}

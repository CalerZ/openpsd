package com.caler.zkl.openpsd.service;

import com.caler.zkl.openpsd.bean.ExcelImportResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-05-14 15:22
 * @description :
 */
public interface ExcelDataService {

    List<ExcelImportResult> importProduct(MultipartFile file);
}

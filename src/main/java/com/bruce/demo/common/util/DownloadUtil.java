package com.bruce.demo.common.util;

import org.apache.poi.ss.usermodel.Workbook;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author bruce
 * @date 2023/6/4
 * @desc 文件下载工具
 */
public class DownloadUtil {

    private DownloadUtil() {
    }

    public static void downloadExcel(Workbook workbook, HttpServletResponse response, String fileName) throws IOException {
        String urlFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
        response.setHeader("Content-disposition", "attachment; filename=\"" + urlFileName + "\"; filename*=utf-8''" + urlFileName);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");
        workbook.write(response.getOutputStream());
    }
}

package com.pangmutou.common.core.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfUtil {

    public static void createPdf() {
        try {
            Document doc = new Document(PageSize.B5, 0, 0, 0, 0);
            String file = "d:/pdfblod.pdf";
            PdfWriter writer = null;

            writer = PdfWriter.getInstance(doc, new FileOutputStream(file));

            doc.open();
//            "d:/SIMYOU.TTF"
//            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            BaseFont bfChinese = BaseFont.createFont("C:/WINDOWS/Fonts/SIMYOU.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
            Font FontChinese1 = new Font(bfChinese, 14, Font.BOLD);

            Paragraph t = new Paragraph("JAVA世纪网(www.java2000.net)", FontChinese1);
            t.setAlignment(Paragraph.ALIGN_CENTER);
            doc.add(t);

            Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
            Paragraph lawDb = new Paragraph("提供最全面最实用的Java面试题,Java代码,Java项目,Java学习资料",
                    FontChinese);
            lawDb.setAlignment(Paragraph.ALIGN_CENTER);
            doc.add(lawDb);
            doc.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PdfUtil.createPdf();
    }

}

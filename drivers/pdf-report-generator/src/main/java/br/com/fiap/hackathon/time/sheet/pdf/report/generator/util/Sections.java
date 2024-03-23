package br.com.fiap.hackathon.time.sheet.pdf.report.generator.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Sections {

    public static CTSectPr currentSection(XWPFDocument document){
        var body = document.getDocument().getBody();

        if (!body.isSetSectPr()){
            body.addNewSectPr();
        }

        return body.getSectPr();
    }

}

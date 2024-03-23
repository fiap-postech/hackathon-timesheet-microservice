package br.com.fiap.hackathon.time.sheet.pdf.report.generator.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageSizes {

    public static CTPageSz currentPageSize(CTSectPr section){
        if(!section.isSetPgSz()) {
            section.addNewPgSz();
        }

        return section.getPgSz();
    }

}

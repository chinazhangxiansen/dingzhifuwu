package com.pangmutou.education.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.itextpdf.text.pdf.parser.PathConstructionRenderInfo;

import java.io.Serializable;

@TableName("edu_reference")
public class Reference  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String referenceName;
    private String referencePrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(String referencePrice) {
        this.referencePrice = referencePrice;
    }
}

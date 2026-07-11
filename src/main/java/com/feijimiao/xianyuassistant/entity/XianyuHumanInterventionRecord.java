package com.feijimiao.xianyuassistant.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "xianyu_human_intervention_record")
@CompoundIndex(name = "idx_human_session_end", def = "{'sId': 1, 'endTime': -1}")
public class XianyuHumanInterventionRecord {

    @Id
    private Long id;

    private Long xianyuAccountId;

    private String xyGoodsId;

    private String sId;

    @Indexed
    private String endTime;

    private String createdTime;
}

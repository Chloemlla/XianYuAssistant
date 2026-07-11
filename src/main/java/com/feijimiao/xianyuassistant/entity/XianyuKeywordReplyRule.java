package com.feijimiao.xianyuassistant.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "xianyu_keyword_reply_rule")
@CompoundIndexes({
        @CompoundIndex(name = "idx_keyword_rule_goods", def = "{'xianyuAccountId': 1, 'xyGoodsId': 1}"),
        @CompoundIndex(name = "idx_keyword_rule_match", def = "{'xianyuAccountId': 1, 'xyGoodsId': 1, 'matchMode': 1, 'keyword': 1}")
})
public class XianyuKeywordReplyRule {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long xianyuAccountId;
    private String xyGoodsId;
    private String keyword;
    private Integer matchMode;
    private Integer isFallback;
    private String createTime;
}

package com.feijimiao.xianyuassistant.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "xianyu_keyword_reply_content")
public class XianyuKeywordReplyContent {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @Indexed
    @JsonSerialize(using = ToStringSerializer.class)
    private Long ruleId;
    private String replyText;
    private String replyImageUrl;
    private String createTime;
}

package com.feijimiao.xianyuassistant.persistence;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "_sequences")
public class MongoSequence {
    @Id
    private String id;
    private long value;
}

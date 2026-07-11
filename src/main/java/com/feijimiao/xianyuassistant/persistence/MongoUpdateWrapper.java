package com.feijimiao.xianyuassistant.persistence;

import org.springframework.data.mongodb.core.query.Update;

public class MongoUpdateWrapper<T> extends MongoQueryWrapper<T> {
    private final Update update = new Update();

    @Override
    public MongoUpdateWrapper<T> eq(SFunction<T, ?> field, Object value) {
        super.eq(field, value);
        return this;
    }

    @Override
    public MongoUpdateWrapper<T> eq(boolean condition, SFunction<T, ?> field, Object value) {
        super.eq(condition, field, value);
        return this;
    }

    public MongoUpdateWrapper<T> set(SFunction<T, ?> field, Object value) {
        update.set(MongoFieldNames.from(field), value);
        return this;
    }

    public MongoUpdateWrapper<T> set(boolean condition, SFunction<T, ?> field, Object value) {
        if (condition) update.set(MongoFieldNames.from(field), value);
        return this;
    }

    public Update toUpdate() {
        return update;
    }
}

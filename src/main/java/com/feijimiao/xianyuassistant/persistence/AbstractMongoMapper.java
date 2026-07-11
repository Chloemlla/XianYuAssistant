package com.feijimiao.xianyuassistant.persistence;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.Field;
import java.util.List;

public abstract class AbstractMongoMapper<T> {
    protected final MongoTemplate mongoTemplate;
    private final MongoIdGenerator idGenerator;
    protected final Class<T> entityType;
    private final Field idField;

    protected AbstractMongoMapper(MongoTemplate mongoTemplate, MongoIdGenerator idGenerator, Class<T> entityType) {
        this.mongoTemplate = mongoTemplate;
        this.idGenerator = idGenerator;
        this.entityType = entityType;
        this.idField = findIdField(entityType);
        this.idField.setAccessible(true);
    }

    public int insert(T entity) {
        assignId(entity);
        mongoTemplate.insert(entity);
        return 1;
    }

    public int updateById(T entity) {
        Object id = getId(entity);
        if (id == null) return 0;
        mongoTemplate.save(entity);
        return 1;
    }

    public T selectById(Object id) {
        return mongoTemplate.findById(id, entityType);
    }

    public T selectOne(MongoQueryWrapper<T> wrapper) {
        return mongoTemplate.findOne(wrapper.toQuery().limit(1), entityType);
    }

    public List<T> selectList(MongoQueryWrapper<T> wrapper) {
        return mongoTemplate.find(wrapper == null ? new Query() : wrapper.toQuery(), entityType);
    }

    public Long selectCount(MongoQueryWrapper<T> wrapper) {
        return mongoTemplate.count(wrapper == null ? new Query() : wrapper.toQuery(), entityType);
    }

    public int deleteById(Object id) {
        return count(mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)), entityType));
    }

    public int delete(MongoQueryWrapper<T> wrapper) {
        return count(mongoTemplate.remove(wrapper.toQuery(), entityType));
    }

    public int update(T entity, MongoUpdateWrapper<T> wrapper) {
        Update update = wrapper.toUpdate();
        UpdateResult result = mongoTemplate.updateMulti(wrapper.toQuery(), update, entityType);
        return Math.toIntExact(result.getModifiedCount());
    }

    private void assignId(T entity) {
        try {
            if (idField.get(entity) == null && (idField.getType() == Long.class || idField.getType() == long.class)) {
                idField.set(entity, idGenerator.next(entityType.getSimpleName()));
            }
        } catch (IllegalAccessException exception) {
            throw new IllegalStateException("Unable to assign MongoDB document id", exception);
        }
    }

    private Object getId(T entity) {
        try {
            return idField.get(entity);
        } catch (IllegalAccessException exception) {
            throw new IllegalStateException("Unable to read MongoDB document id", exception);
        }
    }

    private static Field findIdField(Class<?> type) {
        for (Field field : type.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class) || field.getName().equals("id")) return field;
        }
        throw new IllegalArgumentException("MongoDB entity has no id field: " + type.getName());
    }

    private int count(DeleteResult result) {
        return Math.toIntExact(result.getDeletedCount());
    }
}

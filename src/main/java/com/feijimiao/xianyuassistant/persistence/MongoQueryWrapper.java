package com.feijimiao.xianyuassistant.persistence;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MongoQueryWrapper<T> {
    private final List<Criteria> criteria = new ArrayList<>();
    private Sort sort = Sort.unsorted();
    private int limit;

    public MongoQueryWrapper<T> eq(SFunction<T, ?> field, Object value) {
        return eq(true, field, value);
    }

    public MongoQueryWrapper<T> eq(boolean condition, SFunction<T, ?> field, Object value) {
        if (condition) criteria.add(Criteria.where(MongoFieldNames.from(field)).is(value));
        return this;
    }

    public MongoQueryWrapper<T> ne(SFunction<T, ?> field, Object value) {
        criteria.add(Criteria.where(MongoFieldNames.from(field)).ne(value));
        return this;
    }

    public MongoQueryWrapper<T> like(SFunction<T, ?> field, String value) {
        criteria.add(Criteria.where(MongoFieldNames.from(field)).regex(java.util.regex.Pattern.quote(value), "i"));
        return this;
    }

    public MongoQueryWrapper<T> in(SFunction<T, ?> field, Collection<?> values) {
        criteria.add(Criteria.where(MongoFieldNames.from(field)).in(values));
        return this;
    }

    public MongoQueryWrapper<T> isNull(SFunction<T, ?> field) {
        criteria.add(new Criteria().orOperator(
                Criteria.where(MongoFieldNames.from(field)).is(null),
                Criteria.where(MongoFieldNames.from(field)).exists(false)));
        return this;
    }

    public MongoQueryWrapper<T> orderByDesc(SFunction<T, ?> field) {
        sort = sort.and(Sort.by(Sort.Direction.DESC, MongoFieldNames.from(field)));
        return this;
    }

    public MongoQueryWrapper<T> orderByAsc(SFunction<T, ?> field) {
        sort = sort.and(Sort.by(Sort.Direction.ASC, MongoFieldNames.from(field)));
        return this;
    }

    @SafeVarargs
    public final MongoQueryWrapper<T> orderByAsc(SFunction<T, ?>... fields) {
        for (SFunction<T, ?> field : fields) {
            sort = sort.and(Sort.by(Sort.Direction.ASC, MongoFieldNames.from(field)));
        }
        return this;
    }

    public MongoQueryWrapper<T> last(String expression) {
        if (expression != null && expression.trim().toUpperCase().startsWith("LIMIT ")) {
            limit = Integer.parseInt(expression.trim().substring(6).trim());
        }
        return this;
    }

    public Query toQuery() {
        Query query = new Query();
        if (criteria.size() == 1) query.addCriteria(criteria.getFirst());
        if (criteria.size() > 1) query.addCriteria(new Criteria().andOperator(criteria));
        if (sort.isSorted()) query.with(sort);
        if (limit > 0) query.limit(limit);
        return query;
    }
}

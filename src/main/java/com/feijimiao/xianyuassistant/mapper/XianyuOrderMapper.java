package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuOrder;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class XianyuOrderMapper extends AbstractMongoMapper<XianyuOrder> {
    public XianyuOrderMapper(MongoTemplate t, MongoIdGenerator ids){super(t,ids,XianyuOrder.class);}
    public Page<XianyuOrder> queryOrderList(Pageable page,Long accountId,String goodsId,Integer status){Criteria c=new Criteria(); java.util.List<Criteria> all=new java.util.ArrayList<>(); if(accountId!=null)all.add(Criteria.where("xianyuAccountId").is(accountId)); if(goodsId!=null&&!goodsId.isBlank())all.add(Criteria.where("xyGoodsId").is(goodsId)); if(status!=null)all.add(Criteria.where("orderStatus").is(status)); Query q=all.isEmpty()?new Query():Query.query(c.andOperator(all)); long total=mongoTemplate.count(q,entityType); q.with(page).with(Sort.by(Sort.Direction.DESC,"orderCreateTime")); return new PageImpl<>(mongoTemplate.find(q,entityType),page,total);}
}

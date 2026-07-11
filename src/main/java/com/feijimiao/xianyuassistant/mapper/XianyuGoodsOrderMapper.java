package com.feijimiao.xianyuassistant.mapper;

import com.feijimiao.xianyuassistant.entity.XianyuGoodsOrder;
import com.feijimiao.xianyuassistant.persistence.AbstractMongoMapper;
import com.feijimiao.xianyuassistant.persistence.MongoIdGenerator;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

@Repository
public class XianyuGoodsOrderMapper extends AbstractMongoMapper<XianyuGoodsOrder> {
    public XianyuGoodsOrderMapper(MongoTemplate t, MongoIdGenerator ids) { super(t, ids, XianyuGoodsOrder.class); }
    public List<XianyuGoodsOrder> selectByAccountId(Long a){return mongoTemplate.find(Query.query(Criteria.where("xianyuAccountId").is(a)).with(Sort.by(Sort.Direction.DESC,"createTime")),entityType);}
    public int deleteByAccountId(Long a){return Math.toIntExact(mongoTemplate.remove(Query.query(Criteria.where("xianyuAccountId").is(a)),entityType).getDeletedCount());}
    public List<XianyuGoodsOrder> selectByAccountIdWithPage(Long a,String g,String k,int l,int o){return mongoTemplate.find(filter(a,g,null,k).with(Sort.by(Sort.Direction.DESC,"createTime")).skip(o).limit(l),entityType);}
    public long countByAccountId(Long a,String g,String k){return mongoTemplate.count(filter(a,g,null,k),entityType);}
    public int updateState(Long id,Integer s){return update(id,new Update().set("state",s));}
    public int updateStateAndContent(Long id,Integer s,String c){return update(id,new Update().set("state",s).set("content",c));}
    public int updateStateContentAndFailReason(Long id,Integer s,String c,String f){return update(id,new Update().set("state",s).set("content",c).set("failReason",f));}
    public XianyuGoodsOrder selectByOrderId(Long a,String g,String o){return mongoTemplate.findOne(Query.query(Criteria.where("xianyuAccountId").is(a).and("xyGoodsId").is(g).and("orderId").is(o)),entityType);}
    public XianyuGoodsOrder selectByAccountIdAndOrderId(Long a,String o){return mongoTemplate.findOne(Query.query(Criteria.where("xianyuAccountId").is(a).and("orderId").is(o)),entityType);}
    public XianyuGoodsOrder claimForApiDelivery(Long accountId,String orderId,String claimToken,long leaseUntil){
        Criteria available = new Criteria().orOperator(Criteria.where("deliveryClaimExpiresAt").exists(false),Criteria.where("deliveryClaimExpiresAt").lt(System.currentTimeMillis()));
        Query query = Query.query(new Criteria().andOperator(Criteria.where("xianyuAccountId").is(accountId),Criteria.where("orderId").is(orderId),Criteria.where("state").ne(1),available));
        Update update = new Update().set("deliveryClaimToken",claimToken).set("deliveryClaimExpiresAt",leaseUntil).set("state",2);
        return mongoTemplate.findAndModify(query,update,FindAndModifyOptions.options().returnNew(true),entityType);
    }
    public int finishApiDeliveryClaim(Long id,String claimToken,boolean success,String failure){
        Query query=Query.query(Criteria.where("_id").is(id).and("deliveryClaimToken").is(claimToken));
        Update update=new Update().set("state",success?1:-1).unset("deliveryClaimToken").unset("deliveryClaimExpiresAt");
        if(failure!=null)update.set("failReason",failure);
        return Math.toIntExact(mongoTemplate.updateFirst(query,update,entityType).getModifiedCount());
    }
    public int updateConfirmState(Long a,String o){return Math.toIntExact(mongoTemplate.updateMulti(Query.query(Criteria.where("xianyuAccountId").is(a).and("orderId").is(o)),new Update().set("confirmState",1),entityType).getModifiedCount());}
    public XianyuGoodsOrder selectByPnmId(Long a,String p){return mongoTemplate.findOne(Query.query(Criteria.where("xianyuAccountId").is(a).and("pnmId").is(p)),entityType);}
    public int countYesterdayOrders(){return countOrdersByDate(LocalDate.now().minusDays(1).toString());}
    public int countDeliverySuccess(){return countState(1,null);}
    public int countDeliveryFail(){return countState(-1,null);}
    public int countAllOrders(){return Math.toIntExact(mongoTemplate.count(new Query(),entityType));}
    public int countOrdersByDate(String d){return Math.toIntExact(mongoTemplate.count(dateQuery(d),entityType));}
    public List<XianyuGoodsOrder> selectByConditionWithPage(Long a,String g,Integer s,String k,int l,int o){return mongoTemplate.find(filter(a,g,s,k).with(Sort.by(Sort.Direction.DESC,"createTime")).skip(o).limit(l),entityType);}
    public long countByCondition(Long a,String g,Integer s,String k){return mongoTemplate.count(filter(a,g,s,k),entityType);}
    public int countDeliverySuccessByDate(String d){return countState(1,d);}
    public int countDeliveryFailByDate(String d){return countState(-1,d);}
    public double sumDeliverySuccessAmount(){return sum(null,null);}
    public int updateSkuName(Long id,String sku){return update(id,new Update().set("skuName",sku));}
    public int updateOrderDetail(Long id,String buyer,String created,String paid,String consign,String sku,String title,String price,Integer num){Update u=new Update().set("buyerUserName",buyer).set("orderCreateTime",created).set("paySuccessTime",paid).set("consignTime",consign).set("goodsTitle",title).set("totalPrice",price).set("buyNum",num); if(sku!=null)u.set("skuName",sku); return update(id,u);}
    public double sumDeliverySuccessAmountByDate(String d){return sum(d,d);}
    public double sumDeliverySuccessAmountByDateRange(String start,String end){return sum(start,end);}
    private int update(Long id,Update u){return Math.toIntExact(mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(id)),u,entityType).getModifiedCount());}
    private Query dateQuery(String d){return Query.query(Criteria.where("createTime").regex("^"+Pattern.quote(d)));}
    private int countState(int s,String d){Query q=Query.query(Criteria.where("state").is(s)); if(d!=null)q.addCriteria(Criteria.where("createTime").regex("^"+Pattern.quote(d))); return Math.toIntExact(mongoTemplate.count(q,entityType));}
    private Query filter(Long a,String g,Integer s,String k){Criteria c=new Criteria(); java.util.List<Criteria> all=new java.util.ArrayList<>(); if(a!=null)all.add(Criteria.where("xianyuAccountId").is(a)); if(g!=null&&!g.isBlank())all.add(Criteria.where("xyGoodsId").is(g)); if(s!=null)all.add(Criteria.where("state").is(s)); if(k!=null&&!k.isBlank()){Pattern p=Pattern.compile(Pattern.quote(k),Pattern.CASE_INSENSITIVE); all.add(new Criteria().orOperator(Criteria.where("goodsTitle").regex(p),Criteria.where("skuName").regex(p),Criteria.where("buyerUserName").regex(p),Criteria.where("content").regex(p)));} return all.isEmpty()?new Query():Query.query(c.andOperator(all));}
    private double sum(String start,String end){Query q=Query.query(Criteria.where("state").is(1).and("confirmState").is(1)); if(start!=null)q.addCriteria(Criteria.where("createTime").gte(start).lt(LocalDate.parse(end).plusDays(1).toString())); return mongoTemplate.find(q,entityType).stream().mapToDouble(x->{try{return Double.parseDouble(x.getTotalPrice());}catch(Exception e){return 0;}}).sum();}
}

package com.yoooho.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmsOrderCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmsOrderCommentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("`uid` is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("`uid` is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("`uid` =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("`uid` <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("`uid` >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("`uid` >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("`uid` <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("`uid` <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("`uid` in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("`uid` not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("`uid` between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("`uid` not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Long value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Long value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Long value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Long value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Long> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Long> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andUniqueIsNull() {
            addCriterion("`unique` is null");
            return (Criteria) this;
        }

        public Criteria andUniqueIsNotNull() {
            addCriterion("`unique` is not null");
            return (Criteria) this;
        }

        public Criteria andUniqueEqualTo(String value) {
            addCriterion("`unique` =", value, "unique");
            return (Criteria) this;
        }

        public Criteria andUniqueNotEqualTo(String value) {
            addCriterion("`unique` <>", value, "unique");
            return (Criteria) this;
        }

        public Criteria andUniqueGreaterThan(String value) {
            addCriterion("`unique` >", value, "unique");
            return (Criteria) this;
        }

        public Criteria andUniqueGreaterThanOrEqualTo(String value) {
            addCriterion("`unique` >=", value, "unique");
            return (Criteria) this;
        }

        public Criteria andUniqueLessThan(String value) {
            addCriterion("`unique` <", value, "unique");
            return (Criteria) this;
        }

        public Criteria andUniqueLessThanOrEqualTo(String value) {
            addCriterion("`unique` <=", value, "unique");
            return (Criteria) this;
        }

        public Criteria andUniqueLike(String value) {
            addCriterion("`unique` like", value, "unique");
            return (Criteria) this;
        }

        public Criteria andUniqueNotLike(String value) {
            addCriterion("`unique` not like", value, "unique");
            return (Criteria) this;
        }

        public Criteria andUniqueIn(List<String> values) {
            addCriterion("`unique` in", values, "unique");
            return (Criteria) this;
        }

        public Criteria andUniqueNotIn(List<String> values) {
            addCriterion("`unique` not in", values, "unique");
            return (Criteria) this;
        }

        public Criteria andUniqueBetween(String value1, String value2) {
            addCriterion("`unique` between", value1, value2, "unique");
            return (Criteria) this;
        }

        public Criteria andUniqueNotBetween(String value1, String value2) {
            addCriterion("`unique` not between", value1, value2, "unique");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIsNull() {
            addCriterion("reply_type is null");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIsNotNull() {
            addCriterion("reply_type is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTypeEqualTo(Integer value) {
            addCriterion("reply_type =", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotEqualTo(Integer value) {
            addCriterion("reply_type <>", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeGreaterThan(Integer value) {
            addCriterion("reply_type >", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_type >=", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeLessThan(Integer value) {
            addCriterion("reply_type <", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("reply_type <=", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIn(List<Integer> values) {
            addCriterion("reply_type in", values, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotIn(List<Integer> values) {
            addCriterion("reply_type not in", values, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeBetween(Integer value1, Integer value2) {
            addCriterion("reply_type between", value1, value2, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_type not between", value1, value2, "replyType");
            return (Criteria) this;
        }

        public Criteria andProductScoreIsNull() {
            addCriterion("product_score is null");
            return (Criteria) this;
        }

        public Criteria andProductScoreIsNotNull() {
            addCriterion("product_score is not null");
            return (Criteria) this;
        }

        public Criteria andProductScoreEqualTo(Boolean value) {
            addCriterion("product_score =", value, "productScore");
            return (Criteria) this;
        }

        public Criteria andProductScoreNotEqualTo(Boolean value) {
            addCriterion("product_score <>", value, "productScore");
            return (Criteria) this;
        }

        public Criteria andProductScoreGreaterThan(Boolean value) {
            addCriterion("product_score >", value, "productScore");
            return (Criteria) this;
        }

        public Criteria andProductScoreGreaterThanOrEqualTo(Boolean value) {
            addCriterion("product_score >=", value, "productScore");
            return (Criteria) this;
        }

        public Criteria andProductScoreLessThan(Boolean value) {
            addCriterion("product_score <", value, "productScore");
            return (Criteria) this;
        }

        public Criteria andProductScoreLessThanOrEqualTo(Boolean value) {
            addCriterion("product_score <=", value, "productScore");
            return (Criteria) this;
        }

        public Criteria andProductScoreIn(List<Boolean> values) {
            addCriterion("product_score in", values, "productScore");
            return (Criteria) this;
        }

        public Criteria andProductScoreNotIn(List<Boolean> values) {
            addCriterion("product_score not in", values, "productScore");
            return (Criteria) this;
        }

        public Criteria andProductScoreBetween(Boolean value1, Boolean value2) {
            addCriterion("product_score between", value1, value2, "productScore");
            return (Criteria) this;
        }

        public Criteria andProductScoreNotBetween(Boolean value1, Boolean value2) {
            addCriterion("product_score not between", value1, value2, "productScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreIsNull() {
            addCriterion("service_score is null");
            return (Criteria) this;
        }

        public Criteria andServiceScoreIsNotNull() {
            addCriterion("service_score is not null");
            return (Criteria) this;
        }

        public Criteria andServiceScoreEqualTo(Boolean value) {
            addCriterion("service_score =", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreNotEqualTo(Boolean value) {
            addCriterion("service_score <>", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreGreaterThan(Boolean value) {
            addCriterion("service_score >", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreGreaterThanOrEqualTo(Boolean value) {
            addCriterion("service_score >=", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreLessThan(Boolean value) {
            addCriterion("service_score <", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreLessThanOrEqualTo(Boolean value) {
            addCriterion("service_score <=", value, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreIn(List<Boolean> values) {
            addCriterion("service_score in", values, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreNotIn(List<Boolean> values) {
            addCriterion("service_score not in", values, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreBetween(Boolean value1, Boolean value2) {
            addCriterion("service_score between", value1, value2, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andServiceScoreNotBetween(Boolean value1, Boolean value2) {
            addCriterion("service_score not between", value1, value2, "serviceScore");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("`comment` is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("`comment` is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("`comment` =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("`comment` <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("`comment` >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("`comment` >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("`comment` <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("`comment` <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("`comment` like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("`comment` not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("`comment` in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("`comment` not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("`comment` between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("`comment` not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentIsNull() {
            addCriterion("merchant_reply_content is null");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentIsNotNull() {
            addCriterion("merchant_reply_content is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentEqualTo(String value) {
            addCriterion("merchant_reply_content =", value, "merchantReplyContent");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentNotEqualTo(String value) {
            addCriterion("merchant_reply_content <>", value, "merchantReplyContent");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentGreaterThan(String value) {
            addCriterion("merchant_reply_content >", value, "merchantReplyContent");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_reply_content >=", value, "merchantReplyContent");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentLessThan(String value) {
            addCriterion("merchant_reply_content <", value, "merchantReplyContent");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentLessThanOrEqualTo(String value) {
            addCriterion("merchant_reply_content <=", value, "merchantReplyContent");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentLike(String value) {
            addCriterion("merchant_reply_content like", value, "merchantReplyContent");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentNotLike(String value) {
            addCriterion("merchant_reply_content not like", value, "merchantReplyContent");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentIn(List<String> values) {
            addCriterion("merchant_reply_content in", values, "merchantReplyContent");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentNotIn(List<String> values) {
            addCriterion("merchant_reply_content not in", values, "merchantReplyContent");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentBetween(String value1, String value2) {
            addCriterion("merchant_reply_content between", value1, value2, "merchantReplyContent");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyContentNotBetween(String value1, String value2) {
            addCriterion("merchant_reply_content not between", value1, value2, "merchantReplyContent");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyTimeIsNull() {
            addCriterion("merchant_reply_time is null");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyTimeIsNotNull() {
            addCriterion("merchant_reply_time is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyTimeEqualTo(Date value) {
            addCriterion("merchant_reply_time =", value, "merchantReplyTime");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyTimeNotEqualTo(Date value) {
            addCriterion("merchant_reply_time <>", value, "merchantReplyTime");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyTimeGreaterThan(Date value) {
            addCriterion("merchant_reply_time >", value, "merchantReplyTime");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("merchant_reply_time >=", value, "merchantReplyTime");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyTimeLessThan(Date value) {
            addCriterion("merchant_reply_time <", value, "merchantReplyTime");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("merchant_reply_time <=", value, "merchantReplyTime");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyTimeIn(List<Date> values) {
            addCriterion("merchant_reply_time in", values, "merchantReplyTime");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyTimeNotIn(List<Date> values) {
            addCriterion("merchant_reply_time not in", values, "merchantReplyTime");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyTimeBetween(Date value1, Date value2) {
            addCriterion("merchant_reply_time between", value1, value2, "merchantReplyTime");
            return (Criteria) this;
        }

        public Criteria andMerchantReplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("merchant_reply_time not between", value1, value2, "merchantReplyTime");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Boolean value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Boolean value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Boolean value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Boolean value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Boolean value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Boolean> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Boolean> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Boolean value1, Boolean value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsReplyIsNull() {
            addCriterion("is_reply is null");
            return (Criteria) this;
        }

        public Criteria andIsReplyIsNotNull() {
            addCriterion("is_reply is not null");
            return (Criteria) this;
        }

        public Criteria andIsReplyEqualTo(Boolean value) {
            addCriterion("is_reply =", value, "isReply");
            return (Criteria) this;
        }

        public Criteria andIsReplyNotEqualTo(Boolean value) {
            addCriterion("is_reply <>", value, "isReply");
            return (Criteria) this;
        }

        public Criteria andIsReplyGreaterThan(Boolean value) {
            addCriterion("is_reply >", value, "isReply");
            return (Criteria) this;
        }

        public Criteria andIsReplyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_reply >=", value, "isReply");
            return (Criteria) this;
        }

        public Criteria andIsReplyLessThan(Boolean value) {
            addCriterion("is_reply <", value, "isReply");
            return (Criteria) this;
        }

        public Criteria andIsReplyLessThanOrEqualTo(Boolean value) {
            addCriterion("is_reply <=", value, "isReply");
            return (Criteria) this;
        }

        public Criteria andIsReplyIn(List<Boolean> values) {
            addCriterion("is_reply in", values, "isReply");
            return (Criteria) this;
        }

        public Criteria andIsReplyNotIn(List<Boolean> values) {
            addCriterion("is_reply not in", values, "isReply");
            return (Criteria) this;
        }

        public Criteria andIsReplyBetween(Boolean value1, Boolean value2) {
            addCriterion("is_reply between", value1, value2, "isReply");
            return (Criteria) this;
        }

        public Criteria andIsReplyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_reply not between", value1, value2, "isReply");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
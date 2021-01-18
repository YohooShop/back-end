package com.yoooho.mall.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OmsPinkBuyerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmsPinkBuyerExample() {
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

        public Criteria andBuyerIdIsNull() {
            addCriterion("buyer_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNotNull() {
            addCriterion("buyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdEqualTo(Long value) {
            addCriterion("buyer_id =", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotEqualTo(Long value) {
            addCriterion("buyer_id <>", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThan(Long value) {
            addCriterion("buyer_id >", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("buyer_id >=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThan(Long value) {
            addCriterion("buyer_id <", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThanOrEqualTo(Long value) {
            addCriterion("buyer_id <=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIn(List<Long> values) {
            addCriterion("buyer_id in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotIn(List<Long> values) {
            addCriterion("buyer_id not in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdBetween(Long value1, Long value2) {
            addCriterion("buyer_id between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotBetween(Long value1, Long value2) {
            addCriterion("buyer_id not between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andPinkIdIsNull() {
            addCriterion("pink_id is null");
            return (Criteria) this;
        }

        public Criteria andPinkIdIsNotNull() {
            addCriterion("pink_id is not null");
            return (Criteria) this;
        }

        public Criteria andPinkIdEqualTo(Long value) {
            addCriterion("pink_id =", value, "pinkId");
            return (Criteria) this;
        }

        public Criteria andPinkIdNotEqualTo(Long value) {
            addCriterion("pink_id <>", value, "pinkId");
            return (Criteria) this;
        }

        public Criteria andPinkIdGreaterThan(Long value) {
            addCriterion("pink_id >", value, "pinkId");
            return (Criteria) this;
        }

        public Criteria andPinkIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pink_id >=", value, "pinkId");
            return (Criteria) this;
        }

        public Criteria andPinkIdLessThan(Long value) {
            addCriterion("pink_id <", value, "pinkId");
            return (Criteria) this;
        }

        public Criteria andPinkIdLessThanOrEqualTo(Long value) {
            addCriterion("pink_id <=", value, "pinkId");
            return (Criteria) this;
        }

        public Criteria andPinkIdIn(List<Long> values) {
            addCriterion("pink_id in", values, "pinkId");
            return (Criteria) this;
        }

        public Criteria andPinkIdNotIn(List<Long> values) {
            addCriterion("pink_id not in", values, "pinkId");
            return (Criteria) this;
        }

        public Criteria andPinkIdBetween(Long value1, Long value2) {
            addCriterion("pink_id between", value1, value2, "pinkId");
            return (Criteria) this;
        }

        public Criteria andPinkIdNotBetween(Long value1, Long value2) {
            addCriterion("pink_id not between", value1, value2, "pinkId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andPinkNumIsNull() {
            addCriterion("pink_num is null");
            return (Criteria) this;
        }

        public Criteria andPinkNumIsNotNull() {
            addCriterion("pink_num is not null");
            return (Criteria) this;
        }

        public Criteria andPinkNumEqualTo(Integer value) {
            addCriterion("pink_num =", value, "pinkNum");
            return (Criteria) this;
        }

        public Criteria andPinkNumNotEqualTo(Integer value) {
            addCriterion("pink_num <>", value, "pinkNum");
            return (Criteria) this;
        }

        public Criteria andPinkNumGreaterThan(Integer value) {
            addCriterion("pink_num >", value, "pinkNum");
            return (Criteria) this;
        }

        public Criteria andPinkNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pink_num >=", value, "pinkNum");
            return (Criteria) this;
        }

        public Criteria andPinkNumLessThan(Integer value) {
            addCriterion("pink_num <", value, "pinkNum");
            return (Criteria) this;
        }

        public Criteria andPinkNumLessThanOrEqualTo(Integer value) {
            addCriterion("pink_num <=", value, "pinkNum");
            return (Criteria) this;
        }

        public Criteria andPinkNumIn(List<Integer> values) {
            addCriterion("pink_num in", values, "pinkNum");
            return (Criteria) this;
        }

        public Criteria andPinkNumNotIn(List<Integer> values) {
            addCriterion("pink_num not in", values, "pinkNum");
            return (Criteria) this;
        }

        public Criteria andPinkNumBetween(Integer value1, Integer value2) {
            addCriterion("pink_num between", value1, value2, "pinkNum");
            return (Criteria) this;
        }

        public Criteria andPinkNumNotBetween(Integer value1, Integer value2) {
            addCriterion("pink_num not between", value1, value2, "pinkNum");
            return (Criteria) this;
        }

        public Criteria andPinkPriceIsNull() {
            addCriterion("pink_price is null");
            return (Criteria) this;
        }

        public Criteria andPinkPriceIsNotNull() {
            addCriterion("pink_price is not null");
            return (Criteria) this;
        }

        public Criteria andPinkPriceEqualTo(BigDecimal value) {
            addCriterion("pink_price =", value, "pinkPrice");
            return (Criteria) this;
        }

        public Criteria andPinkPriceNotEqualTo(BigDecimal value) {
            addCriterion("pink_price <>", value, "pinkPrice");
            return (Criteria) this;
        }

        public Criteria andPinkPriceGreaterThan(BigDecimal value) {
            addCriterion("pink_price >", value, "pinkPrice");
            return (Criteria) this;
        }

        public Criteria andPinkPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pink_price >=", value, "pinkPrice");
            return (Criteria) this;
        }

        public Criteria andPinkPriceLessThan(BigDecimal value) {
            addCriterion("pink_price <", value, "pinkPrice");
            return (Criteria) this;
        }

        public Criteria andPinkPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pink_price <=", value, "pinkPrice");
            return (Criteria) this;
        }

        public Criteria andPinkPriceIn(List<BigDecimal> values) {
            addCriterion("pink_price in", values, "pinkPrice");
            return (Criteria) this;
        }

        public Criteria andPinkPriceNotIn(List<BigDecimal> values) {
            addCriterion("pink_price not in", values, "pinkPrice");
            return (Criteria) this;
        }

        public Criteria andPinkPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pink_price between", value1, value2, "pinkPrice");
            return (Criteria) this;
        }

        public Criteria andPinkPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pink_price not between", value1, value2, "pinkPrice");
            return (Criteria) this;
        }

        public Criteria andPinkAmtIsNull() {
            addCriterion("pink_amt is null");
            return (Criteria) this;
        }

        public Criteria andPinkAmtIsNotNull() {
            addCriterion("pink_amt is not null");
            return (Criteria) this;
        }

        public Criteria andPinkAmtEqualTo(BigDecimal value) {
            addCriterion("pink_amt =", value, "pinkAmt");
            return (Criteria) this;
        }

        public Criteria andPinkAmtNotEqualTo(BigDecimal value) {
            addCriterion("pink_amt <>", value, "pinkAmt");
            return (Criteria) this;
        }

        public Criteria andPinkAmtGreaterThan(BigDecimal value) {
            addCriterion("pink_amt >", value, "pinkAmt");
            return (Criteria) this;
        }

        public Criteria andPinkAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pink_amt >=", value, "pinkAmt");
            return (Criteria) this;
        }

        public Criteria andPinkAmtLessThan(BigDecimal value) {
            addCriterion("pink_amt <", value, "pinkAmt");
            return (Criteria) this;
        }

        public Criteria andPinkAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pink_amt <=", value, "pinkAmt");
            return (Criteria) this;
        }

        public Criteria andPinkAmtIn(List<BigDecimal> values) {
            addCriterion("pink_amt in", values, "pinkAmt");
            return (Criteria) this;
        }

        public Criteria andPinkAmtNotIn(List<BigDecimal> values) {
            addCriterion("pink_amt not in", values, "pinkAmt");
            return (Criteria) this;
        }

        public Criteria andPinkAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pink_amt between", value1, value2, "pinkAmt");
            return (Criteria) this;
        }

        public Criteria andPinkAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pink_amt not between", value1, value2, "pinkAmt");
            return (Criteria) this;
        }

        public Criteria andPinkStatusIsNull() {
            addCriterion("pink_status is null");
            return (Criteria) this;
        }

        public Criteria andPinkStatusIsNotNull() {
            addCriterion("pink_status is not null");
            return (Criteria) this;
        }

        public Criteria andPinkStatusEqualTo(Boolean value) {
            addCriterion("pink_status =", value, "pinkStatus");
            return (Criteria) this;
        }

        public Criteria andPinkStatusNotEqualTo(Boolean value) {
            addCriterion("pink_status <>", value, "pinkStatus");
            return (Criteria) this;
        }

        public Criteria andPinkStatusGreaterThan(Boolean value) {
            addCriterion("pink_status >", value, "pinkStatus");
            return (Criteria) this;
        }

        public Criteria andPinkStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("pink_status >=", value, "pinkStatus");
            return (Criteria) this;
        }

        public Criteria andPinkStatusLessThan(Boolean value) {
            addCriterion("pink_status <", value, "pinkStatus");
            return (Criteria) this;
        }

        public Criteria andPinkStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("pink_status <=", value, "pinkStatus");
            return (Criteria) this;
        }

        public Criteria andPinkStatusIn(List<Boolean> values) {
            addCriterion("pink_status in", values, "pinkStatus");
            return (Criteria) this;
        }

        public Criteria andPinkStatusNotIn(List<Boolean> values) {
            addCriterion("pink_status not in", values, "pinkStatus");
            return (Criteria) this;
        }

        public Criteria andPinkStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("pink_status between", value1, value2, "pinkStatus");
            return (Criteria) this;
        }

        public Criteria andPinkStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("pink_status not between", value1, value2, "pinkStatus");
            return (Criteria) this;
        }

        public Criteria andPinkTimeIsNull() {
            addCriterion("pink_time is null");
            return (Criteria) this;
        }

        public Criteria andPinkTimeIsNotNull() {
            addCriterion("pink_time is not null");
            return (Criteria) this;
        }

        public Criteria andPinkTimeEqualTo(Long value) {
            addCriterion("pink_time =", value, "pinkTime");
            return (Criteria) this;
        }

        public Criteria andPinkTimeNotEqualTo(Long value) {
            addCriterion("pink_time <>", value, "pinkTime");
            return (Criteria) this;
        }

        public Criteria andPinkTimeGreaterThan(Long value) {
            addCriterion("pink_time >", value, "pinkTime");
            return (Criteria) this;
        }

        public Criteria andPinkTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("pink_time >=", value, "pinkTime");
            return (Criteria) this;
        }

        public Criteria andPinkTimeLessThan(Long value) {
            addCriterion("pink_time <", value, "pinkTime");
            return (Criteria) this;
        }

        public Criteria andPinkTimeLessThanOrEqualTo(Long value) {
            addCriterion("pink_time <=", value, "pinkTime");
            return (Criteria) this;
        }

        public Criteria andPinkTimeIn(List<Long> values) {
            addCriterion("pink_time in", values, "pinkTime");
            return (Criteria) this;
        }

        public Criteria andPinkTimeNotIn(List<Long> values) {
            addCriterion("pink_time not in", values, "pinkTime");
            return (Criteria) this;
        }

        public Criteria andPinkTimeBetween(Long value1, Long value2) {
            addCriterion("pink_time between", value1, value2, "pinkTime");
            return (Criteria) this;
        }

        public Criteria andPinkTimeNotBetween(Long value1, Long value2) {
            addCriterion("pink_time not between", value1, value2, "pinkTime");
            return (Criteria) this;
        }

        public Criteria andIsRefundIsNull() {
            addCriterion("is_refund is null");
            return (Criteria) this;
        }

        public Criteria andIsRefundIsNotNull() {
            addCriterion("is_refund is not null");
            return (Criteria) this;
        }

        public Criteria andIsRefundEqualTo(Boolean value) {
            addCriterion("is_refund =", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotEqualTo(Boolean value) {
            addCriterion("is_refund <>", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundGreaterThan(Boolean value) {
            addCriterion("is_refund >", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_refund >=", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLessThan(Boolean value) {
            addCriterion("is_refund <", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLessThanOrEqualTo(Boolean value) {
            addCriterion("is_refund <=", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundIn(List<Boolean> values) {
            addCriterion("is_refund in", values, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotIn(List<Boolean> values) {
            addCriterion("is_refund not in", values, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundBetween(Boolean value1, Boolean value2) {
            addCriterion("is_refund between", value1, value2, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_refund not between", value1, value2, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsTplIsNull() {
            addCriterion("is_tpl is null");
            return (Criteria) this;
        }

        public Criteria andIsTplIsNotNull() {
            addCriterion("is_tpl is not null");
            return (Criteria) this;
        }

        public Criteria andIsTplEqualTo(Boolean value) {
            addCriterion("is_tpl =", value, "isTpl");
            return (Criteria) this;
        }

        public Criteria andIsTplNotEqualTo(Boolean value) {
            addCriterion("is_tpl <>", value, "isTpl");
            return (Criteria) this;
        }

        public Criteria andIsTplGreaterThan(Boolean value) {
            addCriterion("is_tpl >", value, "isTpl");
            return (Criteria) this;
        }

        public Criteria andIsTplGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_tpl >=", value, "isTpl");
            return (Criteria) this;
        }

        public Criteria andIsTplLessThan(Boolean value) {
            addCriterion("is_tpl <", value, "isTpl");
            return (Criteria) this;
        }

        public Criteria andIsTplLessThanOrEqualTo(Boolean value) {
            addCriterion("is_tpl <=", value, "isTpl");
            return (Criteria) this;
        }

        public Criteria andIsTplIn(List<Boolean> values) {
            addCriterion("is_tpl in", values, "isTpl");
            return (Criteria) this;
        }

        public Criteria andIsTplNotIn(List<Boolean> values) {
            addCriterion("is_tpl not in", values, "isTpl");
            return (Criteria) this;
        }

        public Criteria andIsTplBetween(Boolean value1, Boolean value2) {
            addCriterion("is_tpl between", value1, value2, "isTpl");
            return (Criteria) this;
        }

        public Criteria andIsTplNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_tpl not between", value1, value2, "isTpl");
            return (Criteria) this;
        }

        public Criteria andBuyerNameIsNull() {
            addCriterion("buyer_name is null");
            return (Criteria) this;
        }

        public Criteria andBuyerNameIsNotNull() {
            addCriterion("buyer_name is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerNameEqualTo(String value) {
            addCriterion("buyer_name =", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameNotEqualTo(String value) {
            addCriterion("buyer_name <>", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameGreaterThan(String value) {
            addCriterion("buyer_name >", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_name >=", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameLessThan(String value) {
            addCriterion("buyer_name <", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameLessThanOrEqualTo(String value) {
            addCriterion("buyer_name <=", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameLike(String value) {
            addCriterion("buyer_name like", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameNotLike(String value) {
            addCriterion("buyer_name not like", value, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameIn(List<String> values) {
            addCriterion("buyer_name in", values, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameNotIn(List<String> values) {
            addCriterion("buyer_name not in", values, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameBetween(String value1, String value2) {
            addCriterion("buyer_name between", value1, value2, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerNameNotBetween(String value1, String value2) {
            addCriterion("buyer_name not between", value1, value2, "buyerName");
            return (Criteria) this;
        }

        public Criteria andBuyerIconIsNull() {
            addCriterion("buyer_icon is null");
            return (Criteria) this;
        }

        public Criteria andBuyerIconIsNotNull() {
            addCriterion("buyer_icon is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerIconEqualTo(String value) {
            addCriterion("buyer_icon =", value, "buyerIcon");
            return (Criteria) this;
        }

        public Criteria andBuyerIconNotEqualTo(String value) {
            addCriterion("buyer_icon <>", value, "buyerIcon");
            return (Criteria) this;
        }

        public Criteria andBuyerIconGreaterThan(String value) {
            addCriterion("buyer_icon >", value, "buyerIcon");
            return (Criteria) this;
        }

        public Criteria andBuyerIconGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_icon >=", value, "buyerIcon");
            return (Criteria) this;
        }

        public Criteria andBuyerIconLessThan(String value) {
            addCriterion("buyer_icon <", value, "buyerIcon");
            return (Criteria) this;
        }

        public Criteria andBuyerIconLessThanOrEqualTo(String value) {
            addCriterion("buyer_icon <=", value, "buyerIcon");
            return (Criteria) this;
        }

        public Criteria andBuyerIconLike(String value) {
            addCriterion("buyer_icon like", value, "buyerIcon");
            return (Criteria) this;
        }

        public Criteria andBuyerIconNotLike(String value) {
            addCriterion("buyer_icon not like", value, "buyerIcon");
            return (Criteria) this;
        }

        public Criteria andBuyerIconIn(List<String> values) {
            addCriterion("buyer_icon in", values, "buyerIcon");
            return (Criteria) this;
        }

        public Criteria andBuyerIconNotIn(List<String> values) {
            addCriterion("buyer_icon not in", values, "buyerIcon");
            return (Criteria) this;
        }

        public Criteria andBuyerIconBetween(String value1, String value2) {
            addCriterion("buyer_icon between", value1, value2, "buyerIcon");
            return (Criteria) this;
        }

        public Criteria andBuyerIconNotBetween(String value1, String value2) {
            addCriterion("buyer_icon not between", value1, value2, "buyerIcon");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
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
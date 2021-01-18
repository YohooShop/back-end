package com.yoooho.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmsLogisticOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmsLogisticOrderExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andShipperCodeIsNull() {
            addCriterion("shipper_code is null");
            return (Criteria) this;
        }

        public Criteria andShipperCodeIsNotNull() {
            addCriterion("shipper_code is not null");
            return (Criteria) this;
        }

        public Criteria andShipperCodeEqualTo(String value) {
            addCriterion("shipper_code =", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeNotEqualTo(String value) {
            addCriterion("shipper_code <>", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeGreaterThan(String value) {
            addCriterion("shipper_code >", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeGreaterThanOrEqualTo(String value) {
            addCriterion("shipper_code >=", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeLessThan(String value) {
            addCriterion("shipper_code <", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeLessThanOrEqualTo(String value) {
            addCriterion("shipper_code <=", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeLike(String value) {
            addCriterion("shipper_code like", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeNotLike(String value) {
            addCriterion("shipper_code not like", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeIn(List<String> values) {
            addCriterion("shipper_code in", values, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeNotIn(List<String> values) {
            addCriterion("shipper_code not in", values, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeBetween(String value1, String value2) {
            addCriterion("shipper_code between", value1, value2, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeNotBetween(String value1, String value2) {
            addCriterion("shipper_code not between", value1, value2, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeIsNull() {
            addCriterion("logistic_code is null");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeIsNotNull() {
            addCriterion("logistic_code is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeEqualTo(String value) {
            addCriterion("logistic_code =", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeNotEqualTo(String value) {
            addCriterion("logistic_code <>", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeGreaterThan(String value) {
            addCriterion("logistic_code >", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeGreaterThanOrEqualTo(String value) {
            addCriterion("logistic_code >=", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeLessThan(String value) {
            addCriterion("logistic_code <", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeLessThanOrEqualTo(String value) {
            addCriterion("logistic_code <=", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeLike(String value) {
            addCriterion("logistic_code like", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeNotLike(String value) {
            addCriterion("logistic_code not like", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeIn(List<String> values) {
            addCriterion("logistic_code in", values, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeNotIn(List<String> values) {
            addCriterion("logistic_code not in", values, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeBetween(String value1, String value2) {
            addCriterion("logistic_code between", value1, value2, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeNotBetween(String value1, String value2) {
            addCriterion("logistic_code not between", value1, value2, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andSenderNameIsNull() {
            addCriterion("sender_name is null");
            return (Criteria) this;
        }

        public Criteria andSenderNameIsNotNull() {
            addCriterion("sender_name is not null");
            return (Criteria) this;
        }

        public Criteria andSenderNameEqualTo(String value) {
            addCriterion("sender_name =", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotEqualTo(String value) {
            addCriterion("sender_name <>", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameGreaterThan(String value) {
            addCriterion("sender_name >", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameGreaterThanOrEqualTo(String value) {
            addCriterion("sender_name >=", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLessThan(String value) {
            addCriterion("sender_name <", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLessThanOrEqualTo(String value) {
            addCriterion("sender_name <=", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLike(String value) {
            addCriterion("sender_name like", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotLike(String value) {
            addCriterion("sender_name not like", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameIn(List<String> values) {
            addCriterion("sender_name in", values, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotIn(List<String> values) {
            addCriterion("sender_name not in", values, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameBetween(String value1, String value2) {
            addCriterion("sender_name between", value1, value2, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotBetween(String value1, String value2) {
            addCriterion("sender_name not between", value1, value2, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderTelIsNull() {
            addCriterion("sender_tel is null");
            return (Criteria) this;
        }

        public Criteria andSenderTelIsNotNull() {
            addCriterion("sender_tel is not null");
            return (Criteria) this;
        }

        public Criteria andSenderTelEqualTo(String value) {
            addCriterion("sender_tel =", value, "senderTel");
            return (Criteria) this;
        }

        public Criteria andSenderTelNotEqualTo(String value) {
            addCriterion("sender_tel <>", value, "senderTel");
            return (Criteria) this;
        }

        public Criteria andSenderTelGreaterThan(String value) {
            addCriterion("sender_tel >", value, "senderTel");
            return (Criteria) this;
        }

        public Criteria andSenderTelGreaterThanOrEqualTo(String value) {
            addCriterion("sender_tel >=", value, "senderTel");
            return (Criteria) this;
        }

        public Criteria andSenderTelLessThan(String value) {
            addCriterion("sender_tel <", value, "senderTel");
            return (Criteria) this;
        }

        public Criteria andSenderTelLessThanOrEqualTo(String value) {
            addCriterion("sender_tel <=", value, "senderTel");
            return (Criteria) this;
        }

        public Criteria andSenderTelLike(String value) {
            addCriterion("sender_tel like", value, "senderTel");
            return (Criteria) this;
        }

        public Criteria andSenderTelNotLike(String value) {
            addCriterion("sender_tel not like", value, "senderTel");
            return (Criteria) this;
        }

        public Criteria andSenderTelIn(List<String> values) {
            addCriterion("sender_tel in", values, "senderTel");
            return (Criteria) this;
        }

        public Criteria andSenderTelNotIn(List<String> values) {
            addCriterion("sender_tel not in", values, "senderTel");
            return (Criteria) this;
        }

        public Criteria andSenderTelBetween(String value1, String value2) {
            addCriterion("sender_tel between", value1, value2, "senderTel");
            return (Criteria) this;
        }

        public Criteria andSenderTelNotBetween(String value1, String value2) {
            addCriterion("sender_tel not between", value1, value2, "senderTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelIsNull() {
            addCriterion("receiver_tel is null");
            return (Criteria) this;
        }

        public Criteria andReceiverTelIsNotNull() {
            addCriterion("receiver_tel is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverTelEqualTo(String value) {
            addCriterion("receiver_tel =", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotEqualTo(String value) {
            addCriterion("receiver_tel <>", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelGreaterThan(String value) {
            addCriterion("receiver_tel >", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_tel >=", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelLessThan(String value) {
            addCriterion("receiver_tel <", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelLessThanOrEqualTo(String value) {
            addCriterion("receiver_tel <=", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelLike(String value) {
            addCriterion("receiver_tel like", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotLike(String value) {
            addCriterion("receiver_tel not like", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelIn(List<String> values) {
            addCriterion("receiver_tel in", values, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotIn(List<String> values) {
            addCriterion("receiver_tel not in", values, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelBetween(String value1, String value2) {
            addCriterion("receiver_tel between", value1, value2, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotBetween(String value1, String value2) {
            addCriterion("receiver_tel not between", value1, value2, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeIsNull() {
            addCriterion("kdn_order_code is null");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeIsNotNull() {
            addCriterion("kdn_order_code is not null");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeEqualTo(String value) {
            addCriterion("kdn_order_code =", value, "kdnOrderCode");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeNotEqualTo(String value) {
            addCriterion("kdn_order_code <>", value, "kdnOrderCode");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeGreaterThan(String value) {
            addCriterion("kdn_order_code >", value, "kdnOrderCode");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("kdn_order_code >=", value, "kdnOrderCode");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeLessThan(String value) {
            addCriterion("kdn_order_code <", value, "kdnOrderCode");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("kdn_order_code <=", value, "kdnOrderCode");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeLike(String value) {
            addCriterion("kdn_order_code like", value, "kdnOrderCode");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeNotLike(String value) {
            addCriterion("kdn_order_code not like", value, "kdnOrderCode");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeIn(List<String> values) {
            addCriterion("kdn_order_code in", values, "kdnOrderCode");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeNotIn(List<String> values) {
            addCriterion("kdn_order_code not in", values, "kdnOrderCode");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeBetween(String value1, String value2) {
            addCriterion("kdn_order_code between", value1, value2, "kdnOrderCode");
            return (Criteria) this;
        }

        public Criteria andKdnOrderCodeNotBetween(String value1, String value2) {
            addCriterion("kdn_order_code not between", value1, value2, "kdnOrderCode");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeIsNull() {
            addCriterion("thr_order_code is null");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeIsNotNull() {
            addCriterion("thr_order_code is not null");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeEqualTo(String value) {
            addCriterion("thr_order_code =", value, "thrOrderCode");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeNotEqualTo(String value) {
            addCriterion("thr_order_code <>", value, "thrOrderCode");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeGreaterThan(String value) {
            addCriterion("thr_order_code >", value, "thrOrderCode");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("thr_order_code >=", value, "thrOrderCode");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeLessThan(String value) {
            addCriterion("thr_order_code <", value, "thrOrderCode");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("thr_order_code <=", value, "thrOrderCode");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeLike(String value) {
            addCriterion("thr_order_code like", value, "thrOrderCode");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeNotLike(String value) {
            addCriterion("thr_order_code not like", value, "thrOrderCode");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeIn(List<String> values) {
            addCriterion("thr_order_code in", values, "thrOrderCode");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeNotIn(List<String> values) {
            addCriterion("thr_order_code not in", values, "thrOrderCode");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeBetween(String value1, String value2) {
            addCriterion("thr_order_code between", value1, value2, "thrOrderCode");
            return (Criteria) this;
        }

        public Criteria andThrOrderCodeNotBetween(String value1, String value2) {
            addCriterion("thr_order_code not between", value1, value2, "thrOrderCode");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIsNull() {
            addCriterion("commodity_name is null");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIsNotNull() {
            addCriterion("commodity_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityNameEqualTo(String value) {
            addCriterion("commodity_name =", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotEqualTo(String value) {
            addCriterion("commodity_name <>", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameGreaterThan(String value) {
            addCriterion("commodity_name >", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_name >=", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLessThan(String value) {
            addCriterion("commodity_name <", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLessThanOrEqualTo(String value) {
            addCriterion("commodity_name <=", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLike(String value) {
            addCriterion("commodity_name like", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotLike(String value) {
            addCriterion("commodity_name not like", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIn(List<String> values) {
            addCriterion("commodity_name in", values, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotIn(List<String> values) {
            addCriterion("commodity_name not in", values, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameBetween(String value1, String value2) {
            addCriterion("commodity_name between", value1, value2, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotBetween(String value1, String value2) {
            addCriterion("commodity_name not between", value1, value2, "commodityName");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andExpTypeIsNull() {
            addCriterion("exp_type is null");
            return (Criteria) this;
        }

        public Criteria andExpTypeIsNotNull() {
            addCriterion("exp_type is not null");
            return (Criteria) this;
        }

        public Criteria andExpTypeEqualTo(String value) {
            addCriterion("exp_type =", value, "expType");
            return (Criteria) this;
        }

        public Criteria andExpTypeNotEqualTo(String value) {
            addCriterion("exp_type <>", value, "expType");
            return (Criteria) this;
        }

        public Criteria andExpTypeGreaterThan(String value) {
            addCriterion("exp_type >", value, "expType");
            return (Criteria) this;
        }

        public Criteria andExpTypeGreaterThanOrEqualTo(String value) {
            addCriterion("exp_type >=", value, "expType");
            return (Criteria) this;
        }

        public Criteria andExpTypeLessThan(String value) {
            addCriterion("exp_type <", value, "expType");
            return (Criteria) this;
        }

        public Criteria andExpTypeLessThanOrEqualTo(String value) {
            addCriterion("exp_type <=", value, "expType");
            return (Criteria) this;
        }

        public Criteria andExpTypeLike(String value) {
            addCriterion("exp_type like", value, "expType");
            return (Criteria) this;
        }

        public Criteria andExpTypeNotLike(String value) {
            addCriterion("exp_type not like", value, "expType");
            return (Criteria) this;
        }

        public Criteria andExpTypeIn(List<String> values) {
            addCriterion("exp_type in", values, "expType");
            return (Criteria) this;
        }

        public Criteria andExpTypeNotIn(List<String> values) {
            addCriterion("exp_type not in", values, "expType");
            return (Criteria) this;
        }

        public Criteria andExpTypeBetween(String value1, String value2) {
            addCriterion("exp_type between", value1, value2, "expType");
            return (Criteria) this;
        }

        public Criteria andExpTypeNotBetween(String value1, String value2) {
            addCriterion("exp_type not between", value1, value2, "expType");
            return (Criteria) this;
        }

        public Criteria andSenderMobileIsNull() {
            addCriterion("sender_mobile is null");
            return (Criteria) this;
        }

        public Criteria andSenderMobileIsNotNull() {
            addCriterion("sender_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andSenderMobileEqualTo(String value) {
            addCriterion("sender_mobile =", value, "senderMobile");
            return (Criteria) this;
        }

        public Criteria andSenderMobileNotEqualTo(String value) {
            addCriterion("sender_mobile <>", value, "senderMobile");
            return (Criteria) this;
        }

        public Criteria andSenderMobileGreaterThan(String value) {
            addCriterion("sender_mobile >", value, "senderMobile");
            return (Criteria) this;
        }

        public Criteria andSenderMobileGreaterThanOrEqualTo(String value) {
            addCriterion("sender_mobile >=", value, "senderMobile");
            return (Criteria) this;
        }

        public Criteria andSenderMobileLessThan(String value) {
            addCriterion("sender_mobile <", value, "senderMobile");
            return (Criteria) this;
        }

        public Criteria andSenderMobileLessThanOrEqualTo(String value) {
            addCriterion("sender_mobile <=", value, "senderMobile");
            return (Criteria) this;
        }

        public Criteria andSenderMobileLike(String value) {
            addCriterion("sender_mobile like", value, "senderMobile");
            return (Criteria) this;
        }

        public Criteria andSenderMobileNotLike(String value) {
            addCriterion("sender_mobile not like", value, "senderMobile");
            return (Criteria) this;
        }

        public Criteria andSenderMobileIn(List<String> values) {
            addCriterion("sender_mobile in", values, "senderMobile");
            return (Criteria) this;
        }

        public Criteria andSenderMobileNotIn(List<String> values) {
            addCriterion("sender_mobile not in", values, "senderMobile");
            return (Criteria) this;
        }

        public Criteria andSenderMobileBetween(String value1, String value2) {
            addCriterion("sender_mobile between", value1, value2, "senderMobile");
            return (Criteria) this;
        }

        public Criteria andSenderMobileNotBetween(String value1, String value2) {
            addCriterion("sender_mobile not between", value1, value2, "senderMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIsNull() {
            addCriterion("receiver_mobile is null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIsNotNull() {
            addCriterion("receiver_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileEqualTo(String value) {
            addCriterion("receiver_mobile =", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotEqualTo(String value) {
            addCriterion("receiver_mobile <>", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThan(String value) {
            addCriterion("receiver_mobile >", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_mobile >=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThan(String value) {
            addCriterion("receiver_mobile <", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThanOrEqualTo(String value) {
            addCriterion("receiver_mobile <=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLike(String value) {
            addCriterion("receiver_mobile like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotLike(String value) {
            addCriterion("receiver_mobile not like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIn(List<String> values) {
            addCriterion("receiver_mobile in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotIn(List<String> values) {
            addCriterion("receiver_mobile not in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileBetween(String value1, String value2) {
            addCriterion("receiver_mobile between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotBetween(String value1, String value2) {
            addCriterion("receiver_mobile not between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceIsNull() {
            addCriterion("sender_province is null");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceIsNotNull() {
            addCriterion("sender_province is not null");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceEqualTo(String value) {
            addCriterion("sender_province =", value, "senderProvince");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceNotEqualTo(String value) {
            addCriterion("sender_province <>", value, "senderProvince");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceGreaterThan(String value) {
            addCriterion("sender_province >", value, "senderProvince");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("sender_province >=", value, "senderProvince");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceLessThan(String value) {
            addCriterion("sender_province <", value, "senderProvince");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceLessThanOrEqualTo(String value) {
            addCriterion("sender_province <=", value, "senderProvince");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceLike(String value) {
            addCriterion("sender_province like", value, "senderProvince");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceNotLike(String value) {
            addCriterion("sender_province not like", value, "senderProvince");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceIn(List<String> values) {
            addCriterion("sender_province in", values, "senderProvince");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceNotIn(List<String> values) {
            addCriterion("sender_province not in", values, "senderProvince");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceBetween(String value1, String value2) {
            addCriterion("sender_province between", value1, value2, "senderProvince");
            return (Criteria) this;
        }

        public Criteria andSenderProvinceNotBetween(String value1, String value2) {
            addCriterion("sender_province not between", value1, value2, "senderProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceIsNull() {
            addCriterion("receiver_province is null");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceIsNotNull() {
            addCriterion("receiver_province is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceEqualTo(String value) {
            addCriterion("receiver_province =", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNotEqualTo(String value) {
            addCriterion("receiver_province <>", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceGreaterThan(String value) {
            addCriterion("receiver_province >", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_province >=", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceLessThan(String value) {
            addCriterion("receiver_province <", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceLessThanOrEqualTo(String value) {
            addCriterion("receiver_province <=", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceLike(String value) {
            addCriterion("receiver_province like", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNotLike(String value) {
            addCriterion("receiver_province not like", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceIn(List<String> values) {
            addCriterion("receiver_province in", values, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNotIn(List<String> values) {
            addCriterion("receiver_province not in", values, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceBetween(String value1, String value2) {
            addCriterion("receiver_province between", value1, value2, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNotBetween(String value1, String value2) {
            addCriterion("receiver_province not between", value1, value2, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNull() {
            addCriterion("package_name is null");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNotNull() {
            addCriterion("package_name is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNameEqualTo(String value) {
            addCriterion("package_name =", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotEqualTo(String value) {
            addCriterion("package_name <>", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThan(String value) {
            addCriterion("package_name >", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            addCriterion("package_name >=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThan(String value) {
            addCriterion("package_name <", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThanOrEqualTo(String value) {
            addCriterion("package_name <=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLike(String value) {
            addCriterion("package_name like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotLike(String value) {
            addCriterion("package_name not like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameIn(List<String> values) {
            addCriterion("package_name in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotIn(List<String> values) {
            addCriterion("package_name not in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameBetween(String value1, String value2) {
            addCriterion("package_name between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotBetween(String value1, String value2) {
            addCriterion("package_name not between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andSenderCityIsNull() {
            addCriterion("sender_city is null");
            return (Criteria) this;
        }

        public Criteria andSenderCityIsNotNull() {
            addCriterion("sender_city is not null");
            return (Criteria) this;
        }

        public Criteria andSenderCityEqualTo(String value) {
            addCriterion("sender_city =", value, "senderCity");
            return (Criteria) this;
        }

        public Criteria andSenderCityNotEqualTo(String value) {
            addCriterion("sender_city <>", value, "senderCity");
            return (Criteria) this;
        }

        public Criteria andSenderCityGreaterThan(String value) {
            addCriterion("sender_city >", value, "senderCity");
            return (Criteria) this;
        }

        public Criteria andSenderCityGreaterThanOrEqualTo(String value) {
            addCriterion("sender_city >=", value, "senderCity");
            return (Criteria) this;
        }

        public Criteria andSenderCityLessThan(String value) {
            addCriterion("sender_city <", value, "senderCity");
            return (Criteria) this;
        }

        public Criteria andSenderCityLessThanOrEqualTo(String value) {
            addCriterion("sender_city <=", value, "senderCity");
            return (Criteria) this;
        }

        public Criteria andSenderCityLike(String value) {
            addCriterion("sender_city like", value, "senderCity");
            return (Criteria) this;
        }

        public Criteria andSenderCityNotLike(String value) {
            addCriterion("sender_city not like", value, "senderCity");
            return (Criteria) this;
        }

        public Criteria andSenderCityIn(List<String> values) {
            addCriterion("sender_city in", values, "senderCity");
            return (Criteria) this;
        }

        public Criteria andSenderCityNotIn(List<String> values) {
            addCriterion("sender_city not in", values, "senderCity");
            return (Criteria) this;
        }

        public Criteria andSenderCityBetween(String value1, String value2) {
            addCriterion("sender_city between", value1, value2, "senderCity");
            return (Criteria) this;
        }

        public Criteria andSenderCityNotBetween(String value1, String value2) {
            addCriterion("sender_city not between", value1, value2, "senderCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityIsNull() {
            addCriterion("receiver_city is null");
            return (Criteria) this;
        }

        public Criteria andReceiverCityIsNotNull() {
            addCriterion("receiver_city is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverCityEqualTo(String value) {
            addCriterion("receiver_city =", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotEqualTo(String value) {
            addCriterion("receiver_city <>", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityGreaterThan(String value) {
            addCriterion("receiver_city >", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_city >=", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityLessThan(String value) {
            addCriterion("receiver_city <", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityLessThanOrEqualTo(String value) {
            addCriterion("receiver_city <=", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityLike(String value) {
            addCriterion("receiver_city like", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotLike(String value) {
            addCriterion("receiver_city not like", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityIn(List<String> values) {
            addCriterion("receiver_city in", values, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotIn(List<String> values) {
            addCriterion("receiver_city not in", values, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityBetween(String value1, String value2) {
            addCriterion("receiver_city between", value1, value2, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotBetween(String value1, String value2) {
            addCriterion("receiver_city not between", value1, value2, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaIsNull() {
            addCriterion("sender_expArea is null");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaIsNotNull() {
            addCriterion("sender_expArea is not null");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaEqualTo(String value) {
            addCriterion("sender_expArea =", value, "senderExparea");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaNotEqualTo(String value) {
            addCriterion("sender_expArea <>", value, "senderExparea");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaGreaterThan(String value) {
            addCriterion("sender_expArea >", value, "senderExparea");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaGreaterThanOrEqualTo(String value) {
            addCriterion("sender_expArea >=", value, "senderExparea");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaLessThan(String value) {
            addCriterion("sender_expArea <", value, "senderExparea");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaLessThanOrEqualTo(String value) {
            addCriterion("sender_expArea <=", value, "senderExparea");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaLike(String value) {
            addCriterion("sender_expArea like", value, "senderExparea");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaNotLike(String value) {
            addCriterion("sender_expArea not like", value, "senderExparea");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaIn(List<String> values) {
            addCriterion("sender_expArea in", values, "senderExparea");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaNotIn(List<String> values) {
            addCriterion("sender_expArea not in", values, "senderExparea");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaBetween(String value1, String value2) {
            addCriterion("sender_expArea between", value1, value2, "senderExparea");
            return (Criteria) this;
        }

        public Criteria andSenderExpareaNotBetween(String value1, String value2) {
            addCriterion("sender_expArea not between", value1, value2, "senderExparea");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaIsNull() {
            addCriterion("receiver_expArea is null");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaIsNotNull() {
            addCriterion("receiver_expArea is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaEqualTo(String value) {
            addCriterion("receiver_expArea =", value, "receiverExparea");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaNotEqualTo(String value) {
            addCriterion("receiver_expArea <>", value, "receiverExparea");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaGreaterThan(String value) {
            addCriterion("receiver_expArea >", value, "receiverExparea");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_expArea >=", value, "receiverExparea");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaLessThan(String value) {
            addCriterion("receiver_expArea <", value, "receiverExparea");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaLessThanOrEqualTo(String value) {
            addCriterion("receiver_expArea <=", value, "receiverExparea");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaLike(String value) {
            addCriterion("receiver_expArea like", value, "receiverExparea");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaNotLike(String value) {
            addCriterion("receiver_expArea not like", value, "receiverExparea");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaIn(List<String> values) {
            addCriterion("receiver_expArea in", values, "receiverExparea");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaNotIn(List<String> values) {
            addCriterion("receiver_expArea not in", values, "receiverExparea");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaBetween(String value1, String value2) {
            addCriterion("receiver_expArea between", value1, value2, "receiverExparea");
            return (Criteria) this;
        }

        public Criteria andReceiverExpareaNotBetween(String value1, String value2) {
            addCriterion("receiver_expArea not between", value1, value2, "receiverExparea");
            return (Criteria) this;
        }

        public Criteria andCreatimeIsNull() {
            addCriterion("creatime is null");
            return (Criteria) this;
        }

        public Criteria andCreatimeIsNotNull() {
            addCriterion("creatime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatimeEqualTo(Date value) {
            addCriterion("creatime =", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeNotEqualTo(Date value) {
            addCriterion("creatime <>", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeGreaterThan(Date value) {
            addCriterion("creatime >", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creatime >=", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeLessThan(Date value) {
            addCriterion("creatime <", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeLessThanOrEqualTo(Date value) {
            addCriterion("creatime <=", value, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeIn(List<Date> values) {
            addCriterion("creatime in", values, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeNotIn(List<Date> values) {
            addCriterion("creatime not in", values, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeBetween(Date value1, Date value2) {
            addCriterion("creatime between", value1, value2, "creatime");
            return (Criteria) this;
        }

        public Criteria andCreatimeNotBetween(Date value1, Date value2) {
            addCriterion("creatime not between", value1, value2, "creatime");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNull() {
            addCriterion("order_sn is null");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSnEqualTo(String value) {
            addCriterion("order_sn =", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThan(String value) {
            addCriterion("order_sn >", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThan(String value) {
            addCriterion("order_sn <", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLike(String value) {
            addCriterion("order_sn like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotLike(String value) {
            addCriterion("order_sn not like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnIn(List<String> values) {
            addCriterion("order_sn in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotIn(List<String> values) {
            addCriterion("order_sn not in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "orderSn");
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

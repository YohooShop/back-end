package com.yoooho.mall.model;

import java.util.ArrayList;
import java.util.List;

public class OmsLogisticExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmsLogisticExample() {
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

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andEbusinessidIsNull() {
            addCriterion("eBusinessID is null");
            return (Criteria) this;
        }

        public Criteria andEbusinessidIsNotNull() {
            addCriterion("eBusinessID is not null");
            return (Criteria) this;
        }

        public Criteria andEbusinessidEqualTo(String value) {
            addCriterion("eBusinessID =", value, "ebusinessid");
            return (Criteria) this;
        }

        public Criteria andEbusinessidNotEqualTo(String value) {
            addCriterion("eBusinessID <>", value, "ebusinessid");
            return (Criteria) this;
        }

        public Criteria andEbusinessidGreaterThan(String value) {
            addCriterion("eBusinessID >", value, "ebusinessid");
            return (Criteria) this;
        }

        public Criteria andEbusinessidGreaterThanOrEqualTo(String value) {
            addCriterion("eBusinessID >=", value, "ebusinessid");
            return (Criteria) this;
        }

        public Criteria andEbusinessidLessThan(String value) {
            addCriterion("eBusinessID <", value, "ebusinessid");
            return (Criteria) this;
        }

        public Criteria andEbusinessidLessThanOrEqualTo(String value) {
            addCriterion("eBusinessID <=", value, "ebusinessid");
            return (Criteria) this;
        }

        public Criteria andEbusinessidLike(String value) {
            addCriterion("eBusinessID like", value, "ebusinessid");
            return (Criteria) this;
        }

        public Criteria andEbusinessidNotLike(String value) {
            addCriterion("eBusinessID not like", value, "ebusinessid");
            return (Criteria) this;
        }

        public Criteria andEbusinessidIn(List<String> values) {
            addCriterion("eBusinessID in", values, "ebusinessid");
            return (Criteria) this;
        }

        public Criteria andEbusinessidNotIn(List<String> values) {
            addCriterion("eBusinessID not in", values, "ebusinessid");
            return (Criteria) this;
        }

        public Criteria andEbusinessidBetween(String value1, String value2) {
            addCriterion("eBusinessID between", value1, value2, "ebusinessid");
            return (Criteria) this;
        }

        public Criteria andEbusinessidNotBetween(String value1, String value2) {
            addCriterion("eBusinessID not between", value1, value2, "ebusinessid");
            return (Criteria) this;
        }

        public Criteria andOrdercodeIsNull() {
            addCriterion("orderCode is null");
            return (Criteria) this;
        }

        public Criteria andOrdercodeIsNotNull() {
            addCriterion("orderCode is not null");
            return (Criteria) this;
        }

        public Criteria andOrdercodeEqualTo(String value) {
            addCriterion("orderCode =", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotEqualTo(String value) {
            addCriterion("orderCode <>", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeGreaterThan(String value) {
            addCriterion("orderCode >", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeGreaterThanOrEqualTo(String value) {
            addCriterion("orderCode >=", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeLessThan(String value) {
            addCriterion("orderCode <", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeLessThanOrEqualTo(String value) {
            addCriterion("orderCode <=", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeLike(String value) {
            addCriterion("orderCode like", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotLike(String value) {
            addCriterion("orderCode not like", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeIn(List<String> values) {
            addCriterion("orderCode in", values, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotIn(List<String> values) {
            addCriterion("orderCode not in", values, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeBetween(String value1, String value2) {
            addCriterion("orderCode between", value1, value2, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotBetween(String value1, String value2) {
            addCriterion("orderCode not between", value1, value2, "ordercode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeIsNull() {
            addCriterion("logisticCode is null");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeIsNotNull() {
            addCriterion("logisticCode is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeEqualTo(String value) {
            addCriterion("logisticCode =", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeNotEqualTo(String value) {
            addCriterion("logisticCode <>", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeGreaterThan(String value) {
            addCriterion("logisticCode >", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeGreaterThanOrEqualTo(String value) {
            addCriterion("logisticCode >=", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeLessThan(String value) {
            addCriterion("logisticCode <", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeLessThanOrEqualTo(String value) {
            addCriterion("logisticCode <=", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeLike(String value) {
            addCriterion("logisticCode like", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeNotLike(String value) {
            addCriterion("logisticCode not like", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeIn(List<String> values) {
            addCriterion("logisticCode in", values, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeNotIn(List<String> values) {
            addCriterion("logisticCode not in", values, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeBetween(String value1, String value2) {
            addCriterion("logisticCode between", value1, value2, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeNotBetween(String value1, String value2) {
            addCriterion("logisticCode not between", value1, value2, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andShippercodeIsNull() {
            addCriterion("shipperCode is null");
            return (Criteria) this;
        }

        public Criteria andShippercodeIsNotNull() {
            addCriterion("shipperCode is not null");
            return (Criteria) this;
        }

        public Criteria andShippercodeEqualTo(Integer value) {
            addCriterion("shipperCode =", value, "shippercode");
            return (Criteria) this;
        }

        public Criteria andShippercodeNotEqualTo(Integer value) {
            addCriterion("shipperCode <>", value, "shippercode");
            return (Criteria) this;
        }

        public Criteria andShippercodeGreaterThan(Integer value) {
            addCriterion("shipperCode >", value, "shippercode");
            return (Criteria) this;
        }

        public Criteria andShippercodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shipperCode >=", value, "shippercode");
            return (Criteria) this;
        }

        public Criteria andShippercodeLessThan(Integer value) {
            addCriterion("shipperCode <", value, "shippercode");
            return (Criteria) this;
        }

        public Criteria andShippercodeLessThanOrEqualTo(Integer value) {
            addCriterion("shipperCode <=", value, "shippercode");
            return (Criteria) this;
        }

        public Criteria andShippercodeIn(List<Integer> values) {
            addCriterion("shipperCode in", values, "shippercode");
            return (Criteria) this;
        }

        public Criteria andShippercodeNotIn(List<Integer> values) {
            addCriterion("shipperCode not in", values, "shippercode");
            return (Criteria) this;
        }

        public Criteria andShippercodeBetween(Integer value1, Integer value2) {
            addCriterion("shipperCode between", value1, value2, "shippercode");
            return (Criteria) this;
        }

        public Criteria andShippercodeNotBetween(Integer value1, Integer value2) {
            addCriterion("shipperCode not between", value1, value2, "shippercode");
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
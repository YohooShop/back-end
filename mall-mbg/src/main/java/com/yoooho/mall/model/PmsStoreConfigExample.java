package com.yoooho.mall.model;

import java.util.ArrayList;
import java.util.List;

public class PmsStoreConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsStoreConfigExample() {
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

        public Criteria andMapKeyIsNull() {
            addCriterion("map_key is null");
            return (Criteria) this;
        }

        public Criteria andMapKeyIsNotNull() {
            addCriterion("map_key is not null");
            return (Criteria) this;
        }

        public Criteria andMapKeyEqualTo(String value) {
            addCriterion("map_key =", value, "mapKey");
            return (Criteria) this;
        }

        public Criteria andMapKeyNotEqualTo(String value) {
            addCriterion("map_key <>", value, "mapKey");
            return (Criteria) this;
        }

        public Criteria andMapKeyGreaterThan(String value) {
            addCriterion("map_key >", value, "mapKey");
            return (Criteria) this;
        }

        public Criteria andMapKeyGreaterThanOrEqualTo(String value) {
            addCriterion("map_key >=", value, "mapKey");
            return (Criteria) this;
        }

        public Criteria andMapKeyLessThan(String value) {
            addCriterion("map_key <", value, "mapKey");
            return (Criteria) this;
        }

        public Criteria andMapKeyLessThanOrEqualTo(String value) {
            addCriterion("map_key <=", value, "mapKey");
            return (Criteria) this;
        }

        public Criteria andMapKeyLike(String value) {
            addCriterion("map_key like", value, "mapKey");
            return (Criteria) this;
        }

        public Criteria andMapKeyNotLike(String value) {
            addCriterion("map_key not like", value, "mapKey");
            return (Criteria) this;
        }

        public Criteria andMapKeyIn(List<String> values) {
            addCriterion("map_key in", values, "mapKey");
            return (Criteria) this;
        }

        public Criteria andMapKeyNotIn(List<String> values) {
            addCriterion("map_key not in", values, "mapKey");
            return (Criteria) this;
        }

        public Criteria andMapKeyBetween(String value1, String value2) {
            addCriterion("map_key between", value1, value2, "mapKey");
            return (Criteria) this;
        }

        public Criteria andMapKeyNotBetween(String value1, String value2) {
            addCriterion("map_key not between", value1, value2, "mapKey");
            return (Criteria) this;
        }

        public Criteria andOpenStatusIsNull() {
            addCriterion("open_status is null");
            return (Criteria) this;
        }

        public Criteria andOpenStatusIsNotNull() {
            addCriterion("open_status is not null");
            return (Criteria) this;
        }

        public Criteria andOpenStatusEqualTo(Boolean value) {
            addCriterion("open_status =", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusNotEqualTo(Boolean value) {
            addCriterion("open_status <>", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusGreaterThan(Boolean value) {
            addCriterion("open_status >", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("open_status >=", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusLessThan(Boolean value) {
            addCriterion("open_status <", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("open_status <=", value, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusIn(List<Boolean> values) {
            addCriterion("open_status in", values, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusNotIn(List<Boolean> values) {
            addCriterion("open_status not in", values, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("open_status between", value1, value2, "openStatus");
            return (Criteria) this;
        }

        public Criteria andOpenStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("open_status not between", value1, value2, "openStatus");
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
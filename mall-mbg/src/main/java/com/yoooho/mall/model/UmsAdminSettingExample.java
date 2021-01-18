package com.yoooho.mall.model;

import java.util.ArrayList;
import java.util.List;

public class UmsAdminSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsAdminSettingExample() {
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

        public Criteria andNotificationFormMailIsNull() {
            addCriterion("notification_form_mail is null");
            return (Criteria) this;
        }

        public Criteria andNotificationFormMailIsNotNull() {
            addCriterion("notification_form_mail is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationFormMailEqualTo(String value) {
            addCriterion("notification_form_mail =", value, "notificationFormMail");
            return (Criteria) this;
        }

        public Criteria andNotificationFormMailNotEqualTo(String value) {
            addCriterion("notification_form_mail <>", value, "notificationFormMail");
            return (Criteria) this;
        }

        public Criteria andNotificationFormMailGreaterThan(String value) {
            addCriterion("notification_form_mail >", value, "notificationFormMail");
            return (Criteria) this;
        }

        public Criteria andNotificationFormMailGreaterThanOrEqualTo(String value) {
            addCriterion("notification_form_mail >=", value, "notificationFormMail");
            return (Criteria) this;
        }

        public Criteria andNotificationFormMailLessThan(String value) {
            addCriterion("notification_form_mail <", value, "notificationFormMail");
            return (Criteria) this;
        }

        public Criteria andNotificationFormMailLessThanOrEqualTo(String value) {
            addCriterion("notification_form_mail <=", value, "notificationFormMail");
            return (Criteria) this;
        }

        public Criteria andNotificationFormMailLike(String value) {
            addCriterion("notification_form_mail like", value, "notificationFormMail");
            return (Criteria) this;
        }

        public Criteria andNotificationFormMailNotLike(String value) {
            addCriterion("notification_form_mail not like", value, "notificationFormMail");
            return (Criteria) this;
        }

        public Criteria andNotificationFormMailIn(List<String> values) {
            addCriterion("notification_form_mail in", values, "notificationFormMail");
            return (Criteria) this;
        }

        public Criteria andNotificationFormMailNotIn(List<String> values) {
            addCriterion("notification_form_mail not in", values, "notificationFormMail");
            return (Criteria) this;
        }

        public Criteria andNotificationFormMailBetween(String value1, String value2) {
            addCriterion("notification_form_mail between", value1, value2, "notificationFormMail");
            return (Criteria) this;
        }

        public Criteria andNotificationFormMailNotBetween(String value1, String value2) {
            addCriterion("notification_form_mail not between", value1, value2, "notificationFormMail");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailIsNull() {
            addCriterion("notification_to_mail is null");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailIsNotNull() {
            addCriterion("notification_to_mail is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailEqualTo(String value) {
            addCriterion("notification_to_mail =", value, "notificationToMail");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailNotEqualTo(String value) {
            addCriterion("notification_to_mail <>", value, "notificationToMail");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailGreaterThan(String value) {
            addCriterion("notification_to_mail >", value, "notificationToMail");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailGreaterThanOrEqualTo(String value) {
            addCriterion("notification_to_mail >=", value, "notificationToMail");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailLessThan(String value) {
            addCriterion("notification_to_mail <", value, "notificationToMail");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailLessThanOrEqualTo(String value) {
            addCriterion("notification_to_mail <=", value, "notificationToMail");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailLike(String value) {
            addCriterion("notification_to_mail like", value, "notificationToMail");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailNotLike(String value) {
            addCriterion("notification_to_mail not like", value, "notificationToMail");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailIn(List<String> values) {
            addCriterion("notification_to_mail in", values, "notificationToMail");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailNotIn(List<String> values) {
            addCriterion("notification_to_mail not in", values, "notificationToMail");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailBetween(String value1, String value2) {
            addCriterion("notification_to_mail between", value1, value2, "notificationToMail");
            return (Criteria) this;
        }

        public Criteria andNotificationToMailNotBetween(String value1, String value2) {
            addCriterion("notification_to_mail not between", value1, value2, "notificationToMail");
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
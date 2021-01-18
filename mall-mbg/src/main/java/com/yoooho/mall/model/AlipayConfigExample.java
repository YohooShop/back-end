package com.yoooho.mall.model;

import java.util.ArrayList;
import java.util.List;

public class AlipayConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlipayConfigExample() {
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andCharsetIsNull() {
            addCriterion("charset is null");
            return (Criteria) this;
        }

        public Criteria andCharsetIsNotNull() {
            addCriterion("charset is not null");
            return (Criteria) this;
        }

        public Criteria andCharsetEqualTo(String value) {
            addCriterion("charset =", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotEqualTo(String value) {
            addCriterion("charset <>", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetGreaterThan(String value) {
            addCriterion("charset >", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetGreaterThanOrEqualTo(String value) {
            addCriterion("charset >=", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetLessThan(String value) {
            addCriterion("charset <", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetLessThanOrEqualTo(String value) {
            addCriterion("charset <=", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetLike(String value) {
            addCriterion("charset like", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotLike(String value) {
            addCriterion("charset not like", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetIn(List<String> values) {
            addCriterion("charset in", values, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotIn(List<String> values) {
            addCriterion("charset not in", values, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetBetween(String value1, String value2) {
            addCriterion("charset between", value1, value2, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotBetween(String value1, String value2) {
            addCriterion("charset not between", value1, value2, "charset");
            return (Criteria) this;
        }

        public Criteria andFormatIsNull() {
            addCriterion("format is null");
            return (Criteria) this;
        }

        public Criteria andFormatIsNotNull() {
            addCriterion("format is not null");
            return (Criteria) this;
        }

        public Criteria andFormatEqualTo(String value) {
            addCriterion("format =", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotEqualTo(String value) {
            addCriterion("format <>", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatGreaterThan(String value) {
            addCriterion("format >", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatGreaterThanOrEqualTo(String value) {
            addCriterion("format >=", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatLessThan(String value) {
            addCriterion("format <", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatLessThanOrEqualTo(String value) {
            addCriterion("format <=", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatLike(String value) {
            addCriterion("format like", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotLike(String value) {
            addCriterion("format not like", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatIn(List<String> values) {
            addCriterion("format in", values, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotIn(List<String> values) {
            addCriterion("format not in", values, "format");
            return (Criteria) this;
        }

        public Criteria andFormatBetween(String value1, String value2) {
            addCriterion("format between", value1, value2, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotBetween(String value1, String value2) {
            addCriterion("format not between", value1, value2, "format");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlIsNull() {
            addCriterion("gateway_url is null");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlIsNotNull() {
            addCriterion("gateway_url is not null");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlEqualTo(String value) {
            addCriterion("gateway_url =", value, "gatewayUrl");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlNotEqualTo(String value) {
            addCriterion("gateway_url <>", value, "gatewayUrl");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlGreaterThan(String value) {
            addCriterion("gateway_url >", value, "gatewayUrl");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlGreaterThanOrEqualTo(String value) {
            addCriterion("gateway_url >=", value, "gatewayUrl");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlLessThan(String value) {
            addCriterion("gateway_url <", value, "gatewayUrl");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlLessThanOrEqualTo(String value) {
            addCriterion("gateway_url <=", value, "gatewayUrl");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlLike(String value) {
            addCriterion("gateway_url like", value, "gatewayUrl");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlNotLike(String value) {
            addCriterion("gateway_url not like", value, "gatewayUrl");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlIn(List<String> values) {
            addCriterion("gateway_url in", values, "gatewayUrl");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlNotIn(List<String> values) {
            addCriterion("gateway_url not in", values, "gatewayUrl");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlBetween(String value1, String value2) {
            addCriterion("gateway_url between", value1, value2, "gatewayUrl");
            return (Criteria) this;
        }

        public Criteria andGatewayUrlNotBetween(String value1, String value2) {
            addCriterion("gateway_url not between", value1, value2, "gatewayUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("notify_url is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("notify_url =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("notify_url <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("notify_url >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("notify_url <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("notify_url <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("notify_url like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("notify_url not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("notify_url in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("notify_url not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("notify_url between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("notify_url not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNull() {
            addCriterion("return_url is null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNotNull() {
            addCriterion("return_url is not null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlEqualTo(String value) {
            addCriterion("return_url =", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotEqualTo(String value) {
            addCriterion("return_url <>", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThan(String value) {
            addCriterion("return_url >", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThanOrEqualTo(String value) {
            addCriterion("return_url >=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThan(String value) {
            addCriterion("return_url <", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThanOrEqualTo(String value) {
            addCriterion("return_url <=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLike(String value) {
            addCriterion("return_url like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotLike(String value) {
            addCriterion("return_url not like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIn(List<String> values) {
            addCriterion("return_url in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotIn(List<String> values) {
            addCriterion("return_url not in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlBetween(String value1, String value2) {
            addCriterion("return_url between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotBetween(String value1, String value2) {
            addCriterion("return_url not between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNull() {
            addCriterion("sign_type is null");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNotNull() {
            addCriterion("sign_type is not null");
            return (Criteria) this;
        }

        public Criteria andSignTypeEqualTo(String value) {
            addCriterion("sign_type =", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotEqualTo(String value) {
            addCriterion("sign_type <>", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThan(String value) {
            addCriterion("sign_type >", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sign_type >=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThan(String value) {
            addCriterion("sign_type <", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThanOrEqualTo(String value) {
            addCriterion("sign_type <=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLike(String value) {
            addCriterion("sign_type like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotLike(String value) {
            addCriterion("sign_type not like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeIn(List<String> values) {
            addCriterion("sign_type in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotIn(List<String> values) {
            addCriterion("sign_type not in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeBetween(String value1, String value2) {
            addCriterion("sign_type between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotBetween(String value1, String value2) {
            addCriterion("sign_type not between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdIsNull() {
            addCriterion("sys_service_provider_id is null");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdIsNotNull() {
            addCriterion("sys_service_provider_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdEqualTo(String value) {
            addCriterion("sys_service_provider_id =", value, "sysServiceProviderId");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdNotEqualTo(String value) {
            addCriterion("sys_service_provider_id <>", value, "sysServiceProviderId");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdGreaterThan(String value) {
            addCriterion("sys_service_provider_id >", value, "sysServiceProviderId");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdGreaterThanOrEqualTo(String value) {
            addCriterion("sys_service_provider_id >=", value, "sysServiceProviderId");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdLessThan(String value) {
            addCriterion("sys_service_provider_id <", value, "sysServiceProviderId");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdLessThanOrEqualTo(String value) {
            addCriterion("sys_service_provider_id <=", value, "sysServiceProviderId");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdLike(String value) {
            addCriterion("sys_service_provider_id like", value, "sysServiceProviderId");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdNotLike(String value) {
            addCriterion("sys_service_provider_id not like", value, "sysServiceProviderId");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdIn(List<String> values) {
            addCriterion("sys_service_provider_id in", values, "sysServiceProviderId");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdNotIn(List<String> values) {
            addCriterion("sys_service_provider_id not in", values, "sysServiceProviderId");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdBetween(String value1, String value2) {
            addCriterion("sys_service_provider_id between", value1, value2, "sysServiceProviderId");
            return (Criteria) this;
        }

        public Criteria andSysServiceProviderIdNotBetween(String value1, String value2) {
            addCriterion("sys_service_provider_id not between", value1, value2, "sysServiceProviderId");
            return (Criteria) this;
        }

        public Criteria andInputCharsetIsNull() {
            addCriterion("input_charset is null");
            return (Criteria) this;
        }

        public Criteria andInputCharsetIsNotNull() {
            addCriterion("input_charset is not null");
            return (Criteria) this;
        }

        public Criteria andInputCharsetEqualTo(String value) {
            addCriterion("input_charset =", value, "inputCharset");
            return (Criteria) this;
        }

        public Criteria andInputCharsetNotEqualTo(String value) {
            addCriterion("input_charset <>", value, "inputCharset");
            return (Criteria) this;
        }

        public Criteria andInputCharsetGreaterThan(String value) {
            addCriterion("input_charset >", value, "inputCharset");
            return (Criteria) this;
        }

        public Criteria andInputCharsetGreaterThanOrEqualTo(String value) {
            addCriterion("input_charset >=", value, "inputCharset");
            return (Criteria) this;
        }

        public Criteria andInputCharsetLessThan(String value) {
            addCriterion("input_charset <", value, "inputCharset");
            return (Criteria) this;
        }

        public Criteria andInputCharsetLessThanOrEqualTo(String value) {
            addCriterion("input_charset <=", value, "inputCharset");
            return (Criteria) this;
        }

        public Criteria andInputCharsetLike(String value) {
            addCriterion("input_charset like", value, "inputCharset");
            return (Criteria) this;
        }

        public Criteria andInputCharsetNotLike(String value) {
            addCriterion("input_charset not like", value, "inputCharset");
            return (Criteria) this;
        }

        public Criteria andInputCharsetIn(List<String> values) {
            addCriterion("input_charset in", values, "inputCharset");
            return (Criteria) this;
        }

        public Criteria andInputCharsetNotIn(List<String> values) {
            addCriterion("input_charset not in", values, "inputCharset");
            return (Criteria) this;
        }

        public Criteria andInputCharsetBetween(String value1, String value2) {
            addCriterion("input_charset between", value1, value2, "inputCharset");
            return (Criteria) this;
        }

        public Criteria andInputCharsetNotBetween(String value1, String value2) {
            addCriterion("input_charset not between", value1, value2, "inputCharset");
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
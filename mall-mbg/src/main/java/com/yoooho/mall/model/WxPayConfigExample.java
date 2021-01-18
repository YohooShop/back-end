package com.yoooho.mall.model;

import java.util.ArrayList;
import java.util.List;

public class WxPayConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WxPayConfigExample() {
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

        public Criteria andMchKeyIsNull() {
            addCriterion("mch_key is null");
            return (Criteria) this;
        }

        public Criteria andMchKeyIsNotNull() {
            addCriterion("mch_key is not null");
            return (Criteria) this;
        }

        public Criteria andMchKeyEqualTo(String value) {
            addCriterion("mch_key =", value, "mchKey");
            return (Criteria) this;
        }

        public Criteria andMchKeyNotEqualTo(String value) {
            addCriterion("mch_key <>", value, "mchKey");
            return (Criteria) this;
        }

        public Criteria andMchKeyGreaterThan(String value) {
            addCriterion("mch_key >", value, "mchKey");
            return (Criteria) this;
        }

        public Criteria andMchKeyGreaterThanOrEqualTo(String value) {
            addCriterion("mch_key >=", value, "mchKey");
            return (Criteria) this;
        }

        public Criteria andMchKeyLessThan(String value) {
            addCriterion("mch_key <", value, "mchKey");
            return (Criteria) this;
        }

        public Criteria andMchKeyLessThanOrEqualTo(String value) {
            addCriterion("mch_key <=", value, "mchKey");
            return (Criteria) this;
        }

        public Criteria andMchKeyLike(String value) {
            addCriterion("mch_key like", value, "mchKey");
            return (Criteria) this;
        }

        public Criteria andMchKeyNotLike(String value) {
            addCriterion("mch_key not like", value, "mchKey");
            return (Criteria) this;
        }

        public Criteria andMchKeyIn(List<String> values) {
            addCriterion("mch_key in", values, "mchKey");
            return (Criteria) this;
        }

        public Criteria andMchKeyNotIn(List<String> values) {
            addCriterion("mch_key not in", values, "mchKey");
            return (Criteria) this;
        }

        public Criteria andMchKeyBetween(String value1, String value2) {
            addCriterion("mch_key between", value1, value2, "mchKey");
            return (Criteria) this;
        }

        public Criteria andMchKeyNotBetween(String value1, String value2) {
            addCriterion("mch_key not between", value1, value2, "mchKey");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNull() {
            addCriterion("mch_id is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(String value) {
            addCriterion("mch_id =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(String value) {
            addCriterion("mch_id <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(String value) {
            addCriterion("mch_id >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("mch_id >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(String value) {
            addCriterion("mch_id <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(String value) {
            addCriterion("mch_id <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLike(String value) {
            addCriterion("mch_id like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotLike(String value) {
            addCriterion("mch_id not like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<String> values) {
            addCriterion("mch_id in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<String> values) {
            addCriterion("mch_id not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(String value1, String value2) {
            addCriterion("mch_id between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(String value1, String value2) {
            addCriterion("mch_id not between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andKeyPathIsNull() {
            addCriterion("key_path is null");
            return (Criteria) this;
        }

        public Criteria andKeyPathIsNotNull() {
            addCriterion("key_path is not null");
            return (Criteria) this;
        }

        public Criteria andKeyPathEqualTo(String value) {
            addCriterion("key_path =", value, "keyPath");
            return (Criteria) this;
        }

        public Criteria andKeyPathNotEqualTo(String value) {
            addCriterion("key_path <>", value, "keyPath");
            return (Criteria) this;
        }

        public Criteria andKeyPathGreaterThan(String value) {
            addCriterion("key_path >", value, "keyPath");
            return (Criteria) this;
        }

        public Criteria andKeyPathGreaterThanOrEqualTo(String value) {
            addCriterion("key_path >=", value, "keyPath");
            return (Criteria) this;
        }

        public Criteria andKeyPathLessThan(String value) {
            addCriterion("key_path <", value, "keyPath");
            return (Criteria) this;
        }

        public Criteria andKeyPathLessThanOrEqualTo(String value) {
            addCriterion("key_path <=", value, "keyPath");
            return (Criteria) this;
        }

        public Criteria andKeyPathLike(String value) {
            addCriterion("key_path like", value, "keyPath");
            return (Criteria) this;
        }

        public Criteria andKeyPathNotLike(String value) {
            addCriterion("key_path not like", value, "keyPath");
            return (Criteria) this;
        }

        public Criteria andKeyPathIn(List<String> values) {
            addCriterion("key_path in", values, "keyPath");
            return (Criteria) this;
        }

        public Criteria andKeyPathNotIn(List<String> values) {
            addCriterion("key_path not in", values, "keyPath");
            return (Criteria) this;
        }

        public Criteria andKeyPathBetween(String value1, String value2) {
            addCriterion("key_path between", value1, value2, "keyPath");
            return (Criteria) this;
        }

        public Criteria andKeyPathNotBetween(String value1, String value2) {
            addCriterion("key_path not between", value1, value2, "keyPath");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5IsNull() {
            addCriterion("notify_url_h5 is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5IsNotNull() {
            addCriterion("notify_url_h5 is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5EqualTo(String value) {
            addCriterion("notify_url_h5 =", value, "notifyUrlH5");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5NotEqualTo(String value) {
            addCriterion("notify_url_h5 <>", value, "notifyUrlH5");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5GreaterThan(String value) {
            addCriterion("notify_url_h5 >", value, "notifyUrlH5");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5GreaterThanOrEqualTo(String value) {
            addCriterion("notify_url_h5 >=", value, "notifyUrlH5");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5LessThan(String value) {
            addCriterion("notify_url_h5 <", value, "notifyUrlH5");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5LessThanOrEqualTo(String value) {
            addCriterion("notify_url_h5 <=", value, "notifyUrlH5");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5Like(String value) {
            addCriterion("notify_url_h5 like", value, "notifyUrlH5");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5NotLike(String value) {
            addCriterion("notify_url_h5 not like", value, "notifyUrlH5");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5In(List<String> values) {
            addCriterion("notify_url_h5 in", values, "notifyUrlH5");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5NotIn(List<String> values) {
            addCriterion("notify_url_h5 not in", values, "notifyUrlH5");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5Between(String value1, String value2) {
            addCriterion("notify_url_h5 between", value1, value2, "notifyUrlH5");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlH5NotBetween(String value1, String value2) {
            addCriterion("notify_url_h5 not between", value1, value2, "notifyUrlH5");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlIsNull() {
            addCriterion("refund_notify_url is null");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlIsNotNull() {
            addCriterion("refund_notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlEqualTo(String value) {
            addCriterion("refund_notify_url =", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlNotEqualTo(String value) {
            addCriterion("refund_notify_url <>", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlGreaterThan(String value) {
            addCriterion("refund_notify_url >", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("refund_notify_url >=", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlLessThan(String value) {
            addCriterion("refund_notify_url <", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("refund_notify_url <=", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlLike(String value) {
            addCriterion("refund_notify_url like", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlNotLike(String value) {
            addCriterion("refund_notify_url not like", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlIn(List<String> values) {
            addCriterion("refund_notify_url in", values, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlNotIn(List<String> values) {
            addCriterion("refund_notify_url not in", values, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlBetween(String value1, String value2) {
            addCriterion("refund_notify_url between", value1, value2, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("refund_notify_url not between", value1, value2, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpIsNull() {
            addCriterion("spbill_create_ip is null");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpIsNotNull() {
            addCriterion("spbill_create_ip is not null");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpEqualTo(String value) {
            addCriterion("spbill_create_ip =", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpNotEqualTo(String value) {
            addCriterion("spbill_create_ip <>", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpGreaterThan(String value) {
            addCriterion("spbill_create_ip >", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpGreaterThanOrEqualTo(String value) {
            addCriterion("spbill_create_ip >=", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpLessThan(String value) {
            addCriterion("spbill_create_ip <", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpLessThanOrEqualTo(String value) {
            addCriterion("spbill_create_ip <=", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpLike(String value) {
            addCriterion("spbill_create_ip like", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpNotLike(String value) {
            addCriterion("spbill_create_ip not like", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpIn(List<String> values) {
            addCriterion("spbill_create_ip in", values, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpNotIn(List<String> values) {
            addCriterion("spbill_create_ip not in", values, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpBetween(String value1, String value2) {
            addCriterion("spbill_create_ip between", value1, value2, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpNotBetween(String value1, String value2) {
            addCriterion("spbill_create_ip not between", value1, value2, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppIsNull() {
            addCriterion("notify_url_app is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppIsNotNull() {
            addCriterion("notify_url_app is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppEqualTo(String value) {
            addCriterion("notify_url_app =", value, "notifyUrlApp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppNotEqualTo(String value) {
            addCriterion("notify_url_app <>", value, "notifyUrlApp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppGreaterThan(String value) {
            addCriterion("notify_url_app >", value, "notifyUrlApp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url_app >=", value, "notifyUrlApp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppLessThan(String value) {
            addCriterion("notify_url_app <", value, "notifyUrlApp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppLessThanOrEqualTo(String value) {
            addCriterion("notify_url_app <=", value, "notifyUrlApp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppLike(String value) {
            addCriterion("notify_url_app like", value, "notifyUrlApp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppNotLike(String value) {
            addCriterion("notify_url_app not like", value, "notifyUrlApp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppIn(List<String> values) {
            addCriterion("notify_url_app in", values, "notifyUrlApp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppNotIn(List<String> values) {
            addCriterion("notify_url_app not in", values, "notifyUrlApp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppBetween(String value1, String value2) {
            addCriterion("notify_url_app between", value1, value2, "notifyUrlApp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlAppNotBetween(String value1, String value2) {
            addCriterion("notify_url_app not between", value1, value2, "notifyUrlApp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpIsNull() {
            addCriterion("notify_url_sp is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpIsNotNull() {
            addCriterion("notify_url_sp is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpEqualTo(String value) {
            addCriterion("notify_url_sp =", value, "notifyUrlSp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpNotEqualTo(String value) {
            addCriterion("notify_url_sp <>", value, "notifyUrlSp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpGreaterThan(String value) {
            addCriterion("notify_url_sp >", value, "notifyUrlSp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url_sp >=", value, "notifyUrlSp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpLessThan(String value) {
            addCriterion("notify_url_sp <", value, "notifyUrlSp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpLessThanOrEqualTo(String value) {
            addCriterion("notify_url_sp <=", value, "notifyUrlSp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpLike(String value) {
            addCriterion("notify_url_sp like", value, "notifyUrlSp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpNotLike(String value) {
            addCriterion("notify_url_sp not like", value, "notifyUrlSp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpIn(List<String> values) {
            addCriterion("notify_url_sp in", values, "notifyUrlSp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpNotIn(List<String> values) {
            addCriterion("notify_url_sp not in", values, "notifyUrlSp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpBetween(String value1, String value2) {
            addCriterion("notify_url_sp between", value1, value2, "notifyUrlSp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlSpNotBetween(String value1, String value2) {
            addCriterion("notify_url_sp not between", value1, value2, "notifyUrlSp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsIsNull() {
            addCriterion("notify_url_js is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsIsNotNull() {
            addCriterion("notify_url_js is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsEqualTo(String value) {
            addCriterion("notify_url_js =", value, "notifyUrlJs");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsNotEqualTo(String value) {
            addCriterion("notify_url_js <>", value, "notifyUrlJs");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsGreaterThan(String value) {
            addCriterion("notify_url_js >", value, "notifyUrlJs");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url_js >=", value, "notifyUrlJs");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsLessThan(String value) {
            addCriterion("notify_url_js <", value, "notifyUrlJs");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsLessThanOrEqualTo(String value) {
            addCriterion("notify_url_js <=", value, "notifyUrlJs");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsLike(String value) {
            addCriterion("notify_url_js like", value, "notifyUrlJs");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsNotLike(String value) {
            addCriterion("notify_url_js not like", value, "notifyUrlJs");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsIn(List<String> values) {
            addCriterion("notify_url_js in", values, "notifyUrlJs");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsNotIn(List<String> values) {
            addCriterion("notify_url_js not in", values, "notifyUrlJs");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsBetween(String value1, String value2) {
            addCriterion("notify_url_js between", value1, value2, "notifyUrlJs");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlJsNotBetween(String value1, String value2) {
            addCriterion("notify_url_js not between", value1, value2, "notifyUrlJs");
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
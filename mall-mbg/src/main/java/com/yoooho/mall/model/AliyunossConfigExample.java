package com.yoooho.mall.model;

import java.util.ArrayList;
import java.util.List;

public class AliyunossConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AliyunossConfigExample() {
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

        public Criteria andEndpointIsNull() {
            addCriterion("endpoint is null");
            return (Criteria) this;
        }

        public Criteria andEndpointIsNotNull() {
            addCriterion("endpoint is not null");
            return (Criteria) this;
        }

        public Criteria andEndpointEqualTo(String value) {
            addCriterion("endpoint =", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointNotEqualTo(String value) {
            addCriterion("endpoint <>", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointGreaterThan(String value) {
            addCriterion("endpoint >", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointGreaterThanOrEqualTo(String value) {
            addCriterion("endpoint >=", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointLessThan(String value) {
            addCriterion("endpoint <", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointLessThanOrEqualTo(String value) {
            addCriterion("endpoint <=", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointLike(String value) {
            addCriterion("endpoint like", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointNotLike(String value) {
            addCriterion("endpoint not like", value, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointIn(List<String> values) {
            addCriterion("endpoint in", values, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointNotIn(List<String> values) {
            addCriterion("endpoint not in", values, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointBetween(String value1, String value2) {
            addCriterion("endpoint between", value1, value2, "endpoint");
            return (Criteria) this;
        }

        public Criteria andEndpointNotBetween(String value1, String value2) {
            addCriterion("endpoint not between", value1, value2, "endpoint");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdIsNull() {
            addCriterion("access_key_id is null");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdIsNotNull() {
            addCriterion("access_key_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdEqualTo(String value) {
            addCriterion("access_key_id =", value, "accessKeyId");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdNotEqualTo(String value) {
            addCriterion("access_key_id <>", value, "accessKeyId");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdGreaterThan(String value) {
            addCriterion("access_key_id >", value, "accessKeyId");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdGreaterThanOrEqualTo(String value) {
            addCriterion("access_key_id >=", value, "accessKeyId");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdLessThan(String value) {
            addCriterion("access_key_id <", value, "accessKeyId");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdLessThanOrEqualTo(String value) {
            addCriterion("access_key_id <=", value, "accessKeyId");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdLike(String value) {
            addCriterion("access_key_id like", value, "accessKeyId");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdNotLike(String value) {
            addCriterion("access_key_id not like", value, "accessKeyId");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdIn(List<String> values) {
            addCriterion("access_key_id in", values, "accessKeyId");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdNotIn(List<String> values) {
            addCriterion("access_key_id not in", values, "accessKeyId");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdBetween(String value1, String value2) {
            addCriterion("access_key_id between", value1, value2, "accessKeyId");
            return (Criteria) this;
        }

        public Criteria andAccessKeyIdNotBetween(String value1, String value2) {
            addCriterion("access_key_id not between", value1, value2, "accessKeyId");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreIsNull() {
            addCriterion("access_key_secre is null");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreIsNotNull() {
            addCriterion("access_key_secre is not null");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreEqualTo(String value) {
            addCriterion("access_key_secre =", value, "accessKeySecre");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreNotEqualTo(String value) {
            addCriterion("access_key_secre <>", value, "accessKeySecre");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreGreaterThan(String value) {
            addCriterion("access_key_secre >", value, "accessKeySecre");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreGreaterThanOrEqualTo(String value) {
            addCriterion("access_key_secre >=", value, "accessKeySecre");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreLessThan(String value) {
            addCriterion("access_key_secre <", value, "accessKeySecre");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreLessThanOrEqualTo(String value) {
            addCriterion("access_key_secre <=", value, "accessKeySecre");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreLike(String value) {
            addCriterion("access_key_secre like", value, "accessKeySecre");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreNotLike(String value) {
            addCriterion("access_key_secre not like", value, "accessKeySecre");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreIn(List<String> values) {
            addCriterion("access_key_secre in", values, "accessKeySecre");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreNotIn(List<String> values) {
            addCriterion("access_key_secre not in", values, "accessKeySecre");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreBetween(String value1, String value2) {
            addCriterion("access_key_secre between", value1, value2, "accessKeySecre");
            return (Criteria) this;
        }

        public Criteria andAccessKeySecreNotBetween(String value1, String value2) {
            addCriterion("access_key_secre not between", value1, value2, "accessKeySecre");
            return (Criteria) this;
        }

        public Criteria andBucketNameIsNull() {
            addCriterion("bucket_name is null");
            return (Criteria) this;
        }

        public Criteria andBucketNameIsNotNull() {
            addCriterion("bucket_name is not null");
            return (Criteria) this;
        }

        public Criteria andBucketNameEqualTo(String value) {
            addCriterion("bucket_name =", value, "bucketName");
            return (Criteria) this;
        }

        public Criteria andBucketNameNotEqualTo(String value) {
            addCriterion("bucket_name <>", value, "bucketName");
            return (Criteria) this;
        }

        public Criteria andBucketNameGreaterThan(String value) {
            addCriterion("bucket_name >", value, "bucketName");
            return (Criteria) this;
        }

        public Criteria andBucketNameGreaterThanOrEqualTo(String value) {
            addCriterion("bucket_name >=", value, "bucketName");
            return (Criteria) this;
        }

        public Criteria andBucketNameLessThan(String value) {
            addCriterion("bucket_name <", value, "bucketName");
            return (Criteria) this;
        }

        public Criteria andBucketNameLessThanOrEqualTo(String value) {
            addCriterion("bucket_name <=", value, "bucketName");
            return (Criteria) this;
        }

        public Criteria andBucketNameLike(String value) {
            addCriterion("bucket_name like", value, "bucketName");
            return (Criteria) this;
        }

        public Criteria andBucketNameNotLike(String value) {
            addCriterion("bucket_name not like", value, "bucketName");
            return (Criteria) this;
        }

        public Criteria andBucketNameIn(List<String> values) {
            addCriterion("bucket_name in", values, "bucketName");
            return (Criteria) this;
        }

        public Criteria andBucketNameNotIn(List<String> values) {
            addCriterion("bucket_name not in", values, "bucketName");
            return (Criteria) this;
        }

        public Criteria andBucketNameBetween(String value1, String value2) {
            addCriterion("bucket_name between", value1, value2, "bucketName");
            return (Criteria) this;
        }

        public Criteria andBucketNameNotBetween(String value1, String value2) {
            addCriterion("bucket_name not between", value1, value2, "bucketName");
            return (Criteria) this;
        }

        public Criteria andExpireIsNull() {
            addCriterion("expire is null");
            return (Criteria) this;
        }

        public Criteria andExpireIsNotNull() {
            addCriterion("expire is not null");
            return (Criteria) this;
        }

        public Criteria andExpireEqualTo(String value) {
            addCriterion("expire =", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireNotEqualTo(String value) {
            addCriterion("expire <>", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireGreaterThan(String value) {
            addCriterion("expire >", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireGreaterThanOrEqualTo(String value) {
            addCriterion("expire >=", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireLessThan(String value) {
            addCriterion("expire <", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireLessThanOrEqualTo(String value) {
            addCriterion("expire <=", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireLike(String value) {
            addCriterion("expire like", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireNotLike(String value) {
            addCriterion("expire not like", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireIn(List<String> values) {
            addCriterion("expire in", values, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireNotIn(List<String> values) {
            addCriterion("expire not in", values, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireBetween(String value1, String value2) {
            addCriterion("expire between", value1, value2, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireNotBetween(String value1, String value2) {
            addCriterion("expire not between", value1, value2, "expire");
            return (Criteria) this;
        }

        public Criteria andMaxSizeIsNull() {
            addCriterion("max_size is null");
            return (Criteria) this;
        }

        public Criteria andMaxSizeIsNotNull() {
            addCriterion("max_size is not null");
            return (Criteria) this;
        }

        public Criteria andMaxSizeEqualTo(String value) {
            addCriterion("max_size =", value, "maxSize");
            return (Criteria) this;
        }

        public Criteria andMaxSizeNotEqualTo(String value) {
            addCriterion("max_size <>", value, "maxSize");
            return (Criteria) this;
        }

        public Criteria andMaxSizeGreaterThan(String value) {
            addCriterion("max_size >", value, "maxSize");
            return (Criteria) this;
        }

        public Criteria andMaxSizeGreaterThanOrEqualTo(String value) {
            addCriterion("max_size >=", value, "maxSize");
            return (Criteria) this;
        }

        public Criteria andMaxSizeLessThan(String value) {
            addCriterion("max_size <", value, "maxSize");
            return (Criteria) this;
        }

        public Criteria andMaxSizeLessThanOrEqualTo(String value) {
            addCriterion("max_size <=", value, "maxSize");
            return (Criteria) this;
        }

        public Criteria andMaxSizeLike(String value) {
            addCriterion("max_size like", value, "maxSize");
            return (Criteria) this;
        }

        public Criteria andMaxSizeNotLike(String value) {
            addCriterion("max_size not like", value, "maxSize");
            return (Criteria) this;
        }

        public Criteria andMaxSizeIn(List<String> values) {
            addCriterion("max_size in", values, "maxSize");
            return (Criteria) this;
        }

        public Criteria andMaxSizeNotIn(List<String> values) {
            addCriterion("max_size not in", values, "maxSize");
            return (Criteria) this;
        }

        public Criteria andMaxSizeBetween(String value1, String value2) {
            addCriterion("max_size between", value1, value2, "maxSize");
            return (Criteria) this;
        }

        public Criteria andMaxSizeNotBetween(String value1, String value2) {
            addCriterion("max_size not between", value1, value2, "maxSize");
            return (Criteria) this;
        }

        public Criteria andCallbackIsNull() {
            addCriterion("callback is null");
            return (Criteria) this;
        }

        public Criteria andCallbackIsNotNull() {
            addCriterion("callback is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackEqualTo(String value) {
            addCriterion("callback =", value, "callback");
            return (Criteria) this;
        }

        public Criteria andCallbackNotEqualTo(String value) {
            addCriterion("callback <>", value, "callback");
            return (Criteria) this;
        }

        public Criteria andCallbackGreaterThan(String value) {
            addCriterion("callback >", value, "callback");
            return (Criteria) this;
        }

        public Criteria andCallbackGreaterThanOrEqualTo(String value) {
            addCriterion("callback >=", value, "callback");
            return (Criteria) this;
        }

        public Criteria andCallbackLessThan(String value) {
            addCriterion("callback <", value, "callback");
            return (Criteria) this;
        }

        public Criteria andCallbackLessThanOrEqualTo(String value) {
            addCriterion("callback <=", value, "callback");
            return (Criteria) this;
        }

        public Criteria andCallbackLike(String value) {
            addCriterion("callback like", value, "callback");
            return (Criteria) this;
        }

        public Criteria andCallbackNotLike(String value) {
            addCriterion("callback not like", value, "callback");
            return (Criteria) this;
        }

        public Criteria andCallbackIn(List<String> values) {
            addCriterion("callback in", values, "callback");
            return (Criteria) this;
        }

        public Criteria andCallbackNotIn(List<String> values) {
            addCriterion("callback not in", values, "callback");
            return (Criteria) this;
        }

        public Criteria andCallbackBetween(String value1, String value2) {
            addCriterion("callback between", value1, value2, "callback");
            return (Criteria) this;
        }

        public Criteria andCallbackNotBetween(String value1, String value2) {
            addCriterion("callback not between", value1, value2, "callback");
            return (Criteria) this;
        }

        public Criteria andPrefixIsNull() {
            addCriterion("`prefix` is null");
            return (Criteria) this;
        }

        public Criteria andPrefixIsNotNull() {
            addCriterion("`prefix` is not null");
            return (Criteria) this;
        }

        public Criteria andPrefixEqualTo(String value) {
            addCriterion("`prefix` =", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotEqualTo(String value) {
            addCriterion("`prefix` <>", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixGreaterThan(String value) {
            addCriterion("`prefix` >", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("`prefix` >=", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLessThan(String value) {
            addCriterion("`prefix` <", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLessThanOrEqualTo(String value) {
            addCriterion("`prefix` <=", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLike(String value) {
            addCriterion("`prefix` like", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotLike(String value) {
            addCriterion("`prefix` not like", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixIn(List<String> values) {
            addCriterion("`prefix` in", values, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotIn(List<String> values) {
            addCriterion("`prefix` not in", values, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixBetween(String value1, String value2) {
            addCriterion("`prefix` between", value1, value2, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotBetween(String value1, String value2) {
            addCriterion("`prefix` not between", value1, value2, "prefix");
            return (Criteria) this;
        }

        public Criteria andHostIsNull() {
            addCriterion("`host` is null");
            return (Criteria) this;
        }

        public Criteria andHostIsNotNull() {
            addCriterion("`host` is not null");
            return (Criteria) this;
        }

        public Criteria andHostEqualTo(String value) {
            addCriterion("`host` =", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotEqualTo(String value) {
            addCriterion("`host` <>", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThan(String value) {
            addCriterion("`host` >", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThanOrEqualTo(String value) {
            addCriterion("`host` >=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThan(String value) {
            addCriterion("`host` <", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThanOrEqualTo(String value) {
            addCriterion("`host` <=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLike(String value) {
            addCriterion("`host` like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotLike(String value) {
            addCriterion("`host` not like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostIn(List<String> values) {
            addCriterion("`host` in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotIn(List<String> values) {
            addCriterion("`host` not in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostBetween(String value1, String value2) {
            addCriterion("`host` between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotBetween(String value1, String value2) {
            addCriterion("`host` not between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andZoneIsNull() {
            addCriterion("`zone` is null");
            return (Criteria) this;
        }

        public Criteria andZoneIsNotNull() {
            addCriterion("`zone` is not null");
            return (Criteria) this;
        }

        public Criteria andZoneEqualTo(String value) {
            addCriterion("`zone` =", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotEqualTo(String value) {
            addCriterion("`zone` <>", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneGreaterThan(String value) {
            addCriterion("`zone` >", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneGreaterThanOrEqualTo(String value) {
            addCriterion("`zone` >=", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneLessThan(String value) {
            addCriterion("`zone` <", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneLessThanOrEqualTo(String value) {
            addCriterion("`zone` <=", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneLike(String value) {
            addCriterion("`zone` like", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotLike(String value) {
            addCriterion("`zone` not like", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneIn(List<String> values) {
            addCriterion("`zone` in", values, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotIn(List<String> values) {
            addCriterion("`zone` not in", values, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneBetween(String value1, String value2) {
            addCriterion("`zone` between", value1, value2, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotBetween(String value1, String value2) {
            addCriterion("`zone` not between", value1, value2, "zone");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("`type` not between", value1, value2, "type");
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
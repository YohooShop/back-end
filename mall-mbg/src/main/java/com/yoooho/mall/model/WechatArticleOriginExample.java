package com.yoooho.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WechatArticleOriginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WechatArticleOriginExample() {
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

        public Criteria andMidIsNull() {
            addCriterion("mid is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mid is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(String value) {
            addCriterion("mid =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(String value) {
            addCriterion("mid <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(String value) {
            addCriterion("mid >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(String value) {
            addCriterion("mid >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(String value) {
            addCriterion("mid <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(String value) {
            addCriterion("mid <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLike(String value) {
            addCriterion("mid like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotLike(String value) {
            addCriterion("mid not like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<String> values) {
            addCriterion("mid in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<String> values) {
            addCriterion("mid not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(String value1, String value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(String value1, String value2) {
            addCriterion("mid not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdIsNull() {
            addCriterion("thumb_media_id is null");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdIsNotNull() {
            addCriterion("thumb_media_id is not null");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdEqualTo(String value) {
            addCriterion("thumb_media_id =", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdNotEqualTo(String value) {
            addCriterion("thumb_media_id <>", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdGreaterThan(String value) {
            addCriterion("thumb_media_id >", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdGreaterThanOrEqualTo(String value) {
            addCriterion("thumb_media_id >=", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdLessThan(String value) {
            addCriterion("thumb_media_id <", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdLessThanOrEqualTo(String value) {
            addCriterion("thumb_media_id <=", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdLike(String value) {
            addCriterion("thumb_media_id like", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdNotLike(String value) {
            addCriterion("thumb_media_id not like", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdIn(List<String> values) {
            addCriterion("thumb_media_id in", values, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdNotIn(List<String> values) {
            addCriterion("thumb_media_id not in", values, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdBetween(String value1, String value2) {
            addCriterion("thumb_media_id between", value1, value2, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdNotBetween(String value1, String value2) {
            addCriterion("thumb_media_id not between", value1, value2, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbUrlIsNull() {
            addCriterion("thumb_url is null");
            return (Criteria) this;
        }

        public Criteria andThumbUrlIsNotNull() {
            addCriterion("thumb_url is not null");
            return (Criteria) this;
        }

        public Criteria andThumbUrlEqualTo(String value) {
            addCriterion("thumb_url =", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlNotEqualTo(String value) {
            addCriterion("thumb_url <>", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlGreaterThan(String value) {
            addCriterion("thumb_url >", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlGreaterThanOrEqualTo(String value) {
            addCriterion("thumb_url >=", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlLessThan(String value) {
            addCriterion("thumb_url <", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlLessThanOrEqualTo(String value) {
            addCriterion("thumb_url <=", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlLike(String value) {
            addCriterion("thumb_url like", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlNotLike(String value) {
            addCriterion("thumb_url not like", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlIn(List<String> values) {
            addCriterion("thumb_url in", values, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlNotIn(List<String> values) {
            addCriterion("thumb_url not in", values, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlBetween(String value1, String value2) {
            addCriterion("thumb_url between", value1, value2, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlNotBetween(String value1, String value2) {
            addCriterion("thumb_url not between", value1, value2, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlIsNull() {
            addCriterion("content_source_url is null");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlIsNotNull() {
            addCriterion("content_source_url is not null");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlEqualTo(String value) {
            addCriterion("content_source_url =", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlNotEqualTo(String value) {
            addCriterion("content_source_url <>", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlGreaterThan(String value) {
            addCriterion("content_source_url >", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("content_source_url >=", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlLessThan(String value) {
            addCriterion("content_source_url <", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlLessThanOrEqualTo(String value) {
            addCriterion("content_source_url <=", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlLike(String value) {
            addCriterion("content_source_url like", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlNotLike(String value) {
            addCriterion("content_source_url not like", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlIn(List<String> values) {
            addCriterion("content_source_url in", values, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlNotIn(List<String> values) {
            addCriterion("content_source_url not in", values, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlBetween(String value1, String value2) {
            addCriterion("content_source_url between", value1, value2, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlNotBetween(String value1, String value2) {
            addCriterion("content_source_url not between", value1, value2, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andDigestIsNull() {
            addCriterion("digest is null");
            return (Criteria) this;
        }

        public Criteria andDigestIsNotNull() {
            addCriterion("digest is not null");
            return (Criteria) this;
        }

        public Criteria andDigestEqualTo(String value) {
            addCriterion("digest =", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotEqualTo(String value) {
            addCriterion("digest <>", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThan(String value) {
            addCriterion("digest >", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThanOrEqualTo(String value) {
            addCriterion("digest >=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThan(String value) {
            addCriterion("digest <", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThanOrEqualTo(String value) {
            addCriterion("digest <=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLike(String value) {
            addCriterion("digest like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotLike(String value) {
            addCriterion("digest not like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestIn(List<String> values) {
            addCriterion("digest in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotIn(List<String> values) {
            addCriterion("digest not in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestBetween(String value1, String value2) {
            addCriterion("digest between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotBetween(String value1, String value2) {
            addCriterion("digest not between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andShowcCoverPicIsNull() {
            addCriterion("showc_cover_pic is null");
            return (Criteria) this;
        }

        public Criteria andShowcCoverPicIsNotNull() {
            addCriterion("showc_cover_pic is not null");
            return (Criteria) this;
        }

        public Criteria andShowcCoverPicEqualTo(Boolean value) {
            addCriterion("showc_cover_pic =", value, "showcCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowcCoverPicNotEqualTo(Boolean value) {
            addCriterion("showc_cover_pic <>", value, "showcCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowcCoverPicGreaterThan(Boolean value) {
            addCriterion("showc_cover_pic >", value, "showcCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowcCoverPicGreaterThanOrEqualTo(Boolean value) {
            addCriterion("showc_cover_pic >=", value, "showcCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowcCoverPicLessThan(Boolean value) {
            addCriterion("showc_cover_pic <", value, "showcCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowcCoverPicLessThanOrEqualTo(Boolean value) {
            addCriterion("showc_cover_pic <=", value, "showcCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowcCoverPicIn(List<Boolean> values) {
            addCriterion("showc_cover_pic in", values, "showcCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowcCoverPicNotIn(List<Boolean> values) {
            addCriterion("showc_cover_pic not in", values, "showcCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowcCoverPicBetween(Boolean value1, Boolean value2) {
            addCriterion("showc_cover_pic between", value1, value2, "showcCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowcCoverPicNotBetween(Boolean value1, Boolean value2) {
            addCriterion("showc_cover_pic not between", value1, value2, "showcCoverPic");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andNeedOpenCommentIsNull() {
            addCriterion("need_open_comment is null");
            return (Criteria) this;
        }

        public Criteria andNeedOpenCommentIsNotNull() {
            addCriterion("need_open_comment is not null");
            return (Criteria) this;
        }

        public Criteria andNeedOpenCommentEqualTo(Boolean value) {
            addCriterion("need_open_comment =", value, "needOpenComment");
            return (Criteria) this;
        }

        public Criteria andNeedOpenCommentNotEqualTo(Boolean value) {
            addCriterion("need_open_comment <>", value, "needOpenComment");
            return (Criteria) this;
        }

        public Criteria andNeedOpenCommentGreaterThan(Boolean value) {
            addCriterion("need_open_comment >", value, "needOpenComment");
            return (Criteria) this;
        }

        public Criteria andNeedOpenCommentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_open_comment >=", value, "needOpenComment");
            return (Criteria) this;
        }

        public Criteria andNeedOpenCommentLessThan(Boolean value) {
            addCriterion("need_open_comment <", value, "needOpenComment");
            return (Criteria) this;
        }

        public Criteria andNeedOpenCommentLessThanOrEqualTo(Boolean value) {
            addCriterion("need_open_comment <=", value, "needOpenComment");
            return (Criteria) this;
        }

        public Criteria andNeedOpenCommentIn(List<Boolean> values) {
            addCriterion("need_open_comment in", values, "needOpenComment");
            return (Criteria) this;
        }

        public Criteria andNeedOpenCommentNotIn(List<Boolean> values) {
            addCriterion("need_open_comment not in", values, "needOpenComment");
            return (Criteria) this;
        }

        public Criteria andNeedOpenCommentBetween(Boolean value1, Boolean value2) {
            addCriterion("need_open_comment between", value1, value2, "needOpenComment");
            return (Criteria) this;
        }

        public Criteria andNeedOpenCommentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_open_comment not between", value1, value2, "needOpenComment");
            return (Criteria) this;
        }

        public Criteria andOnlyFansCanCommentIsNull() {
            addCriterion("only_fans_can_comment is null");
            return (Criteria) this;
        }

        public Criteria andOnlyFansCanCommentIsNotNull() {
            addCriterion("only_fans_can_comment is not null");
            return (Criteria) this;
        }

        public Criteria andOnlyFansCanCommentEqualTo(Boolean value) {
            addCriterion("only_fans_can_comment =", value, "onlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andOnlyFansCanCommentNotEqualTo(Boolean value) {
            addCriterion("only_fans_can_comment <>", value, "onlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andOnlyFansCanCommentGreaterThan(Boolean value) {
            addCriterion("only_fans_can_comment >", value, "onlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andOnlyFansCanCommentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("only_fans_can_comment >=", value, "onlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andOnlyFansCanCommentLessThan(Boolean value) {
            addCriterion("only_fans_can_comment <", value, "onlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andOnlyFansCanCommentLessThanOrEqualTo(Boolean value) {
            addCriterion("only_fans_can_comment <=", value, "onlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andOnlyFansCanCommentIn(List<Boolean> values) {
            addCriterion("only_fans_can_comment in", values, "onlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andOnlyFansCanCommentNotIn(List<Boolean> values) {
            addCriterion("only_fans_can_comment not in", values, "onlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andOnlyFansCanCommentBetween(Boolean value1, Boolean value2) {
            addCriterion("only_fans_can_comment between", value1, value2, "onlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andOnlyFansCanCommentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("only_fans_can_comment not between", value1, value2, "onlyFansCanComment");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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
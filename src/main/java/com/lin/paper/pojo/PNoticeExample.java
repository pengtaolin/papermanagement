package com.lin.paper.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PNoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PNoticeExample() {
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

        public Criteria andNoticeidIsNull() {
            addCriterion("noticeId is null");
            return (Criteria) this;
        }

        public Criteria andNoticeidIsNotNull() {
            addCriterion("noticeId is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeidEqualTo(String value) {
            addCriterion("noticeId =", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidNotEqualTo(String value) {
            addCriterion("noticeId <>", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidGreaterThan(String value) {
            addCriterion("noticeId >", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidGreaterThanOrEqualTo(String value) {
            addCriterion("noticeId >=", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidLessThan(String value) {
            addCriterion("noticeId <", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidLessThanOrEqualTo(String value) {
            addCriterion("noticeId <=", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidLike(String value) {
            addCriterion("noticeId like", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidNotLike(String value) {
            addCriterion("noticeId not like", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidIn(List<String> values) {
            addCriterion("noticeId in", values, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidNotIn(List<String> values) {
            addCriterion("noticeId not in", values, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidBetween(String value1, String value2) {
            addCriterion("noticeId between", value1, value2, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidNotBetween(String value1, String value2) {
            addCriterion("noticeId not between", value1, value2, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticetitleIsNull() {
            addCriterion("noticeTitle is null");
            return (Criteria) this;
        }

        public Criteria andNoticetitleIsNotNull() {
            addCriterion("noticeTitle is not null");
            return (Criteria) this;
        }

        public Criteria andNoticetitleEqualTo(String value) {
            addCriterion("noticeTitle =", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleNotEqualTo(String value) {
            addCriterion("noticeTitle <>", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleGreaterThan(String value) {
            addCriterion("noticeTitle >", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleGreaterThanOrEqualTo(String value) {
            addCriterion("noticeTitle >=", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleLessThan(String value) {
            addCriterion("noticeTitle <", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleLessThanOrEqualTo(String value) {
            addCriterion("noticeTitle <=", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleLike(String value) {
            addCriterion("noticeTitle like", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleNotLike(String value) {
            addCriterion("noticeTitle not like", value, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleIn(List<String> values) {
            addCriterion("noticeTitle in", values, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleNotIn(List<String> values) {
            addCriterion("noticeTitle not in", values, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleBetween(String value1, String value2) {
            addCriterion("noticeTitle between", value1, value2, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andNoticetitleNotBetween(String value1, String value2) {
            addCriterion("noticeTitle not between", value1, value2, "noticetitle");
            return (Criteria) this;
        }

        public Criteria andFileurlIsNull() {
            addCriterion("fileUrl is null");
            return (Criteria) this;
        }

        public Criteria andFileurlIsNotNull() {
            addCriterion("fileUrl is not null");
            return (Criteria) this;
        }

        public Criteria andFileurlEqualTo(String value) {
            addCriterion("fileUrl =", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlNotEqualTo(String value) {
            addCriterion("fileUrl <>", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlGreaterThan(String value) {
            addCriterion("fileUrl >", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlGreaterThanOrEqualTo(String value) {
            addCriterion("fileUrl >=", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlLessThan(String value) {
            addCriterion("fileUrl <", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlLessThanOrEqualTo(String value) {
            addCriterion("fileUrl <=", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlLike(String value) {
            addCriterion("fileUrl like", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlNotLike(String value) {
            addCriterion("fileUrl not like", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlIn(List<String> values) {
            addCriterion("fileUrl in", values, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlNotIn(List<String> values) {
            addCriterion("fileUrl not in", values, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlBetween(String value1, String value2) {
            addCriterion("fileUrl between", value1, value2, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlNotBetween(String value1, String value2) {
            addCriterion("fileUrl not between", value1, value2, "fileurl");
            return (Criteria) this;
        }

        public Criteria andDownloadsIsNull() {
            addCriterion("downloads is null");
            return (Criteria) this;
        }

        public Criteria andDownloadsIsNotNull() {
            addCriterion("downloads is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadsEqualTo(Integer value) {
            addCriterion("downloads =", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsNotEqualTo(Integer value) {
            addCriterion("downloads <>", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsGreaterThan(Integer value) {
            addCriterion("downloads >", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsGreaterThanOrEqualTo(Integer value) {
            addCriterion("downloads >=", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsLessThan(Integer value) {
            addCriterion("downloads <", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsLessThanOrEqualTo(Integer value) {
            addCriterion("downloads <=", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsIn(List<Integer> values) {
            addCriterion("downloads in", values, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsNotIn(List<Integer> values) {
            addCriterion("downloads not in", values, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsBetween(Integer value1, Integer value2) {
            addCriterion("downloads between", value1, value2, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsNotBetween(Integer value1, Integer value2) {
            addCriterion("downloads not between", value1, value2, "downloads");
            return (Criteria) this;
        }

        public Criteria andWatchnumIsNull() {
            addCriterion("watchNum is null");
            return (Criteria) this;
        }

        public Criteria andWatchnumIsNotNull() {
            addCriterion("watchNum is not null");
            return (Criteria) this;
        }

        public Criteria andWatchnumEqualTo(Integer value) {
            addCriterion("watchNum =", value, "watchnum");
            return (Criteria) this;
        }

        public Criteria andWatchnumNotEqualTo(Integer value) {
            addCriterion("watchNum <>", value, "watchnum");
            return (Criteria) this;
        }

        public Criteria andWatchnumGreaterThan(Integer value) {
            addCriterion("watchNum >", value, "watchnum");
            return (Criteria) this;
        }

        public Criteria andWatchnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("watchNum >=", value, "watchnum");
            return (Criteria) this;
        }

        public Criteria andWatchnumLessThan(Integer value) {
            addCriterion("watchNum <", value, "watchnum");
            return (Criteria) this;
        }

        public Criteria andWatchnumLessThanOrEqualTo(Integer value) {
            addCriterion("watchNum <=", value, "watchnum");
            return (Criteria) this;
        }

        public Criteria andWatchnumIn(List<Integer> values) {
            addCriterion("watchNum in", values, "watchnum");
            return (Criteria) this;
        }

        public Criteria andWatchnumNotIn(List<Integer> values) {
            addCriterion("watchNum not in", values, "watchnum");
            return (Criteria) this;
        }

        public Criteria andWatchnumBetween(Integer value1, Integer value2) {
            addCriterion("watchNum between", value1, value2, "watchnum");
            return (Criteria) this;
        }

        public Criteria andWatchnumNotBetween(Integer value1, Integer value2) {
            addCriterion("watchNum not between", value1, value2, "watchnum");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andNoticestateIsNull() {
            addCriterion("noticeState is null");
            return (Criteria) this;
        }

        public Criteria andNoticestateIsNotNull() {
            addCriterion("noticeState is not null");
            return (Criteria) this;
        }

        public Criteria andNoticestateEqualTo(Integer value) {
            addCriterion("noticeState =", value, "noticestate");
            return (Criteria) this;
        }

        public Criteria andNoticestateNotEqualTo(Integer value) {
            addCriterion("noticeState <>", value, "noticestate");
            return (Criteria) this;
        }

        public Criteria andNoticestateGreaterThan(Integer value) {
            addCriterion("noticeState >", value, "noticestate");
            return (Criteria) this;
        }

        public Criteria andNoticestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("noticeState >=", value, "noticestate");
            return (Criteria) this;
        }

        public Criteria andNoticestateLessThan(Integer value) {
            addCriterion("noticeState <", value, "noticestate");
            return (Criteria) this;
        }

        public Criteria andNoticestateLessThanOrEqualTo(Integer value) {
            addCriterion("noticeState <=", value, "noticestate");
            return (Criteria) this;
        }

        public Criteria andNoticestateIn(List<Integer> values) {
            addCriterion("noticeState in", values, "noticestate");
            return (Criteria) this;
        }

        public Criteria andNoticestateNotIn(List<Integer> values) {
            addCriterion("noticeState not in", values, "noticestate");
            return (Criteria) this;
        }

        public Criteria andNoticestateBetween(Integer value1, Integer value2) {
            addCriterion("noticeState between", value1, value2, "noticestate");
            return (Criteria) this;
        }

        public Criteria andNoticestateNotBetween(Integer value1, Integer value2) {
            addCriterion("noticeState not between", value1, value2, "noticestate");
            return (Criteria) this;
        }

        public Criteria andColumnidIsNull() {
            addCriterion("columnId is null");
            return (Criteria) this;
        }

        public Criteria andColumnidIsNotNull() {
            addCriterion("columnId is not null");
            return (Criteria) this;
        }

        public Criteria andColumnidEqualTo(String value) {
            addCriterion("columnId =", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidNotEqualTo(String value) {
            addCriterion("columnId <>", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidGreaterThan(String value) {
            addCriterion("columnId >", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidGreaterThanOrEqualTo(String value) {
            addCriterion("columnId >=", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidLessThan(String value) {
            addCriterion("columnId <", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidLessThanOrEqualTo(String value) {
            addCriterion("columnId <=", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidLike(String value) {
            addCriterion("columnId like", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidNotLike(String value) {
            addCriterion("columnId not like", value, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidIn(List<String> values) {
            addCriterion("columnId in", values, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidNotIn(List<String> values) {
            addCriterion("columnId not in", values, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidBetween(String value1, String value2) {
            addCriterion("columnId between", value1, value2, "columnid");
            return (Criteria) this;
        }

        public Criteria andColumnidNotBetween(String value1, String value2) {
            addCriterion("columnId not between", value1, value2, "columnid");
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
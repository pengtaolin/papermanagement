package com.lin.paper.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PSubjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PSubjectExample() {
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

        public Criteria andSubjectidIsNull() {
            addCriterion("subjectId is null");
            return (Criteria) this;
        }

        public Criteria andSubjectidIsNotNull() {
            addCriterion("subjectId is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectidEqualTo(String value) {
            addCriterion("subjectId =", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidNotEqualTo(String value) {
            addCriterion("subjectId <>", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidGreaterThan(String value) {
            addCriterion("subjectId >", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidGreaterThanOrEqualTo(String value) {
            addCriterion("subjectId >=", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidLessThan(String value) {
            addCriterion("subjectId <", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidLessThanOrEqualTo(String value) {
            addCriterion("subjectId <=", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidLike(String value) {
            addCriterion("subjectId like", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidNotLike(String value) {
            addCriterion("subjectId not like", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidIn(List<String> values) {
            addCriterion("subjectId in", values, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidNotIn(List<String> values) {
            addCriterion("subjectId not in", values, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidBetween(String value1, String value2) {
            addCriterion("subjectId between", value1, value2, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidNotBetween(String value1, String value2) {
            addCriterion("subjectId not between", value1, value2, "subjectid");
            return (Criteria) this;
        }

        public Criteria andTeachidIsNull() {
            addCriterion("teachId is null");
            return (Criteria) this;
        }

        public Criteria andTeachidIsNotNull() {
            addCriterion("teachId is not null");
            return (Criteria) this;
        }

        public Criteria andTeachidEqualTo(String value) {
            addCriterion("teachId =", value, "teachid");
            return (Criteria) this;
        }

        public Criteria andTeachidNotEqualTo(String value) {
            addCriterion("teachId <>", value, "teachid");
            return (Criteria) this;
        }

        public Criteria andTeachidGreaterThan(String value) {
            addCriterion("teachId >", value, "teachid");
            return (Criteria) this;
        }

        public Criteria andTeachidGreaterThanOrEqualTo(String value) {
            addCriterion("teachId >=", value, "teachid");
            return (Criteria) this;
        }

        public Criteria andTeachidLessThan(String value) {
            addCriterion("teachId <", value, "teachid");
            return (Criteria) this;
        }

        public Criteria andTeachidLessThanOrEqualTo(String value) {
            addCriterion("teachId <=", value, "teachid");
            return (Criteria) this;
        }

        public Criteria andTeachidLike(String value) {
            addCriterion("teachId like", value, "teachid");
            return (Criteria) this;
        }

        public Criteria andTeachidNotLike(String value) {
            addCriterion("teachId not like", value, "teachid");
            return (Criteria) this;
        }

        public Criteria andTeachidIn(List<String> values) {
            addCriterion("teachId in", values, "teachid");
            return (Criteria) this;
        }

        public Criteria andTeachidNotIn(List<String> values) {
            addCriterion("teachId not in", values, "teachid");
            return (Criteria) this;
        }

        public Criteria andTeachidBetween(String value1, String value2) {
            addCriterion("teachId between", value1, value2, "teachid");
            return (Criteria) this;
        }

        public Criteria andTeachidNotBetween(String value1, String value2) {
            addCriterion("teachId not between", value1, value2, "teachid");
            return (Criteria) this;
        }

        public Criteria andSubjectnameIsNull() {
            addCriterion("subjectName is null");
            return (Criteria) this;
        }

        public Criteria andSubjectnameIsNotNull() {
            addCriterion("subjectName is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectnameEqualTo(String value) {
            addCriterion("subjectName =", value, "subjectname");
            return (Criteria) this;
        }

        public Criteria andSubjectnameNotEqualTo(String value) {
            addCriterion("subjectName <>", value, "subjectname");
            return (Criteria) this;
        }

        public Criteria andSubjectnameGreaterThan(String value) {
            addCriterion("subjectName >", value, "subjectname");
            return (Criteria) this;
        }

        public Criteria andSubjectnameGreaterThanOrEqualTo(String value) {
            addCriterion("subjectName >=", value, "subjectname");
            return (Criteria) this;
        }

        public Criteria andSubjectnameLessThan(String value) {
            addCriterion("subjectName <", value, "subjectname");
            return (Criteria) this;
        }

        public Criteria andSubjectnameLessThanOrEqualTo(String value) {
            addCriterion("subjectName <=", value, "subjectname");
            return (Criteria) this;
        }

        public Criteria andSubjectnameLike(String value) {
            addCriterion("subjectName like", value, "subjectname");
            return (Criteria) this;
        }

        public Criteria andSubjectnameNotLike(String value) {
            addCriterion("subjectName not like", value, "subjectname");
            return (Criteria) this;
        }

        public Criteria andSubjectnameIn(List<String> values) {
            addCriterion("subjectName in", values, "subjectname");
            return (Criteria) this;
        }

        public Criteria andSubjectnameNotIn(List<String> values) {
            addCriterion("subjectName not in", values, "subjectname");
            return (Criteria) this;
        }

        public Criteria andSubjectnameBetween(String value1, String value2) {
            addCriterion("subjectName between", value1, value2, "subjectname");
            return (Criteria) this;
        }

        public Criteria andSubjectnameNotBetween(String value1, String value2) {
            addCriterion("subjectName not between", value1, value2, "subjectname");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeIsNull() {
            addCriterion("subjectType is null");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeIsNotNull() {
            addCriterion("subjectType is not null");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeEqualTo(String value) {
            addCriterion("subjectType =", value, "subjecttype");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeNotEqualTo(String value) {
            addCriterion("subjectType <>", value, "subjecttype");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeGreaterThan(String value) {
            addCriterion("subjectType >", value, "subjecttype");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeGreaterThanOrEqualTo(String value) {
            addCriterion("subjectType >=", value, "subjecttype");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeLessThan(String value) {
            addCriterion("subjectType <", value, "subjecttype");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeLessThanOrEqualTo(String value) {
            addCriterion("subjectType <=", value, "subjecttype");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeLike(String value) {
            addCriterion("subjectType like", value, "subjecttype");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeNotLike(String value) {
            addCriterion("subjectType not like", value, "subjecttype");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeIn(List<String> values) {
            addCriterion("subjectType in", values, "subjecttype");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeNotIn(List<String> values) {
            addCriterion("subjectType not in", values, "subjecttype");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeBetween(String value1, String value2) {
            addCriterion("subjectType between", value1, value2, "subjecttype");
            return (Criteria) this;
        }

        public Criteria andSubjecttypeNotBetween(String value1, String value2) {
            addCriterion("subjectType not between", value1, value2, "subjecttype");
            return (Criteria) this;
        }

        public Criteria andSubjectstateIsNull() {
            addCriterion("subjectState is null");
            return (Criteria) this;
        }

        public Criteria andSubjectstateIsNotNull() {
            addCriterion("subjectState is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectstateEqualTo(Integer value) {
            addCriterion("subjectState =", value, "subjectstate");
            return (Criteria) this;
        }

        public Criteria andSubjectstateNotEqualTo(Integer value) {
            addCriterion("subjectState <>", value, "subjectstate");
            return (Criteria) this;
        }

        public Criteria andSubjectstateGreaterThan(Integer value) {
            addCriterion("subjectState >", value, "subjectstate");
            return (Criteria) this;
        }

        public Criteria andSubjectstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("subjectState >=", value, "subjectstate");
            return (Criteria) this;
        }

        public Criteria andSubjectstateLessThan(Integer value) {
            addCriterion("subjectState <", value, "subjectstate");
            return (Criteria) this;
        }

        public Criteria andSubjectstateLessThanOrEqualTo(Integer value) {
            addCriterion("subjectState <=", value, "subjectstate");
            return (Criteria) this;
        }

        public Criteria andSubjectstateIn(List<Integer> values) {
            addCriterion("subjectState in", values, "subjectstate");
            return (Criteria) this;
        }

        public Criteria andSubjectstateNotIn(List<Integer> values) {
            addCriterion("subjectState not in", values, "subjectstate");
            return (Criteria) this;
        }

        public Criteria andSubjectstateBetween(Integer value1, Integer value2) {
            addCriterion("subjectState between", value1, value2, "subjectstate");
            return (Criteria) this;
        }

        public Criteria andSubjectstateNotBetween(Integer value1, Integer value2) {
            addCriterion("subjectState not between", value1, value2, "subjectstate");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("createUser is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("createUser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(String value) {
            addCriterion("createUser =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(String value) {
            addCriterion("createUser <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(String value) {
            addCriterion("createUser >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("createUser >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(String value) {
            addCriterion("createUser <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(String value) {
            addCriterion("createUser <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLike(String value) {
            addCriterion("createUser like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotLike(String value) {
            addCriterion("createUser not like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<String> values) {
            addCriterion("createUser in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<String> values) {
            addCriterion("createUser not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(String value1, String value2) {
            addCriterion("createUser between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(String value1, String value2) {
            addCriterion("createUser not between", value1, value2, "createuser");
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
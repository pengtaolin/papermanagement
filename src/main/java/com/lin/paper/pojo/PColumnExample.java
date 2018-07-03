package com.lin.paper.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PColumnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PColumnExample() {
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

        public Criteria andColumnnameIsNull() {
            addCriterion("columnName is null");
            return (Criteria) this;
        }

        public Criteria andColumnnameIsNotNull() {
            addCriterion("columnName is not null");
            return (Criteria) this;
        }

        public Criteria andColumnnameEqualTo(String value) {
            addCriterion("columnName =", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotEqualTo(String value) {
            addCriterion("columnName <>", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameGreaterThan(String value) {
            addCriterion("columnName >", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameGreaterThanOrEqualTo(String value) {
            addCriterion("columnName >=", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLessThan(String value) {
            addCriterion("columnName <", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLessThanOrEqualTo(String value) {
            addCriterion("columnName <=", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLike(String value) {
            addCriterion("columnName like", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotLike(String value) {
            addCriterion("columnName not like", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameIn(List<String> values) {
            addCriterion("columnName in", values, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotIn(List<String> values) {
            addCriterion("columnName not in", values, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameBetween(String value1, String value2) {
            addCriterion("columnName between", value1, value2, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotBetween(String value1, String value2) {
            addCriterion("columnName not between", value1, value2, "columnname");
            return (Criteria) this;
        }

        public Criteria andParentcolumnIsNull() {
            addCriterion("parentColumn is null");
            return (Criteria) this;
        }

        public Criteria andParentcolumnIsNotNull() {
            addCriterion("parentColumn is not null");
            return (Criteria) this;
        }

        public Criteria andParentcolumnEqualTo(String value) {
            addCriterion("parentColumn =", value, "parentcolumn");
            return (Criteria) this;
        }

        public Criteria andParentcolumnNotEqualTo(String value) {
            addCriterion("parentColumn <>", value, "parentcolumn");
            return (Criteria) this;
        }

        public Criteria andParentcolumnGreaterThan(String value) {
            addCriterion("parentColumn >", value, "parentcolumn");
            return (Criteria) this;
        }

        public Criteria andParentcolumnGreaterThanOrEqualTo(String value) {
            addCriterion("parentColumn >=", value, "parentcolumn");
            return (Criteria) this;
        }

        public Criteria andParentcolumnLessThan(String value) {
            addCriterion("parentColumn <", value, "parentcolumn");
            return (Criteria) this;
        }

        public Criteria andParentcolumnLessThanOrEqualTo(String value) {
            addCriterion("parentColumn <=", value, "parentcolumn");
            return (Criteria) this;
        }

        public Criteria andParentcolumnLike(String value) {
            addCriterion("parentColumn like", value, "parentcolumn");
            return (Criteria) this;
        }

        public Criteria andParentcolumnNotLike(String value) {
            addCriterion("parentColumn not like", value, "parentcolumn");
            return (Criteria) this;
        }

        public Criteria andParentcolumnIn(List<String> values) {
            addCriterion("parentColumn in", values, "parentcolumn");
            return (Criteria) this;
        }

        public Criteria andParentcolumnNotIn(List<String> values) {
            addCriterion("parentColumn not in", values, "parentcolumn");
            return (Criteria) this;
        }

        public Criteria andParentcolumnBetween(String value1, String value2) {
            addCriterion("parentColumn between", value1, value2, "parentcolumn");
            return (Criteria) this;
        }

        public Criteria andParentcolumnNotBetween(String value1, String value2) {
            addCriterion("parentColumn not between", value1, value2, "parentcolumn");
            return (Criteria) this;
        }

        public Criteria andColumnstateIsNull() {
            addCriterion("columnState is null");
            return (Criteria) this;
        }

        public Criteria andColumnstateIsNotNull() {
            addCriterion("columnState is not null");
            return (Criteria) this;
        }

        public Criteria andColumnstateEqualTo(Integer value) {
            addCriterion("columnState =", value, "columnstate");
            return (Criteria) this;
        }

        public Criteria andColumnstateNotEqualTo(Integer value) {
            addCriterion("columnState <>", value, "columnstate");
            return (Criteria) this;
        }

        public Criteria andColumnstateGreaterThan(Integer value) {
            addCriterion("columnState >", value, "columnstate");
            return (Criteria) this;
        }

        public Criteria andColumnstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("columnState >=", value, "columnstate");
            return (Criteria) this;
        }

        public Criteria andColumnstateLessThan(Integer value) {
            addCriterion("columnState <", value, "columnstate");
            return (Criteria) this;
        }

        public Criteria andColumnstateLessThanOrEqualTo(Integer value) {
            addCriterion("columnState <=", value, "columnstate");
            return (Criteria) this;
        }

        public Criteria andColumnstateIn(List<Integer> values) {
            addCriterion("columnState in", values, "columnstate");
            return (Criteria) this;
        }

        public Criteria andColumnstateNotIn(List<Integer> values) {
            addCriterion("columnState not in", values, "columnstate");
            return (Criteria) this;
        }

        public Criteria andColumnstateBetween(Integer value1, Integer value2) {
            addCriterion("columnState between", value1, value2, "columnstate");
            return (Criteria) this;
        }

        public Criteria andColumnstateNotBetween(Integer value1, Integer value2) {
            addCriterion("columnState not between", value1, value2, "columnstate");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andOrderbyIsNull() {
            addCriterion("orderBy is null");
            return (Criteria) this;
        }

        public Criteria andOrderbyIsNotNull() {
            addCriterion("orderBy is not null");
            return (Criteria) this;
        }

        public Criteria andOrderbyEqualTo(Integer value) {
            addCriterion("orderBy =", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotEqualTo(Integer value) {
            addCriterion("orderBy <>", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyGreaterThan(Integer value) {
            addCriterion("orderBy >", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderBy >=", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyLessThan(Integer value) {
            addCriterion("orderBy <", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyLessThanOrEqualTo(Integer value) {
            addCriterion("orderBy <=", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyIn(List<Integer> values) {
            addCriterion("orderBy in", values, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotIn(List<Integer> values) {
            addCriterion("orderBy not in", values, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyBetween(Integer value1, Integer value2) {
            addCriterion("orderBy between", value1, value2, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotBetween(Integer value1, Integer value2) {
            addCriterion("orderBy not between", value1, value2, "orderby");
            return (Criteria) this;
        }

        public Criteria andIsparentIsNull() {
            addCriterion("isParent is null");
            return (Criteria) this;
        }

        public Criteria andIsparentIsNotNull() {
            addCriterion("isParent is not null");
            return (Criteria) this;
        }

        public Criteria andIsparentEqualTo(Integer value) {
            addCriterion("isParent =", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotEqualTo(Integer value) {
            addCriterion("isParent <>", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentGreaterThan(Integer value) {
            addCriterion("isParent >", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentGreaterThanOrEqualTo(Integer value) {
            addCriterion("isParent >=", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentLessThan(Integer value) {
            addCriterion("isParent <", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentLessThanOrEqualTo(Integer value) {
            addCriterion("isParent <=", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentIn(List<Integer> values) {
            addCriterion("isParent in", values, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotIn(List<Integer> values) {
            addCriterion("isParent not in", values, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentBetween(Integer value1, Integer value2) {
            addCriterion("isParent between", value1, value2, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotBetween(Integer value1, Integer value2) {
            addCriterion("isParent not between", value1, value2, "isparent");
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
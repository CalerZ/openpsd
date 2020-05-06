package com.caler.zkl.openpsd.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicationProductExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andType1IsNull() {
            addCriterion("type_1 is null");
            return (Criteria) this;
        }

        public Criteria andType1IsNotNull() {
            addCriterion("type_1 is not null");
            return (Criteria) this;
        }

        public Criteria andType1EqualTo(Long value) {
            addCriterion("type_1 =", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1NotEqualTo(Long value) {
            addCriterion("type_1 <>", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1GreaterThan(Long value) {
            addCriterion("type_1 >", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1GreaterThanOrEqualTo(Long value) {
            addCriterion("type_1 >=", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1LessThan(Long value) {
            addCriterion("type_1 <", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1LessThanOrEqualTo(Long value) {
            addCriterion("type_1 <=", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1In(List<Long> values) {
            addCriterion("type_1 in", values, "type1");
            return (Criteria) this;
        }

        public Criteria andType1NotIn(List<Long> values) {
            addCriterion("type_1 not in", values, "type1");
            return (Criteria) this;
        }

        public Criteria andType1Between(Long value1, Long value2) {
            addCriterion("type_1 between", value1, value2, "type1");
            return (Criteria) this;
        }

        public Criteria andType1NotBetween(Long value1, Long value2) {
            addCriterion("type_1 not between", value1, value2, "type1");
            return (Criteria) this;
        }

        public Criteria andType2IsNull() {
            addCriterion("type_2 is null");
            return (Criteria) this;
        }

        public Criteria andType2IsNotNull() {
            addCriterion("type_2 is not null");
            return (Criteria) this;
        }

        public Criteria andType2EqualTo(Long value) {
            addCriterion("type_2 =", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2NotEqualTo(Long value) {
            addCriterion("type_2 <>", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2GreaterThan(Long value) {
            addCriterion("type_2 >", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2GreaterThanOrEqualTo(Long value) {
            addCriterion("type_2 >=", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2LessThan(Long value) {
            addCriterion("type_2 <", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2LessThanOrEqualTo(Long value) {
            addCriterion("type_2 <=", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2In(List<Long> values) {
            addCriterion("type_2 in", values, "type2");
            return (Criteria) this;
        }

        public Criteria andType2NotIn(List<Long> values) {
            addCriterion("type_2 not in", values, "type2");
            return (Criteria) this;
        }

        public Criteria andType2Between(Long value1, Long value2) {
            addCriterion("type_2 between", value1, value2, "type2");
            return (Criteria) this;
        }

        public Criteria andType2NotBetween(Long value1, Long value2) {
            addCriterion("type_2 not between", value1, value2, "type2");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andMainidIsNull() {
            addCriterion("mainid is null");
            return (Criteria) this;
        }

        public Criteria andMainidIsNotNull() {
            addCriterion("mainid is not null");
            return (Criteria) this;
        }

        public Criteria andMainidEqualTo(Long value) {
            addCriterion("mainid =", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidNotEqualTo(Long value) {
            addCriterion("mainid <>", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidGreaterThan(Long value) {
            addCriterion("mainid >", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidGreaterThanOrEqualTo(Long value) {
            addCriterion("mainid >=", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidLessThan(Long value) {
            addCriterion("mainid <", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidLessThanOrEqualTo(Long value) {
            addCriterion("mainid <=", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidIn(List<Long> values) {
            addCriterion("mainid in", values, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidNotIn(List<Long> values) {
            addCriterion("mainid not in", values, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidBetween(Long value1, Long value2) {
            addCriterion("mainid between", value1, value2, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidNotBetween(Long value1, Long value2) {
            addCriterion("mainid not between", value1, value2, "mainid");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNull() {
            addCriterion("specifications is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNotNull() {
            addCriterion("specifications is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsEqualTo(String value) {
            addCriterion("specifications =", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotEqualTo(String value) {
            addCriterion("specifications <>", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThan(String value) {
            addCriterion("specifications >", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("specifications >=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThan(String value) {
            addCriterion("specifications <", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("specifications <=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLike(String value) {
            addCriterion("specifications like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotLike(String value) {
            addCriterion("specifications not like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIn(List<String> values) {
            addCriterion("specifications in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotIn(List<String> values) {
            addCriterion("specifications not in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsBetween(String value1, String value2) {
            addCriterion("specifications between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotBetween(String value1, String value2) {
            addCriterion("specifications not between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(Long value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(Long value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(Long value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(Long value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(Long value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(Long value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<Long> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<Long> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(Long value1, Long value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(Long value1, Long value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andStandardIsNull() {
            addCriterion("standard is null");
            return (Criteria) this;
        }

        public Criteria andStandardIsNotNull() {
            addCriterion("standard is not null");
            return (Criteria) this;
        }

        public Criteria andStandardEqualTo(String value) {
            addCriterion("standard =", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotEqualTo(String value) {
            addCriterion("standard <>", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThan(String value) {
            addCriterion("standard >", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThanOrEqualTo(String value) {
            addCriterion("standard >=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThan(String value) {
            addCriterion("standard <", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThanOrEqualTo(String value) {
            addCriterion("standard <=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLike(String value) {
            addCriterion("standard like", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotLike(String value) {
            addCriterion("standard not like", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardIn(List<String> values) {
            addCriterion("standard in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotIn(List<String> values) {
            addCriterion("standard not in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardBetween(String value1, String value2) {
            addCriterion("standard between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotBetween(String value1, String value2) {
            addCriterion("standard not between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNull() {
            addCriterion("supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(Long value) {
            addCriterion("supplier_id =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(Long value) {
            addCriterion("supplier_id <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(Long value) {
            addCriterion("supplier_id >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("supplier_id >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(Long value) {
            addCriterion("supplier_id <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(Long value) {
            addCriterion("supplier_id <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<Long> values) {
            addCriterion("supplier_id in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<Long> values) {
            addCriterion("supplier_id not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(Long value1, Long value2) {
            addCriterion("supplier_id between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(Long value1, Long value2) {
            addCriterion("supplier_id not between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSafetyStockIsNull() {
            addCriterion("safety_stock is null");
            return (Criteria) this;
        }

        public Criteria andSafetyStockIsNotNull() {
            addCriterion("safety_stock is not null");
            return (Criteria) this;
        }

        public Criteria andSafetyStockEqualTo(Double value) {
            addCriterion("safety_stock =", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockNotEqualTo(Double value) {
            addCriterion("safety_stock <>", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockGreaterThan(Double value) {
            addCriterion("safety_stock >", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockGreaterThanOrEqualTo(Double value) {
            addCriterion("safety_stock >=", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockLessThan(Double value) {
            addCriterion("safety_stock <", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockLessThanOrEqualTo(Double value) {
            addCriterion("safety_stock <=", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockIn(List<Double> values) {
            addCriterion("safety_stock in", values, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockNotIn(List<Double> values) {
            addCriterion("safety_stock not in", values, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockBetween(Double value1, Double value2) {
            addCriterion("safety_stock between", value1, value2, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockNotBetween(Double value1, Double value2) {
            addCriterion("safety_stock not between", value1, value2, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andLastMonthQuantityIsNull() {
            addCriterion("last_month_quantity is null");
            return (Criteria) this;
        }

        public Criteria andLastMonthQuantityIsNotNull() {
            addCriterion("last_month_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andLastMonthQuantityEqualTo(Double value) {
            addCriterion("last_month_quantity =", value, "lastMonthQuantity");
            return (Criteria) this;
        }

        public Criteria andLastMonthQuantityNotEqualTo(Double value) {
            addCriterion("last_month_quantity <>", value, "lastMonthQuantity");
            return (Criteria) this;
        }

        public Criteria andLastMonthQuantityGreaterThan(Double value) {
            addCriterion("last_month_quantity >", value, "lastMonthQuantity");
            return (Criteria) this;
        }

        public Criteria andLastMonthQuantityGreaterThanOrEqualTo(Double value) {
            addCriterion("last_month_quantity >=", value, "lastMonthQuantity");
            return (Criteria) this;
        }

        public Criteria andLastMonthQuantityLessThan(Double value) {
            addCriterion("last_month_quantity <", value, "lastMonthQuantity");
            return (Criteria) this;
        }

        public Criteria andLastMonthQuantityLessThanOrEqualTo(Double value) {
            addCriterion("last_month_quantity <=", value, "lastMonthQuantity");
            return (Criteria) this;
        }

        public Criteria andLastMonthQuantityIn(List<Double> values) {
            addCriterion("last_month_quantity in", values, "lastMonthQuantity");
            return (Criteria) this;
        }

        public Criteria andLastMonthQuantityNotIn(List<Double> values) {
            addCriterion("last_month_quantity not in", values, "lastMonthQuantity");
            return (Criteria) this;
        }

        public Criteria andLastMonthQuantityBetween(Double value1, Double value2) {
            addCriterion("last_month_quantity between", value1, value2, "lastMonthQuantity");
            return (Criteria) this;
        }

        public Criteria andLastMonthQuantityNotBetween(Double value1, Double value2) {
            addCriterion("last_month_quantity not between", value1, value2, "lastMonthQuantity");
            return (Criteria) this;
        }

        public Criteria andOnHandInventoryIsNull() {
            addCriterion("on_hand_inventory is null");
            return (Criteria) this;
        }

        public Criteria andOnHandInventoryIsNotNull() {
            addCriterion("on_hand_inventory is not null");
            return (Criteria) this;
        }

        public Criteria andOnHandInventoryEqualTo(Double value) {
            addCriterion("on_hand_inventory =", value, "onHandInventory");
            return (Criteria) this;
        }

        public Criteria andOnHandInventoryNotEqualTo(Double value) {
            addCriterion("on_hand_inventory <>", value, "onHandInventory");
            return (Criteria) this;
        }

        public Criteria andOnHandInventoryGreaterThan(Double value) {
            addCriterion("on_hand_inventory >", value, "onHandInventory");
            return (Criteria) this;
        }

        public Criteria andOnHandInventoryGreaterThanOrEqualTo(Double value) {
            addCriterion("on_hand_inventory >=", value, "onHandInventory");
            return (Criteria) this;
        }

        public Criteria andOnHandInventoryLessThan(Double value) {
            addCriterion("on_hand_inventory <", value, "onHandInventory");
            return (Criteria) this;
        }

        public Criteria andOnHandInventoryLessThanOrEqualTo(Double value) {
            addCriterion("on_hand_inventory <=", value, "onHandInventory");
            return (Criteria) this;
        }

        public Criteria andOnHandInventoryIn(List<Double> values) {
            addCriterion("on_hand_inventory in", values, "onHandInventory");
            return (Criteria) this;
        }

        public Criteria andOnHandInventoryNotIn(List<Double> values) {
            addCriterion("on_hand_inventory not in", values, "onHandInventory");
            return (Criteria) this;
        }

        public Criteria andOnHandInventoryBetween(Double value1, Double value2) {
            addCriterion("on_hand_inventory between", value1, value2, "onHandInventory");
            return (Criteria) this;
        }

        public Criteria andOnHandInventoryNotBetween(Double value1, Double value2) {
            addCriterion("on_hand_inventory not between", value1, value2, "onHandInventory");
            return (Criteria) this;
        }

        public Criteria andReportedQuantityIsNull() {
            addCriterion("reported_quantity is null");
            return (Criteria) this;
        }

        public Criteria andReportedQuantityIsNotNull() {
            addCriterion("reported_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andReportedQuantityEqualTo(Double value) {
            addCriterion("reported_quantity =", value, "reportedQuantity");
            return (Criteria) this;
        }

        public Criteria andReportedQuantityNotEqualTo(Double value) {
            addCriterion("reported_quantity <>", value, "reportedQuantity");
            return (Criteria) this;
        }

        public Criteria andReportedQuantityGreaterThan(Double value) {
            addCriterion("reported_quantity >", value, "reportedQuantity");
            return (Criteria) this;
        }

        public Criteria andReportedQuantityGreaterThanOrEqualTo(Double value) {
            addCriterion("reported_quantity >=", value, "reportedQuantity");
            return (Criteria) this;
        }

        public Criteria andReportedQuantityLessThan(Double value) {
            addCriterion("reported_quantity <", value, "reportedQuantity");
            return (Criteria) this;
        }

        public Criteria andReportedQuantityLessThanOrEqualTo(Double value) {
            addCriterion("reported_quantity <=", value, "reportedQuantity");
            return (Criteria) this;
        }

        public Criteria andReportedQuantityIn(List<Double> values) {
            addCriterion("reported_quantity in", values, "reportedQuantity");
            return (Criteria) this;
        }

        public Criteria andReportedQuantityNotIn(List<Double> values) {
            addCriterion("reported_quantity not in", values, "reportedQuantity");
            return (Criteria) this;
        }

        public Criteria andReportedQuantityBetween(Double value1, Double value2) {
            addCriterion("reported_quantity between", value1, value2, "reportedQuantity");
            return (Criteria) this;
        }

        public Criteria andReportedQuantityNotBetween(Double value1, Double value2) {
            addCriterion("reported_quantity not between", value1, value2, "reportedQuantity");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(Date value) {
            addCriterion("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(Date value) {
            addCriterion("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(Date value) {
            addCriterion("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(Date value) {
            addCriterion("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(Date value) {
            addCriterion("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<Date> values) {
            addCriterion("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<Date> values) {
            addCriterion("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(Date value1, Date value2) {
            addCriterion("record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(Date value1, Date value2) {
            addCriterion("record_time not between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordOnIsNull() {
            addCriterion("record_on is null");
            return (Criteria) this;
        }

        public Criteria andRecordOnIsNotNull() {
            addCriterion("record_on is not null");
            return (Criteria) this;
        }

        public Criteria andRecordOnEqualTo(Long value) {
            addCriterion("record_on =", value, "recordOn");
            return (Criteria) this;
        }

        public Criteria andRecordOnNotEqualTo(Long value) {
            addCriterion("record_on <>", value, "recordOn");
            return (Criteria) this;
        }

        public Criteria andRecordOnGreaterThan(Long value) {
            addCriterion("record_on >", value, "recordOn");
            return (Criteria) this;
        }

        public Criteria andRecordOnGreaterThanOrEqualTo(Long value) {
            addCriterion("record_on >=", value, "recordOn");
            return (Criteria) this;
        }

        public Criteria andRecordOnLessThan(Long value) {
            addCriterion("record_on <", value, "recordOn");
            return (Criteria) this;
        }

        public Criteria andRecordOnLessThanOrEqualTo(Long value) {
            addCriterion("record_on <=", value, "recordOn");
            return (Criteria) this;
        }

        public Criteria andRecordOnIn(List<Long> values) {
            addCriterion("record_on in", values, "recordOn");
            return (Criteria) this;
        }

        public Criteria andRecordOnNotIn(List<Long> values) {
            addCriterion("record_on not in", values, "recordOn");
            return (Criteria) this;
        }

        public Criteria andRecordOnBetween(Long value1, Long value2) {
            addCriterion("record_on between", value1, value2, "recordOn");
            return (Criteria) this;
        }

        public Criteria andRecordOnNotBetween(Long value1, Long value2) {
            addCriterion("record_on not between", value1, value2, "recordOn");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodIsNull() {
            addCriterion("purchase_method is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodIsNotNull() {
            addCriterion("purchase_method is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodEqualTo(Long value) {
            addCriterion("purchase_method =", value, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodNotEqualTo(Long value) {
            addCriterion("purchase_method <>", value, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodGreaterThan(Long value) {
            addCriterion("purchase_method >", value, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodGreaterThanOrEqualTo(Long value) {
            addCriterion("purchase_method >=", value, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodLessThan(Long value) {
            addCriterion("purchase_method <", value, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodLessThanOrEqualTo(Long value) {
            addCriterion("purchase_method <=", value, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodIn(List<Long> values) {
            addCriterion("purchase_method in", values, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodNotIn(List<Long> values) {
            addCriterion("purchase_method not in", values, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodBetween(Long value1, Long value2) {
            addCriterion("purchase_method between", value1, value2, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andPurchaseMethodNotBetween(Long value1, Long value2) {
            addCriterion("purchase_method not between", value1, value2, "purchaseMethod");
            return (Criteria) this;
        }

        public Criteria andProdLineMembersIsNull() {
            addCriterion("prod_line_members is null");
            return (Criteria) this;
        }

        public Criteria andProdLineMembersIsNotNull() {
            addCriterion("prod_line_members is not null");
            return (Criteria) this;
        }

        public Criteria andProdLineMembersEqualTo(Integer value) {
            addCriterion("prod_line_members =", value, "prodLineMembers");
            return (Criteria) this;
        }

        public Criteria andProdLineMembersNotEqualTo(Integer value) {
            addCriterion("prod_line_members <>", value, "prodLineMembers");
            return (Criteria) this;
        }

        public Criteria andProdLineMembersGreaterThan(Integer value) {
            addCriterion("prod_line_members >", value, "prodLineMembers");
            return (Criteria) this;
        }

        public Criteria andProdLineMembersGreaterThanOrEqualTo(Integer value) {
            addCriterion("prod_line_members >=", value, "prodLineMembers");
            return (Criteria) this;
        }

        public Criteria andProdLineMembersLessThan(Integer value) {
            addCriterion("prod_line_members <", value, "prodLineMembers");
            return (Criteria) this;
        }

        public Criteria andProdLineMembersLessThanOrEqualTo(Integer value) {
            addCriterion("prod_line_members <=", value, "prodLineMembers");
            return (Criteria) this;
        }

        public Criteria andProdLineMembersIn(List<Integer> values) {
            addCriterion("prod_line_members in", values, "prodLineMembers");
            return (Criteria) this;
        }

        public Criteria andProdLineMembersNotIn(List<Integer> values) {
            addCriterion("prod_line_members not in", values, "prodLineMembers");
            return (Criteria) this;
        }

        public Criteria andProdLineMembersBetween(Integer value1, Integer value2) {
            addCriterion("prod_line_members between", value1, value2, "prodLineMembers");
            return (Criteria) this;
        }

        public Criteria andProdLineMembersNotBetween(Integer value1, Integer value2) {
            addCriterion("prod_line_members not between", value1, value2, "prodLineMembers");
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
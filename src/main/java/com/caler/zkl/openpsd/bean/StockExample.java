package com.caler.zkl.openpsd.bean;

import java.util.ArrayList;
import java.util.List;

public class StockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockExample() {
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
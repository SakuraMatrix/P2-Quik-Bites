package com.github.arenia.orders.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("orders")
public class Order {
    
    @PrimaryKey
    private int orderId;
    private int customerId;
    private int driverId;
    private int resturantId;
    private double total;
    private String orderStatus;

    /**
     * @param orderId
     * @param customerId
     * @param driverId
     * @param resturantId
     * @param total
     * @param orderStatus
     */
    public Order(int orderId, int customerId, int driverId, int resturantId, double total, String orderStatus) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.driverId = driverId;
        this.resturantId = resturantId;
        this.total = total;
        this.orderStatus = orderStatus;
    }

    public Order(){
        
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }
    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }
    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    /**
     * @return the driverId
     */
    public int getDriverId() {
        return driverId;
    }
    /**
     * @param driverId the driverId to set
     */
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    /**
     * @return the resturantId
     */
    public int getResturantId() {
        return resturantId;
    }
    /**
     * @param resturantId the resturantId to set
     */
    public void setResturantId(int resturantId) {
        this.resturantId = resturantId;
    }
    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }
    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    /**
     * @return the orderStatus
     */
    public String getOrderStatus() {
        return orderStatus;
    }
    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }   

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + customerId;
        result = prime * result + driverId;
        result = prime * result + orderId;
        result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
        result = prime * result + resturantId;
        long temp;
        temp = Double.doubleToLongBits(total);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Order [customerId=");
        builder.append(customerId);
        builder.append(", driverId=");
        builder.append(driverId);
        builder.append(", orderId=");
        builder.append(orderId);
        builder.append(", orderStatus=");
        builder.append(orderStatus);
        builder.append(", resturantId=");
        builder.append(resturantId);
        builder.append(", total=");
        builder.append(total);
        builder.append("]");
        return builder.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Order other = (Order) obj;
        if (customerId != other.customerId) {
            return false;
        }
        if (driverId != other.driverId) {
            return false;
        }
        if (orderId != other.orderId) {
            return false;
        }
        if (orderStatus == null) {
            if (other.orderStatus != null) {
                return false;
            }
        } else if (!orderStatus.equals(other.orderStatus)) {
            return false;
        }
        if (resturantId != other.resturantId) {
            return false;
        }
        if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        return true;
    }

    

}
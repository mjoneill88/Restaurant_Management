package com.example.restaurantManagement.restaurantManagement.NotificationDTO.Domain;


public class NotificationDto {
    Integer id;
    String itemName;
    String currentQuantity;
    String restaurant_name;


    public NotificationDto(Integer id, String itemName, String currentQuantity, String restaurant_name) {
        this.id = id;
        this.itemName = itemName;
        this.currentQuantity = currentQuantity;
        this.restaurant_name = restaurant_name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(String currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public interface notificationrepofunction{
        Integer getId();
        String getItem_name();
        String getQuantity();
        String getName();
    }


    @Override
    public String toString() {
        return "NotificationDto{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", currentQuantity='" + currentQuantity + '\'' +
                ", restaurant_name='" + restaurant_name + '\'' +
                '}';
    }
}

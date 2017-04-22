package com.mdw.wrappers;

public class RoomWrapper {
    private long id;

    private String image;

    private String type;

    private String extraServices;

    private int hotel;

    private double price;

    public RoomWrapper() {
    }

    public RoomWrapper(long id, String image, String type, String extraServices, int hotel, double price) {
        super();
        this.id = id;
        this.image = image;
        this.type = type;
        this.extraServices = extraServices;
        this.hotel = hotel;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtraServices() {
        return extraServices;
    }

    public void setExtraServices(String extraServices) {
        this.extraServices = extraServices;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RoomWrapper [id=" + id + ", image=" + image + ", type=" + type + ", extraServices=" + extraServices + ", hotel=" + hotel
                + ", price=" + price + "]";
    }
    
    
}

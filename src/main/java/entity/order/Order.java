package entity.order;

//Builder
public class Order {

    private final String mainDish;

    private final String desert;

    private final double price;

    public String getMainDish() {
        return mainDish;
    }

    public String getDesert() {
        return desert;
    }

    public double getPrice() {
        return price;
    }

    private Order(OrderBuilder orderBuilder) {
        this.mainDish = orderBuilder.mainDish;
        this.price = orderBuilder.price;
        this.desert = orderBuilder.desert;
    }

    @Override
    public String toString() {
        return "Main dish=" + mainDish +
                ", Desert='" + desert +
                ", Price=" + price;
    }

    public static class OrderBuilder {

        private String mainDish;

        private String desert;

        private double price;

        private OrderBuilder() {

        }

        public static OrderBuilder builder() {
            return new OrderBuilder();
        }

        public OrderBuilder mainDish(String mainDish) {
            this.mainDish = mainDish;
            return this;
        }

        public OrderBuilder desert(String desert) {
            this.desert = desert;
            return this;
        }

        public OrderBuilder price(double price) {
            this.price = price;
            return this;
        }

        public Order build() {
            return new Order(this);
        }


    }

}

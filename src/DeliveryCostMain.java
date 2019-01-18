public class DeliveryCostMain {
    public static void main(String[] args) {
        IDeliveryInform deliveryInform = new DeliveryInformImpl();
        deliveryInform.setDdeliveryParameters();
        deliveryInform.totalPrice();
    }
}

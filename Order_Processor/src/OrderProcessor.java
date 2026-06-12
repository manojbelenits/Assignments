@FunctionalInterface
interface OrderProcessor {
    Order process(Order order);

    default OrderProcessor andThen(OrderProcessor nextProcessor) {
        return order -> nextProcessor.process(this.process(order));
    }
}
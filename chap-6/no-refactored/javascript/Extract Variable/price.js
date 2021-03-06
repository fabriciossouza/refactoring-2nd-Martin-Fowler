export function price(order) {
  return order.quantity * order.itemPrice - 
      Math.max(0, order.quantity - 500) * order.itemPrice * 0.05 + 
      Math.min(basePrice * 0.1, 100);
}
export function price(anOrder) {
  let basePrice = anOrder.basePrice;
  return basePrice > 1000;
}
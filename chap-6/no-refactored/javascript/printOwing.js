export function printOwing(invoice) {
  
  console.log("***********************");
  console.log("**** Customer Owes ****");
  console.log("***********************");

  let outstanding = 0;
  for (const o of invoice.orders) {
    outstanding += o.amount;
  }

  const today = Clock.today;
  invoice.dueDate = new Date(today.getFullYear(), today.getMonth(), today.getDate() + 30);

  console.log(`name: ${invoice.customer}`);
  console.log(`amount: ${outstanding}`);
  console.log(`due: ${invoice.dueDate.toLocaleDateString("en-US")}`);

}

 const stripe = Stripe('pk_test_51PN8oTP2FgeDNnn4ZFl9OQ8nO0lUTQ9DuP6RqSmKqvNkNAqK2XARIoEFON9GFz9yMqTYgPZaBn7E88Yv08g8xTO900QP2xaaZX');
 const paymentButton = document.querySelector('#paymentButton');
 
 paymentButton.addEventListener('click', () => {
   stripe.redirectToCheckout({
     sessionId: sessionId
   })
 });
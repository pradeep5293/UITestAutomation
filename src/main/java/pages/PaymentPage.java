package pages;

public class PaymentPage {
	
	public void paymentWithCard() {
		System.out.println("card payment");	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginPage login=new LoginPage();
		login.loginPage();
		CartPage cart=new CartPage();
		cart.AddToCard();
		PaymentPage  payment=new PaymentPage();
		payment.paymentWithCard();
	}

}

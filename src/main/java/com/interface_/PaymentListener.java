package com.interface_;

public interface PaymentListener {

	void paymentDone();

	void paymentCanceled();

	void paymentDataChanged();
}

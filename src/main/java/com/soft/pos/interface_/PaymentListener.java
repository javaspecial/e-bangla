package com.soft.pos.interface_;

public interface PaymentListener {

	void paymentDone();

	void paymentCanceled();

	void paymentDataChanged();
}

package dev.jhonis.ecommerce.payment.service;

import dev.jhonis.ecommerce.checkout.event.CheckoutCreatedEvent;
import dev.jhonis.ecommerce.payment.entity.PaymentEntity;

import java.util.Optional;

public interface PaymentService {
    Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent);
}

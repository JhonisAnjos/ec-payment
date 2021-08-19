package dev.jhonis.ecommerce.payment.service.impl;

import dev.jhonis.ecommerce.checkout.event.CheckoutCreatedEvent;
import dev.jhonis.ecommerce.payment.entity.PaymentEntity;
import dev.jhonis.ecommerce.payment.repository.PaymentRepository;
import dev.jhonis.ecommerce.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent) {
        final PaymentEntity paymentEntity = PaymentEntity.builder()
                .checkoutCode(checkoutCreatedEvent.getCheckoutCode())
                .code(UUID.randomUUID().toString())
                .build();
        paymentRepository.save(paymentEntity);
        return Optional.of(paymentEntity);
    }
}

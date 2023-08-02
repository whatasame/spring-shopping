package shopping.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shopping.domain.cart.CartProduct;
import shopping.dto.request.CartProductRequest;
import shopping.exception.ShoppingException;
import shopping.repository.CartProductRepository;
import shopping.repository.ProductRepository;

@Service
@Transactional(readOnly = true)
public class CartProductService {

    private final CartProductRepository cartProductRepository;
    private final ProductRepository productRepository;

    public CartProductService(final CartProductRepository cartProductRepository,
        final ProductRepository productRepository) {
        this.cartProductRepository = cartProductRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public CartProduct createCartProduct(
        final Long memberId,
        final CartProductRequest cartProductRequest
    ) {
        final Long productId = cartProductRequest.getProductId();

        productRepository.findById(productId)
            .orElseThrow(() -> new ShoppingException("존재하지 않는 상품입니다. 입력값: " + productId));

        cartProductRepository.findByMemberIdAndProductId(memberId, productId)
            .ifPresent(cartProduct -> {
                throw new ShoppingException(
                    "이미 장바구니에 담긴 상품입니다. 입력값: " + cartProduct.getProductId());
            });

        return cartProductRepository.save(new CartProduct(memberId, productId));
    }
}
package shopping.domain.cart;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart_products")
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_product_id")
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "product_id")
    private Long productId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "quantity"))
    private CartProductQuantity quantity;

    protected CartProduct() {
    }

    public CartProduct(
        final Long id,
        final Long memberId,
        final Long productId,
        final CartProductQuantity quantity
    ) {
        this.id = id;
        this.memberId = memberId;
        this.productId = productId;
        this.quantity = quantity;
    }
}

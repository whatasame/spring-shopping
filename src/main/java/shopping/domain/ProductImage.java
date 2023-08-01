package shopping.domain;

import java.util.Objects;
import javax.persistence.Embeddable;
import shopping.exception.ShoppingException;

@Embeddable
public class ProductImage {

    private String image;

    protected ProductImage() {
    }

    public ProductImage(final String image) {
        validateIsNotNullOrEmpty(image);

        this.image = image;
    }

    private void validateIsNotNullOrEmpty(final String value) {
        if (value == null || value.isBlank()) {
            throw new ShoppingException("상품 이미지는 비어있거나 공백이면 안됩니다. 입력값: " + value);
        }
    }

    public String getImage() {
        return this.image;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ProductImage that = (ProductImage) o;
        return Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image);
    }
}

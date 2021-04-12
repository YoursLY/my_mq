package demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author yun.lu
 * @date 2021/4/12 22:45
 * @desc
 */
@Getter
@Setter
@AllArgsConstructor
public class Order {
    private Integer id;

    private String wholeOrderNo;

    private String orderStatus;

    private int price;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

package core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * @author yun.lu
 * @date 2021/4/12 21:57
 * @desc
 */
@AllArgsConstructor
@Setter
@Getter
public class JmqMessage<T> {

    private HashMap<String, Object> headers;

    private T body;
}

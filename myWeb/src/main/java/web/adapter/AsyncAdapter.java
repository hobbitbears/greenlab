package web.adapter;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.function.SupplierUtils;

import java.util.function.Supplier;

@Component
public class AsyncAdapter {
    @Async
    public <T> T resolve(Supplier<T> supplier) {
        return SupplierUtils.resolve(supplier);
    }
}

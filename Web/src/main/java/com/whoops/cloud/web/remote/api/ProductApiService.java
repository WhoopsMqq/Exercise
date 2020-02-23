package com.whoops.cloud.web.remote.api;

import com.whoops.cloud.inter.ProductApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "service", path = "service")
public interface ProductApiService extends ProductApi {
}

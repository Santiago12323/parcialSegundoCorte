package com.arep.parcial.proxy.Search.service.port;

import com.arep.parcial.proxy.Search.Response;

public interface SearchService {
    Response getLinear(String list, int value);

    Response getBYnary(String list, int value);
}

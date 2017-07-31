package com.zoutly.api.resource;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@Getter
public class BaseData {
    Instant created = Instant.now();
}

package com.hbq.cms.common.model;

import lombok.Data;

@Data
public class HexoToken {
    private String client_id;
    private String client_secret;
    private String code;
}

package com.hl.springsecurity.model;

/**
 * @version V1.0.0
 * @Description 生成 token 所需的信息
 */
public interface TokenDetail {

    //TODO: 这里封装了一层，不直接使用 username 做参数的原因是可以方便未来增加其他要封装到 token 中的信息

    String getUsername();
}

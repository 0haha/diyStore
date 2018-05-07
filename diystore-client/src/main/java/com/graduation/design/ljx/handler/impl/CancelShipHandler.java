package com.graduation.design.ljx.handler.impl;

import com.graduation.design.ljx.domain.annotation.Handler;
import com.graduation.design.ljx.handler.BaseHandler;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hehe on 18-3-5.
 */
@Slf4j
@Handler(name = "CancelShipHandler",business = "CancelShip")
public class CancelShipHandler extends BaseHandler{

    public void execute(){
        log.info("Try log");
        System.out.println("Try to call the execute of CancelShipHandler");
    }
}

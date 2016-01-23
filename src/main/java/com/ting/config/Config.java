package com.ting.config;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.ting.controller.MallController;
import com.ting.controller.MessageController;
import com.ting.controller.QueryPriceController;
import com.ting.controller.QuotationController;
import com.ting.domain.*;

/**
 * Created by tingsky on 16/1/12.
 */
public class Config extends JFinalConfig {
    public void configConstant(Constants me) {
        PropKit.use("config.txt");
        me.setDevMode(PropKit.getBoolean("devMode"));
    }

    public void configRoute(Routes me) {
        me.add("/mall", MallController.class);
        me.add("/quotation", QuotationController.class);
        me.add("/queryPrice", QueryPriceController.class);
    }

    public void configPlugin(Plugins me) {
        loadPropertyFile("config.txt");

        C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"));
        me.add(c3p0Plugin);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
        _MappingKit.mapping(arp);
        me.add(arp);

    }

    public void configInterceptor(Interceptors me) {
    }

    public void configHandler(Handlers me) {
    }
}

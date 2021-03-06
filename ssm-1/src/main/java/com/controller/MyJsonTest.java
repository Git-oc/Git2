package com.controller;

import com.po.ItemsCustom;
import com.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MyJsonTest {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/testJson")
    @ResponseBody
    public Object responseJson() throws Exception {
        class ResponseBody {
            String code = "10000";
            String message = "成功";
            Map<String, Object> result = new HashMap<>();

            public Map<String, Object> getResult() {
                return result;
            }

            public void setResult(Map<String, Object> result) {
                this.result = result;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }
        }

        ResponseBody responseBody = new ResponseBody();
        ItemsCustom itemsCustom = itemsService.findItemsById(1);
        responseBody.getResult().put("itemsCustom", itemsCustom);
        return responseBody;

    }
}

package com.patterncat.controller;

import com.patterncat.domain.User;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

/**
 * http://localhost:8080/swagger-ui.html
 *
 * Created by patterncat on 2016-05-05.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private ConcurrentHashMap<String,User> userMap = new ConcurrentHashMap<>();

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody
            @ApiParam(name = "user",value = "json format",required = true)
                          User user){
        userMap.put(user.getId(),user);
        return "add successfully";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody
                             @ApiParam(name = "user",value = "json format",required = true)
                             User user) {
        userMap.put(user.getId(),user);
        return "update successfully";
    }

    @RequestMapping(method = RequestMethod.GET)
    public User get(@RequestParam(value = "id", required = true) String id){
        return userMap.get(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(@RequestParam(value = "id", required = true) String id){
        userMap.remove(id);
        return "delete successfully";
    }

}

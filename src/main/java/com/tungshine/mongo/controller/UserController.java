package com.tungshine.mongo.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.tungshine.mongo.model.User;
import com.tungshine.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: TungShine
 * @Description:
 * @Date: Create in 1:08 2018/7/19
 * @Modified By:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Autowired
    private GridFS gridFS;

    @ResponseBody
    @RequestMapping("/get/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("age") Integer age) {
        User user = new User(id, name, age);
        userService.addUser(user);
        return "success";
    }

    @ResponseBody
    @RequestMapping("upload")
    public void upload(@RequestParam("file") MultipartFile file) {
        try {
            GridFSFile store = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename());
            Object objectId = store.getId();
            System.out.print(objectId);
            System.out.print(file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping("download")
    public void download(@RequestParam("filename") Object filename, HttpServletResponse response) {
        GridFSDBFile gridFSDBFile = gridFS.findOne(new BasicDBObject("filename", filename));
        System.out.print(gridFSDBFile.getFilename());
        try {
            OutputStream sos = response.getOutputStream();
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + gridFSDBFile.getFilename() + "\"");
            gridFSDBFile.writeTo(sos);
            sos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

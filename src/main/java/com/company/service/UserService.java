package com.company.service;

import com.company.dao.UserDao;
import com.company.model.UserEntity;
import com.company.test.proxy.Interface;
import com.company.util.Constant;
import com.company.util.UploadedFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by puyangsky on 2016/6/23.
 */
@Service
public class UserService {
    @Resource(name = "userDaoIml")
    UserDao dao;

    public UserEntity getUserById(String id) {
        try {
            int uid = Integer.valueOf(id);
            return dao.getUserById(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public UserEntity getUserByEmail (String email) {
        return dao.getUserByEmail(email);
    }


    public boolean login(UserEntity user) {
//        UserEntity userEntity = dao.getUserByEmail(user.getEmail());
//        if (userEntity == null) {
//            return false;
//        }
//        return userEntity.getPassword().equals(user.getPassword());
        return true;
    }

    public List<UserEntity> getAllUser() {
        List<UserEntity> list = dao.getAllUser();
        List<UserEntity> delList = new ArrayList<UserEntity>();
        for (UserEntity u : list) {
            if (u.getStatus() != 1) {
                delList.add(u);
            }
        }
        list.removeAll(delList);
        return list;
    }

    public int addUser(UserEntity userEntity) {
        return dao.addUser(userEntity);
    }

    public boolean delUser(int id) {
        return dao.delUserById(id) > 0;
    }

    public boolean delUsers(List<Integer> ids) {
        boolean res = false;
        for (int id : ids) {
            res = delUser(id);
        }
        return res;
    }

    public boolean updateUser(UserEntity userEntity) {
        return dao.updateUser(userEntity) > 0;
    }

    public void getImage(String name, String type,
                         HttpServletResponse response) throws IOException {
        OutputStream out = null;
        BufferedImage image = null;
        try {
            File file = new File(Constant.IMGDIR + name + "." + type);
            image = ImageIO.read(file);
            out = response.getOutputStream();
            ImageIO.write(image, type, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                out.close();
        }
    }

    public String saveImage(MultipartHttpServletRequest request) throws IOException {
        UploadedFile ufile;
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = request.getFile(itr.next());

        String name = Calendar.getInstance().getTimeInMillis() + "";
        String type = "jpg";
        String originName = mpf.getOriginalFilename();
        if (originName.contains(".")) {
            String[] names = originName.split("\\.");
            type = names[1];
        }
        ufile = new UploadedFile(mpf.getBytes(), name + "." + type, mpf.getContentType(),
                mpf.getBytes().length);
        String imagePath = "http://" + request.getServerName() + ":" + request.getServerPort() + "/user/image/" +
                name + "/" + type;
        return imagePath;
    }
}

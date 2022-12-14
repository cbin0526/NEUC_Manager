package com.etc.my.controller;


import com.etc.my.dto.*;
import com.etc.my.entity.Car;
import com.etc.my.entity.User;
import com.etc.my.service.CarService;
import com.etc.my.service.UserService;
import com.etc.my.vo.CarBrandnumVo;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }


    //添加车辆信息和图库图片
    @RequestMapping("/addCar")
    public void addCar(CarDto car, PicDto picDto, HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取当前服务器所在的磁盘地址
        String path = request.getServletContext().getRealPath("/upload");
        System.out.println("上传的地址path" + path);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String pic_main = null;
        String pic_appea1 = null;
        String pic_appea2 = null;
        String pic_interior1 = null;
        String pic_interior2 = null;
        //获取当前上传的文件名,主图
        pic_main = picDto.getPic_main().getOriginalFilename();
        //获取当前上传的文件名,外观1
        pic_appea1 = picDto.getPic_appea1().getOriginalFilename();
        //获取当前上传的文件名,外观2
        pic_appea2 = picDto.getPic_appea2().getOriginalFilename();
        //获取当前上传的文件名,内饰1
        pic_interior1 = picDto.getPic_interior1().getOriginalFilename();
        //获取当前上传的文件名,内饰2
        pic_interior2 = picDto.getPic_interior2().getOriginalFilename();

        //对该文件名进行重命名,主图
        pic_main = System.currentTimeMillis() + "-" + pic_main;
        //对该文件名进行重命名,外观1
        pic_appea1 = System.currentTimeMillis() + "-" + pic_appea1;
        //对该文件名进行重命名,外观2
        pic_appea2 = System.currentTimeMillis() + "-" + pic_appea2;
        //对该文件名进行重命名,内饰1
        pic_interior1 = System.currentTimeMillis() + "-" + pic_interior1;
        //对该文件名进行重命名,内饰2
        pic_interior2 = System.currentTimeMillis() + "-" + pic_interior2;
        //获取要上传文件的路径对象
        File file1 = new File(path + "/" + pic_main);
        File file2 = new File(path + "/" + pic_appea1);
        File file3 = new File(path + "/" + pic_appea2);
        File file4 = new File(path + "/" + pic_interior1);
        File file5 = new File(path + "/" + pic_interior2);
        try {
            FileUtils.copyInputStreamToFile(picDto.getPic_main().getInputStream(), file1);
            FileUtils.copyInputStreamToFile(picDto.getPic_appea1().getInputStream(), file2);
            FileUtils.copyInputStreamToFile(picDto.getPic_appea2().getInputStream(), file3);
            FileUtils.copyInputStreamToFile(picDto.getPic_interior1().getInputStream(), file4);
            FileUtils.copyInputStreamToFile(picDto.getPic_interior2().getInputStream(), file5);
            System.out.println("文件上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<script>alert('保存失败，发生异常');history.go(-1);</script>");
        }
        try {
            //注入值
            User user = userService.getUser(car.getPhone());
            if(user==null){
                out.print("<script>alert('保存失败，手机号填写有误！');history.go(-1);</script>");
            }else{
                UUID uuid = UUID.randomUUID();
                car.setCar_name(car.getCar_name());
                car.setCar_brand(car.getCar_brand());
                car.setCar_dept(car.getCar_dept());
                car.setCar_price(car.getCar_price());
                car.setCar_regist(car.getCar_regist());
                car.setCar_mile(car.getCar_mile());
                car.setCar_at(car.getCar_at());
                car.setCar_dc(car.getCar_dc());
                car.setCar_newprice(car.getCar_newprice());
                car.setCar_transfer(car.getCar_transfer());
                car.setCar_power(car.getCar_power());
                car.setCar_adress(car.getS_city());
                car.setCar_endurance(car.getCar_endurance());
                car.setCar_capacity(car.getCar_capacity());
                car.setCar_color(car.getCar_color());
                car.setCar_producetime(car.getCar_producetime());
                car.setCar_keynum(car.getCar_keynum());
                car.setCar_status(car.getCar_status());
                car.setCar_time(car.getCar_time());
                car.setCar_id(uuid.toString());

                car.setCar_sale(user.getUser_id());
                PicDto2 picDto2 = new PicDto2();
                picDto2.setPic_car(uuid.toString());
                picDto2.setPic_main(pic_main);
                picDto2.setPic_appea1(pic_appea1);
                picDto2.setPic_appea2(pic_appea2);
                picDto2.setPic_interior1(pic_interior1);
                picDto2.setPic_interior2(pic_interior2);
                if (carService.addCarAndPic(car, picDto2)) {

                    out.print("<script>alert('保存成功');location.href='addCar.jsp';</script>");
                } else {
                    out.print("<script>alert('保存失败');history.go(-1);</script>");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            out.print("<script>alert('保存失败');history.go(-1);</script>");
        }


    }

    //利用ajax获取车辆信息和动态查询
    @RequestMapping("/getCar")
    @ResponseBody
    public MyMessage getCar(CarDto car) {


        MyMessage myMessage = new MyMessage();
        //page，size默认值
        Integer page = car.getPage();
        Integer size = car.getSize();
        //注入值
        car.setCar_name("%" + car.getCar_name() + "%");
        car.setCar_brand("%" + car.getCar_brand() + "%");
        car.setCar_dept("%" + car.getCar_dept() + "%");
        car.setCar_adress("%" + car.getCar_adress() + "%");
        car.setCar_color("%" + car.getCar_color() + "%");
        car.setCar_producetime("%" + car.getCar_producetime() + "%");
        car.setCar_status("%" + car.getCar_status() + "%");
        car.setCar_regist("%" + car.getCar_regist() + "%");
        car.setCar_power("%" + car.getCar_power() + "%");
        car.setCar_endurance("%" + car.getCar_endurance() + "%");
        //page，size默认值

        //size.page.maxPage容错

        Long count = carService.getCarCount();
        Integer maxPage = (int) (count % size == 0 ? (count / size) : (count / size + 1));
        //页数条数上限容错
        page = page > maxPage ? maxPage : page;
        size = size > 5 ? 5 : size;
        //页数条数下限容错
        page = page <= 0 ? 1 : page;
        size = size <= 0 ? 5 : size;
        car.setSize(size);
        car.setPage((page - 1) * size);
        car.setMaxPage(maxPage);
        List<Car> list = carService.queryCar(car);
        myMessage.setData(car);
        myMessage.setOlist(list);
        myMessage.setPage(page);
        myMessage.setSize(size);
        myMessage.setMaxPage(maxPage);

        return myMessage;

    }

    //根据id查询车辆信息
    @RequestMapping("/getCarById")
    public void getCarById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cid = request.getParameter("cid");
        CarAndPicDto carDto = carService.queryCar(cid);
        request.setAttribute("carDto", carDto);
        request.getSession().setAttribute("carDto", carDto);
        request.getRequestDispatcher("editCar.jsp").forward(request, response);

    }

    //修改车辆信息
    @RequestMapping("/updateCarAndPic")
    public void updateCarAndPic(CarDto car, PicDto picDto, HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取当前服务器所在的磁盘地址
        String path = request.getServletContext().getRealPath("/upload");
        System.out.println("上传的地址path" + path);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String pic_main = null;
        String pic_appea1 = null;
        String pic_appea2 = null;
        String pic_interior1 = null;
        String pic_interior2 = null;
        //获取当前上传的文件名,主图
        pic_main = picDto.getPic_main().getOriginalFilename();
        //获取当前上传的文件名,外观1
        pic_appea1 = picDto.getPic_appea1().getOriginalFilename();
        //获取当前上传的文件名,外观2
        pic_appea2 = picDto.getPic_appea2().getOriginalFilename();
        //获取当前上传的文件名,内饰1
        pic_interior1 = picDto.getPic_interior1().getOriginalFilename();
        //获取当前上传的文件名,内饰2
        pic_interior2 = picDto.getPic_interior2().getOriginalFilename();

        //对该文件名进行重命名,主图
        pic_main = System.currentTimeMillis() + "-" + pic_main;
        //对该文件名进行重命名,外观1
        pic_appea1 = System.currentTimeMillis() + "-" + pic_appea1;
        //对该文件名进行重命名,外观2
        pic_appea2 = System.currentTimeMillis() + "-" + pic_appea2;
        //对该文件名进行重命名,内饰1
        pic_interior1 = System.currentTimeMillis() + "-" + pic_interior1;
        //对该文件名进行重命名,内饰2
        pic_interior2 = System.currentTimeMillis() + "-" + pic_interior2;
        //获取要上传文件的路径对象
        File file1 = new File(path + "/" + pic_main);
        File file2 = new File(path + "/" + pic_appea1);
        File file3 = new File(path + "/" + pic_appea2);
        File file4 = new File(path + "/" + pic_interior1);
        File file5 = new File(path + "/" + pic_interior2);
        try {
            FileUtils.copyInputStreamToFile(picDto.getPic_main().getInputStream(), file1);
            FileUtils.copyInputStreamToFile(picDto.getPic_appea1().getInputStream(), file2);
            FileUtils.copyInputStreamToFile(picDto.getPic_appea2().getInputStream(), file3);
            FileUtils.copyInputStreamToFile(picDto.getPic_interior1().getInputStream(), file4);
            FileUtils.copyInputStreamToFile(picDto.getPic_interior2().getInputStream(), file5);
            System.out.println("文件上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<script>alert('保存失败，发生异常');history.go(-1);</script>");
        }
        try {

            CarAndPicDto carAndPicDto = (CarAndPicDto) request.getSession().getAttribute("carDto");
            //注入值
            car.setCar_name(car.getCar_name());
            car.setCar_brand(car.getCar_brand());
            car.setCar_dept(car.getCar_dept());
            car.setCar_price(car.getCar_price());
            car.setCar_regist(car.getCar_regist());
            car.setCar_mile(car.getCar_mile());
            car.setCar_at(car.getCar_at());
            car.setCar_dc(car.getCar_dc());
            car.setCar_newprice(car.getCar_newprice());
            car.setCar_transfer(car.getCar_transfer());
            car.setCar_power(car.getCar_power());
            car.setCar_adress(car.getS_city());
            car.setCar_endurance(car.getCar_endurance());
            car.setCar_capacity(car.getCar_capacity());
            car.setCar_color(car.getCar_color());
            car.setCar_producetime(car.getCar_producetime());
            car.setCar_keynum(car.getCar_keynum());
            car.setCar_status(car.getCar_status());
            car.setCar_time(car.getCar_time());
            car.setCar_id(carAndPicDto.getCar_id());
            PicDto2 picDto2 = new PicDto2();
            picDto2.setPic_id(carAndPicDto.getPic_id());
            picDto2.setPic_main(pic_main);
            picDto2.setPic_appea1(pic_appea1);
            picDto2.setPic_appea2(pic_appea2);
            picDto2.setPic_interior1(pic_interior1);
            picDto2.setPic_interior2(pic_interior2);
            if (carService.updateCarAndPic(car, picDto2)) {

                out.print("<script>alert('修改成功');location.href='carlist.jsp';</script>");
            } else {
                out.print("<script>alert('修改失败');history.go(-1);</script>");
            }


        } catch (Exception e) {
            e.printStackTrace();
            out.print("<script>alert('修改失败');history.go(-1);</script>");
        }


    }
    //导出excel文件
    @RequestMapping("/exportExcel")
    @ResponseBody
    public String exportExcel(HttpServletResponse response, Map<String, Object> params) {

        HSSFWorkbook workbook = carService.exportExcel(params);
        try {
            if (response != null) {
                response.setContentType("application/vnd.ms-excel;charset=utf-8");
                response.setHeader("Content-Disposition",
                        "attachment;filename=\"" + new String(("车辆数据信息" + ".xls").getBytes("gb2312"), "ISO8859-1"));
                OutputStream out = response.getOutputStream();
                workbook.write(out);
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/queryCarBrandAndNum")
    @ResponseBody
    public List<CarBrandnumVo> queryCarBrandAndNum(){
       return carService.queryCarBrandAndNum();
    }


}
